/* Game Class Starter File
 * Last Edit: 5/6/2021
 * Author: James Paija Pun
 */

public class Game {

  private Grid grid;
  private int userRow;
  private int msElapsed;
  private int timesGet;
  private int timesAvoid;
  private String userPic = "images/target.png";

  public Game() {

    grid = new Grid(15, 15);
    userRow = 1;
    msElapsed = 0;
    timesGet = 0;
    timesAvoid = 0;
    updateTitle();
    grid.setBackground("images/map.jpg");
    grid.setImage(new Location(userRow, 0), userPic);
  }

  public void play() {

    while (!isGameOver()) {
      Grid.pause(100);
      handleKeyPress();
      if (msElapsed % 300 == 0) {
        // this will make move
        scrollLeft();
        spawn();
      }
      updateTitle();
      msElapsed += 100;
    }
  }

  public void handleKeyPress() {

    // check last key pressed
    int key = grid.checkLastKeyPressed();
    System.out.println(key);

    // set "w" key to move the plane up
    if (key == 87) {
      // check case where out of bounds

      // change the field for userrow

      userRow--;

      // shift the user picture up in the array
      Location loc = new Location(userRow, 0);
      grid.setImage(loc, "user.gif");

      Location oldLoc = new Location(userRow + 1, 0);
      grid.setImage(oldLoc, null);

    }
    // if I push down arrow, then plane goes down

  }

  // populate target
  public void spawn() {
    // spawns random target on the grid
    for(int i = 0; i < grid.getNumRows(); i++){
      for(int c = 0; c< grid.getNumCols(); i++){


  }
}
  }

  public void scrollLeft() {

  }

  public void handleCollision(Location loc) {

  }

  public int getScore() {
    // score updates if you hit the target
    return 0;
  }

  public void updateTitle() {
    grid.setTitle("Your Score :  " + getScore());

  }

  public boolean isGameOver() {
    return false;
  }

  //public boolean accuracy() {

    // average from target divided by the shots made.
  
}