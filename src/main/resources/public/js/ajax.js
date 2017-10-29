window.onload = function()
{
  $.ajax({
      url: '/restartGame',
      success: function (Data) {
        if(Data) {
          console.log("restarted");
        }
        else {
          console.log("error");
        }
      }
  });

};
$(document).ready(function(){
  hasWinner = false;
    $('div#game-grid').on('click', '.box', function (){
      if(!hasWinner) {
        var id = $(this).attr('id');
        var winner = "the winner is ";

        $.ajax({
            url: '/makeMove?number=' +  id,
            success: function (Data) {
              if(Data.startsWith("Error")) {

              }
              else {
                $.ajax({
                  url: '/hasWinner',
                  success: function (Data) {

                      if(Data == "true")
                      {
                        if(!hasWinner) {
                          $("#winner-is").html(winner + object[id].symbol + "!");
                        }
                        hasWinner = true;
                      }
                  }
                });
                if(!hasWinner) {
                  object = JSON.parse(Data);
                  var html = "<div class=\"row\">";
                  for(i = 0; i < 9; i++) {
                    if(i % 3 === 0 && i > 0) {
                      html += "</div>";
                      html += "<div class=\"row\">";
                    }
                    html += "<div class=\"col-md-4 box\" id=\""+ i +"\">";
                    html += object[i].symbol +"</div>";
                  }
                  $("div#game-grid").html(html);
                }

                $.ajax({
                  url: '/isTie',
                  success: function (Data) {
                      if(Data == "true")
                      {
                        $("#tie").html("Its a tie!");
                      }
                  }
                });
              }
            }

        });
      }
    });
});
