package org.handson.entitites.concrete;

public class Coins {
    private String index;
    private String rank;
    private String name;
    private String symbol;
    private String price;
    private String circulatingSupply;
    private String startingValue;

    public Coins()
    {}

    public Coins( Integer index,String name, String symbol, Double price, Long circulatingSupply)
    {
        this.index=index.toString();
        this.circulatingSupply=circulatingSupply.toString();
        this.name=name;
        this.symbol=symbol;
        this.price=price.toString();
    }
    /**
     * Sets the index value.
     *
     * @param  index  the new value for the index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Retrieves the index value.
     *
     * @return         	The index value.
     */
    public String getIndex() {
        return this.index;
    }
    /**
     * Sets the starting value for the volume.
     *
     * @param  volume  the volume value to set
     */
    public void setStartingValue(String volume)
    {
        this.startingValue = volume;
    }

    /**
     * Sets the rank of the object.
     *
     * @param  rank  the rank to be set
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * Retrieves the rank of the object.
     *
     * @return          the rank of the object
     */
    public String getRank() {
        return this.rank;
    }
    /**
     * Retrieves the initial coin value.
     *
     * @return the starting value of the coin
     */
    public String getInitialCoinValue()
    {
        return startingValue;
    }
    /**
     * Sets the coin name.
     *
     * @param  name  the name of the coin
     */ 
    public void setCoinName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the coin.
     *
     * @return  the name of the coin
     */
    public String getCoinName() {
        return this.name;
    }

    /**
     * Sets the symbol for the object.
     *
     * @param  symbol  the symbol to be set
     */
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Retrieves the symbol of the coin.
     *
     * @return         	The symbol of the coin.
     */
    public String getCoinSymbol() {
        return this.symbol;
    }

    /**
     * Sets the price of this object.
     *
     * @param  price  the new price to be set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Retrieves the price of the object.
     *
     * @return the price of the objecta
     */
    public String getPrice() {
        return this.price;
    }

    /**
     * Sets the circulating supply of the object.
     *
     * @param  circulatingSupply  the new circulating supply to be set
     */
    public void setCirculatingSupply(String circulatingSupply) {
        if (startingValue == null) {
            setStartingValue(circulatingSupply);
        }
        this.circulatingSupply = circulatingSupply;
    }

    /**
     * Returns the circulating supply value.
     *
     * @return  the circulating supply value
     */
    public String getCirculatingSupply() {
        if (startingValue == null) {
            setStartingValue(circulatingSupply);
        }
        return this.circulatingSupply;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return          a string representation of the object
     */
    public String toString()
    {
        return "Name:"+name+" Price:"+price+" Symbol:"+symbol+" Circulating Value:"+circulatingSupply;
    }

}
