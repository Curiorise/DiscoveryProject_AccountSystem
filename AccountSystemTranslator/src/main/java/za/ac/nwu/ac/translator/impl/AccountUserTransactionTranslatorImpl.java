package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.AbstractCachingConfiguration;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.repo.persistence.AccountUserTransactionRepository;
import za.ac.nwu.ac.translator.AccountUserTransactionTranslator;
import java.util.List;

public class AccountUserTransactionTranslatorImpl implements AccountUserTransactionTranslator {

    private final AccountUserTransactionRepository accountUserTransactionRepository;

    @Autowired
    public AccountUserTransactionTranslatorImpl(AccountUserTransactionRepository accountUserTransactionRepository){
        this.accountUserTransactionRepository = accountUserTransactionRepository;
    }

    @Override
    public List<AccountUserTransactionDto> getAllAccountUserTransactions(){

    }
}
