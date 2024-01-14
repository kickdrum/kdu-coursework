package org.handson.entitites.concrete;

import org.handson.Constants;
import org.handson.logger.MyLogger;

import java.util.*;

public class Trader {
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String walletAddress;
   private Double netProfit;
   private Map<String, CoinInfo> coinsBought = new HashMap<>();
   /**
    * Sets the first name.
    *
    * @param  firstName  the first name to set
    */
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   /**
    * Sets the net profit value.
    *
    * @param  netProfit  the net profit value to be set
    */
   public void setNetProfit(Double netProfit) {
      this.netProfit = netProfit;
   }

   /**
    * Gets the first name of the object.
    *
    * @return the first name of the object.
    */
   public String getFirstName() {
      return this.firstName;
   }
/**
 * Returns the net profit.
 *
 * @return the net profit
 */
public Double getNetProfit() {
   return this.netProfit;
}
   /**
    * Sets the last name of the object.
    *
    * @param  lastName  the new last name to be set
    */
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   /**
    * Returns the last name of the object.
    *
    * @return  the last name of the object
    */
   public String getLastName() {
      return this.lastName;
   }

   /**
    * Sets the phone number.
    *
    * @param  phoneNumber  the phone number to be set
    */
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   /**
    * Returns the phone number associated with this object.
    *
    * @return the phone number
    */
   public String getPhoneNumber() {
      return this.phoneNumber;
   }

   /**
    * Sets the wallet address.
    *
    * @param  walletAddress  the wallet address to be set
    */
   public void setWalletAddress(String walletAddress) {
      this.walletAddress = walletAddress;
   }

   /**
    * Retrieves the wallet address.
    *
    * @return the wallet address
    */
   public String getWalletAddress() {
      return this.walletAddress;
   }

   /**
    * Adds a coin to the collection of coins bought.
    *
    * @param  coin     the name of the coin to be added
    * @param  price    the price of the coin
    * @param  quantity the quantity of the coin to be added
    */
   public void addCoin(String coin,Double price, Long quantity)
   {
      CoinInfo coinInfo = coinsBought.get(coin);
      if (coinInfo == null) {
         coinInfo = new CoinInfo(price, quantity);
      } else {
         Double previousPrice = coinInfo.getPrice();
         coinInfo.setPrice((previousPrice+price)/2);
         coinInfo.setQuantity(coinInfo.getQuantity() + quantity);

         MyLogger.customLogger("Coin has been previously bought: quantity-> "+coinInfo.getQuantity()+" price: "+coinInfo.getPrice()+" updated from "+previousPrice,"DEBUG");
      }
      coinsBought.put(coin, coinInfo);

   }
   /**
    * Removes a specified quantity of a coin from the list of coins bought.
    *
    * @param  coin      the name of the coin to be removed
    * @param  quantity  the quantity of the coin to be removed
    * @return           the total value of the removed coins
    */
   public Double removeCoin(String coin,Long quantity)
   {
      CoinInfo coinInfo = coinsBought.get(coin);
      if(coinInfo==null)
      {
         MyLogger.customLogger("Insufficient information",Constants.ERROR_LOGGER);
         return null;
      }
      if(coinInfo.getQuantity().equals(quantity))
      {
         MyLogger.customLogger("Quantity of buying = selling",Constants.INFO_LOGGER);// displau message that quantity is the same
         coinsBought.remove(coin);
      }
      else
      {
         MyLogger.customLogger("The price the coin was bought at: "+coinInfo.getPrice(),Constants.DEBUG_LOGGER);
         coinInfo.setQuantity(coinInfo.getQuantity()-quantity);
      }

      return coinInfo.getPrice()*quantity;
   }
   /**
    * Determines if a specific coin has been bought.
    *
    * @param  coin  the coin to check if it has been bought
    * @return       true if the coin has been bought, false otherwise
    */
   public boolean isBought(String coin)
   {
      return coinsBought.containsKey(coin);
   }
   /**
    * Returns a string representation of the Trader object.
    *
    * @return  a string representation of the Trader object
    */
   @Override
   public String toString()
   {
      return "Trader{" +
              "firstName='" + firstName + '\'' +
              ", lastName='" + lastName + '\'' +
              ", phoneNumber='" + phoneNumber + '\'' +
              ", walletAddress='" + walletAddress + '\'' +
              ", netProfit=" + netProfit +
              ", coinsBought=" + coinsBought.keySet() +
              '}';
   }
   private static class CoinInfo {
      private Double price;
      private Long quantity;

      public CoinInfo(Double price, Long quantity) {
         this.price = price;
         this.quantity = quantity;
      }

      /**
       * Retrieves the price of the object.
       *
       * @return the price of the object
       */
      public Double getPrice() {
         return price;
      }
      public void setPrice(Double price)
      {
         this.price=price;
      }

      /**
       * Retrieves the quantity.
       *
       * @return the quantity
       */
      public Long getQuantity() {
         return quantity;
      }

      /**
       * Sets the quantity for the object.
       *
       * @param  quantity  the new quantity to be set
       */
      public void setQuantity(Long quantity) {
         this.quantity = quantity;
      }
   }
}
