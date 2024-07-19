package board.ui;

import board.dao.BoardManager;
import board.dao.CreateBoard;
import board.dao.ReadBoard;
import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowMenu {

  public static boolean mainMenu(BoardManager boardManager) {
    System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
    System.out.print("메뉴 선택: ");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Board board;
    boolean quit = false;

    try {
      int menu = Integer.parseInt(br.readLine());
      switch (menu) {
        case 1 -> {
          board = CreateBoard.create();
          boardManager.createBoard(board);
        }
        case 2 -> ReadBoard.read(boardManager);
        case 3 -> boardManager.clearBoard();
        case 4 -> quit = true;
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return quit;

  }

}
