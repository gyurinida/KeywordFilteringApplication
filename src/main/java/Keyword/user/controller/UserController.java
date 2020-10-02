package Keyword.user.controller;

import Keyword.content.service.ContentService;
import Keyword.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final ContentService contentService;

    @Inject
    public UserController(UserService userService, ContentService contentService) {
        this.userService = userService;
        this.contentService = contentService;
    }

    // myInfo 페이지
    @RequestMapping(value = "/myInfo", method = RequestMethod.GET)
    public String myInfo(){
        return "user/myInfo";
    }

    // myLikes 페이지
    @RequestMapping(value = "/myLikes", method = RequestMethod.GET)
    public String myLikes(@RequestParam("userId") String userId, Model model) throws Exception{
        model.addAttribute("likes", contentService.getMyLikes(userId));
        return "user/myLikes";
    }
}
