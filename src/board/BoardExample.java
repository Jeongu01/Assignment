package board;

import board.ui.MenuManager;

public class BoardExample {

  public static void main(String[] args) {
    MenuManager menu = new MenuManager();

    boolean quit = false;
    while (!quit) {
      menu.list();
      quit = menu.mainMenu();
    }
  }

}
