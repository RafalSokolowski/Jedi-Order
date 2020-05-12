package pl.rav.jediorder.support;

import java.util.*;

public class MainTest {

    private static int i;

    public static void main(String[] args) {

//        Runnable

//        Thread;
//        Date;
//        String;
//        Integer;

        System.out.println(returnSth());
        System.out.println(returnSth());

        System.out.println(i);



    }

    private static int returnSth () {
        return i++;
    }
}
