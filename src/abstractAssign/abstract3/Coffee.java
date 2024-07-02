package abstractAssign.abstract3;

public class Coffee extends Beverage {

  static public int amount;

  public Coffee(String name) {
    super(name);
    amount++;
  }

  @Override
  public void calcPrice() {
    this.price = switch (this.name) {
      case "Americano" -> 1500;
      case "CafeLatte" -> 2500;
      case "Cappuccino" -> 3000;
      default -> 0;
    };
  }
}
