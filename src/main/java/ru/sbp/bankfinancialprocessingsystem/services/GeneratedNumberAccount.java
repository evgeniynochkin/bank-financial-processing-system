package ru.sbp.bankfinancialprocessingsystem.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;

@Service
public class GeneratedNumberAccount {

    /**
     * Номер нового счета.
     */
    private String newNumberCard;

    /**
     * Настраиваемая длинна счета.
     */
    private int lenghtNumberCard;

    /**
     * Вызов у application.properties данных.
     * @param lenghtNumberCard
     */
    @Value("${length.number.card}")
    public void setLenghtNumberCard(int lenghtNumberCard) {
        this.lenghtNumberCard = lenghtNumberCard;
    }

    /**
     * Связь с репозеторием db.
     */
    @Autowired
    private AccountRepository repository;

    /**
     * Вызов entity для работы с db.
     */
    @Autowired
    private Account account;

    public GeneratedNumberAccount(){
    }

    /**
     * Генерация нового номера счета и проверка ,что такого номера
     * нет в bd c помощью NullPointerException.
     * @return
     * @throws NullPointerException
     */
    public String getNumberAccount() throws NullPointerException{

        int x = 0;
        do{
         newNumberCard = RandomStringUtils.randomNumeric(lenghtNumberCard);
         account = repository.findByNumberAccount(newNumberCard);
            try {
                account.getNumberAccount();
            }catch(NullPointerException e){
                System.out.println("Creating number account");
                return newNumberCard;
            }
            x++;
        }while (x > 0);
        return null;
    }
}
