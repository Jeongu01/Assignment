package board.service;

import board.vo.Board;
import java.util.ArrayList;

public interface BoardService {

  ArrayList<Board> getBoardList();

  void createBoard(Board board);

  Board readBoard(int bno);

  void updateBoard(int bno, Board board);

  void deleteBoard(int bno);

  void clearBoard();

}
