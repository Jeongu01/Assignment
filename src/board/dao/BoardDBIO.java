package board.dao;

import board.vo.Board;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public abstract class BoardDBIO extends ObjectDBIO {

  public ArrayList<Board> getBoardList() {
    ArrayList<Board> boardList = new ArrayList<>();
    String query = "SELECT * FROM post";
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
      e.printStackTrace();
    }
    return boardList;
  }

  public boolean createBoard(Board board) {
    String title = board.getBtitle();
    String content = board.getBcontent();
    String writer = board.getBwriter();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    Calendar calendar = Calendar.getInstance();
    String date = sdf.format(calendar.getTime());

    String query = "INSERT INTO post VALUES (" +
                    "NULL, '" +
                    title + "', '" +
                    content + "', '" +
                    writer + "', '" +
                    date + "')";
    super.execute(query);
    super.close();
    return true;
  }

  public Board readBoard(int no) {
    Board board = new Board();
    String query = "SELECT bno, title, content, writer, date " +
                   "FROM post " +
                   "WHERE bno=" +
                   no;
    ResultSet rs = null;

    try {
      rs = super.execute(query, rs);
      while (rs.next()) {
        board = getBoard(rs);
      }
      super.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return board;
  }

  public boolean updateBoard(int bno, Board board) {
    String title = board.getBtitle();
    String content = board.getBcontent();
    String writer = board.getBwriter();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
    Calendar calendar = Calendar.getInstance();
    String date = sdf.format(calendar.getTime());

    String query = "UPDATE post SET " +
        "title = '" + title +
        "', content = '" + content +
        "', writer = '" + writer +
        "', date = '" + date +
        "' WHERE bno = " + bno;
    super.execute(query);
    super.close();
    return true;
  }

  public boolean deleteBoard(int bno) {
    String query = "DELETE FROM post WHERE bno = " + bno;
    super.execute(query);
    super.close();
    return true;
  }

  public boolean clearBoard() {
    String query = "DELETE FROM post";
    super.execute(query);
    super.close();
    return true;
  }

  private Board getBoard(ResultSet rs) throws SQLException{
    int bno = rs.getInt(1);
    String title = rs.getString(2);
    String content = rs.getString(3);
    String writer = rs.getString(4);
    String date = rs.getString(5);

    return new Board(bno, title, content, writer, date);
  }

}
