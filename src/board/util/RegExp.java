package board.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RegExp {
  MAIN_MENU("^[1-4]"),
  SUB_MENU("^[1-3]"),
  CHECK_MENU("^[1-2]"),

  BOARD_INPUT("^[0-9a-zA-zㄱ-ㅎ가-힣]*$");

  private final String regExp;
}
