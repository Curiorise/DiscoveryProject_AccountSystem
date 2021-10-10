package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;

public interface CreateAccountUserTransactionFlow {
    AccountUserTransactionDto create(AccountUserTransactionDto accountUserTransactionDto);
}
