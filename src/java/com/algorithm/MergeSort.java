package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/6/23.
 */
public class MergeSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("12");
        list.add("1");
        Collections.sort(list,(String a,String b)->-1);
        System.out.println(list);
    }
}
