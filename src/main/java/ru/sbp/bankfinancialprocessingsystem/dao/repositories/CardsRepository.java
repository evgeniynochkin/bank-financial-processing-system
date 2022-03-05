package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Cards;

/**
 * Интерфейс CardsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Cards#Object()
 */
@Repository
public interface CardsRepository extends CrudRepository<Cards, String> {

}
