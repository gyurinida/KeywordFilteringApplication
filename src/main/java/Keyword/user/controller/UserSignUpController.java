package Keyword.user.controller;

import Keyword.commons.paging.PageMaker;
import Keyword.commons.paging.SearchCriteria;
import Keyword.user.domain.UserVO;
import Keyword.user.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
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

@Controller
@RequestMapping("/user")
public class UserSignUpController {
    private final UserService userService;

    @Inject
    public UserSignUpController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String registerGET(@ModelAttribute("searchCriteria") SearchCriteria searchCriteria,
                              Model model) throws Exception{
        // 검색어 처리
        PageMaker pageMaker = new PageMaker();
        pageMaker.setCriteria(searchCriteria);
        model.addAttribute("pageMaker", pageMaker);

        return "user/signUp";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception{
        String hashedPw = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
        userVO.setUserPw(hashedPw);
        userService.signUp(userVO);
        redirectAttributes.addFlashAttribute("msg", "REGISTERED");

        return "redirect:/user/login";
    }

    @RequestMapping(value = "/dupCheck", method = RequestMethod.GET)
    public ResponseEntity<Integer> dupCheck(@RequestParam("uncheckedId") String uncheckedId){
        ResponseEntity<Integer> entity = null;
        try {
            entity = new ResponseEntity<>(userService.dupCheck(uncheckedId), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
