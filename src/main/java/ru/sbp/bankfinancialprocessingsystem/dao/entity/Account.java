package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import org.springframework.stereotype.Component;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.AccountType;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.enums.CurrencyType;

import javax.persistence.*;
//import java.sql.Date;
import java.util.Date;
/**
 * Класс Accounts - POJO-класс (Plain Old Java Object) таблицы account
 * @version 2.0
 * @autor Sergey Vasiliev
 * @autor Sergey Proshchaev
 */
@Component
@Entity
public class Account {

    /**
     * Генерация уникального айди счета
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "Id")
    private  Integer id;

    /**
     *Номер счета
     */
    @Column(name = "number_account")
    private String numberAccount;

    /**
     * Логин пользователя
     */
//    @Basic
    @Column(name = "user_login")
    private String userLogin;

    /**
     * Активный ли аккаунт
     */
//    @Basic
    @Column(name = "account_active")
    private Boolean accountActive;

    /**
     * Дата открытия
     */
//    @Basic
    @Column(name = "date_open")
    private Date dateOpen;

    /**
     * -
     */
//    @Basic
    @Column(name = "currency")
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;

    /**
     * Количество валюты в рублях
     */
//    @Basic
    @Column(name = "balance")
    private Double balance;
    /**
     * -
     */
//    @Basic
    @Column(name = "account_type")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    /**
     * -
     */
//    @Basic
    @Column(name = "date_close")
    private Date dateClose;

    /**
     * Конструктор класса
     */
    public Account() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String numberAccount номер счета 20 знаков
     * @param - String userLogin логин пользователя
     * @param - Boolean accountActive признак отсутствия ограничений по счету
     * @param - Date dateOpen дата открытия
     * @param - CurrencyType currency валюта счета
     * @param - Double balance исходящий остаток
     * @param - AccountType accountType тип счета
     * @param - Date dateClose дата закрытия счета
     */
    public Account(String numberAccount, String userLogin, Boolean accountActive, Date dateOpen, CurrencyType currency, Double balance, AccountType accountType, Date dateClose) {
        this.numberAccount = numberAccount;
        this.userLogin = userLogin;
        this.accountActive = accountActive;
        this.dateOpen = dateOpen;
        this.currency = currency;
        this.balance = balance;
        this.accountType = accountType;
        this.dateClose = dateClose;
    }

    /**
     * Отправляем номер счета
     * @return
     */
    public String getNumberAccount() {
        return numberAccount;
    }

    /**
     * Присваиваем номер счета
     * @param numberAccount
     */
    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    /**
     * Отправляем логин.
     * @return
     */
    public String getUserLogin() {
        return userLogin;
    }

    /**
     * присваиваем Логин
     * @param userLogin
     */
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * Отправляем активный ли аккаунт.
     * @return
     */
    public Boolean getAccountActive() {
        return accountActive;
    }

    /**
     * -
     * @param accountActive
     */
    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
    }

    /**
     * Отправляем дату открытия.
     * @return
     */
    public Date getDateOpen() {
        return dateOpen;
    }

    /**
     * Присваиваем дату открытия
     * @param dateOpen
     */
    public void setDateOpen(Date dateOpen) {
        this.dateOpen = dateOpen;
    }

    /**
     * -
     * @return
     */
    public CurrencyType getCurrency() {
        return currency;
    }

    /**
     * -
     * @param currency
     */
    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    /**
     * Отсылает баланс счета
     * @return
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Присваиваем баланм счета
     * @param balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }

    /**
     * -
     * @return
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * -
     * @param accountType
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * -
     * @return
     */
    public Date getDateClose() {
        return dateClose;
    }

    /**
     *
     * @param dateClose
     */
    public void setDateClose(Date dateClose) {
        this.dateClose = dateClose;
    }

    /**
     * --
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (numberAccount != null ? !numberAccount.equals(account.numberAccount) : account.numberAccount != null)
            return false;
        if (userLogin != null ? !userLogin.equals(account.userLogin) : account.userLogin != null) return false;
        if (accountActive != null ? !accountActive.equals(account.accountActive) : account.accountActive != null)
            return false;
        if (dateOpen != null ? !dateOpen.equals(account.dateOpen) : account.dateOpen != null) return false;
        if (currency != null ? !currency.equals(account.currency) : account.currency != null) return false;
        if (balance != 0 ? !balance.equals(account.balance) : account.balance != null) return false;
        if (accountType != null ? !accountType.equals(account.accountType) : account.accountType != null)
            return false;
        if (dateClose != null ? !dateClose.equals(account.dateClose) : account.dateClose != null) return false;

        return true;
    }

    /**
     * ---
     * @return
     */
    @Override
    public int hashCode() {
        int result = numberAccount != null ? numberAccount.hashCode() : 0;
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        result = 31 * result + (accountActive != null ? accountActive.hashCode() : 0);
        result = 31 * result + (dateOpen != null ? dateOpen.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (accountType != null ? accountType.hashCode() : 0);
        result = 31 * result + (dateClose != null ? dateClose.hashCode() : 0);
        return result;
    }

    /**
     * Выводит всю информацию по аккаунту
     * @return
     */
    @Override
    public String toString() {
        return "Accounts{" +
                "numberAccount='" + numberAccount + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", accountActive=" + accountActive +
                ", dateOpen=" + dateOpen +
                ", currency=" + currency +
                ", balance=" + balance +
                ", accountType=" + accountType +
                ", dateClose=" + dateClose +
                '}';
    }
}
