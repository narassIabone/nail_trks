package org.lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // НЕ потокобезопасный список
        List<Integer> unsafeList = new ArrayList<>();
        // Потокобезопасный список (твоя реализация)
        SafeList<Integer> safeList = new SafeList<>();

        int THREADS = 5;
        int OPERATIONS = 10000;

        //Тест 1: Unsafe List
        System.out.println("Unsafe List test started.");
        Thread[] writersUnsafe = new Thread[THREADS];
        Thread[] readersUnsafe = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            writersUnsafe[i] = new Thread(() -> {
                for (int j = 0; j < OPERATIONS; j++) {
                    unsafeList.add(j);
                }
            });

            readersUnsafe[i] = new Thread(() -> {
                for (int j = 0; j < OPERATIONS; j++) {
                    try {
                        // Попытка получить элемент, может возникнуть IndexOutOfBoundsException
                        if (!unsafeList.isEmpty()) {
                            int val = unsafeList.get(unsafeList.size() - 1);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Exception in unsafeList: " + e);
                    }
                }
            });
        }

        for (int i = 0; i < THREADS; i++) {
            writersUnsafe[i].start();
            readersUnsafe[i].start();
        }
        for (int i = 0; i < THREADS; i++) {
            writersUnsafe[i].join();
            readersUnsafe[i].join();
        }
        System.out.println("Unsafe List test finished.");

        //Тест 2: SafeList
        System.out.println("SafeList test started.");
        Thread[] writersSafe = new Thread[THREADS];
        Thread[] readersSafe = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            writersSafe[i] = new Thread(() -> {
                for (int j = 0; j < OPERATIONS; j++) {
                    safeList.add(j);
                }
            });

            readersSafe[i] = new Thread(() -> {
                for (int j = 0; j < OPERATIONS; j++) {
                    try {
                        if (!safeList.isEmpty()) {
                            int val = safeList.get(safeList.size() - 1);
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Exception in safeList: " + e);
                    }
                }
            });
        }

        for (int i = 0; i < THREADS; i++) {
            writersSafe[i].start();
            readersSafe[i].start();
        }
        for (int i = 0; i < THREADS; i++) {
            writersSafe[i].join();
            readersSafe[i].join();
        }
        System.out.println("SafeList test finished.");
    }
}
