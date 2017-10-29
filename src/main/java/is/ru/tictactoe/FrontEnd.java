package is.ru.tictactoe;

import static spark.Spark.*;
import spark.QueryParamsMap;
import com.google.gson.Gson;


public class FrontEnd {
  private static Business bl;

  public FrontEnd(){
    bl = new Business();
  }


  public static void main(String[] args) {
    DropBox dropbox = new DropBox();
    bl = new Business();
    port(getHerokuPort());
    staticFiles.location("/public");

    get("/makeMove", (req, res) -> {
        QueryParamsMap map = req.queryMap();

        try {
            Integer number = map.get("number").integerValue();
            bl.makeMove(number);
            return squareToJson(bl.getBoard());
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
    });
    get("/hasWinner", (req, res) -> {
      return bl.hasWinner();
    });

    get("/isTie", (req, res) -> {
      return bl.isTie();
    });

    get("/restartGame", (req, res) -> {
      bl.restartGame();
      return true;
    });
  }

  public static String squareToJson(Square[] input) {

      Gson gson = new Gson();
      String json = gson.toJson(input);
      return json;
  }

  static int getHerokuPort() {
    ProcessBuilder psb = new ProcessBuilder();
    if (psb.environment().get("PORT") != null) {
      return Integer.parseInt(psb.environment().get("PORT"));
    }
    return 4567;
  }
}
