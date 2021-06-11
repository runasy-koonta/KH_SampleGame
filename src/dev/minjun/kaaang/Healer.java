package dev.minjun.kaaang;

public class Healer extends Player {
    public void heal(int amount) {
        HP += amount * 2;
    }

    public String getName() {
        return "힐러";
    }
}
