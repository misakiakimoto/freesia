$(function() {
    var i = new Date();
    var todayYear = i.getFullYear();
    var todayMonth = i.getMonth();

    $("#creditPay").submit(function(){
    var OKFlg = true;
  if ($("#year").val() < todayYear) {
	  OKFlg = false;
  	} else if(($("#year").val() == todayYear) && ($("#month").val() <= todayMonth)){
  		OKFlg = false;
  }
  if(OKFlg == false){
	  $("#dateError").html('カードの有効期限が切れています');
      $("#dateError").css('color','red');
      return false;
  }else{
	  $("#dateError").html('');
	  $("#creditPay").submit();
  }
});
});
