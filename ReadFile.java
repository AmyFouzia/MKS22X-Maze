import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class ReadFile {

  private String[][] field = new String[numLines][charsPerLine];
  private static int numLines = 0;
  private static int charsPerLine = 0;

  public static void main(String args[]) throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");

    Scanner inf = new Scanner(maze1);

    while(inf.hasNextLine()){
      numLines ++;
      String line = inf.nextLine();
      System.out.println(line);
    }

  }

  public ReadFile() throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");
    Scanner inf = new Scanner(maze1);

    for (i = 0; i < numLines; i++){
      for (j = 0; j < charsPerLine; j++){
        field[i][j]
      }
    }

  }


}
