package edu.cscc.transactions;

public class TransactionSynchronization {
    private TransactionsReader.TransactionIterator transactionIterator;

    public TransactionSynchronization(TransactionsReader transActionsReader) {
        this.transactionIterator = (TransactionsReader.TransactionIterator) transActionsReader.iterator();
    }


    public boolean hasNext(){
        return this.transactionIterator.hasNext();
    }

    public Transaction peek() {
        return this.transactionIterator.peek();
    }

    public Transaction next() {
        return this.transactionIterator.next();
    }
}
