package com.lhd;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lihongde on 2016/10/24 15:56
 */
public class Test {

    public  static void main(String[] args){


        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Iterator<Integer> it = list.iterator();

        //Collections.sort(list);

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }


}


