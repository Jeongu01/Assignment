package board;

import board.dto.BoardManager;
import board.menu.ShowList;
import board.menu.ShowMenu;

public class BoardExample {

  static BoardManager boardManager = BoardManager.getInstance();

  public static void main(String[] args) {
    boolean quit = false;
    while (!quit) {
      ShowList.list(boardManager);
      quit = ShowMenu.mainMenu(boardManager);
    }
  }

}
