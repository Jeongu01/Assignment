package StringAssign.string3;

public class FindCharacters {


  public static void main(String[] args) {
    FindCharacters fc=new FindCharacters();
    int count=fc.countChar("Boys, be ambitious", 'b');
    System.out.println(count);

  }
  public int countChar(String str, char c) {
    // Method를 완성하세요...
    char[] arr = str.toCharArray();
    int count = 0;
    for (char c1 : arr) {
      if (c1 == c) {
        count++;
      }
    }
    return count;
  }
}
