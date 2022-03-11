package ru.sbp.bankfinancialprocessingsystem.dao.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;

/**
 * Интерфейс TransactionsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @autor Sergey Vasiliev
 */
@Repository
public interface TransactionsRepository extends  JpaRepository<Transactions, String> {

    Transactions findByNumberAccount (String numberAccount);

    Transactions findByCodeAuthorization (String numberAccount);

}
