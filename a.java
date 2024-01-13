import java.util.Scanner;

public class a {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // Get the number of hurdles.
    int n = scanner.nextInt();

    // Get the heights of the hurdles.
    int[] hurdles = new int[n];
    for (int i = 0; i < n; i++) {
      hurdles[i] = scanner.nextInt();
    }

    // Get the player's jump height.
    int jumpHeight = scanner.nextInt();

    // Get the wind speed.
    double windSpeed = scanner.nextDouble();

    // Get the fatigue factor.
    double fatigueFactor = scanner.nextDouble();

    // Analyze the player's performance.
    String result = analyzeKhoKhoHurdlePerformance(hurdles, jumpHeight, windSpeed, fatigueFactor);

    // Print the result.
    System.out.println(result);
  }

  public static String analyzeKhoKhoHurdlePerformance(int[] hurdles, int jumpHeight, double windSpeed, double fatigueFactor) {
    if (hurdles.length == 0) {
      return "There were no hurdles.";
    }

    // Calculate the effective jump height, taking into account wind and fatigue.
    double effectiveJumpHeight = jumpHeight * (1 - fatigueFactor) * (1 + windSpeed / 10);

    // Check if the player can clear all hurdles.
    boolean success = true;
    for (int hurdleHeight : hurdles) {
      if (hurdleHeight > effectiveJumpHeight) {
        success = false;
        break;
      }
    }

    // Return a message indicating success or failure, along with the impact of wind and fatigue.
    if (success) {
      return "Success! Cleared all hurdles. Effective jump height: " + effectiveJumpHeight + " cm. Fatigue had minimal impact.";
    } else {
      return "Failed! Could not clear hurdle at " + hurdles[0] + " cm. Headwind and fatigue reduced performance.";
    }
  }
}