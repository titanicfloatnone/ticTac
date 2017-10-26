$(document).ready(function(){

  $('.box').click(function(){

    var id = $(this).attr('id');

    $.ajax({
        url: '/makeMove?number=' +  id,
        success: function (Data) {
          if(Data.startsWith("Error")) {

          }
          else {
            var object = JSON.parse(Data);
            $("#" + id).html(object[id].symbol);
          }
        }
    });
  });


});
