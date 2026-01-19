import org.code.theater.*;
import org.code.media.*;
import java.util.Scanner;
import java.io.File;

public class LastYear extends Scene {
/*
  Instance Variables
  */
  private String[] highlights;
  private String[] lessons;
  private int lessonCount;

    /*
   Constructor initializes default highlights and loads lessons from a file
   */
  public LastYear() {
    highlights = new String[] {
      "School",
      "Friends",
      "Coding",
      "Growth"
    };
    loadLessons();
  }

  public LastYear(String[] customHighlights) {
    highlights = customHighlights;
    loadLessons();
  }

    /*
   Loads up to 10 lessons from "data.txt"
   */
  private void loadLessons() {
    lessons = new String[10];   
    lessonCount = 0;

    try {
      Scanner input = new Scanner(new File("data.txt"));
      while (input.hasNextLine() && lessonCount < lessons.length) {
        lessons[lessonCount] = input.nextLine();
        lessonCount++;
      }
      input.close();
    } catch (Exception e) {
      System.out.println("Error reading data.txt");
    }
  }

  /*
   Draws the background, title, highlights, and lessons on the scene
   */
  public void drawScene() {
    setFillColor(new Color(173, 216, 230));
    drawRectangle(0, 0, 400, 400);

    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("My 2025 Recap", 120, 40);

    drawHighlights();
    drawLessons();

    pause(2);
  }

  private void drawHighlights() {
    for (int i = 0; i < highlights.length; i++) {
      drawText(highlights[i], 40, 80 + i * 30);
    }
  }

   /*
   Draws lessons with bullet points, or a message if none are loaded
   */
  private void drawLessons() {
    if (lessonCount > 0) {
      for (int i = 0; i < lessonCount; i++) {
        drawEllipse(250, 75 + i * 30, 10, 10);
        drawText(lessons[i], 270, 85 + i * 30);
      }
    } else {
      drawText("No lessons loaded", 230, 100);
    }
  }
}
