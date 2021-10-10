package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountUserTransaction;
import za.ac.nwu.ac.repo.persistence.AccountUserTransactionRepository;
import za.ac.nwu.ac.translator.AccountUserTransactionTranslator;
import java.util.List;
import java.util.ArrayList;

@Component
public class AccountUserTransactionTranslatorImpl implements AccountUserTransactionTranslator {

    private final AccountUserTransactionRepository accountUserTransactionRepository;

    @Autowired
    public AccountUserTransactionTranslatorImpl(AccountUserTransactionRepository accountUserTransactionRepository) {
        this.accountUserTransactionRepository = accountUserTransactionRepository;
    }

    @Override
    public List<AccountUserTransactionDto> getAllAccountUserTransactions() {

        List<AccountUserTransactionDto> accountUserTransactionDtos = new ArrayList<>();
        try {
            for (AccountUserTransaction accountUserTransaction : accountUserTransactionRepository.findAll()) {
                accountUserTransactionDtos.add(new AccountUserTransactionDto(accountUserTransaction));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
        return accountUserTransactionDtos;
    }

    @Override
    public AccountUserTransactionDto create(AccountUserTransactionDto accountUserTransactionDto) {
        try {
            AccountUserTransaction accountUserTransaction = accountUserTransactionRepository.save(accountUserTransactionDto.getAccountUserTransaction());
            return new AccountUserTransactionDto(accountUserTransaction);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }

    @Override
    public AccountUserTransactionDto getAccountUserTransaction(Long transactionID) {
        try {
            return accountUserTransactionRepository.getAccountUserTransaction(transactionID);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}


