package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;
import ru.sbp.bankfinancialprocessingsystem.service.CardService;

@Controller
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService service;

    @GetMapping("/info")
    public ModelAndView getCardPage() {

//        service.createNewCard();

        ModelAndView model = new ModelAndView();
        model.setViewName("cardpage.jsp");

        return model;
    }
}
