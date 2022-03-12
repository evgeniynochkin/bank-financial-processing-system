package ru.sbp.bankfinancialprocessingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Card;
import ru.sbp.bankfinancialprocessingsystem.service.CardService;

@SpringBootApplication
public class BankFinancialProcessingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankFinancialProcessingSystemApplication.class, args);
	}
}