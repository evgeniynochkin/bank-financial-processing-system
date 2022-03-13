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
     */
    public void setInformation (String currency, String accountType){
        this.currency = currency;
        this.accountType = accountType;
    }

    /**
     * Создание нового счетац
     * @return
     */
    public String createNewAccount() {
        Date date = new Date();

        int numberOfVariations = 2;
        String []  a = new String[numberOfVariations];
        a[0] = "1";
        String newNumber = generated.getNumberAccount();
        account.setNumberAccount(newNumber);
        account.setBalance(0.);
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
        return newNumber;
    }
}
