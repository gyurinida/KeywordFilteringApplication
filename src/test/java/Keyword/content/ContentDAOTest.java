package Keyword.content;

import Keyword.commons.paging.Criteria;
import Keyword.commons.paging.SearchCriteria;
import Keyword.content.domain.ContentVO;
import Keyword.content.persistence.ContentDAO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ContentDAOTest {
    private static final Logger logger = LoggerFactory.getLogger(ContentDAO.class);

    @Inject
    private ContentDAO contentDAO;

    @Test
    public void testSearch() throws Exception{
        SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setSearchType("c");
        searchCriteria.setSearchKeyword("Robert");
        System.out.println(contentDAO.listSearch(searchCriteria, "Latest"));
    }

    @Test
    public void testMyGenre() throws Exception{
        System.out.println(contentDAO.listMyGenre("tt3521164"));
    }

    @Test
    public void testCreate() throws Exception{
        ContentVO content = new ContentVO();
        content.setContentId("tt0000000");
        content.setTitle("CREATE 테스트 제목");
        content.setPlot("CREATE 테스트 줄거리");
        content.setYear(2020);
        contentDAO.create(content);
    }

    @Test
    public void testRead() throws Exception{
        logger.info(contentDAO.read("tt0019422").toString());
    }

    @Test
    public void testUpdate() throws Exception{
        ContentVO content = new ContentVO();
        content.setContentId("tt0000000");
        content.setTitle("UPDATE 테스트");
        contentDAO.update(content);
    }

    @Test
    public void testDelete() throws Exception{
        contentDAO.delete("tt0000000");
    }

    @Test
    public void testListAll() throws Exception{
        System.out.println(contentDAO.listAll());
    }


    @Test
    public void ListSelected() throws Exception{
        String[] selGenre = null;
        String[] selRated = null;
        int selRtime_start = -1;
        int selRtime_end = -1;

        Criteria criteria = new Criteria();
        criteria.setPage(1);

        List<ContentVO> contents = contentDAO.listSelected("episode", selGenre, selRated, selRtime_start, selRtime_end,"Latest", criteria);

        for(ContentVO content : contents) {
            logger.info(content.getContentId() + " : " + content.getTitle());
        }
    }

    @Test
    public void testURI() throws Exception {
        UriComponents uriComponents= UriComponentsBuilder.newInstance()
                .path("/article/read")
                .queryParam("articleNo", 12)
                .queryParam("perPageNum",20)
                .build();

        logger.info(uriComponents.toString());
    }

    //db에 포스터 이미지 넣기
    @Test
    public void testCrawling() throws Exception {
        List<ContentVO> contents = contentDAO.listAll();
        for (ContentVO s : contents) {

            //System.out.println(s.getContentId());
            String imdbsrc = "https://www.imdb.com/title/";
            imdbsrc += s.getContentId() + "/";

            Document doc;
            doc = Jsoup.connect(imdbsrc).get();

            Element imageElement = doc.select(".poster > a > img").first();
            String poster = imageElement.attr("src");

            contentDAO.setPoster(s.getContentId(), poster);

        }
    }

    private Map<String, String> awardParsing(String award){
        Map<String, String> dic = new HashMap<>();
        boolean flag = false;
        String[] tmp = award.split(" ");

        if(award.contains("Oscar")){
            dic.put("major", "Oscar");
            flag = true;
        }
        if(award.contains("Golden")){
            dic.put("major", "Golden Globe");
            flag = true;
        }
        if(award.contains("Emmy")){
            dic.put("major", "Primetime Emmy");
            flag = true;
        }
        if(flag){
            if(tmp[0].equals("Won")){
                dic.put("major_type", tmp[1]+" won");
            }
            if(tmp[0].equals("Nominated")){
                dic.put("major_type", tmp[2]+" nominated");
            }
        }
        else{
            if(award.contains("&")){
                if(tmp[0].equals("Another")){
                    dic.put("win", tmp[1]);
                    dic.put("nominate", tmp[4]);
                }
                else {
                    dic.put("win", tmp[0]);
                    dic.put("nominate", tmp[3]);
                }
            }
            else{
                if(tmp[0].equals("Another")) {
                    if (award.contains("win"))
                        dic.put("win", tmp[1]);
                    if(award.contains("nomination"))
                        dic.put("nominate", tmp[1]);
                }
                else{
                    if (award.contains("win"))
                        dic.put("win", tmp[0]);
                    if(award.contains("nomination"))
                        dic.put("nominate", tmp[0]);
                }
            }
        }
        //System.out.println(dic.get("win")+","+dic.get("nominate")+","+dic.get("major")+","+dic.get("major_type"));
        return dic;
    }

    @Test
    public void testAddData() throws Exception{ // imdb 크롤링 해서 데이터 추가하기

        BufferedReader br = null;
        br = Files.newBufferedReader(Paths.get("/Users/gyurin/Downloads/imdb_movie-id-4.csv"));

        List<String> ttid = new ArrayList<String>();
        String line = "";
        while((line = br.readLine()) != null){
            ttid.add(line);
        }

        for(String id:ttid){
            System.out.print(id+"\t");
            //String id = "tt0417741";//: 기본;    // "tt1300854": 아이언맨3, runtime여러개; // tt3098874: subtitle 여러개
            if(contentDAO.read(id)!=null)   continue;

            String imdbsrc = "https://www.imdb.com/title/" + id + "/";

            Document doc;
            doc = Jsoup.connect(imdbsrc).get();

            ContentVO contentVO = new ContentVO();
            contentVO.setContentId(id);

            contentVO.setTitle(doc.select(".title_wrapper > h1").first().ownText());
            contentVO.setPlot(doc.select(".inline.canwrap > p > span").text());
            contentVO.setType("movie");

            String rated = doc.select(".title_wrapper > .subtext").first().ownText();
            rated = rated.replace(",", "");
            rated = rated.replace(" ", "");
            contentVO.setRated(rated);

            String year = doc.select("#titleYear > a").text();
            if(year==null || year.isEmpty())
                continue;
            contentVO.setYear(Integer.parseInt(year));

            // runtime
            if(doc.select("#titleDetails > div > time").last()!=null) {
                String rt = doc.select("#titleDetails > div > time").last().text();
                contentVO.setRuntime(Integer.parseInt(rt.substring(0, rt.length() - 4)));
            }

            // director, writer, actor
            for(Element e: doc.select(".credit_summary_item")){
                String role = e.select("h4").text();
                Elements eas = e.select("a");
                String names = "";
                for(Element ea:eas)
                    names += ea.text() + ", ";
                names = names.substring(0, names.length()-2);

                if(role.equals("Director:") || role.equals("Directors:")){
                    contentVO.setDirector(names);
                }
                if(role.equals("Writer:") || role.equals("Writers:")){
                    contentVO.setWriter(names);
                }
                if(role.equals("Star:") || role.equals("Stars:")){
                    contentVO.setActor(names);
                }
            }

            // subtitle
            String lan = doc.select("#titleDetails > div").get(2).select("h4").text();
            String subt = "";
            if(lan.equals("Language:")) subt = doc.select("#titleDetails > div").get(2).select("a").text();
            else                        subt = doc.select("#titleDetails > div").get(1).select("a").text();
            contentVO.setSubtitle(subt.replace(" ", ", "));

            // 수상 내역
            List<String> awardlist = doc.select("#titleAwardsRanks > .awards-blurb").eachText();
            Map<String, String> dic = new HashMap<>();
            for(String award:awardlist){
                dic = awardParsing(award);
                String aw = dic.get("win");
                if(aw != null && !aw.isEmpty())
                    contentVO.setAwardWin(Integer.parseInt(aw));
                String an = dic.get("nominate");
                if(an != null && !an.isEmpty())
                    contentVO.setAwardNominate(Integer.parseInt(an));
                String am = dic.get("major");
                if(am != null && !am.isEmpty())
                    contentVO.setAwardMajor(am);
                String amj = dic.get("major_type");
                if(amj != null && !amj.isEmpty())
                    contentVO.setAwardMajorType(amj);
            }

            System.out.print(contentVO.getAwardWin()+","+contentVO.getAwardNominate()+","+contentVO.getAwardMajor()+","+contentVO.getAwardMajorType());

            contentVO.setImdbRating(Double.parseDouble(doc.select(".ratingValue > strong > span").text()));

            String votes = doc.select(".imdbRating > a > span").text().replace(",", "");
            contentVO.setImdbVotes(Integer.parseInt(votes));

            contentVO.setRating((double) 0);
            contentVO.setReviewCnt(0);
            contentVO.setLikesCnt(0);
            contentVO.setPoster(doc.select(".poster > a > img").attr("src"));

            contentDAO.create(contentVO);

            // 장르
            List<String> genres = doc.select(".title_wrapper > .subtext > a").eachText();
            genres.remove(genres.size()-1);
            contentDAO.insertGenre(id, genres);
            System.out.println("\t"+contentVO.getRated()+" : "+genres);
        }
    }

    //랭킹 테스트
    @Test
    public void getRanking() throws Exception{

        String selType = "movie";

        List<ContentVO> contents = contentDAO.getRanking(selType);

        for(ContentVO content : contents) {
            logger.info(content.getTitle());
        }
    }
}
