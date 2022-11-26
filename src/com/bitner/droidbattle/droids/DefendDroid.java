package com.bitner.droidbattle.droids;

import java.util.Random;
/**
 * Клас,що представляє тип Defend дроїда
 * @author Anton Bitner
 */
public class DefendDroid extends Droid{
    protected final int chanceToAbsorb;
    /**Конструктор без параметрів,що викликає конструктор у батьківського класу*/
    public DefendDroid() {
        super("Defend Droid", 150, 10);
        this.chanceToAbsorb = 25;
    }

    /**
     * Метод для отримання шкоди нанесеної дроїдом
     * @param damage шкода, яку наніс ворожий дроїд
     * @return false or true
     */
    @Override
    public boolean getHit(int damage) {
        Random random = new Random();
        if(random.nextInt(100) > chanceToAbsorb) {
            this.health -=damage;
            if (health<0) {
                health = 0;
                System.out.println("The "+name+" was killed!");
            }
            return true;
        }
        else{
            System.out.println("The attack was blocked!");
            return false;
        }
    }
}
