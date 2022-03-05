package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс ServerController содержит методы реализации REST-контроллера
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@RestController
@RequestMapping("/bank")
public class ServerController {

    private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

    @Value("${appName}")
    private String appName;

    @Value("${dbType}")
    private String dbType;

    @Autowired
    private GlobalUserRepository globalUserRepository;

    @Autowired
    private BankDataRepository bankDataRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CardsRepository cardsRepository;

    /**
     * Метод index выполняет тестирование сервисов Сервера
     * GET http://localhost:8080/bank/test
     * @return - String информационная строка
     */
    @RequestMapping("/test")
    public String index() {

        String responseString = appName + "\n" + " DBMS=" + dbType + "\n" + "Сurrent date and time: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "\n";

        logger.info("Test globalUserRepository.existsById(\"admin\")=" + globalUserRepository.existsById("admin"));
        responseString = responseString + "Test globalUserRepository=" + globalUserRepository.existsById("admin") + ", ";

        logger.info("Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1));
        responseString = responseString + "Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1) + ", ";

        logger.info("Test bankDataRepository.count()=" + clientsRepository.count());
        responseString = responseString + "Test bankDataRepository.count()=" + clientsRepository.count() + ", ";

        logger.info("Test accountsRepository.count()=" + accountsRepository.count());
        responseString = responseString + "Test accountsRepository.count()=" + accountsRepository.count() + ", ";

        logger.info("Test transactionsRepository.count()=" + transactionsRepository.count());
        responseString = responseString + "Test transactionsRepository.count()=" + transactionsRepository.count() + ", ";

        logger.info("Test cardsRepository.count()=" + cardsRepository.count());
        responseString = responseString + "Test cardsRepository.count()=" + cardsRepository.count() + ".";

        return responseString;
    }


}
