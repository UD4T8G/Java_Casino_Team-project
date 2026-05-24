package game2;

import core.User;
import java.util.Random;

public class lottery {
	public void startLotteryModule(User u, int initialCoin) {
		if (initialCoin <= 0) {
			System.out.print("코인 부족입니다");
			return;
		}

		Random r = new Random();

		int correct[] = new int[6];
		int mynum[] = new int[6];

		for (int i = 0; i < 6; i++) {
			correct[i] = r.nextInt(50) + 1;
			mynum[i] = r.nextInt(50) + 1;
		}

		boolean isWin = true;

		System.out.print("내 번호: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(mynum[i] + " ");

			if (correct[i] != mynum[i]) {
				isWin = false;
			}
		}

		System.out.println();
		System.out.print("당첨 번호: ");
		for (int i = 0; i < 6; i++) {
			System.out.print(correct[i] + " ");
		}

		System.out.println();

		if (isWin) {
			System.out.print("you win");
			u.setCoin(initialCoin * 10);
		} else {
			System.out.print("you lose");
			u.setCoin(0);
		}
	}
}