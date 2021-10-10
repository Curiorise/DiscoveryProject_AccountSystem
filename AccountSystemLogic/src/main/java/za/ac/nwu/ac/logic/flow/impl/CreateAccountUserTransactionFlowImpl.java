package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.logic.flow.CreateAccountUserTransactionFlow;
import za.ac.nwu.ac.translator.AccountUserTransactionTranslator;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountUserTransactionFlow")
public class CreateAccountUserTransactionFlowImpl implements CreateAccountUserTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountUserTransactionFlowImpl.class);

    private final AccountUserTransactionTranslator accountUserTransactionTranslator;

    @Autowired
    public CreateAccountUserTransactionFlowImpl(AccountUserTransactionTranslator accountUserTransactionTranslator){
        this.accountUserTransactionTranslator = accountUserTransactionTranslator;
    }

    @Override
    public AccountUserTransactionDto create(AccountUserTransactionDto accountUserTransactionDto){
        LOGGER.info("The input object was {}", accountUserTransactionDto);

        if(null == accountUserTransactionDto.getTransactionDate()){
            accountUserTransactionDto.setTransactionDate(LocalDate.now());
        }
        return accountUserTransactionTranslator.create(accountUserTransactionDto);
    }
}
