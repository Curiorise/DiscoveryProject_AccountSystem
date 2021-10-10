package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import java.util.List;

public interface FetchAccountUserTransactionFlow {

    List<AccountUserTransactionDto> getAllAccountUserTransactions();

    AccountUserTransactionDto  getAccountUserTransaction(Long transactionID);
}
