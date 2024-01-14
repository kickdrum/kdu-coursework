package backend.assignment.transaction;

public class TransactionData {
    private String type;
    private Transaction transaction;
    private String blockHash;
    public String getHash() {
        return blockHash ;
    }
    public void setHash(String blockHash) {
        this.blockHash = blockHash;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
         this.type = type;
    }

    public void setData(Transaction data) {
        this.transaction = data;
    }
    public Transaction getData() {
        return this.transaction;
    }
    public boolean performTransaction() {
        return this.transaction.executeTransaction();
    }
}
