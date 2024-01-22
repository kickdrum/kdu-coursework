package org.handson.components;

public enum Speaker
{
    BOSE("BOSE",100),
    SONY("SONY",12);

    private  String name;
    private  int price;

    Speaker(String name, int price)
    {
        this.name = name;
        this.price= price;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice()
    {
       return this.price;
    }
    /**
     * Retrieve the name of the object.
     *
     * @return         	the name of the object
     */
    public String getName()
    {
        return this.name;
    }
}
