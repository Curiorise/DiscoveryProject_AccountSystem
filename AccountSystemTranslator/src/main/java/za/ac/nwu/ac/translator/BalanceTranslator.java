package za.ac.nwu.ac.translator;

import za.ac.nwu.ac.domain.persistence.Balance;

public interface BalanceTranslator {

    Balance getBalanceNativeQuery(Long transactionId);
}
