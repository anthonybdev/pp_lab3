package com.bitner.droidbattle.Battle;

import com.bitner.droidbattle.droids.Droid;
import com.bitner.droidbattle.Printer.Printer;
import com.bitner.droidbattle.Team.Team;

/**
 * Клас для представлення поля бою Дроїдів
 * @author Anton Bitner
 */
public class Battle {

    protected Team firstTeam;
    protected Team secondTeam;
    private int currentRound = 1;

    /**
     * Конструктор з параметрами
     * @param firstTeam перша команда
     * @param secondTeam друга команда
     */
    public Battle(Team firstTeam,Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    /**Метод для запуску бою між дроїдами*/
    public void start() {
        battle();
    }

    /**
     * Метод який реалізує атаку дроїдів один на одного
     * @param first перша команда
     * @param second друга команда
     * @param firstDroidIndex індекс дроїда із першої команди який буде атакувати
     * @param secondDroidIndex індекс дроїда із другої команди який буде атакувати
     */
    private void fight(Team first,Team second,int firstDroidIndex,int secondDroidIndex)
    {
        if(!first.getDroidList().isEmpty())
        {
            Droid firstDroid=first.getDroidList().get(firstDroidIndex);
            Droid secondDroid=second.getDroidList().get(secondDroidIndex);
            int damage = firstDroid.attack();
            boolean isDamaged = secondDroid.getHit(damage);

            if(isDamaged)
                Printer.print(first.getDroidList().get(firstDroidIndex).getName()+" give "+damage+ " damage to "+secondDroid.getName());

            if(second.getDroidList().get(secondDroidIndex).getHealth()<=0) second.getDroidList().remove(secondDroidIndex);
        }
        else Printer.print("Team is empty\n");

    }
    /**Метод,що реалізує бій між командами дроїдів*/
    private void battle()
    {
        int myDroidIndex=0;
        int enemyDroidIndex=0;
        while (!firstTeam.getDroidList().isEmpty() && !secondTeam.getDroidList().isEmpty()) {
            Printer.print("\n----------------------------Round №" + currentRound++ +"----------------------------");

            Printer.print("First team turn:");
            fight(firstTeam,secondTeam,myDroidIndex,enemyDroidIndex);
            Printer.print("\nSecond team turn:");
            fight(secondTeam,firstTeam,enemyDroidIndex,myDroidIndex);
            showInfo();

            myDroidIndex++;
            enemyDroidIndex++;

            if(myDroidIndex>=firstTeam.getDroidList().size()-1) myDroidIndex=0;

            if(enemyDroidIndex>=secondTeam.getDroidList().size()-1) enemyDroidIndex=0;

        }
        if(firstTeam.getDroidList().isEmpty()) Printer.print("\nSecond team win\n");
        else Printer.print("\nFirst team win\n");
    }
    /**Метод який викликає printList для виводу двох команд*/
    private void showInfo()
    {
        Printer.print("\nFirst team:");
        printList(firstTeam);

        Printer.print("\nSecond team:");
        printList(secondTeam);
    }

    /**
     * Метод для виводу на екран команди,що передається як параметр
     * @param team команда,що передається у метод
     */
    private void printList(Team team)
    {
        if(team.getDroidList().isEmpty()) Printer.print("Empty");

        for (int i = 0;i<team.getDroidList().size();i++)
            Printer.print(team.getDroidList().get(i).toString());
    }

}
