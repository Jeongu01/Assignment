package abstractAssign.abstract3;

public class Tea extends Beverage {

  static public int amount;

  public Tea(String name) {
    super(name);
    amount++;
  }

  @Override
  public void calcPrice() {
    this.price = switch (this.name) {
      case "lemonTea" -> 1500;
      case "ginsengTea" -> 2000;
      case "redginsengTea" -> 2500;
      default -> 0;
    };
  }
}
