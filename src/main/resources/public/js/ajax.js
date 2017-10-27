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

}
$(document).ready(function(){

  $('.box').click(function(){

    var id = $(this).attr('id');
    var object = null;
    var winner = "the winner is ";

    $.ajax({
        url: '/makeMove?number=' +  id,
        success: function (Data) {
          if(Data.startsWith("Error")) {

          }
          else {
            object = JSON.parse(Data);
            $("#" + id).html(object[id].symbol);

            $.ajax({
              url: '/hasWinner',
              success: function (Data) {

                  if(Data == "true")
                  {
                    $("#winner-is").html(winner + object[id].symbol);
                  }
              }
            });

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

  });

});
