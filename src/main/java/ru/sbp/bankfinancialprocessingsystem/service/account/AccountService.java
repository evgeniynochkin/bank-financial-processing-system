package ru.sbp.bankfinancialprocessingsystem.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.AccountType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;

import java.util.Date;

/**
 * Сервис дляоткрытия счета.
 * @autor Sergey Vasiliev
 */
@Service
@Configurable
public class AccountService {

    /**
     * Валюта счета.
     */
    private String currency;

    /**
     * Тип счета
     */
    private String accountType;

    /**
     * Поступаеммая сумма.
     */
    private double money;

    /**
     * Связь с репозеторием db.
     */
    @Autowired
    private AccountRepository repository;

    /**
     * Генерация номера счета.
     */
    @Autowired
    private GeneratedNumber generated;

    /**
     * Вызов entity для работы с db.
     */
    @Autowired
    private Account account;

    /**
     * Пустой конструктор
     */
    public AccountService(){

    }

    /**
     * Получение информации о счете
     * @param currency
     * @param accountType
     * @param money
     */
    public void setInformation (String currency, String accountType, double money){
        this.currency = currency;
        this.accountType = accountType;
        this.money = money;
    }


    /**
     * Создание нового счетац
     * @return
     */
    public boolean createNewAccount() {
        Date date = new Date();

        int numberOfVariations = 2;
        String []  a = new String[numberOfVariations];
        a[0] = "1";

        account.setNumberAccount(generated.getNumberAccount());
        account.setBalance(money);
        account.setAccountActive(true);
        if (currency.equals(a[0])) {
            account.setAccountType(AccountType.Card);
        } else {
            account.setAccountType(null);
        }
        if (accountType.equals(a[0])) {
            account.setCurrency(CurrencyType.RUB);
        } else {
            account.setAccountType(null);
        }
        account.setDateOpen(date);
        //вызов узер логин
        account.setUserLogin("ser");
        repository.save(account);
        return true;
    }
}
