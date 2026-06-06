package game2;

import core.User;
import java.util.Scanner;

public class game2_main {
	public static void start(User u, Scanner scanner) {
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("사용할 코인을 입력하세요: ");
		int initialCoin = s.nextInt();

		System.out.println("1. horse");
		System.out.println("2. lottery");
		System.out.print("게임을 선택하세요: ");
		int gameNumber = s.nextInt();
		
		
		
		if (gameNumber == 1) {
			horse h_game = new horse();
			h_game.startHorseModule(u, initialCoin);
		} else if (gameNumber == 2) {
			lottery l_game = new lottery();
			l_game.startLotteryModule(u, initialCoin);
		} else {
			System.out.print("다시 입력하시오");
		}
	}
}