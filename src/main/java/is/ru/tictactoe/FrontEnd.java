package is.ru.tictactoe;

import static spark.Spark.*;

public class FrontEnd {
  public static void main(String[] args) {
    get("/", (req, res) -> greet());
  }

  public static String greet() {
      return "Hello world";
  }
}
