package lhd;


import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by lihongde on 2016/10/24 15:56
 */
public class Test {

    public  static void main(String[] args){



        NumberFormat percentFormat = new DecimalFormat("0.00%");
        double d = (double)10368 / (double)101933;
        String s = percentFormat.format(d);
        System.out.println(s);

    }


}


