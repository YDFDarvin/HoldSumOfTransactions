package sample.model;

/* threadsForProhor
 *
 * variant 2
 *
 * by Andrukh Sergey
 * 243(2), IFTKN,
 * department Software Engineering
 *
 * 10/21/19
 *
 * (c) YDFD corporated
 */

public class Transaction {
    Long valueOfTransaction;
    Long incomeTime;

    public Transaction() {
    }

    public Transaction(Long valueOfTransaction, Long incomeTime) {
        this.valueOfTransaction = valueOfTransaction;
        this.incomeTime = incomeTime;
    }

    public Transaction(Long valueOfTransaction) {
        this.valueOfTransaction = valueOfTransaction;
        this.incomeTime = System.currentTimeMillis();
    }

    public Long getValueOfTransaction() {
        return valueOfTransaction;
    }

    public Long getIncomeTime() {
        return incomeTime;
    }
}
