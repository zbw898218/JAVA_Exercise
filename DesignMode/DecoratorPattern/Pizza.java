package org.charles;

public class Pizza implements Order {
    private double price;
    private String label;

    public Pizza() {

    }
    public Pizza(double price, String label) {
        this.price = price;
        this.label = label;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getLabel() {
        return label;
    }
}
