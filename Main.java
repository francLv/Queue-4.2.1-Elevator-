//package ru.netology;

import java.util.*;

public class Main {
    static Deque<Integer> liftMoves = new ArrayDeque<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int inputFloor;
        int zeroFloor = 0;
        int lastFloor = 25;
        int previousFloor = -1;
        while (true) {
            System.out.println("Ожидаю ввода этажа: (для завершения введите 0)");
            inputFloor = scanner.nextInt();
            if (inputFloor == previousFloor) {
                System.out.println("Лифт уже на данном этаже");
            } else if (inputFloor == zeroFloor) {
                liftMoves.offer(inputFloor);
                break;
            } else if (inputFloor > zeroFloor && inputFloor <= lastFloor) {
                liftMoves.offer(inputFloor);
                previousFloor = inputFloor;
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
            totalSeconds += Math.abs(currentfloor - previousFloor) * waitMoveInSeconds;
            totalSeconds += waitDoorsInSeconds;
            System.out.print("Этаж " + currentfloor + " -> ");
        }
        totalSeconds += currentfloor * waitMoveInSeconds; //возвращаемся на 0 этаж
        System.out.println("\nВремя затраченное лифтом на маршрут: " + totalSeconds + " с.");
    }
}

