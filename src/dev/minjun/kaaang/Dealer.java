package dev.minjun.kaaang;

import java.util.Random;

public class Dealer extends Player {
    int critical = 5, moreDamageTurns = 0;
    public int getDeal() {
        Random rand = new Random();
        int currentDeal = Deal;
        if ((rand.nextInt(100) + 1) <= critical) {
            currentDeal *= 2;
        }
        if (moreDamageTurns > 0) {
            moreDamageTurns--;
            currentDeal *= 2;
        }

        return currentDeal;
    }

    public void skillQ(Player p) {
        critical += 5;
    }
    public void skillW(Player p) {
        moreDamageTurns = 3;
    }

    public String getName() {
        return "딜러";
    }
}
