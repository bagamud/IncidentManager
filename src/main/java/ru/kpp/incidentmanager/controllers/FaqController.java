package ru.kpp.incidentmanager.controllers;

import org.springframework.stereotype.Controller;
import ru.kpp.incidentmanager.entity.Faq;
import ru.kpp.incidentmanager.repositories.FaqRepository;


@Controller
public class FaqController {

    /**
     * Веб-метод отвечающий за загрузку справочных карточек для отображения на сайте
     */

    final FaqRepository faqRepository;

    public FaqController(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    public String getFaq() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Faq faq : faqRepository.findAll()) {
            stringBuilder.append("<div class=\"carousel-item\" id=\"")
                    .append(faq.getId())
                    .append("\"><div class=\"card\">")
                    .append("<div class=\"card-header bg-info text-center text-light text-uppercase\">")
                    .append(faq.getCardTitle())
                    .append("</div><div class=\"card-body\">")
                    .append(faq.getCardText())
                    .append("</div></div></div>");
        }

        return stringBuilder.toString();
    }
}