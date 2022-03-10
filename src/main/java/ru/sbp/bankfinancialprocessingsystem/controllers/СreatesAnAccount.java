package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.service.account.AccountService;
import ru.sbp.bankfinancialprocessingsystem.service.account.СalculationsAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/createAnAccount")
public class СreatesAnAccount {

    /**
     * Связь с репозеторием db.
     */
    private AccountRepository repository;

    @Autowired
    public void setRepository(AccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Вызов калькулятора.
     */
    @Autowired
    private СalculationsAccount сalculations;

    /**
     * Вызов entity для работы с db.
     */
    @Autowired
    private Account account;

    /**
     * Сервис по созданию нового счета.
     */
    @Autowired
    private AccountService service;

    /**
     * Поступаеммая сумма.
     */
    private double money;

    @GetMapping
    public ModelAndView getInformationCreateNumberAccount() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/createsAnAccount.jsp");
        modelAndView.addObject("login","User: " + account.getUserLogin());
        modelAndView.addObject("accountNumber","Number account: " +account.getNumberAccount());

        return modelAndView;
    }

    @PostMapping
    public ModelAndView updateDeposit(
                                      @RequestParam("accountType") String accountType,
                                      @RequestParam("currency") String currency,
                                      @RequestParam("balance") String moneyString) {

        ModelAndView modelAndView = new ModelAndView();
        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }
        service.setInformation(currency,accountType,money);
        service.createNewAccount();


        return this.getInformationCreateNumberAccount();
    }
}
