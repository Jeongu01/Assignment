package board.dto;

import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadBoard {

  public static void read(BoardManager boardManager) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("[게시물 읽기]");
    System.out.print("bno: ");
    int bno = Integer.parseInt(br.readLine());
    System.out.println("####################");
    Board board = boardManager.readBoard(bno);
    System.out.println("번호: " + board.getBno());
    System.out.println("제목: " + board.getBtitle());
    System.out.println("내용: " + board.getBcontent());
    System.out.println("작성자: " + board.getBwriter());
    System.out.println("날짜: " + board.getBdate());
    System.out.println("--------------------");

    subMenu(bno, boardManager);
  }

  private static void subMenu(int bno, BoardManager boardManager) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Board board;

    System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
    System.out.print("메뉴 선택: ");
    int menu = Integer.parseInt(br.readLine());

    switch (menu) {
      case 1 -> {
        board = UpdateBoard.update();
        boardManager.updateBoard(bno, board);}
      case 2 -> boardManager.deleteBoard(bno);
      case 3 -> {}  // TODO : List
    }

  }
}
