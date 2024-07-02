package interfaceAssign.interface2;

public class TVFactory extends Factory implements IWorkingTogether{

  public TVFactory(String name, int openHour, int closeHour) {
    super(name, openHour, closeHour);
  }

  @Override
  int makeProducts(char skill) {
    int skillValue = switch (skill) {
      case 'A' -> 8;
      case 'B' -> 5;
      case 'C' -> 3;
      default -> 1;
    };
    return this.getWorkingTime() * skillValue;
  }

  @Override
  public int workTogether(IWorkingTogether partner) {
    return ((TVFactory) partner).makeProducts('C');
  }
}
