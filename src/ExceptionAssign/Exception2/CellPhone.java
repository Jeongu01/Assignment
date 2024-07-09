package ExceptionAssign.Exception2;

public class CellPhone {

  String model;
  double battery;

  CellPhone(String model) {
    this.model = model;
  }

  void call(int time) {
    try {
      if (time < 0) {
        throw new IllegalArgumentException("통화시간입력오류");
      }
      System.out.println("통화 시간 : " + time + "분");
      this.battery = Math.max(this.battery - (time * 0.5), 0);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  void charge(int time) {
    try {
      if (time < 0) {
        throw new IllegalArgumentException("충전시간입력오류");
      }
      System.out.println("충전 시간 : " + time + "분");
      this.battery = Math.min(this.battery + (time * 3), 100);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }

  void printBattery() {
    System.out.printf("남은 배터리 양 : %.1f\n", this.battery);
  }

}
