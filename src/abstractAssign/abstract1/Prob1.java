package abstractAssign.abstract1;
public class Prob1 {

  public static void main(String[] args) {
    Wheeler truck = new Truck("truck", 60, 4);
    Wheeler bike = new Bike("bike", 20, 2);

    System.out.print("트럭 : ");
    truck.printWheelNumber();
    System.out.print("자전거 : ");
    bike.printWheelNumber();
    truck.speedUp(8);
    bike.speedUp(5);
    truck.speedDown(20);
    bike.speedDown(30);
    truck.stop();
    bike.stop();
    truck.speedUp(10);
  }
}
