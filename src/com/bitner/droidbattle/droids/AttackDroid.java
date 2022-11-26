package com.bitner.droidbattle.droids;

import java.util.Random;

/**
 * Клас,що представляє тип Attack дроїда
 * @author Anton Bitner
 */
public class AttackDroid extends Droid{
    private final int chanceCrit;
    private final int critAttack;

    /**Конструктор без параметрів,що викликає конструктор у батьківського класу*/
    public AttackDroid() {
        super("Attack Droid",70,20);
        critAttack=25;
        chanceCrit=25;
    }

    /**
     * Метод для атаки ворожого дроїда.Повертає шкоду нанесену дроїдом.
     * @return real damage or critAttack
     */
    @Override
    public int attack() {
        Random random = new Random();
        if (random.nextInt(100) > chanceCrit) return random.nextInt(damage-1)+1;
        else{
            System.out.println("Critical attack!");
            return critAttack;}
    }

}
