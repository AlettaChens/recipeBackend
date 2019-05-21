package com.example.food.utils;

import java.util.Random;
import java.util.UUID;

public class UUIDutils {

    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }

    public static long getLongUUID() {
        long result = 0;
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        for (int i = 0; i < 6; i++)
            result = result * 10 + array[i];
        return result;
    }
}
