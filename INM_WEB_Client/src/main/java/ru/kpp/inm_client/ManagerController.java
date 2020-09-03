package ru.kpp.inm_client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.kpp.inm_client.clients.VocabularyClient;

import java.util.Map;

@Controller
public class ManagerController {

    final
    VocabularyClient vocabularyClient;

    public ManagerController(VocabularyClient vocabularyClient) {
        this.vocabularyClient = vocabularyClient;
    }

    @GetMapping(value = {"/", "/index"})
    public String index(Map<String, Object> model) {
        model.put("users", vocabularyClient.getUserSelect());
        return "index";
    }

    @GetMapping(path = "/manager")
    public String manager(Map<String, Object> model) {
        model.put("categories", vocabularyClient.getCategorySelect());
        return "manager";
    }
}
