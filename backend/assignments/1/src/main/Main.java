package backend.assignment;
import backend.assignment.logging.LogBack;
import backend.assignment.util.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
   public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch,Market market) {
      int transactionCount = jsonTransactions.size();
      ExecutorService executor = Executors.newFixedThreadPool(transactionCount);
      for (JsonNode transaction : jsonTransactions) {
         executor.execute(new ExecuteTransaction(transaction ,market));
         latch.countDown();
      }
      executor.shutdown();

   }
   public static void  main (String[] args) {
      Market market = new Market();

      ObjectMapper mapper = new ObjectMapper();
      JsonNode jsonTransactions = null;
      try {
         jsonTransactions = mapper.readTree(new File(Constants.FILE_JSON_PATH));  // Replace with actual file path
      } catch (Exception e) {
         System.exit(1);  // Exit with error if file loading fails
      }
      int transactionCount = jsonTransactions.size();
      CountDownLatch latch = new CountDownLatch(transactionCount);
      LogBack.infoLogger(String.valueOf(transactionCount));
      executeTransactions(jsonTransactions, latch,market);
      try {
        latch.await();  // Wait for all transactions to complete
      } catch (InterruptedException e) {
         Thread.currentThread().interrupt();
      }
      queryPanel(market);
   }

   public static void queryPanel(Market market){
      Scanner scanner = new Scanner(System.in);
      boolean running = true;
      while(running){
         LogBack.infoLogger("\n1.Search a Coin.\n2.Display N Top Coins\n3.Search Trader's portfolio\n4.Search Trader's Profit or Loss\n5.See Top 5 and Bottom 5 Traders\n6.Exit\n");
           int choice = scanner.nextInt();
         switch (choice){
            case 1 :findCoin(market);
                     break;
            case 2: topCoins(market);
                     break;
            case 3: printTraderProtfolio(market);
                    break;
            case 4: printProfitOrLoss(market);
               break;
            case 5:market.getTopTradersByProfit(5);
                  market.getTopTradersByLoss(5);
                  break;
            case 6:running=false;
                  break;
            default:
               LogBack.infoLogger("Enter a correct Choice\n");
         }
      }
      scanner.close();
   }
   public static void findCoin(Market market){
      Scanner scanner = new Scanner(System.in);
      LogBack.infoLogger("Enter name or Symbol of Coin to Retrieve:");
      String coinName = scanner.next();
      Coin coin = market.findCoinByName(coinName).orElse(null);
      if (coin != null) {
         String coinPrint = String.format("Coin Found:Name:%s Rank: %d Price: %.2f Quantity:%d",coin.getName(),coin.getRank(),coin.getPrice(),coin.getCirculatingSupply());
         LogBack.infoLogger(coinPrint);
      } else {
         LogBack.infoLogger("Coin not Found!");
      }
      scanner.close();
   }

   public static void topCoins(Market market){
      Scanner scanner = new Scanner(System.in);
      LogBack.infoLogger("Enter how many number of coins to see");
      int n = scanner.nextInt();
      market.getTopNCoins(n);
      scanner.close();
   }

   public static void printTraderProtfolio(Market market){
      Scanner scanner = new Scanner(System.in);
      LogBack.infoLogger("Enter Trader's Name");
      Trader trader = market.findTraderByName(scanner.nextLine()).orElse(null);
      if(trader!=null){
         trader.printPortfolio();
      } else {
         LogBack.infoLogger("Trader Not Found");
      }
      scanner.close();
   }

   public static void printProfitOrLoss(Market market){
      Scanner scanner = new Scanner(System.in);
      LogBack.infoLogger("Enter Trader's Name");
      Trader trader = market.findTraderByName(scanner.nextLine()).orElse(null);
      if(trader !=null){
         Double profitOrLoss = trader.getTotalProfitLoss();
         if (profitOrLoss < 0){
            String loss = String.format("Loss : %.2f",profitOrLoss);
            LogBack.infoLogger(loss);
         } else {
            String profit = String.format("Profit : %.2f",profitOrLoss);
            LogBack.infoLogger(profit);
         }
      } else {
         LogBack.infoLogger("Trader Not Found");
      }
      scanner.close();
   }

}