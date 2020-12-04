package edu.cscc;

import edu.cscc.transactions.TransactionSynchronization;
import edu.cscc.transactions.TransactionsReader;
import edu.cscc.transactions.TransactionsThread;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("." + File.separator + "rental_transactions.csv");
            TransactionsReader transactionsReader = new TransactionsReader(fileReader);
            TransactionSynchronization synchronization = new TransactionSynchronization(transactionsReader);
            Thread thread1 = new TransactionsThread(synchronization, "2020-09-07" );
            Thread thread2 = new TransactionsThread(synchronization, "2020-09-08" );
            Thread thread3 = new TransactionsThread(synchronization, "2020-09-09" );
            Thread thread4 = new TransactionsThread(synchronization, "2020-09-10" );
            Thread thread5 = new TransactionsThread(synchronization, "2020-09-11" );
            Thread thread6 = new TransactionsThread(synchronization, "2020-09-12" );
            Thread thread7 = new TransactionsThread(synchronization, "2020-09-13" );

            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();

            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
            thread7.join();


            //TODO Implement the solution here.
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
