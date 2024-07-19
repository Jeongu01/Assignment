package board.dao;

import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateBoard {
  public static Board create() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Board board = new Board();

    System.out.println("[새 게시물 입력]");
    try {
      System.out.print("제목: ");
      board.setBtitle(br.readLine());
      System.out.print("내용: ");
      board.setBcontent(br.readLine());
      System.out.print("작성자: ");
      board.setBwriter(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return board;
  }
}
