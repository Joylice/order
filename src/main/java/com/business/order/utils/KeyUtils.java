package com.business.order.utils;

import java.util.Random;

public class KeyUtils {
    public  String getUniqueKey() {

        return Integer.toString(new Random(10).nextInt(10000));
    }
}
