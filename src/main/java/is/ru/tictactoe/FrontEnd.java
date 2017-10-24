package is.ru.tictactoe;

import static spark.Spark.*;
import spark.QueryParamsMap;

public class FrontEnd {
  public static void main(String[] args) {
    staticFiles.location("/public");

    get("/", (req, res) -> greet("html/index.html"));
  }

  public static String greet(String htmlFile) {
      return "Hello world";
  }
}
