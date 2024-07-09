package StringAssign.string1;

public class Prob1 {

  public static void main(String[] args) {

    Prob1 prob1 = new Prob1();

    System.out.println( prob1.leftPad("SSG", 6, '#') );
    System.out.println( prob1.leftPad("SSG", 5, '$') );
    System.out.println( prob1.leftPad("SSG", 2, '&') );

  }

  public String leftPad(String str, int size, char padChar) {

    /*  여기에 프로그램을 완성하십시오. */

    StringBuilder sb = new StringBuilder(str);
    while (sb.length() < size) {
      sb.insert(0,padChar);
    }
    return sb.toString();
  }

}
