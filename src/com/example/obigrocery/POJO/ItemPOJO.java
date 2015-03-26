package com.example.obigrocery.POJO;

import java.math.BigDecimal;

public class ItemPOJO implements Comparable<ItemPOJO>{
    
    private String name;
    private BigDecimal price;
    private int quantity;
    private String category;
    private boolean purchased;

    public ItemPOJO(String name, BigDecimal price, int quantity, String category) {
        // price should use BigDecimal for money stuff, not double
        // this is due to floating point number's bad precision
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.purchased = (!price.equals(BigDecimal.ZERO) && quantity != 0);
    }
    
    public ItemPOJO(String name, String category) {
        this(name, new BigDecimal(0), 0, category);
    }

    public String getName() {
        return name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getCategory() {
        return category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public boolean isPurchased() {
        return purchased;
    }
    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
    
    @Override
    public String toString() {
        String aString = name + ": " + category;
        if(purchased) {
            aString += "\n\t" + quantity + " x $" + price;
        }
        System.out.println(aString);
        return aString;
    }
    
    @Override
    public boolean equals(Object other) {
        if(other == this) {
            return true;
        }
        if(other == null) {
            return false;
        }
        if(!(other instanceof ItemPOJO)) {
            return false;
        }
        ItemPOJO that = (ItemPOJO)other;
        return this.getName().equals(that.getName())
                && this.getCategory().equals(that.getCategory());
    }
    
    @Override
    public int hashCode() {
        return this.getName().hashCode() + this.getCategory().hashCode();
    }

    @Override
    public int compareTo(ItemPOJO another) {
        if(this.getCategory().compareTo(another.getCategory()) != 0) {
            return this.getCategory().compareTo(another.getCategory());
        }
        return this.getName().compareTo(another.getName());
    }

}
