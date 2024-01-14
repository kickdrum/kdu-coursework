package jav.assignment.Transactions;

import jav.assignment.Coins.Coin;
import jav.assignment.BlockHash.BlockHash;
import jav.assignment.Entities.Buy;
import java.util.concurrent.CountDownLatch;

import static jav.assignment.globalObjects.GlobalData.tradersData;
//
//public class BuyTransaction extends Thread {
//    private Buy buy;
//    private String transactionID;
//
//
//
//    public Buy getBuy() {
//        return buy;
//    }
//
//    public void BuyCoinTransaction(Buy buy) {
//        this.buy = buy;
//    }
//
//    @Override
//    public void run() {
//        synchronized (this.buy.getCoin()) {
//            while ((this.buy.getCoin().getStatus().equals("not-available")) || (this.buy.getCoin().getCirculatingSupply() < this.buy.getQuantity())) {
//                try {
//                    this.buy.getCoin().wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//            this.buy.getCoin().setStatus("not-available");
//            this.transactionID = BlockHash.getBlockHash();
//
//
//            if (tradersData.get(this.buy.getWalletAddress()).tradersCoin.containsKey(this.buy.getCoin().getSymbol())) {
//                long vol = tradersData.get(this.buy.getWalletAddress()).tradersCoin.get(this.buy.getCoin().getSymbol()).getCirculatingSupply() + this.buy.getQuantity();
//                tradersData.get(this.buy.getWalletAddress()).tradersCoin.get(this.buy.getCoin().getSymbol()).setCirculatingSupply(vol);
//
//                Double totalSpendings = tradersData.get(this.buy.getWalletAddress()).getSpending() + this.buy.getQuantity() * this.buy.getCoin().getPrice();
//                tradersData.get(this.buy.getWalletAddress()).setSpending(totalSpendings);
//            } else {
//                Coin coin = new Coin();
//                coin.setName(this.buy.getCoin().getName());
//                coin.setPrice(this.buy.getCoin().getPrice());
//                coin.setSymbol(this.buy.getCoin().getSymbol());
//                coin.setSrNo(this.buy.getCoin().getSrNo());
//                coin.setStatus(this.buy.getCoin().getStatus());
//                coin.setRank(this.buy.getCoin().getRank());
//                coin.setCirculatingSupply(this.buy.getCoin().getCirculatingSupply());
//                tradersData.get(this.buy.getWalletAddress()).tradersCoin.put(coin.getSymbol(), coin);
//                Double totalSpendings = this.buy.getQuantity() * this.buy.getCoin().getPrice();
//                tradersData.get(this.buy.getWalletAddress()).setSpending(totalSpendings);
//            }
//
//            this.buy.getCoin().setCirculatingSupply(buy.getCoin().getCirculatingSupply() - buy.getQuantity());
//            this.buy.getCoin().notifyAll();
//            this.buy.getCoin().setStatus("available");
//            this.buy.setStatus("available");
//        }
//    }
//}

public class BuyTransaction extends Thread {
    private Buy buy;
    private String transactionID;
    private CountDownLatch latch;  // Add this field

    public BuyTransaction(Buy buy, CountDownLatch latch) {
        this.buy = buy;
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this.buy.getCoin()) {
            try {
                while (this.buy.getCoin().getStatus().equals("not-available") || this.buy.getCoin().getCirculatingSupply() < this.buy.getQuantity()) {
                    this.buy.getCoin().wait();
                }

                this.buy.getCoin().setStatus("not-available");
                this.transactionID = BlockHash.getBlockHash();

                if (tradersData.get(this.buy.getWalletAddress()).tradersCoin.containsKey(this.buy.getCoin().getSymbol())) {
                    long vol = tradersData.get(this.buy.getWalletAddress()).tradersCoin.get(this.buy.getCoin().getSymbol()).getCirculatingSupply() + this.buy.getQuantity();
                    tradersData.get(this.buy.getWalletAddress()).tradersCoin.get(this.buy.getCoin().getSymbol()).setCirculatingSupply(vol);

                    Double totalSpendings = tradersData.get(this.buy.getWalletAddress()).getSpending() + this.buy.getQuantity() * this.buy.getCoin().getPrice();
                    tradersData.get(this.buy.getWalletAddress()).setSpending(totalSpendings);
                } else {
                    Coin coin = new Coin();
                    coin.setName(this.buy.getCoin().getName());
                    coin.setPrice(this.buy.getCoin().getPrice());
                    coin.setSymbol(this.buy.getCoin().getSymbol());
                    coin.setSrNo(this.buy.getCoin().getSrNo());
                    coin.setStatus(this.buy.getCoin().getStatus());
                    coin.setRank(this.buy.getCoin().getRank());
                    coin.setCirculatingSupply(this.buy.getCoin().getCirculatingSupply());
                    tradersData.get(this.buy.getWalletAddress()).tradersCoin.put(coin.getSymbol(), coin);
                    Double totalSpendings = this.buy.getQuantity() * this.buy.getCoin().getPrice();
                    tradersData.get(this.buy.getWalletAddress()).setSpending(totalSpendings);
                }

                this.buy.getCoin().setCirculatingSupply(buy.getCoin().getCirculatingSupply() - buy.getQuantity());
                this.buy.getCoin().notifyAll();
                this.buy.getCoin().setStatus("available");
                this.buy.setStatus("available");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // Count down the latch after the transaction is completed
                latch.countDown();
            }
        }
    }
}
