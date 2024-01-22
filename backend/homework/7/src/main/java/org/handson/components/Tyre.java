package org.handson.components;

public enum Tyre {
    MRF("MRF",300),
    BRIGESTONE("Brigestone",3000);

    private String brand;
    private int price;
    Tyre(String brand, int price)
    {
        this.brand = brand;
        this.price = price;
    }
    /**
     * Retrieves the price of the object.
     *
     * @return         	the price of the object
     */
    public int getPrice()
    {
        return this.price;
    }
    /**
     * Get the name of the object.
     *
     * @return the brand name
     */
    public String getName()
    {
        return this.brand;
    }
}
