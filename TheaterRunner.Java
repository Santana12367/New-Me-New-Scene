import org.code.theater.*;

public class TheaterRunner {
  public static void main(String[] args) {

    // Creates scene objects
    LastYear lastYear = new LastYear();
    ThisYear thisYear = new ThisYear();

    // Calls methods
    lastYear.drawScene();
    thisYear.drawScene();

    // Plays scenes
    Theater.playScenes(lastYear, thisYear);
    
  }
}
