package com.company;

import java.util.Scanner;

public class ArrayInput {
    static void ArInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Введите кол-во чисел массива : ");
        number = scanner.nextInt();
        int[] array = new int[number];

        System.out.println("Введите числа массива : ");
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Вы ввели числа : ");
        for (int i = 0; i < number; i++) {
            System.out.println(array[i]);
        }
    }
}
