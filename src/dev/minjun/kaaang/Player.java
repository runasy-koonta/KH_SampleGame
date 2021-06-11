package dev.minjun.kaaang;

public class Player {
    int HP = 100, Deal = 1;

    public void increaseDeal(int amount) {
        Deal += amount;
    }
    public void setDeal(int amount) {
        Deal = amount;
    }
    public int getDeal() {
        return Deal;
    }

    public String getName() {
        return "";
    }

    public void skillQ(Player p) {}
    public void skillW(Player p) {}

    public void heal(int amount) {
        HP += amount;
    }
    public void damage(int amount) {
        HP -= amount;
    }
    public int getHP() {
        return HP;
    }
}
