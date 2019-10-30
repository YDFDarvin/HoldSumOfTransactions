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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransactionService extends Thread {
    private static ListOfDeletedElements listOfDeletedElements = new ListOfDeletedElements();
    final private static Long sumOfHold = 1_000_000L;

    @Override
    synchronized public void run() {
        deleteByTimeBorder();
        Iterator<Transaction> transactionIterator = ListOfTransactions.getList().iterator();
        while(transactionIterator.hasNext()) {
            Transaction transaction = transactionIterator.next();

            if (ListOfTransactions.getList().stream().mapToLong(Transaction::getValueOfTransaction).sum()
                        >= sumOfHold
                    + transaction.getValueOfTransaction()) {
                    transactionIterator.remove();
                    ListOfDeletedElements.getList().add(transaction);
            }
        }
    }

    private void deleteByTimeBorder() {
        Iterator<Transaction> transactionIterator = ListOfTransactions.getList().iterator();

        while (transactionIterator.hasNext()) {
            Transaction transaction = transactionIterator.next();
            if (System.currentTimeMillis() - transaction.getIncomeTime() >= 60_000) {
                transactionIterator.remove();
                ListOfDeletedElements.getList().add(transaction);
            }
        }
    }

}
