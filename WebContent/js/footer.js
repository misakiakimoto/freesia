$(function(){


//	$(".menu-name").hover(function(){
//		$(this).css("cursol", "pointer");
//	})
//ここからプルダウン
	var num1=0;

	$('#suit').click(function(){
		$(this).data('click', ++num1);
		var click=$(this).data("click");
		if(click %2 !=0){
			$('ul#suit-list li').fadeIn();
		}else{
			$('ul#suit-list li').fadeOut();
		}
	});

	var num2=0;

	$('#bag').click(function(){
		$(this).data('click', ++num2);
		var click=$(this).data("click");
		if(click %2 !=0){
			$('ul#bag-list li').fadeIn();
		}else{
			$('ul#bag-list li').fadeOut();
		}
	});

	var num3=0;

	$('#kaden').click(function(){
		$(this).data('click', ++num3);
		var click=$(this).data("click");
		if(click %2 !=0){
			$('ul#kaden-list li').fadeIn();
		}else{
			$('ul#kaden-list li').fadeOut();
		}
	});

	var num4=0;

	$('#small').click(function(){
		$(this).data('click', ++num4);
		var click=$(this).data("click");
		if(click %2 !=0){
			$('ul#small-list li').fadeIn();
		}else{
			$('ul#small-list li').fadeOut();
		}
	});

	$(document).on('click', function(e){
	    if( !$(e.target).closest('#suit','ul#suit-list li').length ){
	    	num1=0;
	    	$('ul#suit-list li').fadeOut();
	    }
	});
	$(document).on('click', function(e){
	    if( !$(e.target).closest('#bag','ul#bag-list li').length ){
	    	num2=0;
	    	$('ul#bag-list li').fadeOut();
	    }
	});
	$(document).on('click', function(e){
	    if( !$(e.target).closest('#kaden','ul#kaden-list li').length ){
	    	num3=0;
	    	$('ul#kaden-list li').fadeOut();
	    }
	});
	$(document).on('click', function(e){
	    if( !$(e.target).closest('#small','ul#small-list li').length ){
	    	num4=0;
	    	$('ul#small-list li').fadeOut();
	    }
	});

//	$('.item-detail id').click(function(){
//		alert("On Click!")
//console.log("アイテム")
//	});

//	$(document).on('click', function(e){
////alert(e);
//	  if (!$(e.target).closest('.menu-name> ul').length) {
//alert(num1);
//			$(this).fadeOut();
//	    // フェードやスライドなどの処理方法を記述;
//	  }
//	});

//	$('.item-detail').click(function(){
//		  // クリックした場所がmenu-wrapper(領域内とみなす範囲)に無ければmenuを消す
//	  if(!$(this()){
//		  $(this).fadeOut();
//
//		  var num1=0;
//		  var num2=0;
//		  var num3=0;
//		  var num4=0;
//	  }
//	});
//プルダウンここまでまで

});


/*--------------------------------------------------------------------------*
 *
 *  footerFixed.js
 *
 *  MIT-style license.
 *
 *  2007 Kazuma Nishihata [to-R]
 *  http://blog.webcreativepark.net
 *
 *--------------------------------------------------------------------------*/
// footer

new function(){

	var footerId = "footer";
	//メイン
	function footerFixed(){
		//ドキュメントの高さ
		var dh = document.getElementsByTagName("body")[0].clientHeight;
		//フッターのtopからの位置
		document.getElementById(footerId).style.top = "0px";
		var ft = document.getElementById(footerId).offsetTop;
		//フッターの高さ
		var fh = document.getElementById(footerId).offsetHeight;
		//ウィンドウの高さ
		if (window.innerHeight){
			var wh = window.innerHeight;
		}else if(document.documentElement && document.documentElement.clientHeight != 0){
			var wh = document.documentElement.clientHeight;
		}
		if(ft+fh<wh){
			document.getElementById(footerId).style.position = "relative";
			document.getElementById(footerId).style.top = (wh-fh-ft-1)+"px";
		}
	}

	//文字サイズ
	function checkFontSize(func){

		//判定要素の追加
		var e = document.createElement("div");
		var s = document.createTextNode("S");
		e.appendChild(s);
		e.style.visibility="hidden"
		e.style.position="absolute"
		e.style.top="0"
		document.body.appendChild(e);
		var defHeight = e.offsetHeight;

		//判定関数
		function checkBoxSize(){
			if(defHeight != e.offsetHeight){
				func();
				defHeight= e.offsetHeight;
			}
		}
		setInterval(checkBoxSize,1000)
	}

	//イベントリスナー
	function addEvent(elm,listener,fn){
		try{
			elm.addEventListener(listener,fn,false);
		}catch(e){
			elm.attachEvent("on"+listener,fn);
		}
	}

	addEvent(window,"load",footerFixed);
	addEvent(window,"load",function(){
		checkFontSize(footerFixed);
	});
	addEvent(window,"resize",footerFixed);

}