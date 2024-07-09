package ObjectAssign;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Vehicle {
  private Owner owner;
  private int price;

  @Override
  public boolean equals(Object obj) {
    Vehicle target = (Vehicle) obj;
    return this.owner.equals(target.getOwner());
  }

  @Override
  public String toString() {
    return "소유주정보 : 이름은 " + this.owner.getName() + "이고, 핸드폰 번호는 " + this.owner.getCellPhone() + "입니다." + '\n' +
        "차량정보 : 가격은 " + this.price + " 입니다.";
  }
}
