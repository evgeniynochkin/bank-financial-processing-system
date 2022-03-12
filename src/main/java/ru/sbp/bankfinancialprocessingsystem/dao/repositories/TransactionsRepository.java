package ru.sbp.bankfinancialprocessingsystem.dao.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;

import java.util.Collection;
import java.util.List;

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

    Transactions findByCodeAuthorization (String codeAuthorization);

    Transactions findAllByNumberAccount (String numberAccount);
//    @Query("select e from StudentEntity e where e.courseNumber in :courses" )
//    List<StudentEntity> getStudentBySingleCourse(@Param("courses") Collection<Integer> cList);

}
