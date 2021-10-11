package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountUserTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.logic.flow.CreateAccountUserTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountUserTransactionTranslator;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createAccountUserTransactionFlow")
public class CreateAccountUserTransactionFlowImpl implements CreateAccountUserTransactionFlow {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountUserTransactionFlowImpl.class);

    private final AccountUserTransactionTranslator accountUserTransactionTranslator;
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public CreateAccountUserTransactionFlowImpl(AccountUserTransactionTranslator accountUserTransactionTranslator,
                                                FetchAccountTypeFlow fetchAccountTypeFlow){
        this.accountUserTransactionTranslator = accountUserTransactionTranslator;
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @Override
    public AccountUserTransactionDto create(AccountUserTransactionDto accountUserTransactionDto){
        if(LOGGER.isInfoEnabled()){
            String outputForLogging = "null";
            if((null != accountUserTransactionDto) && (null != accountUserTransactionDto.getTransactionDate())){
               outputForLogging = accountUserTransactionDto.getTransactionDate().toString();
            }
            LOGGER.info("The input object was {} and the Transaction Date is {}", accountUserTransactionDto, outputForLogging);
        }


        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Got AccountUserTransaction for transaction ID {}", accountUserTransactionDto.getTransactionID());
        }

        LOGGER.info("The return object is {}", accountUserTransactionTranslator.create(accountUserTransactionDto));

        return accountUserTransactionTranslator.create(accountUserTransactionDto);
    }
}
