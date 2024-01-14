package backend.assignment.transaction;

public interface Transaction {
    public String getType();
    public void setType(String type);
    public String getCoinName();
    public void setCoinName(String coinName);
    public boolean executeTransaction();
}

