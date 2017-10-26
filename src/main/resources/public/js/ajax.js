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
            console.log(Data);

            $.ajax({
              url: '/hasWinner',
              success: function (Data) {
                  console.log("Im in hasWinner!");
                  console.log(Data);

                  console.log(object);
                  if(Data == "true")
                  {
                    console.log("winner!");
                    $("#winner-is").html(winner + object[id].symbol);
                  }
              }
            })

          }
        }

    });

  });

});
