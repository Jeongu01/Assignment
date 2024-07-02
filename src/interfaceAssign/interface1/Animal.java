package interfaceAssign.interface1;

public abstract class Animal {
  int speed;
  double distance;

  public Animal(int speed) {
    this.speed = speed;
  }

  abstract void run(int hours);

  public double getDistance() {
    return distance;
  }
}
