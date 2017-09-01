package org.charles;

public class SecExtra extends Extre {
    public SecExtra(Order order, double price, String label) {
        super(order, price, label);
    }

    @Override
    public double getPrice() {
        return order.getPrice();
    }
}
