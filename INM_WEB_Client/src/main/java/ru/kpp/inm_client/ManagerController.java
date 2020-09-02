package ru.kpp.inm_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpp.inm_client.clients.VocabularyClient;

@Controller
public class ManagerController {

    @Autowired
    VocabularyClient vocabularyClient;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        return "/index";
    }

    @GetMapping(path = "/manager")
    public String manager(Model model) {
        System.out.println(vocabularyClient.getCategorySelect());
        return "/manager";
    }
}
