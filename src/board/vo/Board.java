package board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private String bdate;
}
