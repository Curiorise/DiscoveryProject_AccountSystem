package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BALANCE", schema = "HR")
public class Balance implements Serializable {

    private Long balanceID;
    private AccountUserTransaction accountUserTransaction;
    private Long amount;
    private Long amountToAdd;
    private Long amountToSubtract;
    private LocalDate startDate;

    public Balance(){}

    public Balance(Long balanceID, AccountUserTransaction accountUserTransaction, Long amount, Long amountToAdd, Long amountToSubtract, LocalDate startDate) {
        this.balanceID = balanceID;
        this.accountUserTransaction = accountUserTransaction;
        this.amount = amount;
        this.amountToAdd = amountToAdd;
        this.amountToSubtract = amountToSubtract;
        this.startDate = startDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BALANCE_ID", nullable = false)
    public Long getBalanceID() {
        return balanceID;
    }

    public void setBalanceID(Long balanceID) {
        this.balanceID = balanceID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID")
    public AccountUserTransaction getAccountUserTransaction() {
        return accountUserTransaction;
    }

    public void setAccountUserTransaction(AccountUserTransaction accountUserTransaction) {
        this.accountUserTransaction = accountUserTransaction;
    }

    @Column(name = "AMOUNT", nullable = false)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "AMOUNT_TO_ADD", nullable = false)
    public Long getAmountToAdd() {
        return amountToAdd;
    }

    public void setAmountToAdd(Long amountToAdd) {
        this.amountToAdd = amountToAdd;
    }

    @Column(name = "AMOUNT_TO_SUBTRACT", nullable = false)
    public Long getAmountToSubtract() {
        return amountToSubtract;
    }

    public void setAmountToSubtract(Long amountToSubtract) {
        this.amountToSubtract = amountToSubtract;
    }

    @Column(name = "START_DATE", nullable = false)
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
        Balance balance = (Balance) o;
        return Objects.equals(balanceID, balance.balanceID) && Objects.equals(accountUserTransaction, balance.accountUserTransaction) && Objects.equals(amount, balance.amount) && Objects.equals(amountToAdd, balance.amountToAdd) && Objects.equals(amountToSubtract, balance.amountToSubtract) && Objects.equals(startDate, balance.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balanceID, accountUserTransaction, amount, amountToAdd, amountToSubtract, startDate);
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balanceID=" + balanceID +
                ", accountUserTransaction=" + accountUserTransaction +
                ", amount=" + amount +
                ", amountToAdd=" + amountToAdd +
                ", amountToSubtract=" + amountToSubtract +
                ", startDate=" + startDate +
                '}';
    }
}
