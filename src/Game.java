
/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: James Paija Pun
 */
import java.util.Random;
import java.text.NumberFormat;
import java.util.Formatter;

//import javax.naming.TimeLimitExceededException;

import javax.naming.spi.DirStateFactory.Result;

public class Game {

  private Grid grid;
  private int userRow;
  private int msElapsed;
  private String targetPic = "images/target.png";
  public int score = 0;
  private Location targetLoc;
  private int start;
  private int timer;
  private int accuracy;
  private int counter = 0;
  private double result = 0.0;

  public Game() {
    timer = 60;
    grid = new Grid(40,60);
    userRow = 1;
    msElapsed = 0;
    updateTitle();
    grid.setBackground("images/map.jpg");

    targetLoc = new Location(0, 0);
    spawn();
  }

  public void play() {
    grid.fullscreen();
    grid.showMessageDialog("Try to hit the target for 1 minute. ");
    while (timer != -1) {
      Grid.pause(100);
      handleMousePressed();
      updateTitle();

      if (msElapsed - start >= 15000) {
        spawn();
      }

      msElapsed += 100;
      if (msElapsed % 1000 == 0)
        timer -= 1;
    }
    grid.setBackground("images/wallpaper.jpg");
    grid.showMessageDialog("You got " + score + " out of " + result() + " targets." + "\n You have accuracy of " + accuracy()+"%");

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
    counter++;
    grid.setImage(targetLoc, targetPic);
    start = msElapsed;
    System.out.println(targetLoc);

  }

  public int getScore() {
    return score;
  }

  public void updateScore() {
    score++;
  }

  public void updateTitle() {
    grid.setTitle("Your Score:" + getScore() + " \tTimer:" + timer + " second");

  }

  public boolean isGameOver() {
    return false;
  }

  public int result() {
    return counter;
  }

  public String accuracy() {
    result = (getScore() * 100.0 / result());
    NumberFormat nf = NumberFormat.getInstance();
    nf.setMaximumFractionDigits(2);
    return nf.format(result);
  }

}