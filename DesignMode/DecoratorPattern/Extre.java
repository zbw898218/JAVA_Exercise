package org.charles;

public abstract class Extre implements Order  {
    protected Order order;
    protected double price;
    protected String label;
    public Extre() {
    }

    public Extre(Order order, double price, String label) {
        this.order = order;
        this.price = price;
        this.label = label;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getLabel() {
        return order.getLabel()+","+label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
