package dev.minjun.kaaang;

import java.util.Random;
import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Player player1 = null, player2 = null;
        int turn = 1;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        int player1Char = rand.nextInt(2), player2Char = rand.nextInt(2);
        if (player1Char == 0) {
            player1 = new Dealer();
        } else if (player1Char == 1) {
            player1 = new Healer();
        } else if (player1Char == 2) {
            player1 = new Tanker();
        }
        if (player2Char == 0) {
            player2 = new Dealer();
        } else if (player2Char == 1) {
            player2 = new Healer();
        } else if (player2Char == 2) {
            player2 = new Tanker();
        }

        System.out.println("플레이어 1 : " + player1.getName());
        System.out.println("플레이어 2 : " + player2.getName());

        while (player1.getHP() > 0 && player2.getHP() > 0) {
            if (turn == 1) {
                // 플레이어 1의 차례라면?
                System.out.println("====================");
                System.out.println("플레이어 1 차례, 공격은 1, 힐은 2, 강화는 3, Q는 4, W는 5 : ");
                int selection = scan.nextInt();
                int amount = rand.nextInt(10);
                if (selection == 1) {
                    player2.damage(player1.getDeal());
                    System.out.println(player1.getDeal() + " 공격");
                    System.out.println("플레이어 1 HP : " + player1.getHP());
                    System.out.println("플레이어 2 HP : " + player2.getHP());
                } else if (selection == 2) {
                    player1.heal(amount);
                    System.out.println(amount + " 힐");
                    System.out.println("플레이어 1 HP : " + player1.getHP());
                    System.out.println("플레이어 2 HP : " + player2.getHP());
                } else if (selection == 3) {
                    int enchantAmount = rand.nextInt(11) - 5;
                                        // 0 ~ 10까지 정수 반환한거에서 5 뺌
                    player1.increaseDeal(enchantAmount);
                    if (player1.getDeal() < 1) {
                        player1.setDeal(1);
                    }
                    System.out.println("강화 완료! 현재 공격력 " + player1.getDeal());
                } else if (selection == 4) {
                    player1.skillQ(player2);
                } else if (selection == 5) {
                    player1.skillW(player2);
                }
                turn = 2;
            } else if (turn == 2) {
                // 플레이어 2의 차례라면?
                System.out.println("====================");
                System.out.println("플레이어 2 차례, 공격은 1, 힐은 2, 강화는 3 : ");
                int selection = scan.nextInt();
                int amount = rand.nextInt(10);
                if (selection == 1) {
                    player1.damage(player2.getDeal());
                    System.out.println(player2.getDeal() + " 공격");
                    System.out.println("플레이어 1 HP : " + player1.getHP());
                    System.out.println("플레이어 2 HP : " + player2.getHP());
                } else if (selection == 2) {
                    player2.heal(amount);
                    System.out.println(amount + " 힐");
                    System.out.println("플레이어 1 HP : " + player1.getHP());
                    System.out.println("플레이어 2 HP : " + player2.getHP());
                } else if (selection == 3) {
                    int enchantAmount = rand.nextInt(11) - 5;
                    // 0 ~ 10까지 정수 반환한거에서 5 뺌
                    player2.increaseDeal(enchantAmount);
                    if (player2.getDeal() < 1) {
                        player2.setDeal(1);
                    }
                    System.out.println("강화 완료! 현재 공격력 " + player2.getDeal());
                } else if (selection == 4) {
                    player2.skillQ(player1);
                } else if (selection == 5) {
                    player2.skillW(player1);
                }
                turn = 1;
            }
        }
        if (player1.getHP() <= 0) { System.out.println("플레이어 2 승리!"); }
        else { System.out.println("플레이어 1 승리"); }
    }
}
