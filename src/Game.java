
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
  private int timer;
  private double accuracy;

  public Game() {
    timer = 10;
    grid = new Grid(25, 25);
    userRow = 1;
    msElapsed = 0;
    updateTitle();
    grid.setBackground("images/map.jpg");

    targetLoc = new Location(0, 0);
    spawn();
  }

  public void play() {
    grid.showMessageDialog("Try to hit the target for 2 minutes. ");
    while (timer != -1) {
      Grid.pause(100);
      handleMousePressed();
      updateTitle();

      if (msElapsed - start >= 5000) {
        spawn();
      }

      msElapsed += 100;
      if (msElapsed % 1000 == 0)
        timer -= 1;
    }
    if (timer == 0) {

    }

  }

  public void handleMousePressed() {

    // check last key pressed
    Location loc = grid.checkLastLocationClicked();

    if (loc == null) {
      return;
    }

    System.out.println(loc);

    WavPlayer.play("sounds/val.wav");
    String currentPic = grid.getImage(loc);

    if (targetPic.equals(currentPic)) {
      System.out.println("hit target");
      score++;
      spawn();
    }

  }

  public void spawn() {

    grid.setImage(targetLoc, "");

    // spawns random target on the grid

    int r = (int) (Math.random() * 25 - 1);
    int c = (int) (Math.random() * 25 - 1);
    targetLoc = new Location(r, c);

    grid.setImage(targetLoc, targetPic);
    start = msElapsed;

  }

  public int getScore() {
    return score;
  }

  public void updateScore() {
    score++;
  }

  public void updateTitle() {
    grid.setTitle("Your Score:" + getScore() + " \tTimer:" + timer);

  }

  public boolean isGameOver() {
    // grid.showInputDialog("Try Again");
    return false;
  }

  public double result() {
    // accuracy = (1.0)(score-)
    return accuracy;
  }
}