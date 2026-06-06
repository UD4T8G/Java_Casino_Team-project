package game2;

import core.User;
import java.util.Random;
import java.util.Scanner;

class run {
    private static final int finish = 100;
    private static final int track = 50;

    Random r = new Random();
    int sum = 0;

    int add() {
        int num = r.nextInt(10) + 1;
        sum += num;
        return sum;
    }

    void anime(String horseName) {
        int position = Math.min(track, sum * track / finish);
        
        System.out.print(horseName + " |");
        for (int i = 0; i < track; i++) {
            if (i == position) {
                System.out.print("🐎");
            } else {
                System.out.print(".");
            }
        }
        System.out.printf("| %3d/%d%n", sum, finish);
    }
}

public class horse {
    public void startHorseModule(User u) {
        Scanner scanner = new Scanner(System.in);

        int currentCoin = u.getCoin();

        if (currentCoin <= 0) {
            System.out.println("코인이 부족합니다! (현재 코인: " + currentCoin + ")");
            return;
        }

        run h1 = new run();
        run h2 = new run();
        run h3 = new run();

        System.out.print("배팅할 말 번호를 선택하세요(1~3): ");
        int bet = scanner.nextInt();
        int winner = 0;

        switch (bet) {
            case 1:
            case 2:
            case 3:
                System.out.println("\n=== 경마 시작! ===");
                while (true) {
                    h1.add();
                    h1.anime("H1");

                    h2.add();
                    h2.anime("H2");

                    h3.add();
                    h3.anime("H3");

                    System.out.println("========================================================");

                    if (h1.sum >= 100 || h2.sum >= 100 || h3.sum >= 100) {
                        if (h1.sum >= h2.sum && h1.sum >= h3.sum) winner = 1;
                        else if (h2.sum >= h1.sum && h2.sum >= h3.sum) winner = 2;
                        else winner = 3;
                        break;
                    }

                    try {
                        Thread.sleep(400);
                    } catch (Exception e) {
                    }
                }
                break;

            default:
                System.out.println("올바른 말 번호가 아닙니다. 게임을 종료합니다.");
                return;
        }

        System.out.println("\n=== 게임 결과 ===");
        System.out.println("우승말 H" + winner + " / 내가 배팅한 말 H" + bet);

        int resultCoin;

        if (bet == winner) {
            System.out.println("축하합니다! 예측에 성공했습니다. (코인 20% 증가)");
            resultCoin = (int)(currentCoin * 1.2);
        } else {
            System.out.println("아쉽게도 틀렸습니다. (코인 20% 감소)");
            resultCoin = (int)(currentCoin / 1.2);
        }

        u.setCoin(resultCoin);
        System.out.println("최종 보유 코인: " + u.getCoin());
    }
}
