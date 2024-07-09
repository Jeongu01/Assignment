package ObjectAssign;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Owner {
  private String name;
  private String cellPhone;

  @Override
  public boolean equals(Object obj) {
    Owner target = (Owner) obj;
    return this.name.equals(target.getName());
  }

  @Override
  public String toString() {
    return "이름은 " + this.name + "이고, 핸드폰 번호는 " + this.cellPhone + "입니다.";
  }
}
