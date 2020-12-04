package edu.cscc.transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionsThread extends Thread {
    public String date;
    public TransactionSynchronization transactionSynchronization;
    public List <String> rentalList = new ArrayList<>();

    public TransactionsThread(TransactionSynchronization transactionSynchronization, String date) {
        super();
        this.date = date;
        this.transactionSynchronization = transactionSynchronization;
    }

    @Override
    public void run() {
        Transaction thisTransaction = null;
        System.out.println("Thread Started " + date);
             do {

                    synchronized (transactionSynchronization) {
                        thisTransaction = transactionSynchronization.peek();

                }
                    if (thisTransaction != null && thisTransaction.getDate().equals(date)) {
                       rentalList.add(thisTransaction.getRentalId());

                        synchronized (transactionSynchronization) {
                            transactionSynchronization.next();
                        }

                    }
                    else {
                        try {
                            Thread.sleep(500L); //Sleep for 0.5 seconds.
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }  while (thisTransaction != null);

            System.out.println("Rental ID's for " + date);
        for (String rental:rentalList) {
            System.out.println("Rental ID " + rental);
        }
    }

}




