package com.bitner.droidbattle.Team;

import com.bitner.droidbattle.droids.Droid;
import com.bitner.droidbattle.Printer.Printer;
import com.bitner.droidbattle.droids.AttackDroid;
import com.bitner.droidbattle.droids.HealDroid;
import com.bitner.droidbattle.droids.DefendDroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**Клас для представлення команди дроїдів*/
public class Team {
    private final List<Droid> droids = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Конструктор з параметром
     * @param size кількість дроїдів у команді
     */
    public Team(int size)
    {
        fillTeam(size);
    }

    /**
     * Геттер для поля droids
     * @return droids
     */
    public List<Droid> getDroidList() {
        return droids;
    }

    /**
     * Метод для заповнення команди дроїдами
     * @param size кількість дроїдів у команді
     */
    public void fillTeam(int size)
    {
        for (int i = 0; i < size; i++) {
            Printer.print("Choose droid №" + (i + 1));
            try {
                droids.add(chooseDroid());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод для вибору дроїда
     * @return droid - екземпляр дроїда
     * @throws IOException виняток,що може виникнути при вводі
     */
    private Droid chooseDroid() throws IOException {
        Printer.print("1. Heal Droid\n2. Attack Droid\n3. Defend Droid");
        Droid droid;
        System.out.print("Your choice: ");
        String value = scanner.nextLine();

        while (!value.equals("1") && !value.equals("2")&& !value.equals("3")) {
            Printer.print("Invalid request");
            value = scanner.nextLine();
        }

        droid = switch (value) {
            case "1" -> new HealDroid();
            case "2" -> new AttackDroid();
            default -> new DefendDroid();
        };

        Printer.printInputValue("Your choice: "+value);
        return droid;
    }
}
