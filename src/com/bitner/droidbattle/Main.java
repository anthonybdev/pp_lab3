package com.bitner.droidbattle;


import com.bitner.droidbattle.Battle.Battle;
import com.bitner.droidbattle.Printer.Printer;
import com.bitner.droidbattle.Team.Team;

import java.util.Scanner;

/**
 * Main клас для створення екземплярів класів
 * @author Anton Bitner
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * main метод
     * @param args масив параметрів командного рядка
     */
    public static void main(String[] args) {
        String value;
        do {
            System.out.println("1.Battle 1 on 1");
            System.out.println("2.Team-on-team combat");
            System.out.println("3.Read battle from file");
            System.out.println("4.Exit\n");
            System.out.print("Your choice: ");
            value = scanner.nextLine();
            switch (value) {
                case "1" -> startBattle(1);
                case "2" -> {
                    System.out.println("Enter team size:");
                    startBattle(scanner.nextInt());
                }
                case "3" -> {
                    System.out.println("Enter the file path:");
                    String fileName = scanner.nextLine();
                    Printer.readFromFile(fileName);
                }
                case "4" -> System.out.println("Completion of the program!");
            }

        } while (!value.equals("4"));

    }

    /**
     * Метод,що викликає метод start Main класу
     * @param size розмір команд дроїдів
     */
    private static void startBattle(int size) {
        Printer pr = null;
        if(size != 1) scanner.nextLine();
        System.out.println("Record the fight to a file? Yes/No: ");
        if (scanner.nextLine().toLowerCase().equals("yes")) {
            pr = new Printer("file.txt");
            Printer.setWriteToFile(true);
        } else {
            Printer.setWriteToFile(false);
        }
        start(size);
        if (Printer.getWriteToFile() && pr != null) {
            pr.closePrinter();
        }
    }

    /**
     * Метод для формування команд та запуску битви між ними
     * @param size розмір команд дроїдів
     */
    private static void start(int size){
        Printer.print("\nFormation of the first team");
        Team myTeam = new Team(size);
        Printer.print("\nFormation of the second team");
        Team enemyTeam = new Team(size);

        Battle battle = new Battle(myTeam, enemyTeam);
        battle.start();
    }
}