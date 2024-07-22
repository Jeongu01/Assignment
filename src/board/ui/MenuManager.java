package board.ui;

import board.dao.BoardManager;
import board.dao.CreateBoard;
import board.dao.ReadBoard;
import board.dao.UpdateBoard;
import board.service.MenuService;
import board.util.RegExp;
import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MenuManager implements MenuService {

  private final BoardManager boardManager = BoardManager.getInstance();
  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private Board board = null;

  @Override
  public void list() {
    System.out.println();
    System.out.println("-".repeat(60));
    System.out.println("[게시물 목록]");
    System.out.println("-".repeat(60));
    System.out.println("no\t\twriter\t\t\tdate\t\t\t\t\ttitle");
    System.out.println("-".repeat(60));
    ArrayList<Board> boardList = boardManager.getBoardList();
    for (Board board : boardList) {
      System.out.printf("%-3d\t\t%-10s\t%-12s\t%s\n",
          board.getBno(),
          board.getBwriter(),
          board.getBdate(),
          board.getBtitle()
      );
    }
  }

  @Override
  public boolean mainMenu() {
    System.out.println("-".repeat(60));
    System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
    System.out.print("메뉴 선택: ");
    boolean quit = false;

    try {
      String menu = br.readLine();
      if (!Pattern.matches(RegExp.MAIN_MENU.getRegExp(), menu)) {
        throw new IOException();
      }
      switch (menu) {
        case "1" -> {
          board = CreateBoard.create();
          if (checkMenu()) {
            boardManager.createBoard(board);
          }
        }
        case "2" -> ReadBoard.read();
        case "3" -> boardManager.clearBoard();
        case "4" -> quit = true;
      }
    } catch (IOException e) {
      printWrongInput();
    }

    return quit;
  }

  @Override
  public void subMenu(int bno) {
    System.out.println("-".repeat(60));
    System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
    System.out.print("메뉴 선택: ");

    try {
      String menu = br.readLine();
      if (!Pattern.matches(RegExp.SUB_MENU.getRegExp(), menu)) {
        throw new IOException();
      }
      switch (menu) {
        case "1" -> {
          board = UpdateBoard.update();
          boardManager.updateBoard(bno, board);
        }
        case "2" -> boardManager.deleteBoard(bno);
        case "3" -> {
        }
      }
    } catch (IOException e) {
      printWrongInput();
    }

  }

  @Override
  public boolean checkMenu() {
    System.out.println("-".repeat(60));
    System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
    System.out.print("메뉴 선택: ");

    try {
      String menu = br.readLine();
      if (!Pattern.matches(RegExp.CHECK_MENU.getRegExp(), menu)) {
        throw new IOException();
      }
      return menu.equals("1");
    } catch (IOException e) {
      printWrongInput();
    }

    return false;
  }

  private void printWrongInput() {
    System.out.println("잘못된 입력입니다. 메뉴에 있는 번호만 입력해주세요.");
  }
}
