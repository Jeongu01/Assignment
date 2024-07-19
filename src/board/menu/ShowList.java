package board.menu;

import board.dto.BoardManager;
import board.vo.Board;
import java.util.ArrayList;

public class ShowList {

  public static void list(BoardManager boardManager) {
    System.out.println("[게시물 목록]");
    System.out.println("------------------------------------------------------------");   // - 60개
    System.out.println("no\t\twriter\t\t\tdate\t\t\t\t\ttitle");
    System.out.println("------------------------------------------------------------");   // - 60개
    ArrayList<Board> boardList = boardManager.getBoardList();
    for (Board board : boardList) {
      System.out.printf("%-3d\t\t%-10s\t%-12s\t%s\n",
          board.getBno(),
          board.getBwriter(),
          board.getBdate(),
          board.getBtitle()
      );
    }
    System.out.println("------------------------------------------------------------");   // - 60개
  }

}
