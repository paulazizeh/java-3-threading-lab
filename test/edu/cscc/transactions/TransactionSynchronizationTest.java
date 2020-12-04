package edu.cscc.transactions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class TransactionSynchronizationTest {

    private TransactionSynchronization synchronization;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        FileReader fileReader = new FileReader("." + File.separator + "rental_transactions.csv");
        TransactionsReader transactionsReader = new TransactionsReader(fileReader);
        synchronization = new TransactionSynchronization(transactionsReader);
    }

    @org.junit.jupiter.api.Test
    void hasNext() {
        assertEquals(true, synchronization.hasNext());
    }

    @org.junit.jupiter.api.Test
    void peek() {
        assertEquals("2020-09-08", synchronization.peek().getDate());
    }

    @org.junit.jupiter.api.Test
    void next() {
        assertEquals("2020-09-08", synchronization.next().getDate());
    }
}