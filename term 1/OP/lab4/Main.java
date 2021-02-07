package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayInput();
        PartOne(int.class, int[].class);
    }

    static void ArrayInput() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];

        System.out.println("Введите числа массива : ");
        for (int i = 0; i < 10; i++) {
            array[i] = scanner.nextInt();
        }
    }
    static int PartOne(Class<Integer> value, Class<int[]> array) {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (value % 7 != 0) {
                continue;
            }
            index = i;
            return index;
        }


        return index;
    }
}
