package board.dao;

import board.ui.MenuManager;
import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadBoard {

  public static void read() throws IOException {
    BoardManager boardManager = BoardManager.getInstance();
    MenuManager menu = new MenuManager();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("[게시물 읽기]");
    System.out.print("bno: ");
    int bno = Integer.parseInt(br.readLine());
    Board board = boardManager.readBoard(bno);
    if (board == null) return;
    System.out.println("####################");
    System.out.println("번호: " + board.getBno());
    System.out.println("제목: " + board.getBtitle());
    System.out.println("내용: " + board.getBcontent());
    System.out.println("작성자: " + board.getBwriter());
    System.out.println("날짜: " + board.getBdate());

    menu.subMenu(bno);
  }
}
