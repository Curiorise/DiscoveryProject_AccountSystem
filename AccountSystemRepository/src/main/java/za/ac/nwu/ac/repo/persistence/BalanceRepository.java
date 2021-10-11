package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Balance;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Query(value = "SELECT " +
            "BALANCE_ID," +
            "AMOUNT," +
            "AMOUNT_TO_ADD," +
            "AMOUNT_TO_SUBTRACT," +
            "START_DATE" +
            "  FROM " +
            "HR.BALANCE" +
            "  WHERE TRANSACTION_ID = :transactionId ", nativeQuery = true)
    Balance getBalanceNativeQuery(Long transactionId);
}
