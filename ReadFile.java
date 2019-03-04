import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ReadFile {
//string version
  public static void main(String args[]) throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");
    Scanner inf = new Scanner(maze1);

    ArrayList<String> ref = new ArrayList<String>();
    while(inf.hasNextLine()){
      String line = inf.nextLine();
      System.out.println(line); //string version
      ref.add(line);
    }

  //better way to find/store these values
  int numLines = ref.size();
  int charsPerLine = ref.get(0).length();
  String[][] field = new String[numLines][charsPerLine];

//2d array version
//loop and add to field
    for (int i = 0; i < numLines; i++){
      for (int j = 0; j < charsPerLine; j++){
        field[i][j] = ref.get(i).charAt(j) + "";
      }
    }

    System.out.println( toString(field) );
  }


  public static String toString(String[][]field){
    String res = "";
    for(int i = 0; i < field.length; i++){
      for(int j = 0; j < field[i].length; j++){
        res += field[i][j];
      }
      res += "\n";
    }
    return res;
  }

}
