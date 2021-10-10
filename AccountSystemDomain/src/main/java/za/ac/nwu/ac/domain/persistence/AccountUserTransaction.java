package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANSACTION", schema = "HR")
public class AccountUserTransaction implements Serializable{

    private static final long serialVersionUID = -7055277179559220101L;

    private Long transactionID;
    private AccountType accountType;
    private Long memberId;
    private Long amount;
    private LocalDate transactionDate;

    public AccountUserTransaction()
    {}

    public AccountUserTransaction(Long transactionID, AccountType accountType, Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.accountType = accountType;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountUserTransaction(Long transactionID,Long memberId, Long amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.memberId = memberId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TRANSACTION_ID", nullable = false)
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType()
    {
        return accountType;
    }

    public void setAccountType(AccountType accountType){
        this.accountType = accountType;
    }

    @Column(name = "MEMBER_ID", nullable = false)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "AMOUNT", nullable = false)
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE", nullable = false)
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
        AccountUserTransaction that = (AccountUserTransaction) o;
        return Objects.equals(transactionID, that.transactionID) && Objects.equals(accountType, that.accountType) && Objects.equals(memberId, that.memberId) && Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionID, accountType, memberId, amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountUserTransaction{" +
                "transactionID=" + transactionID +
                ", accountTypeId=" + accountType +
                ", memberId=" + memberId +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
