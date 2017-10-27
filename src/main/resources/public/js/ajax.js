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
  if(!hasWinner) {
    $('.box').click(function(){

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
                        $("#winner-is").html(winner + object[id].symbol);
                      }
                      hasWinner = true;
                    }
                }
              });
              if(!hasWinner) {
                object = JSON.parse(Data);
                $("#" + id).html(object[id].symbol);
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

    });
  }
});
