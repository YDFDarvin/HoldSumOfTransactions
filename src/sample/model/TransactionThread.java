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

public class TransactionThread extends Thread {

    private Integer min;
    private Integer max;

    public TransactionThread() {
    }

    public TransactionThread(Integer min, Integer max) {
        this.min = min;
        this.max = max;
    }

    public Transaction getNewTransaction() throws InterruptedException {
        return new Transaction((long) ((Math.random() * ((max - min) + 1)) + min));
    }

    @Override
    synchronized public void run() {
        try {
            ListOfTransactions.getList().add(this.getNewTransaction());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
