package org.charles;

public class FirExtre extends Extre {
    public FirExtre(Order order, double price, String label) {
        super(order, price, label);
    }

    @Override
    public double getPrice() {
        return order.getPrice()+this.price;
    }


}
