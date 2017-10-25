$(document).ready(function(){

  $('.box').click(function(){

    var id = $(this).attr('id');

    $.ajax({
        url: '/makeMove?number=' +  id,
        success: function (Data) {
            console.log(Data[0]);
        }
    });
  });


});
