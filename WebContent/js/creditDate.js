//クレジットカード期限を自動設定するためのプログラム
$(function() {
  var time = new Date();
  var year = time.getFullYear();

  //今年＋12年分の西暦を算出する
  for(var i=year;i<=(year+12);i++){
    $("#year").append('<option value="'+i+'">' +i+ '</option>');
  }

  //月を算出する
  for(var i=1;i<=12;i++){
    $("#month").append('<option value="'+i+'">' +i+ '</option>');
  }
});
