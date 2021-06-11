package dev.minjun.kaaang;

public class Tanker extends Player {
    public void damage(int amount) {
        HP -= amount / 2;
    }

    public String getName() {
        return "탱커";
    }
}
