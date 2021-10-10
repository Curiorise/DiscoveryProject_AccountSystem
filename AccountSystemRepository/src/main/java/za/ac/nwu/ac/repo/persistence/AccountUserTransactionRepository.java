package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.AccountUserTransaction;

@Repository
public interface AccountUserTransactionRepository extends JpaRepository<AccountUserTransaction, Long> {

    @Query(value = "SELECT " +
            "at" +
            "   FROM " +
            "   AccountUserTransaction at" +
            "   WHERE at.transactionID = :transactionID")
    AccountUserTransactionDto getAccountUserTransaction(Long transactionID);


}
