package is.ru.tictactoe;

import static spark.Spark.*;

public class FrontEnd {
  public static void main(String[] args) {
  	PORT(getHerokuPort());
    staticFiles.location("/public");

    get("/", (req, res) -> greet());
  }

  public static String greet() {
    return "Hello world";
  }

  static int getHerokuPort() {
    ProcessBuilder psb = new ProcessBuilder();
	if (psb.environment().get("PORT") != null) {
	    return Integer.parseInt(psb.environment().get("PORT"));
    }
	return 4567;
    }
}
