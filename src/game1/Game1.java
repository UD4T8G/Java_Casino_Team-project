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
            System.out.println("3. 블랙잭 규칙 듣기");
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
                    
                case "3":
                	String line = "==================================================\n";
                    String subLine = "--------------------------------------------------\n";

                    System.out.print(line);
                    System.out.print("           ♣ ◆ 블랙잭 게임 규칙 ♣ ◆            \n");
                    System.out.print(line);

                    // 1. 핵심 목표
                    System.out.print("[ 핵심 목표 ]\n");
                    System.out.print(" 카드의 합이 '21'에 가장 가까운 사람이 승리합니다.\n");
                    System.out.print(" 단, 21을 단 1점이라도 넘어가면 즉시 패배(Bust)합니다!\n\n");

                    // 2. 카드 계산법
                    System.out.print("[ 카드 계산법 ]\n");
                    System.out.print(" - 2 ~ 10     : 카드에 적힌 숫자 그대로 계산\n");
                    System.out.print(" - K, Q, J    : 무조건 '10'으로 계산\n");
                    System.out.print(" - A(에이스)   : 무조건 '11'로 계산\n\n");
                    System.out.print(subLine); 

                    // 3. 게임 진행 방식
                    System.out.print("[ 게임 진행 ]\n");
                    System.out.print(" 1. 플레이어와 딜러는 각각 카드를 2장씩 받습니다.\n");
                    System.out.print(" 2. 플레이어의 선택 (Hit or Stand):\n");
                    System.out.print("    - 힛(Hit)   : 카드를 1장 더 받음\n");
                    System.out.print("    - 스탠드(Stand) : 카드를 더 받지 않고 차례를 마침\n");
                    System.out.print(" 3. 딜러의 규칙:\n");
                    System.out.print("    - 카드 합이 16점 이하이면 무조건 1장 더 받아야 함\n");
                    System.out.print("    - 카드 합이 17점 이상이면 무조건 멈춰야 함\n\n");
                    System.out.print(subLine);
                    System.out.print(line);

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