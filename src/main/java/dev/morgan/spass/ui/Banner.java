package dev.morgan.spass.ui;

public final class Banner {

  private Banner() {
  }

  public static void print() {

    String logo = """
              _____
             / ____|
            | (___  _ __   __ _ ___ ___
             \\___ \\| '_ \\ / _` / __/ __|
             ____) | |_) | (_| \\__ \\__ \\
            |_____/| .__/ \\__,_|___/___/
                   | |
                   |_|
        """;

    System.out.println(Colors.PURPLE + logo + Colors.RESET);
    System.out.println("   v2.0 - Colors");
  }
}
