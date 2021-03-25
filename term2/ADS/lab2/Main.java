package com.company;

public class Main {

    static Tree ourTree = new Tree();
    public static void main(String[] args){

        testInsert(8);
        testDelete(8);
        testSum(8);
        testFind(8);
        System.out.println();

        testInsert(100);
        testDelete(100);
        testSum(100);
        testFind(100);
        System.out.println();

        testInsert(10_000);
        testDelete(10_000);
        //testSum(10_000);
        testFind(10_000);
        System.out.println();

        testInsert(1_000_000);
        testDelete(1_000_000);
        //testSum(1_000_000);
        testFind(1_000_000);
    }
    public static void testInsert(int amount){
        long start  = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            int number = (int) (Math.random() * 100);
            ourTree.insert(number);
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Добавление " + amount +" элементов - " + result +" наносекунд");
    }
    public static void testDelete(int amount){
        long start  = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            int number = (int) (Math.random() * 100);
            ourTree.delete(number);
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Удаление " + amount +" элементов - " + result +" наносекунд");
    }
    public static void testFind(int amount) {
        long start  = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            int number = (int) (Math.random() * 100);
            ourTree.findElement(number);
        }
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Нахождение " + amount +" элементов - " + result +" наносекунд");
    }
    public static void testSum(int amount) {
        long start = System.nanoTime();
        ourTree.findSum();
        long end = System.nanoTime();
        long result = end - start;
        System.out.println("Суммирование " + amount +" элементов - " + result +" наносекунд");
    }
}
