package core;

public class VIP_User extends User {
    // 관리자용 치트 코드 필드
    private int VIP = 777;

    // 부모 클래스(User)의 생성자를 호출하는 생성자
    public VIP_User(String name, int money) {
        super(name, money);
    }

    // cheat 필드값 참조 (Getter)
    public int getVIP() {
        return this.VIP;
    }

}