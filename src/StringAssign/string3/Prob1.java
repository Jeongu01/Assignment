package StringAssign.string3;

import java.util.ArrayList;
import java.util.List;

public class Prob1 {
  public static void main(String[] args) {
    Prob1 p = new Prob1();
    String addr = "서울시,강남구,봉은사로,SSGJavaBackend";
    String[] addrArr = p.split(addr, ',');
    System.out.println("배열 크기 : " + addrArr.length);
    for(int i=0; i<addrArr.length; i++){
      System.out.print(addrArr[i] + " ");
    }
  }

  public String[] split(String str, char separator){
    List<String> tempList = new ArrayList<>();
    char[] arr = str.toCharArray();
    StringBuilder temp = new StringBuilder();
    for (char c : arr) {
      if (c != separator) {
        temp.append(c);
      }
      else {
        tempList.add(temp.toString());
        temp.delete(0, temp.length());
      }
    }
    return tempList.toArray(new String[0]);
  }
}