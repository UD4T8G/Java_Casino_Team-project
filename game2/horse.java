package game2;

import core.User;
import java.util.Random;
import java.util.Scanner;

class run {
	Random r = new Random();
	int num = r.nextInt(10) + 1;
	int sum = 0;

	int add() {
		sum += num;
		return sum;
	}

	void anime() {
		for (int i = 0; i < this.sum; i++) {
			System.out.print("-");
		}
	}
}

public class horse {
	public void startHorseModule(User u, int initialCoin) {
		Scanner scanner = new Scanner(System.in);

		if (initialCoin <= 0) {
			System.out.print("코인 부족입니다");
			return;
		}

		run h1 = new run();
		run h2 = new run();
		run h3 = new run();

		System.out.print("말 번호를 선택하세요(1~3): ");
		int bet = scanner.nextInt();
		int winner = 0;

		switch (bet) {
		case 1:
		case 2:
		case 3:
			while (true) {
				h1.add();
				h1.anime();
				System.out.println("H1");

				h2.add();
				h2.anime();
				System.out.println("H2");

				h3.add();
				h3.anime();
				System.out.println("H3");

				if (h1.sum >= 100) {
					winner = 1;
					break;
				} else if (h2.sum >= 100) {
					winner = 2;
					break;
				} else if (h3.sum >= 100) {
					winner = 3;
					break;
				}
			}
			break;

		default:
			System.out.print("다시 입력하시오");
			return;
		}

		int result;

		if (bet == winner) {
			System.out.print("you win");
			result = (int)(initialCoin * 1.2);
		} else {
			System.out.print("you lose");
			result = (int)(initialCoin / 1.2);
		}

		u.setCoin(result);
	}
}