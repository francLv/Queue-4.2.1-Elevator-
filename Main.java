//package ru.netology;

import java.util.*;

public class Main {
    static Deque<Integer> liftMoves = new ArrayDeque<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputFloor;
        int zeroFloor = 0;
        int lastFloor = 25;
        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            inputFloor = scanner.nextInt();
            if (inputFloor == zeroFloor) {
                break;
            } else if (inputFloor > zeroFloor && inputFloor <= lastFloor) {
                liftMoves.offer(inputFloor);
            } else System.out.println("Такого этажа нет в доме");
        }
        finishMap();
    }

    static void finishMap() {
        int waitDoorsInSeconds = 10;
        int waitMoveInSeconds = 5;
        int totalSeconds = 0;
        int previousFloor = 0;
        int currentfloor = 0;
        while (!liftMoves.isEmpty()) {
            currentfloor = liftMoves.poll();
            if (previousFloor != 0) {
                totalSeconds += Math.abs(currentfloor - previousFloor) * waitMoveInSeconds;
                totalSeconds += waitDoorsInSeconds;
            } else totalSeconds = currentfloor * waitMoveInSeconds + waitDoorsInSeconds;
            previousFloor = currentfloor;
            System.out.print("Этаж " + currentfloor + " -> ");
        }
        totalSeconds += currentfloor * waitMoveInSeconds; //возвращаемся на 0 этаж
        System.out.println("Этаж 0");
        System.out.println("Время затраченное лифтом на маршрут: " + totalSeconds + " с.");
    }
}

