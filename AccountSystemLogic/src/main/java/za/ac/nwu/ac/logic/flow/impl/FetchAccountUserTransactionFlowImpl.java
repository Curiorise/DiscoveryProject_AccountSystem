package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.logic.flow.FetchAccountUserTransactionFlow;
import za.ac.nwu.ac.translator.AccountUserTransactionTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountUserTransactionFlowImpl implements FetchAccountUserTransactionFlow {

    private final AccountUserTransactionTranslator accountUserTransactionTranslator;

    @Autowired
    public FetchAccountUserTransactionFlowImpl(AccountUserTransactionTranslator accountUserTransactionTranslator){
        this.accountUserTransactionTranslator = accountUserTransactionTranslator;
    }

    @Override
    public List<AccountUserTransactionDto> getAllAccountUserTransactions(){
        return accountUserTransactionTranslator.getAllAccountUserTransactions();
    }

    @Override
    public AccountUserTransactionDto getAccountUserTransaction(Long transactionID){
        return accountUserTransactionTranslator.getAccountUserTransaction(transactionID);
    }
}
