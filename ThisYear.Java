import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;
import java.io.File;

public class ThisYear extends Scene {
/*
  Instance Variables
  */
  private String[] motivations;
  private String[] goals;
  private int goalCount;

    /*
   Constructor initializes default motivations and loads goals from a file
   */
  public ThisYear() {
    motivations = new String[] {
      "Focus",
      "Discipline",
      "Confidence"
    };
    loadGoals();
  }

    /*
   Overloaded constructor allows passing custom motivations
   */
  public ThisYear(String[] customMotivations) {
    motivations = customMotivations;
    loadGoals();
  }

  /*
   Loads up to 10 goals from "citation.txt"
   */
  private void loadGoals() {
    goals = new String[10];
    goalCount = 0;

    try {
      Scanner input = new Scanner(new File("citation.txt"));
      while (input.hasNextLine() && goalCount < goals.length) {
        goals[goalCount] = input.nextLine();
        goalCount++;
      }
      input.close();
    } catch (Exception e) {
      System.out.println("Error reading citation.txt");
    }
  }

    /*
   Draws the background, title, goals, and main motivation on the scene
   */
  public void drawScene() {
    setFillColor(new Color(230, 230, 250)); // lavender
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.SERIF, FontStyle.BOLD);
    drawText("My 2026 Goals", 120, 40);

    drawGoals();
    drawMotivation();

    pause(2);
  }
  /*
   Draws each goal with a dash, and shows the main motivation if goals exist
   */
  private void drawGoals() {
    for (int i = 0; i < goalCount; i++) {
      drawText("- " + goals[i], 60, 90 + i * 30);
    }
  }

  private void drawMotivation() {
    if (goalCount > 0) {
      drawText("Mindset: " + motivations[0], 90, 350);
    }
  }
}
