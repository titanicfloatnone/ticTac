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
    bl = new Business();
    staticFiles.location("/public");

    get("/makeMove", (req, res) -> {
        QueryParamsMap map = req.queryMap();

        try {
            Integer number = map.get("number").integerValue();

            return squareToJson(bl.makeMove(number));
        }
        catch (Exception e){
            return "Error: " + e.getMessage();
        }
    });
    get("/hasWinner", (req, res) -> {
      return bl.hasWinner();
    });

  }

  public static String squareToJson(Square[] input) {

      Gson gson = new Gson();
      String json = gson.toJson(input);
      return json;
  }

}
