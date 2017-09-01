package org.charles;

public class Test {
    public static void main(String[] args) {
        Order p1=new Pizza(10,"四季披萨");
        p1=new FirExtre(p1,2,"奶酪");
        p1=new SecExtra(p1,4,"辣椒");
        System.out.println(p1.getLabel());
        System.out.println(p1.getPrice());
    }
}
