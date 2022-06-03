
/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: James Paija Pun
 */
import java.util.Random;
//import javax.naming.TimeLimitExceededException;

public class Game {

  private Grid grid;
  private int userRow;
  private int msElapsed;
  private String targetPic = "images/target.png";
  public int score = 0;
  private Location targetLoc;
  private int start;

  /*
   * private final String fileCursorLocked = "images/cursors/locked.png",
   * fileCursorUnlocked = "images/cursors/unlocked.png",
   * fileCursorDefault = "images/cursors/default.png";
   */
  // public int [][]lastLoc = int [][]; //not valid syntax, what is this for?

  public Game() {

    grid = new Grid(15, 15);
    userRow = 1;
    msElapsed = 0;
    updateTitle();
    grid.setBackground("images/map.jpg");
    grid.setImage(new Location(userRow, 0), targetPic);
  }

  public void play() {

    while (!isGameOver()) {
      Grid.pause(100);

      handleMousePressed();
      spawn();
      // System.out.println("finished hkp");
      if (start >= 5000)
        // System.out.println("about to spawn");
        spawn();
    }
    // System.out.println("finished if");
    // updateTitle();
    // System.out.println("updated title");
    msElapsed += 100;
    // System.out.println("bottom of cycle");
  }

  public void handleMousePressed() {
    WavPlayer.play("/sound/" + val);
    // check last key pressed
    Location loc = grid.checkLastLocationClicked();
    System.out.println(loc);

    if (loc == null) {
      return;
    }

    String currentPic = grid.getImage(loc);

    if (targetPic.equals(currentPic)) {
      System.out.println("hit target");
      getScore();
    }
    // else if(targetPic.equals(currentPic)&& grid. ){
    // getScore();
    // }

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

    grid.setImage(targetLoc, null);

    // spawns random target on the grid

    int r = (int) (Math.random() * 15 - 1);
    int c = (int) (Math.random() * 15 - 1);
    targetLoc = new Location(r, c);

    grid.setImage(targetLoc, targetPic);
    start = 0;

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

  public double accuracy() {
    double aim = getScore() / 30;
    // average from target divided by the shots made.
    return aim;
  }
}