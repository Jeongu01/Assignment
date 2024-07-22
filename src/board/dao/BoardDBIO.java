package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BoardDBIO {

  private Connection connection = null;
  private String url = "jdbc:mysql://localhost:3306/board?characterEncoding=UTF-8&serverTimezone=UTC";
  private String id = "root";
  private String pwd = "asd1234";

  public void setUrl(String url) {
    this.url = url;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  private boolean open() {
    try {
      connection = DriverManager.getConnection(url, id, pwd);
      return true;
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }
  }

  protected boolean close() {
    try {
      connection.close();
      return true;
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
  }

  // select 쿼리문
  protected ResultSet execute(String query, ResultSet rs) {
    try {
      open();
      Statement obj = connection.createStatement();
      rs = obj.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rs;
  }

  // insert, delete, update 쿼리문
  protected boolean execute(String query) {
    boolean returnValue = false;
    try {
      open();
      Statement obj = connection.createStatement();
      int result = obj.executeUpdate(query);
      if (result == 1) {
        returnValue = true;
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return returnValue;
  }
}
