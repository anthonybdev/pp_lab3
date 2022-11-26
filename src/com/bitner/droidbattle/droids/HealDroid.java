package com.bitner.droidbattle.droids;

import java.util.Random;
/**
 * Клас,що представляє тип Heal дроїда
 * @author Anton Bitner
 */
public class HealDroid extends Droid{
    private final int chanceToHeal;
    private final int healHp;

    /**Конструктор без параметрів,що викликає конструктор у батьківського класу*/
    public HealDroid(){
        super("Heal Droid",100,15);
        this.chanceToHeal = 25;
        this.healHp = 10;
    }
    /**
     * Метод для отримання шкоди нанесеною дроїдом
     * @param damage шкода, яку наніс ворожий дроїд
     * @return false or true
     */
    @Override
    public boolean getHit(int damage) {
        Random random = new Random();
        this.health -= damage;
        if(random.nextInt(100) < chanceToHeal) {
            this.health += healHp;
            System.out.println("The heal droid recovered "+healHp+" HP");
        }
        if (health<0) {
            health = 0;
            System.out.println("The "+name+" droid was killed!");
        }
        return true;
    }

}
