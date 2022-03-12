package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.OperationType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.service.account.AccountService;
import ru.sbp.bankfinancialprocessingsystem.service.account.TransactionAccount;
import ru.sbp.bankfinancialprocessingsystem.service.account.СalculationsAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @autor Sergey Vasiliev
 */
@Controller
@RequestMapping(value = "/account")
public class UserAccount {

    /**
     * Cвязь с репозиторием аккаунта в бд
     */
    @Autowired
    private AccountRepository repository;

    /**
     * вызов калькулятора
     */
    @Autowired
    private СalculationsAccount сalculations;

    /**
     * Запись транзакции в bd.
     */
    @Autowired
    private TransactionAccount transactionAccount;

    /**
     * Вызов контроллера для ссылки на ошибку
     */
    @Autowired
    private ErorrAccount erorr;

    /**
     * Сервис по созданию нового счета.
     */
    @Autowired
    private AccountService service;

    /**
     * Номер счета
     */
    private String numberAccount;

    /**
     * новый номер счета
     */
    private String newNumber;

    /**
     * Количество денег
     */
    private double money;

    @Autowired
     Account account;

    /**
     * Отправляет информацию по наименованию клиента(name), номеру аккаунта(accountNumber),
     * активному статусу(activityStatus) и балансу счета(balance)
     * активнаяя ссылка http://localhost:8080/infoAccount
     * @return
     */
    @GetMapping(value = "/info")
    public ModelAndView getInformationAboutCheck() {

        account = repository.findByNumberAccount(numberAccount);
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/account.jsp");
        try {
            modelAndView.addObject("login", account.getUserLogin());
            modelAndView.addObject("accountNumber",account.getNumberAccount());
            modelAndView.addObject("dateOpen", account.getDateOpen());
            modelAndView.addObject("activityStatus", account.getAccountActive());
            modelAndView.addObject("balance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
            return modelAndView;
        }catch (NullPointerException e){
            modelAndView.addObject("login","-");
            modelAndView.addObject("accountNumber","-");
            modelAndView.addObject("dateOpen","-" );
            modelAndView.addObject("activityStatus", "-");
            modelAndView.addObject("balance", "-");
            modelAndView.addObject("currency", "-");
            return modelAndView;
        }
    }

    @PostMapping(value = "/info")
    public ModelAndView updateInformation(
            @RequestParam("numberAccount") String numberAccount){

        this.numberAccount = numberAccount;
       account = repository.findByNumberAccount(numberAccount);
        try {
            account.getNumberAccount();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            return erorr.getErorrNumberInfo();
        }
        return this.getInformationAboutCheck();
    }

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
    @GetMapping(value = "/info/updateDeposit")
    public ModelAndView getInformationDepositCash() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/depositMoney.jsp");

        if((account = repository.findByNumberAccount(numberAccount)) == null){
            this.numberAccount = null;
        }
        if(!(numberAccount == null)) {
            account = repository.findByNumberAccount(numberAccount);
            modelAndView.addObject("newBalance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
        }else {
            modelAndView.addObject("newBalance",
                    "Input your number the number account");
        }
        return modelAndView;
    }

    /**
     * Принимает параметры "moneyString".
     * По номеру счета суммируется поступившая сумма с суммой из bd.
     * Получаемая сумма сохраняется в bd и выводится новая информация
     * getInformationDepositCash().
     *      Если user не ввел вносимую сумму "money = "" " то
     * money = 0 и выводится неизмененная информация по сумме.
     *      Если номер счета не введен или введен тот, которого его
     * нет в bd, выскакивает окно с просьбой проверить № или
     * создать новый.
     *    Также записывается транзакция в бд.
     //     * @param request
     //     * @param response
     * @param moneyString
     * @return
     */
    @PostMapping(value = "/info/updateDeposit")
    public ModelAndView updateDeposit(
            @RequestParam("money") String moneyString){

        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }
        //убрать попробовать
        account = repository.findByNumberAccount(numberAccount);
        сalculations.setNewBalanceAndNumberAccount(money,numberAccount);

        try {
            сalculations.amountOfMoney();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }
        transactionAccount.setInformation(account.getNumberAccount(),
                OperationType.CashIn, money);
        transactionAccount.createNewAccount();

        account.setBalance(сalculations.getNewBalance());
        System.out.println(account.toString());
        repository.save(account);

        return this.getInformationDepositCash();
    }

    /**
     * Выводит информацию по счету.
     *      Eсли номера счета нет в Базе данных, то numberAccount = null,
     * это нужно,чтоб когда человек вводил номер, которого нет,
     * то при возвращении на страничку /updateDeposit выходило бы
     * сообщение "Input your number the number account".
     *      Если номер счета верный,то выводит информацию о счете -
     * account.getBalance().
     * @return
     */
    @GetMapping(value = "/info/withdrawCash")
    public ModelAndView getInformationWithdrawСash () {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/withdrawCash.jsp");

        account = repository.findByNumberAccount(numberAccount);

        if (сalculations.getNewBalance() < 0){

            modelAndView.addObject("newBalance", сalculations.getOldBalance());
            modelAndView.addObject("errorBalance", "Mistake! insufficient funds in the account.");
            return modelAndView;
        }
        if((account = repository.findByNumberAccount(numberAccount)) == null){
            this.numberAccount = null;
        }
        if(!(numberAccount == null)) {
            modelAndView.addObject("newBalance", account.getBalance());
            modelAndView.addObject("currency", account.getCurrency());
        }else {
            modelAndView.addObject("newBalance",
                    "Input your number the number account");
        }

        return modelAndView;
    }

    /**
     * Принимает параметры "moneyString".
     * По номеру счета суммируется поступившая сумма с суммой из bd.
     * Получаемая сумма сохраняется в bd и выводится новая информация
     * getInformationDepositCash().
     *      Если user не ввел вносимую сумму "money = "" " то
     * money = 0 и выводится неизмененная информация по сумме.
     *      Если номер счета не введен или введен тот, которого его
     * нет в bd, выскакивает окно с просьбой проверить № или
     * создать новый.
     *      Также записывается транзакция в бд.
     * @param moneyString
     * @return
     */
    @PostMapping(value = "/info/withdrawCash")
    public ModelAndView updateWithdraw(
            @RequestParam("money") String moneyString){

        if("" == moneyString ){
            money = 0;
        }else {
            money = Double.parseDouble(moneyString);
        }

        account = repository.findByNumberAccount(numberAccount);
        сalculations.setNewBalanceAndNumberAccount(money,numberAccount);

        try {
            сalculations.withdrawOfMoney();
        }catch (NullPointerException e){
            System.out.println("no such number in db");
            e.fillInStackTrace();
            return erorr.getErorrNumberInfo();
        }
        if (сalculations.getNewBalance() < 0){
            return this.getInformationWithdrawСash();
        }
        transactionAccount.setInformation(account.getNumberAccount(),
                OperationType.CashOut, money);
        transactionAccount.createNewAccount();

        account.setBalance(сalculations.getNewBalance());
        repository.save(account);

        return this.getInformationWithdrawСash();
    }

    /**
     * Выводит логин и новый номер счета
     * @return
     */

    @GetMapping(value = "/info/createAnAccount")
    public ModelAndView getInformationCreateNumberAccount() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/createsAnAccount.jsp");
        //вызов логина
        modelAndView.addObject("login","User: " + "serj");
        modelAndView.addObject("accountNumber","Number account: " + newNumber);

        return modelAndView;
    }

    /**
     * Получаем тип счета и тип аккаунта
     * @param accountType
     * @param currency
     * @return
     */
    @PostMapping(value = "/info/createAnAccount")
    public ModelAndView updateDeposit(
            @RequestParam("accountType") String accountType,
            @RequestParam("currency") String currency){

        service.setInformation(currency,accountType);
        this.newNumber = service.createNewAccount();

        return this.getInformationCreateNumberAccount();
    }
}