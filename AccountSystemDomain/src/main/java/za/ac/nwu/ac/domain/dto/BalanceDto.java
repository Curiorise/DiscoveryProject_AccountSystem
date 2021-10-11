package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.AccountUserTransaction;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class BalanceDto implements Serializable {

    private Long balanceID;
    private AccountUserTransaction accountUserTransaction;
    private Long amount;
    private Long amountToAdd;
    private Long amountToSubtract;
    private LocalDate startDate;

    public BalanceDto() {
    }

    public BalanceDto(Long balanceID, AccountUserTransaction accountUserTransaction, Long amount, Long amountToAdd, Long amountToSubtract, LocalDate startDate) {
        this.balanceID = balanceID;
        this.accountUserTransaction = accountUserTransaction;
        this.amount = amount;
        this.amountToAdd = amountToAdd;
        this.amountToSubtract = amountToSubtract;
        this.startDate = startDate;
    }

    @ApiModelProperty(position = 1,
            value = "Balance ID",
            name = "BalanceID",
            notes = "Uniquely identifies the Account Balance ID",
            dataType = "java.lang.String",
            example = "45",
            required = true)
    public Long getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(Long balanceID) {
        this.balanceID = balanceID;
    }

    @JsonIgnore
    public AccountUserTransaction getAccountUserTransaction() {
        return accountUserTransaction;
    }

    public void setAccountUserTransaction(AccountUserTransaction accountUserTransaction) {
        this.accountUserTransaction = accountUserTransaction;
    }

    @ApiModelProperty(position = 2,
            value = "amount",
            name = "Amount",
            notes = "Identifies the available amount",
            dataType = "java.lang.String",
            example = "6090",
            required = true)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 3,
            value = "amountToAdd",
            name = "Amount to Add",
            notes = "Identifies the amount to add to available amount",
            dataType = "java.lang.String",
            example = "45")
    public Long getAmountToAdd() {
        return amountToAdd;
    }

    public void setAmountToAdd(Long amountToAdd) {
        this.amountToAdd = amountToAdd;
    }

    @ApiModelProperty(position = 4,
            value = "amountToSubtract",
            name = "Amount to Subtract",
            notes = "Identifies the amount to subtract from available amount",
            dataType = "java.lang.String",
            example = "45")
    public Long getAmountToSubtract() {
        return amountToSubtract;
    }

    public void setAmountToSubtract(Long amountToSubtract) {
        this.amountToSubtract = amountToSubtract;
    }

    @ApiModelProperty(position = 5,
            value = "startDate",
            name = "startDate",
            notes = "Identifies the start Date",
            dataType = "java.lang.String",
            example = "45")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceDto that = (BalanceDto) o;
        return Objects.equals(balanceID, that.balanceID) && Objects.equals(accountUserTransaction, that.accountUserTransaction) && Objects.equals(amount, that.amount) && Objects.equals(amountToAdd, that.amountToAdd) && Objects.equals(amountToSubtract, that.amountToSubtract) && Objects.equals(startDate, that.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceID, accountUserTransaction, amount, amountToAdd, amountToSubtract, startDate);
    }

    @Override
    public String toString() {
        return "BalanceDto{" +
                "balanceID=" + balanceID +
                ", accountUserTransaction=" + accountUserTransaction +
                ", amount=" + amount +
                ", amountToAdd=" + amountToAdd +
                ", amountToSubtract=" + amountToSubtract +
                ", startDate=" + startDate +
                '}';
    }
}

