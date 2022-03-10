package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.services.СalculationsAccount;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/infoAccount")
public class UserAccount {

    //        ApplicationContext context = new AnnotationConfigApplicationContext("ru.sbp");
//        AccountRepository repository = context.getBean(AccountRepository.class);
    /**
     * Cвязь с репозиторием и бд
     */
    @Autowired
    private AccountRepository repository;

    /**
     * вызов калькулятора
     */
    @Autowired
    private СalculationsAccount сalculations;



//    public void setRepository(AccountRepository repository) {
//        this.repository = repository;
//    }

    /**
     * Отправляет информацию по наименованию клиента(name), номеру аккаунта(accountNumber),
     * активному статусу(activityStatus) и балансу счета(balance)
     * активнаяя ссылка http://localhost:8080/infoAccount
     * @return
     */
    @GetMapping
    public ModelAndView getInformationAboutCheck() {

        Account account = repository.findByNumberAccount("12345678901234567890");
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/account.jsp");
        modelAndView.addObject("login", account.getUserLogin());
        modelAndView.addObject("accountNumber",account.getNumberAccount());
        modelAndView.addObject("dateOpen", account.getDateOpen());
        modelAndView.addObject("activityStatus", account.getAccountActive());
        modelAndView.addObject("balance", account.getBalance());
        modelAndView.addObject("currency", account.getCurrency());

        return modelAndView;
    }
}
