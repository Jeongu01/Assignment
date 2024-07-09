package StringAssign.string3;

public class FindNumbers {

  public static void main(String[] args) {
    FindNumbers fn=new FindNumbers();

    long number = 228754462;
    System.out.println( "입력 숫자 = " + number );
    System.out.println("2 횟수 => " + fn.countNumber(number, 2));//3을 리턴
    System.out.println("4 횟수 => " + fn.countNumber(number, 4));//2를 리턴
  }

  private int countNumber(long number, int i) {
    String str = String.valueOf(number);
    int count = 0;
    for (int k = 0; k < str.length(); k++) {
      if ((int) str.charAt(k) - '0' == i) {
        count++;
      }
    }
    return count;
  }

  /*  이곳에 countNumber 메소드를 작성하십시오. */


}
