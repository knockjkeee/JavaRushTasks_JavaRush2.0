package Test;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Main {


    public static void main(String[] args) {
        System.out.println(numberFormat(123456789));

    }

    public static String numberFormat(int a) {
        DecimalFormat pp = new DecimalFormat("0000000000");
        String result = pp.format(a);
        MessageFormat mm = new MessageFormat("({0}){1}-{2}-{3}");
        String[] arr = {result.substring(0, 3), result.substring(3, 6), result.substring(6, 8), result.substring(8)};
        return "+38" + mm.format(arr);
    }

}

//    long phoneFmt = 123456789L;
//    //get a 12 digits String, filling with left '0' (on the prefix)
//    DecimalFormat phoneDecimalFmt = new DecimalFormat("0000000000");
//    String phoneRawString= phoneDecimalFmt.format(phoneFmt);
//
//    java.text.MessageFormat phoneMsgFmt=new java.text.MessageFormat("({0})-{1}-{2}");
//    //suposing a grouping of 3-3-4
//    String[] phoneNumArr={phoneRawString.substring(0, 3),
//            phoneRawString.substring(3,6),
//            phoneRawString.substring(6)};
//
//System.out.println(phoneMsgFmt.format(phoneNumArr));