package algorithm;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

/**
 * Created by Administrator on 2017/6/23.
 */
public class MergeSort {
    public static void main(String[] args) {
        System.out.println("山炮".substring(0,1));
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("12");
        list.add("1");
        Collections.sort(list,(String a,String b)->a.length() > b.length()?1:(a.length()==b.length()?0:-1));
        System.out.println(list);
    }
}
