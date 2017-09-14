package org.charles;

public enum MyEnum {
    target{
          TargetClz getTargetClz(){
            return getInst.targetClz;
        }
    };
    private static TargetClz targetClz;
    MyEnum(){
    }
    static class getInst{
        private static final TargetClz targetClz=new TargetClz();
    }

    abstract TargetClz getTargetClz();
}
