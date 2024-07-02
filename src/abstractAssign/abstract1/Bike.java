package abstractAssign.abstract1;
public class Bike extends Wheeler {

  public Bike(String carName, int velocity, int wheelNumber) {
    this.carName = carName;
    this.velocity = velocity;
    this.wheelNumber = wheelNumber;
  }

  @Override
  public void speedUp(int speed) {
    this.velocity += speed;

    if (this.velocity > 40) {
      System.out.println("자전거의 최고속도위반으로 속도를 40으로 내립니다.");
    } else {
      System.out.println("자전거의 현재 속도는 " + this.velocity + " 입니다.");
    }
  }

  @Override
  public void speedDown(int speed) {
    this.velocity -= 5 * speed;
    if (this.velocity < 50) {
      System.out.println("자전거의 최저속도위반으로 속도를 10으로 올립니다.");
    } else {
      System.out.println("자전거의 현재 속도는 " + this.velocity + " 입니다.");
    }
  }
}
