package board.dao;

import board.service.BoardService;
import board.vo.Board;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class BoardManager extends BoardDBIO implements BoardService {

  private static final BoardManager instance = new BoardManager();
  private final String date = new SimpleDateFormat("yyyy.MM.dd").format(
      Calendar.getInstance().getTime());

  private BoardManager() {
  }

  public static BoardManager getInstance() {
    return instance;
  }

  @Override
  public ArrayList<Board> getBoardList() {    // 0. ShowList 목록 출력
    ArrayList<Board> boardList = new ArrayList<>();
    String query = "SELECT * "
        + "FROM post "
        + "ORDER BY bno DESC;";
    ResultSet rs = null;

    try {
      rs = super.execute(query, rs);
      while (rs.next()) {
        Board board = getBoard(rs);
        boardList.add(board);
      }
      rs.close();
      super.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return boardList;
  }

  @Override
  public void createBoard(Board board) {   // 1번 메뉴. 게시글 생성
    String title = board.getBtitle();
    String content = board.getBcontent();
    String writer = board.getBwriter();

    String query = "INSERT INTO post VALUES ("
        + "NULL, '"
        + title + "', '"
        + content + "', '"
        + writer + "', '"
        + date + "')";
    super.execute(query);
    super.close();
  }

  @Override
  public Board readBoard(int bno) {   // 2번 메뉴. 게시글 읽기
    Board board = new Board();
    String query = "SELECT bno, title, content, writer, date " +
        "FROM post " +
        "WHERE bno=" + bno;
    ResultSet rs = null;

    try {
      rs = super.execute(query, rs);
      if (rs.next()) {
        board = getBoard(rs);
      } else {
        throw new NullPointerException();
      }
      super.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (NullPointerException e) {
      System.out.println("목록에서 해당 게시글을 찾을 수 없습니다.");
      return null;
    }

    return board;
  }

  @Override
  public void updateBoard(int bno, Board board) {   // 2-1번 메뉴. 게시글 업데이트
    String title = board.getBtitle();
    String content = board.getBcontent();
    String writer = board.getBwriter();

    String query = "UPDATE post SET " +
        "title = '" + title +
        "', content = '" + content +
        "', writer = '" + writer +
        "', date = '" + date +
        "' WHERE bno = " + bno;
    super.execute(query);
    super.close();
  }

  @Override
  public void deleteBoard(int bno) {   // 2-2번 메뉴. 특정 게시글 삭제
    String query = "DELETE FROM post "
        + "WHERE bno = " + bno;
    super.execute(query);
    super.close();
  }

  @Override
  public void clearBoard() {   // 3번 메뉴. 게시글 전체 삭제
    String query = "DELETE FROM post";
    super.execute(query);
    query = "ALTER TABLE post AUTO_INCREMENT=1";
    super.execute(query);
    super.close();
  }

  private Board getBoard(ResultSet rs) throws SQLException {
    int bno = rs.getInt(1);
    String title = rs.getString(2);
    String content = rs.getString(3);
    String writer = rs.getString(4);
    String date = rs.getString(5);

    return new Board(bno, title, content, writer, date);
  }

}
