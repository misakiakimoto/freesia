//追従するサイドバーを設置するプログラム

$(function(){
	var obj = $("div.submit");
	var offset = $(obj).offset();
	var topPadding = 160;
	$(window).scroll(function() {
		if ($(window).scrollTop() > offset.top) {
			$(obj).stop().animate({
				duration: 'fast',
				marginTop: $(window).scrollTop() - offset.top + topPadding
			});
		} else {
			$(obj).stop().animate({
				marginTop: 0
			});
		}
	});
});
