package abstractAssign.abstract2;

public class Circle extends Shape {

  private double radius;

  public Circle(double radius) {
    super("원");
    this.area = 0;
    this.radius = radius;
  }

  @Override
  void calculationArea() {
    this.area = this.radius * this.radius * Math.PI;
  }
}
