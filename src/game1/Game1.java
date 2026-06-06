package game1;

import java.util.Scanner;
import core.StatusView;
import core.User;
import slotmachine.*;
import blackjack.*;

public class Game1 {
    public void start(User player, Scanner scanner) {
        StatusView statusView = new StatusView();
        SlotMachine slotMachine = new SlotMachine();
        BlackJack blackJack = new BlackJack();

        System.out.println("=================================");
        System.out.println("게임장 1에 입장합니다.");
        System.out.println("=================================");

        while (true) { 
            statusView.printStatus(player);
            
            System.out.println("\n게임을 선택하세요.");
            System.out.println("1. 슬롯머신");
            System.out.println("2. 블랙잭");
            System.out.println("0. 돌아가기");
            System.out.print("선택: ");

            String choice = scanner.next();

            if (choice.equals("0")) {
                System.out.println("게임장 1에서 퇴장합니다.");
                break;
            }

            switch (choice) {
                case "1":
                    int coinInSlot = player.getCoin(); 
                    int coinOutSlot = slotMachine.startSlotModule(coinInSlot);
                    player.setCoin(coinOutSlot);
                    
                    player.decreaseDebtTime(1); 
                    break;

                case "2":
                    int coinInBJ = player.getCoin(); 
                    int coinOutBJ = blackJack.startBlackJackModule(coinInBJ); 
                    player.setCoin(coinOutBJ);
                    
                    player.decreaseDebtTime(1); 
                    break;

                default:
                    System.out.println("입력이 잘못되었습니다.");
                    break;
            }
            
            if (player.getDebtTime() == 0) { 
                System.out.println("\n이용 시간이 종료되었습니다.");
                break;
            }
        }
    }
}