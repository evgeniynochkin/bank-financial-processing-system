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
import ru.sbp.bankfinancialprocessingsystem.service.account.СalculationsAccount;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/updateDeposit")
public class DepositCashAccount {

    /**
     * Связь с репозеторием db
     */
    @Autowired
    private AccountRepository repository;

    /**
     * Вызов калькулятора
     */
    @Autowired
    private СalculationsAccount сalculations;

    /**
     * Вызов entity для работы с db
     */
    @Autowired
    private Account account;

    /**
     * Вызов контроллера для ссылки на ошибку
     */
    @Autowired
    private ErorrAccount erorr;

    /**
     * Номер счета
     */
    private String numberAccount;

    /**
     * Количество денег
     */
    private double money;

    /**
     * Выводит информацию по счету.
     *      Eсли номера счета нет в Базе данных, то numberAccount = null,
     * это нужно,чтоб когда человек вводил номера, которого нет,
     * то при возвращении на страничку /updateDeposit выходило бы
     * сообщение "Input your number the number account".
     *      Если номер счета верный,то выводит информацию о счете -
     * account.getBalance().
     *      В самом первом входе на стриничку счет неопределен, поэтому
     * numberAccount == null и будет выводится информация "Input your
     * number the number account".
     * @return
     */
    @GetMapping
    public ModelAndView getInformationDepositCash() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/depositMoney.jsp");

        if((account = repository.findByNumberAccount(numberAccount)) == null){
            this.numberAccount = null;
        }
        if(!(numberAccount == null)) {
            account = repository.findByNumberAccount(numberAccount);
            modelAndView.addObject("newBalance",
                    account.getBalance());
        }else {
            modelAndView.addObject("newBalance",
                    "Input your number the number account");
        }
        return modelAndView;
    }

    /**
     * Принимает параметры "moneyString" и номер счета "numberAccount".
     * По номеру счета суммируется поступившая сумма с суммой из bd.
     * Получаемая сумма сохраняется в bd и выводится новая информация
     * getInformationDepositCash().
     *      Если user не ввел вносимую сумму "money = "" " то
     * money = 0 и выводится неизмененная информация по сумме.
     *      Если номер счета не введен или введен тот, которого его
     * нет в bd, выскакивает окно с просьбой проверить № или
     * создать новый.
//     * @param request
//     * @param response
     * @param moneyString
     * @param numberAccount
     * @return
     */
    @PostMapping
    public ModelAndView updateDeposit(
                                      @RequestParam("money") String moneyString,
                                      @RequestParam("numberAccount") String numberAccount){

        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }

        this.numberAccount = numberAccount;
        account = repository.findByNumberAccount(numberAccount);
        сalculations.setNewBalanceAndNumberAccount(money,numberAccount);

        try {
            сalculations.amountOfMoney();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }

        account.setBalance(сalculations.getNewBalance());
        System.out.println(account.toString());
        repository.save(account);

        return this.getInformationDepositCash();
    }
}
