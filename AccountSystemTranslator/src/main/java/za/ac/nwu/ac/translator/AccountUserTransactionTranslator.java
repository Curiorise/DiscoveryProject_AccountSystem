package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;

import java.util.List;

public interface AccountUserTransactionTranslator {

    AccountUserTransactionDto create(AccountUserTransactionDto accountUserTransactionDto);

    List<AccountUserTransactionDto> getAllAccountUserTransactions();

    AccountUserTransactionDto  getAccountUserTransaction(Long transactionID);
}
