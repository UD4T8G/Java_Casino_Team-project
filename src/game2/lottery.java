package game2;

import core.User;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class lottery {
    // 플레이 한 번당 차감될 코인 설정 (원하는 금액으로 수정 가능)
    private static final int COST_PER_TRY = 1; 

    public void startLotteryModule(User u) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();

        System.out.println("=== 💸 인생역전 로또 시뮬레이터 ===");
        System.out.println("- 엔터(Enter)를 누르면 새로운 로또를 구매합니다. (" + COST_PER_TRY + "코인 차감)");
        System.out.println("- '그만'을 입력하면 게임을 종료합니다.");
        System.out.println("- 당첨 시 모든 빚이 탕감됩니다!");
        System.out.println("=================================");

        while (true) {
            // 1. 코인 잔액 검사
            if (u.getCoin() < COST_PER_TRY) {
                System.out.println("\n❌ 코인이 부족합니다! (현재 코인: " + u.getCoin() + " / 필요 코인: " + COST_PER_TRY + ")");
                break;
            }

            // 2. 유저 입력 대기
            System.out.print("\n[Enter]를 누르면 추첨 (종료하려면 '그만' 입력): ");
            String input = scanner.nextLine();

            if (input.equals("그만")) {
                System.out.println("로또 게임을 종료합니다.");
                break;
            }

            // 3. 코인 차감 및 반영
            u.setCoin(u.getCoin() - COST_PER_TRY);
            System.out.println("💸 " + COST_PER_TRY + "코인이 차감되었습니다. (남은 코인: " + u.getCoin() + ")");

            // 4. 당첨 번호 및 내 번호 생성 (1~50 사이의 중복 없는 랜덤 숫자 6개)
            int[] correct = generateLottoNumbers(r);
            int[] mynum = generateLottoNumbers(r);

            // 오름차순 정렬 (비교 및 시각적인 확인을 편하게 하기 위함)
            Arrays.sort(correct);
            Arrays.sort(mynum);

            // 5. 번호 출력
            System.out.print("내 번호  : ");
            for (int num : mynum) System.out.print(num + " ");
            System.out.println();

            System.out.print("당첨 번호: ");
            for (int num : correct) System.out.print(num + " ");
            System.out.println();

            // 6. 당첨 여부 확인 (6개 숫자가 모두 일치하는지 비교)
            boolean isWin = Arrays.equals(correct, mynum);

            if (isWin) {
                System.out.println("\n🎉🎉🎉 대박! 당첨입니다!!! 🎉🎉🎉");
                
                if (u.getDebt() > 0) {
                    System.out.println("💰 축하합니다! 모든 빚이 탕감되고 소지금이 999999999원이 되었습니다!");
                    u.setDebt(0);
                    u.setDebtTime(-1);
                    u.setMoney(999999999);
                }
                else {
                	u.setMoney(999999999);
                }
                
                // 보너스로 코인도 듬뿍 지급 (기획에 따라 생략 가능)
                u.setCoin(u.getCoin() + 10000); 
                break; // 당첨되었으므로 게임 종료
            }
            else {
                System.out.println("❌ 아쉽게도 낙첨되었습니다. 다음 기회를 노려보세요!");
            }
        }
    }

    // 1~50 사이의 중복 없는 숫자 6개를 뽑는 헬퍼 메서드
    private int[] generateLottoNumbers(Random r) {
        int[] numbers = new int[6];
        for (int i = 0; i < 6; i++) {
            numbers[i] = r.nextInt(50) + 1;
            // 중복 제거 로직
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    i--; // 중복되면 다시 뽑기
                    break;
                }
            }
        }
        return numbers;
    }
}