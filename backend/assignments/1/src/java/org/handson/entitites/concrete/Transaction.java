package org.handson.entitites.concrete;

import org.handson.entitites.transactiondata.TransactionData;

public class Transaction {
    private String type;
    private TransactionData transactionData;
    private String blockHash;
    /**
     * Retrieves the hash value of the block.
     *
     * @return  the hash value of the block
     */
    public String getHash() {
        return blockHash ;
    }

    /**
     * Sets the value of the block hash.
     *
     * @param  blockHash  the new block hash to be set
     */
    public void setHash(String blockHash) {
        this.blockHash = blockHash;
    }

    /**
     * Sets the type of the object.
     *
     * @param  type  the new type for the object
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retrieves the type of the object.
     *
     * @return  the type of the object
     */
    public String getType() {
        return this.type;
    }

    /**
     * Sets the transaction data for the object.
     *
     * @param  data  the transaction data to be set
     */
    public void setData(TransactionData data) {
        this.transactionData = data;
    }

    /**
     * Returns the transaction data.
     *
     * @return the transaction data
     */
    public TransactionData getData() {
        return this.transactionData;
    }

    /**
     * Perform a transaction.
     *
     * @return  a boolean indicating the success of the transaction
     */
    public boolean performTransaction() {
        return this.transactionData.performTransaction();
    }

    
}
