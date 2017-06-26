package Exercise.Work0606;

/**
 * Created by Charles on 2017/6/6.
 */

/**
 * 自定义一个泛型的比较器接口提供通用比较方法
 * 自定义一个泛型方法类Algo，利用接口提供的比较方法，获得极值并返回
 * @param <T> ：泛型类型，实际类型用时指定
 */
public interface ILess<T> {
    boolean less(T x,T y);
}
class Algo<T>{
    public  T getMax(T[] x,ILess y){
        T max=x[0];
        for(int i=0;i<x.length;i++){
            if(y.less(max,x[i])){
                max=x[i];
            }
        }
        return max;
    }
    public  T getMin(ILess y,T[] x){
        T min=x[0];
        for(int i=0;i<x.length;i++){
            if(y.less(x[i],min)){
                min=x[i];
            }
        }
        return min;
    }
}
