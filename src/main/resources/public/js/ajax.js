$(document).ready(function(){

  $('.box').click(function(){

    var id = $(this).attr('id');
    var winnerIs = $(this).attr('winner-is');
    var object = null;
    var winner = "the winner is ";

    $.ajax({
        url: '/makeMove?number=' +  id,
        success: function (Data) {
          if(Data.startsWith("Error")) {

          }
          else {
            object = JSON.parse(Data)
            $("#" + id).html(object[id].symbol);
          }
        }
    });
    $.ajax({
      url: '/hasWinner',
      success: function (Data) {
          if(Data && object != null)
          {
            console.log("winner!");
            $("#winner-is").html(winner + object[id].symbol);
          }
      }
    })
  });


});
