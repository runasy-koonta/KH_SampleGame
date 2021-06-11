package dev.minjun.kaaang;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rand.nextInt(10));
        }
    }
}
