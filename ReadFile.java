import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void main(String args[]) throws FileNotFoundException{
    File maze1 = new File("Maze1.txt");

    Scanner inf = new Scanner(maze1);

    while(inf.hasNextLine()){
      String line = inf.nextLine();
      System.out.println(line);
    }
  }

  public static void main(String args[]) throws FileNotFoundException{


  }


}
