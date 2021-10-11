package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.Balance;
import za.ac.nwu.ac.repo.persistence.BalanceRepository;
import za.ac.nwu.ac.translator.BalanceTranslator;

@Component
public class BalanceTranslatorImpl implements BalanceTranslator {

    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceTranslatorImpl(BalanceRepository balanceRepository){
        this.balanceRepository = balanceRepository;
    }

    @Override
    public Balance getBalanceNativeQuery(Long transactionId){
        try{

            return balanceRepository.getBalanceNativeQuery(transactionId);

        }catch (Exception e) {
            throw new RuntimeException("Unable to read from the DB", e);
        }
    }
}
