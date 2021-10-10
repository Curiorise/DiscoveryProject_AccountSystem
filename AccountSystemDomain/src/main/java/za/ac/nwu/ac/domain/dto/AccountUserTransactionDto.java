package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.AccountUserTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountUserTransaction", description = "A DTO that represents the AccountUserTransactions")

public class AccountUserTransactionDto implements Serializable {

    private Long transactionID;
    private Long amount;
    private LocalDate transactionDate;

    public AccountUserTransactionDto(){}

    public AccountUserTransactionDto(Long transactionID, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountUserTransactionDto(AccountUserTransaction accountUserTransaction){
        this.setTransactionID(accountUserTransaction.getTransactionID());
        this.setAmount(accountUserTransaction.getAmount());
        this.setTransactionDate(accountUserTransaction.getTransactionDate());
    }

    @ApiModelProperty(position = 1,
            value = "AccountUserTransaction ID",
            name = "Transaction ID",
            notes = "Identifies the AccountUser Transaction ID",
            dataType = "java.lang.String",
            example = "550",
            required = true)
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountUserTransaction Amount",
            name = "Amount",
            notes = "Identifies the available Amount for a specific AccountType",
            dataType = "java.lang.String",
            example = "550",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value = "Account User Transaction Date",
            name = "TransactionDate",
            notes = "The date on which the AccountTransaction was performed",
            dataType = "java.lang.String",
            example = "2020-08-01",
            allowEmptyValue = true)
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountUserTransactionDto that = (AccountUserTransactionDto) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountUserTransactionDto{" +
                "transactionID=" + transactionID +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
