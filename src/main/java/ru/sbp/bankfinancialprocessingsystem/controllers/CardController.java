package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.PaymentSystemType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.service.CardService;
import ru.sbp.bankfinancialprocessingsystem.service.account.AccountService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService service;

    @Autowired
    private AccountRepository accountRepository;

    private Account account;

    @GetMapping("/add/{accountNumber}")
    public ModelAndView addCard(@PathVariable(value = "accountNumber") String accountNumber) {
        ModelAndView mav = new ModelAndView();

        if (accountNumber == null) {
            mav.setViewName("account/account.jsp");
            return mav;
        }

        account = accountRepository.findByNumberAccount(accountNumber);

        mav.setViewName("card/createcardpage.jsp");
        mav.addObject("account", account);
        mav.addObject("card", new Card());

        return mav;
    }

    @PostMapping("/add")
    public ModelAndView addCard(@ModelAttribute Card card,
                                @RequestParam("cardType") String cardType,
                                @RequestParam("holderName") String holderName) {
        switch (Integer.parseInt(cardType)) {
            case (1):
                card.setPaymentSystem(PaymentSystemType.VISA);
                break;
            case (2):
                card.setPaymentSystem(PaymentSystemType.MC);
                break;
            case (3):
                card.setPaymentSystem(PaymentSystemType.МИР);
            default: break;
        }
        card.setCardHolderName(holderName);
        card.setNumberAccount(account);
        service.createNewCard(card);

        return this.getCardPage(card);
    }

    @GetMapping("/info")
    public ModelAndView getCardPage(Card card) {

        ModelAndView mav = new ModelAndView();

        if (card == null) {
            mav.setViewName("showall.jsp");
            return mav;
        }

        mav.setViewName("card/cardpage.jsp");
        mav.addObject("card", card);
        mav.addObject("accpunt", card.getNumberAccount());

        return mav;
    }

    @PostMapping("/info")
    public ModelAndView setCard() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("cardpage.jsp");
        return mav;
    }
}
