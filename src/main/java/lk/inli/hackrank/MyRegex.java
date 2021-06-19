package lk.inli.hackrank;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class Solution{

  public static void main(String[] args){
    Scanner in = new Scanner(new ByteArrayInputStream("121.234.12.12".getBytes()));
    while(in.hasNext()){
      String IP = in.next();
      System.out.println(IP.matches(new MyRegex().pattern));
    }

  }
}
public class MyRegex {

  public String pattern = "^[0-2][0-5][0-5]$";
}
