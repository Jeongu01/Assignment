package board.dao;

import board.util.RegExp;
import board.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class CreateBoard {

  public static Board create() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Board board = new Board();

    try {
      System.out.println("[새 게시물 입력]");
      System.out.print("제목: ");
      String input = br.readLine();
      if (!Pattern.matches(RegExp.BOARD_INPUT.getRegExp(), input)) throw new IOException();
      board.setBtitle(input);
      System.out.print("내용: ");
      input = br.readLine();
      if (!Pattern.matches(RegExp.BOARD_INPUT.getRegExp(), input)) throw new IOException();
      board.setBcontent(input);
      System.out.print("작성자: ");
      input = br.readLine();
      if (!Pattern.matches(RegExp.BOARD_INPUT.getRegExp(), input)) throw new IOException();
      board.setBwriter(input);
    } catch (IOException e) {
      System.out.println("잘못된 입력입니다. 한글, 숫자, 영어만 입력해주세요.");
    }

    return board;
  }

}
