package interfaceAssign.interface2;

public abstract class Factory {

  String name;
  int openHour;
  int closeHour;

  public Factory( String name, int openHour, int closeHour) {
    this.openHour = openHour;
    this.closeHour = closeHour;
    this.name = name;
  }

  public String getFactoryName() {
    return name;
  }

  public int getWorkingTime() {
    return closeHour - openHour;
  }

  abstract int makeProducts(char skill);
}
