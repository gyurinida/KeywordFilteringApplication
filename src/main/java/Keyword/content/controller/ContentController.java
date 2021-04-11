package Keyword.content.controller;

import Keyword.commons.filtering.KeywordMaker;
import Keyword.commons.paging.Criteria;
import Keyword.commons.paging.PageMaker;
import Keyword.commons.paging.SearchCriteria;
import Keyword.content.domain.ContentVO;
import Keyword.content.service.ContentService;
import Keyword.likes.domain.LikesVO;
import Keyword.likes.service.LikesService;
import Keyword.user.domain.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
    private final ContentService contentService;
    private final LikesService likesService;

    @Inject
    public ContentController(ContentService contentService, LikesService likesService) {
        this.contentService = contentService;
        this.likesService = likesService;
    }

    @RequestMapping("/")
    public String home(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception{
        KeywordMaker keywordMaker = new KeywordMaker();
        keywordMaker.setTotalType(contentService.listType());
        keywordMaker.setTotalGenre(contentService.listGenre());
        keywordMaker.setTotalRated(contentService.listRated());
        model.addAttribute("keywordMaker", keywordMaker);

        // 검색어 처리
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        model.addAttribute("pageMaker", pageMaker);

        // 상단 배너
        List<String> banner_bg = new ArrayList<>();
        banner_bg.add("https://pbs.twimg.com/media/El6Ej77U0AEtlS8?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/EmEXwKJVgAAhO2T?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/EmJhVIDVoAADkiR?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/EmOq6VAU4AEbq-N?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/El069cqU8AAH575?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/ElvxaGyU0AIxbra?format=jpg&name=large");
        banner_bg.add("https://pbs.twimg.com/media/El_OJKTVoAMi2om?format=jpg&name=large");

        Map<String, Object> banner = new HashMap<>();
        //for(int i=0; i<banner_bg.size(); i++){
            banner.put("url", banner_bg.get(0));
            banner.put("text", "비 오는 날 오싹하게 할 스릴러");
            List<List<String>> banner_content = new ArrayList<>();
            for(int j=0; j<10; j++) {
                List<String> tmp = new ArrayList<>();
                tmp.add("tt7678620");
                tmp.add("https://m.media-amazon.com/images/M/MV5BMDBiNDI3YjQtNDdkNS00ZDliLTlmMmQtMDE4ZWM1ZGIyNjljXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_UX182_CR0,0,182,268_AL_.jpg");
                banner_content.add(tmp);
            }
            banner.put("bannerContents", banner_content);
        //}
        model.addAttribute("banner", banner);

        return "home";
    }

    // 컨텐츠 추가 페이지 이동
    @RequestMapping(value = "/addContent", method = RequestMethod.GET)
    public String writeGET(){
        return "addContent";
    }

    // 컨텐츠 추가 처리
    @RequestMapping(value = "/addContent", method = RequestMethod.POST)
    public String writePOST(ContentVO contentVO, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("Content addPOST...");
        contentService.create(contentVO);
        redirectAttributes.addFlashAttribute("msg", "addSuccess");

        return "redirect:/content/read";
    }

    // 켄텐츠 목록
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> list(@RequestParam("selType") String selType,
                                                @RequestParam(value = "selGenre", required=false) String[] selGenre,
                                                @RequestParam(value = "selRated", required=false) String[] selRated,
                                                @RequestParam("selRtime_start") int selRtime_start,
                                                @RequestParam("selRtime_end") int selRtime_end,
                                                @RequestParam("selSort") String selSort,
                                                @RequestParam("page") Integer page,
                                                @RequestParam("userId") String userId){

        ResponseEntity<Map<String, Object>> entity = null;
        try {
            Criteria criteria = new Criteria();
            criteria.setPage(page);

            List<ContentVO> contents = contentService.listSelected(selType, selGenre, selRated, selRtime_start, selRtime_end, selSort, criteria);
            int resultCount = contentService.countResult(selType, selGenre, selRated, selRtime_start, selRtime_end);

            PageMaker pageMaker = new PageMaker();
            pageMaker.setCriteria(criteria);
            pageMaker.setTotalCount(resultCount);

            Map<String, Object> mapp = new HashMap<>();
            mapp.put("contents", contents);
            mapp.put("pageMaker", pageMaker);


            Map<String, LikesVO> likes = new HashMap<>();
            if(!userId.isEmpty()){
                for(int i=0; i<contents.size(); i++){
                    String contentId = contents.get(i).getContentId();
                    LikesVO likesVO = likesService.isLiked(contentId, userId);
                    if(likesVO != null)
                        likes.put(contentId, likesVO);
                }
            }
            mapp.put("likes", likes);

            entity = new ResponseEntity<>(mapp, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    //목록에서 장르 받아오기 (중첩 ajax 이용)
    @RequestMapping(value = "/list/genres", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>>  genres(@RequestParam("contentId") String contentId, Model model) throws Exception{
        ResponseEntity<Map<String, Object>> entity = null;
        try {
            KeywordMaker keywordMaker = new KeywordMaker();
            keywordMaker.setMyGenre(contentService.listMyGenre(contentId));

            Map<String, Object> mapp = new HashMap<>();
            mapp.put("keywordMaker", keywordMaker);

            entity = new ResponseEntity<>(mapp, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 컨텐츠 조회 페이지 이동
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(@RequestParam("contentId") String contentId,
                       @ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                       Model model) throws Exception{

        KeywordMaker keywordMaker = new KeywordMaker();
        keywordMaker.setMyGenre(contentService.listMyGenre(contentId));
        model.addAttribute("keywordMaker", keywordMaker);

        // 검색어 처리
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        model.addAttribute("pageMaker", pageMaker);

        model.addAttribute("content", contentService.read(contentId));
        return "content/read";
    }

    // 수정 페이지 이동
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyGET(@RequestParam("contentId") String contentId, Model model) throws Exception{
        model.addAttribute("content", contentService.read(contentId));

        return "content/modify";
    }

    // 수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPOST(ContentVO contentVO,
                             RedirectAttributes redirectAttributes) throws Exception{
        logger.info("Content modifyPOST...");
        contentService.update(contentVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/content/read";
    }

    // 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("contentId") String contentId, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("Content remove...");
        contentService.delete(contentId);
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/list";
    }

    // 검색 처리
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                         @ModelAttribute("selSort") String selSort,
                         HttpServletRequest request, Model model) throws Exception{

        if(selSort.isEmpty())   selSort = "Latest";
        model.addAttribute("selSort", selSort);
        List<ContentVO> contents = contentService.listSearch(searchCriteria, selSort);
        model.addAttribute("contents", contents);

        Map<String, List<String>> genres = new HashMap<>();
        for(int i=0; i<contents.size(); i++){
            String contentId = contents.get(i).getContentId();
            genres.put(contentId, contentService.listMyGenre(contentId));
        }
        model.addAttribute("genres", genres);

        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        pageMaker.setTotalCount(contentService.countSearchedContents(searchCriteria));
        model.addAttribute("pageMaker", pageMaker);

        Map<String, LikesVO> likes = new HashMap<>();
        UserVO user = (UserVO) request.getSession().getAttribute("login");
        if(user!=null){
            String userId = user.getUserId();
            for(int i=0; i<contents.size(); i++){
                String contentId = contents.get(i).getContentId();
                LikesVO likesVO = likesService.isLiked(contentId, userId);
                if(likesVO != null)
                    likes.put(contentId, likesVO);
            }
        }
        model.addAttribute("likes", likes);

        return "content/search";
    }


    // 랭킹 불러오기
    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getRanking(@RequestParam("selType") String selType){
        ResponseEntity<Map<String, Object>> entity = null;
        try {
            List<ContentVO> contents = contentService.getRanking(selType);
            Map<String, Object> mapp = new HashMap<>();
            mapp.put("contents", contents);

            entity = new ResponseEntity<>(mapp, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }



}
