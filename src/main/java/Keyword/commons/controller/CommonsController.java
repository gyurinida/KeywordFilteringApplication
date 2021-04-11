package Keyword.commons.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/commons")
public class CommonsController {

    @RequestMapping("/wrongAccess")
    public String wrongAccess(){
        return "commons/wrong_access";
    }
}
