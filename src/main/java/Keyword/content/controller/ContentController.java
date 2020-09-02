package Keyword.content.controller;

import Keyword.content.domain.ContentVO;
import Keyword.content.service.ContentService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.List;

@Controller
@RequestMapping("/")
public class ContentController {
    private static final Logger logger = LoggerFactory.getLogger(ContentController.class);
    private final ContentService contentService;

    @Inject
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
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

        return "redirect:/read";
    }

    // 켄텐츠 목록
    // TODO: ajax로 처리할거라, 페이지 만들면서 확인해봐야 함
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<ContentVO>> list(){
        ResponseEntity<List<ContentVO>> entity = null;
        try {
            entity = new ResponseEntity<>(contentService.listAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    // 컨텐츠 조 페이지 이동
    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public String read(@RequestParam("contentId") String contentId, Model model) throws Exception{
        model.addAttribute("content", contentService.read(contentId));
        return "read";
    }

    // 수정 페이지 이동
    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modifyGET(@RequestParam("contentId") String contentId, Model model) throws Exception{
        model.addAttribute("content", contentService.read(contentId));

        return "modify";
    }

    // 수정 처리
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modifyPOST(ContentVO contentVO,
                             RedirectAttributes redirectAttributes) throws Exception{
        logger.info("Content modifyPOST...");
        contentService.update(contentVO);
        redirectAttributes.addFlashAttribute("msg", "modSuccess");

        return "redirect:/read";
    }

    // 삭제 처리
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(@RequestParam("contentId") String contentId, RedirectAttributes redirectAttributes) throws Exception{
        logger.info("Content remove...");
        contentService.delete(contentId);
        redirectAttributes.addFlashAttribute("msg", "delSuccess");

        return "redirect:/list";
    }
}
