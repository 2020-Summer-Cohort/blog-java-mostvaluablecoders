package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    public HomeController(){}

    @RequestMapping({"","/"})
    public String routeToIndex(Model model){
        return "index-template";
    }
}
