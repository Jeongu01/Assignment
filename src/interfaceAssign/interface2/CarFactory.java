package interfaceAssign.interface2;

public class CarFactory extends Factory implements IWorkingTogether{


  public CarFactory(String name, int openHour, int closeHour) {
    super(name, openHour, closeHour);
  }

  @Override
  int makeProducts(char skill) {
    int skillValue = switch (skill) {
      case 'A' -> 3;
      case 'B' -> 2;
      case 'C' -> 1;
      default -> 0;
    };
    return this.getWorkingTime() * skillValue;
  }

  @Override
  public int workTogether(IWorkingTogether partner) {
    return ((CarFactory) partner).makeProducts('B');
  }
}
