package ru.sbp.bankfinancialprocessingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.sbp.bankfinancialprocessingsystem.config.ServerConfig;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Account;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountRepository;
import ru.sbp.bankfinancialprocessingsystem.services.AccountService;


@SpringBootApplication
public class BankFinancialProcessingSystemApplication {

	public static void main(String[] args) {


		SpringApplication.run(BankFinancialProcessingSystemApplication.class, args);

	}
}
