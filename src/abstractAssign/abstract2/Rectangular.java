package abstractAssign.abstract2;

public class Rectangular extends Shape {

  private double width;
  private String height;

  public Rectangular(double width, String height) {
    super("직사각형");
    this.area = 0;
    this.width = width;
    this.height = height;
  }

  @Override
  void calculationArea() {
    this.area = this.width * Double.parseDouble(this.height);
  }
}
