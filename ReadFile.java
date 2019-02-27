import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  String[][] = field;

  public static void main(String args[]) throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");

    Scanner inf = new Scanner(maze1);

    while(inf.hasNextLine()){
      String line = inf.nextLine();
      System.out.println(line);
    }

    System.out.println(numLines("Maze1.txt"));
  }

/*  public ReadFile() throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");
    Scanner inf = new Scanner(maze1);

    for (i = 0; i < ; i++){
      for (j = 0; j < ; j++){

      }
    }

  }*/


  private int numLines(String filename){
    //counts how many lines a file has
    File maze1 = new File(filename);
    Scanner inf = new Scanner(maze1);
    int numLines;

    while(inf.hasNextLine()){
      numLines++;
    }
  }


}
