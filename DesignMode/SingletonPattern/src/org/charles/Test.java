package org.charles;

public class Test {
    public static void main(String[] args) {
        TargetClz t1=MyEnum.target.getTargetClz();
        TargetClz t2=MyEnum.target.getTargetClz();
        TargetClz t3=MyEnum.target.getTargetClz();

        System.out.println(t1.getI());
        System.out.println(t2.getI());
        System.out.println(t3.getI());

    }
}
