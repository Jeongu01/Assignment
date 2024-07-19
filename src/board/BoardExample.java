package board;

import board.dao.BoardManager;
import board.ui.ShowList;
import board.ui.ShowMenu;

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
