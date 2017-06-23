package algorithm;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/6/23.
 */
public class InsertSort {
    public static void directInsert(int[] a) {
        int[] con = new int[a.length];
        for(int i=0;i<a.length;i++) {
            int temp = a[i];
            int j = i-1;
            while (j>=0&&temp<con[j]) {
                con[j+1] = con[j];
                j--;
            }
            con[j+1] = temp;
        }
        System.out.println(Arrays.toString(con));
    }

    public static void main(String[] args) {
        directInsert(new int[]{8,1,4,7,3,5,9,6});
    }
}
