import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  private String[][] field;

  public static void main(String args[]) throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");

    Scanner inf = new Scanner(maze1);

    int numLines = 0;

    while(inf.hasNextLine()){
      numLines ++;
      String line = inf.nextLine();
      System.out.println(line);
    }
    System.out.println(numLines);

    //System.out.println(numLines("Maze1.txt"));
  }

/* public ReadFile() throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");
    Scanner inf = new Scanner(maze1);

    for (i = 0; i < ; i++){
      for (j = 0; j < ; j++){

      }
    }

  }*/


  public void numLines(String filename, String args[]) throws FileNotFoundException{
    //counts how many lines a file has
    File maze2 = new File(filename);
    Scanner inf = new Scanner(maze2);

    int numLines = 0;

    while(inf.hasNextLine()){
      numLines++;
    }

    System.out.println(numLines);

  }


}
