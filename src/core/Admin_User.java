package core;

public class Admin_User extends User {
    // 관리자용 치트 코드 필드
    private int cheat = 67;

    // 부모 클래스(User)의 생성자를 호출하는 생성자
    public Admin_User(String name, int money) {
        super(name, money);
    }

    // cheat 필드값 참조 (Getter)
    public int getCheat() {
        return this.cheat;
    }

}