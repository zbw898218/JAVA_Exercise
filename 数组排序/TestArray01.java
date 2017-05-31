package Exercise;

/**
 * Created by Charles on 2017/5/31
 */
public class TestArray01 {
public static void main(String[] args){
    int[] arr={5,2,1,3,4,7,3,6,1,5,7,5,1};
    int max=arr[0];
    int min=arr[0];
    int flg;
//直接排序
    for(int x=0;x<arr.length-1;x++){
        for(int y=x+1;y<arr.length;y++){
            if(arr[x]<arr[y]){
                flg=arr[x];
                arr[x]=arr[y];
                arr[y]=flg;
            }
        }
    }

//冒泡排序

        for (int x=0;x<arr.length;x++){
            for(int y=0;y<arr.length-x-1;y++){
                if(arr[y]>arr[y+1]){
                    flg=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=flg;
                }
            }
        }



//插入法
    for(int i=0;i<arr.length;i++) {
        for (int j = i; j > 0; j--) {
            if (arr[j - 1] < arr[j]) {
                flg = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = flg;
            }
        }
    }

    for(int i:arr){
        System.out.print(i+" ");
    }

}

}
