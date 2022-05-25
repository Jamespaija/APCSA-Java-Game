
/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: James Paija Pun
 */
import java.util.Random;

import javax.naming.TimeLimitExceededException;

public class Game {

  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String targetPic = "images/target.png";
  /*
   * private final String fileCursorLocked = "images/cursors/locked.png",
   * fileCursorUnlocked = "images/cursors/unlocked.png",
   * fileCursorDefault = "images/cursors/default.png";
   */
  // public int [][]lastLoc = int [][]; //not valid syntax, what is this for?
  // public int expireTime = Grid.pause(milliseconds: 3);
  public int score = 0;

  public Game() {

    grid = new Grid(15, 15);
    userRow = 1;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setBackground("images/map.jpg");
    grid.setImage(new Location(userRow, 0), targetPic);
  }

  public void play() {

    while (!isGameOver()) {
      Grid.pause(100);

      handleMousePressed();

      // System.out.println("finished hkp");
      if (msElapsed % 300 == 0) {
        // System.out.println("about to spawn");
        spawn();
      }
      // System.out.println("finished if");
      updateTitle();
      // System.out.println("updated title");
      msElapsed += 100;
      // System.out.println("bottom of cycle");
    }
  }

  public void handleMousePressed() {

    // check last key pressed
    Location loc = grid.checkLastLocationClicked();
    System.out.println(loc);

    String currentPic = grid.getImage(loc);
    if (targetPic.equals(currentPic)) {
      // else if(!targetPic.equals(currentPic)&& grid. ){
      getScore();
    }

    // if (loc) {

  }

  /*
   * public void handleKeyPress() {
   * 
   * // check last key pressed
   * int key = grid.checkLastKeyPressed();
   * System.out.println(key);
   * 
   * // set "w" key to move the plane up
   * if (key == 87) {
   * // check case where out of bounds
   * 
   * // change the field for userrow
   * 
   * userRow--;
   * 
   * // shift the user picture up in the array
   * Location loc = new Location(userRow, 0);
   * grid.setImage(loc, "user.gif");
   * 
   * Location oldLoc = new Location(userRow + 1, 0);
   * grid.setImage(oldLoc, null);
   * 
   * }
   * // if I push down arrow, then plane goes down
   * 
   * }
   */

  // populate target
  public void spawn() {
    // spawns random target on the grid
    for(int r = 0; r < grid.getNumRows(); r++){
      for(int c = 0; c< grid.getNumCols(); c++){
        //Object tagetPic;
        [r][c] = tagetPic;

      }
    }

      //field for target and use the field location to compare it to handleMousePressed. 

  }

  public void scrollLeft() {

  }

  public void handleCollision(Location loc) {

  }

  public int getScore() {
    score++;
    // score updates if you hit the target
    return score;
  }

  public void updateTitle() {
    grid.setTitle("Your Score :  " + getScore());

  }

  public boolean isGameOver() {
    return false;
  }

  // public boolean accuracy() {

  // average from target divided by the shots made.

}