package game2;

import core.StatusView;
import core.User;
import java.util.Scanner;

public class game2_main {
    public static void start(User u, Scanner scanner) {
        StatusView statusView = new StatusView();
        int userTotalCoin = u.getCoin();
        if (userTotalCoin <= 0) {
            System.out.println("보유하신 코인이 없습니다. 게임2를 이용할 수 없습니다.");
            return;
        }

        statusView.printStatus(u);
        System.out.println("\n=================================");
        System.out.println("미니게임 천국에 오신 것을 환영합니다!");
        System.out.println("1. 말 달리기 경마 게임");
        System.out.println("2. 인생역전 로또 게임");
        System.out.println("3. 메인으로 돌아가기");
        System.out.print("플레이할 게임을 선택하세요(1~3): ");

        int gameNumber = scanner.nextInt();
        System.out.println("=================================");

        if (gameNumber == 1) {
            horse h_game = new horse();
            h_game.startHorseModule(u);
        } else if (gameNumber == 2) {
            lottery l_game = new lottery();
            l_game.startLotteryModule(u);
        } else if (gameNumber == 3) {
            System.out.println("메인으로 돌아갑니다.");
            return;
        } else {
            System.out.println("잘못된 번호입니다. 다시 입력해 주세요.");
        }
    }
}