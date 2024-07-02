package abstractAssign.abstract2;

public abstract class Shape {

  protected double area;
  protected String name;

  Shape() {
  }

  Shape(String name) {
    this.name = name;
  }

  abstract void calculationArea();

  void print() {
    System.out.println(this.name + "의 면적은 " + this.area);
  }

}
