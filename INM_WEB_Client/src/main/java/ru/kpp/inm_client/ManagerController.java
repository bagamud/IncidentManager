package ru.kpp.inm_client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {

    @RequestMapping(path = "/manager")
    public String manager(Model model) {
        return "manager";
    }
}
