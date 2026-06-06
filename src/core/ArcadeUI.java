package core;

public class ArcadeUI {

    public static void type(String text, int speed) {
        for(char c : text.toCharArray()) {
            System.out.print(c);

            try {
                Thread.sleep(speed);
            } catch(Exception e) {
            		System.out.println("에러");
            }
        }
        System.out.println();
    }

    public static void loadingBar() {

        System.out.print("입장 중 ");

        for(int i = 0; i <= 20; i++) {

            System.out.print("\r입장 중 [");

            for(int j = 0; j < 20; j++) {

                if(j < i)
                    System.out.print("■");
                else
                    System.out.print(" ");
            }

            System.out.print("] " + (i * 5) + "%");

            try {
                Thread.sleep(120);
            }
            catch(Exception e) {
            }
        }

        System.out.println("\n입장 완료!");
    }

    public static void intro() {

        System.out.println();

        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║                                              ║");
        System.out.println("║           🎰 JAVA PLAY YARD 🎰               ║");
        System.out.println("║                                              ║");
        System.out.println("╚══════════════════════════════════════════════╝");

        System.out.println();
        type("자동문이 열립니다...",30);

        loadingBar();

        type("🎮 JAVA GAME LAND에 오신 것을 환영합니다.",25);

        System.out.println();
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("              부자가 되어 탈출하라!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
    }

    public static void vipEnter() {

        System.out.println();

        System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
        System.out.println("👑 VIP 고객 입장");
        System.out.println("VIP 전용 혜택이 적용됩니다.");
        System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨");

        System.out.println();
    }

    public static void normalEnter() {

        System.out.println();
        System.out.println("🚶 손님 한 분 입장하셨습니다.");
        System.out.println();
    }

    public static void adminEnter() {

        System.out.println();

        System.out.println("⚠ 시스템 접근 확인 ⚠");

        System.out.println();
        System.out.println("  ■    ■■■    ■     ■  ■■■■■  ■    ■");
        System.out.println(" ■ ■   ■  ■   ■■   ■■    ■    ■■   ■");
        System.out.println("■   ■  ■   ■  ■ ■ ■ ■    ■    ■ ■  ■");
        System.out.println("■■■■■  ■   ■  ■  ■  ■    ■    ■  ■ ■");
        System.out.println("■   ■  ■  ■   ■     ■    ■    ■   ■■");
        System.out.println("■   ■  ■■■    ■     ■  ■■■■■  ■    ■");

        System.out.println();
        type("관리자 권한 활성화",20);
        System.out.println();
    }

    public static void gameOver(User u) {

        System.out.println();

        System.out.println("  ■■■■     ■   ■     ■ ■■■■■");
        System.out.println(" ■    ■   ■ ■  ■■   ■■ ■    ");
        System.out.println("■        ■   ■ ■ ■ ■ ■ ■    ");
        System.out.println("■    ■■■ ■■■■■ ■  ■  ■ ■■■■■");
        System.out.println(" ■   ■■  ■   ■ ■     ■ ■    ");
        System.out.println("  ■■■ ■  ■   ■ ■     ■ ■■■■■");

        System.out.println();

        System.out.println("  ■■■   ■     ■ ■■■■■ ■■■■  ");
        System.out.println(" ■   ■  ■     ■ ■     ■   ■ ");
        System.out.println("■     ■ ■     ■ ■     ■■■■  ");
        System.out.println("■     ■  ■   ■  ■■■■■ ■ ■   ");
        System.out.println(" ■   ■    ■ ■   ■     ■  ■  ");
        System.out.println("  ■■■      ■    ■■■■■ ■   ■ ");

        System.out.println();
        
        
        type("지금까지 사용한 돈 :", 100);
        System.out.printf(" %,d \n" , u.get_ending_money());
        type("지금까지 대출한 빚 :", 100);
        System.out.printf(" %,d \n" , u.get_ending_debt());
        
        type("카드 한 묶음은 악마의 기도가 적힌 책이다. - 영국 속담 ", 180);
    }

    public static void menu() {

        System.out.println();

        System.out.println("┌─────────────────────────────┐");
        System.out.println("│         GAME MENU           │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ 1. 🎲 게임 1\t              │");
        System.out.println("│ 2. 🎯 게임 2\t              │");
        System.out.println("│ 3. 🪙 코인 구매\t              │");
        System.out.println("│ 4. 💵 현금 환전\t              │");
        System.out.println("│ 5. 💰 대출 받기\t              │");
        System.out.println("│ 6. 🏦 빚 상환\t              │");
        System.out.println("│ 7. 🚪 게임 종료\t              │");
        System.out.println("└─────────────────────────────┘");

        System.out.print("선택 > ");
    }
}