import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private boolean animate = false;//false by default
    int[][] moves = new int[][] {{-1,0},{1,0},{0,1},{0,-1}};
    int Start;
    int End;

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        File mazetxt = new File(filename);
        Scanner inf = new Scanner(mazetxt);

        ArrayList<String> ref = new ArrayList<String>();
        while(inf.hasNextLine()){
          String line = inf.nextLine();
          ref.add(line);
        }

      //better way to find/store these values
      int numLines = ref.size();
      int charsPerLine = ref.get(0).length();
      maze = new char[numLines][charsPerLine];

    //2d array version
    //loop and add to field
        for (int i = 0; i < numLines; i++){
          for (int j = 0; j < ref.get(0).length(); j++){
            maze[i][j] = ref.get(i).charAt(j);
          }
        }

        Start = 0;
        End = 0;

        for(int i = 0; i < maze.length; i++){//loop thru to find letters
          for(int j = 0; j < maze[i].length; j++){
            if(maze[i][j] == 'S') Start++;
            if(maze[i][j] == 'E') End++;
          }
        }

      if(Start != 1 || End != 1){
        throw new IllegalStateException();
      }

    }

    // When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: throw a FileNotFoundException or IllegalStateException


    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }


   /*Return the string that represents the maze.

     It should look like the text file with some characters replaced.

    */
    public String toString(){
      String res = " ";
      for(int i = 0; i < maze.length; i++){
        for(int j = 0; j < maze[i].length; j++){
          res += maze[i][j];
        }
        res += "\n";
      }
      return res;
    }


    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S.


            //erase the S


            //and start solving at the location of the s.
            int row = 0;
            int col = 0;

            for(int i = 0; i < maze.length; i++){
              for(int j = 0; j < maze[i].length; j++){
                if(maze[i][j] == 'S'){
                  row = i;
                  col = j;
                }
              }
            }
            maze[row][col] = ' ';

            return solve(row, col, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int numSteps){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //solved maze (base case)
        if(maze[row][col] == 'E'){
          return numSteps;
        }

        //invalid space
        if(maze[row][col] != ' '){
          return -1;
        }

        for(int i = 0; i < moves.length; i++){

          int Nrow = row + moves[i][0];
          int Ncol = col + moves[i][1];
          //been here
          maze[row][col] = '@';
          int res = solve(Nrow, Ncol, numSteps + 1);

          if(res != -1){
            return res; //valid move
          }
          else{
            maze[row][col] = '.'; //invalid move
          }
        }

        return -1; //so it compiles
    }

}
