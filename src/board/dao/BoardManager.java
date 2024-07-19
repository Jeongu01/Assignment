package board.dao;

import board.vo.Board;
import java.util.ArrayList;

public class BoardManager extends BoardDBIO {

  private static final BoardManager instance = new BoardManager();

  private BoardManager(){}

  public static BoardManager getInstance() {
    return instance;
  }

  public ArrayList<Board> getBoardList() {    // 0. ShowList 목록 출력
    return super.getBoardList();
  }

  public boolean createBoard(Board board) {   // 1번 메뉴. 게시글 생성
    return super.createBoard(board);
  }

  public Board readBoard(int bno) {   // 2번 메뉴. 게시글 읽기
    return super.readBoard(bno);
  }

  public boolean updateBoard(int bno, Board board) {   // 2-1번 메뉴. 게시글 업데이트
    return super.updateBoard(bno, board);
  }

  public boolean deleteBoard(int bno) {   // 2-2번 메뉴. 특정 게시글 삭제
    return super.deleteBoard(bno);
  }

  public boolean clearBoard() {   // 3번 메뉴. 게시글 전체 삭제
    return super.clearBoard();
  }


}
