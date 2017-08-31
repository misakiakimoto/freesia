<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-1.12.4.min.js" type="text/javascript"></script>
</head>
<body>

<header><s:include value="header.jsp" /></header>

<script type="text/javascript">
function slideSwitch() {
   var $active = $('#slideshow img.active');

   if ( $active.length == 0 ) $active = $('#slideshow img:last');

   var $next =  $active.next().length ? $active.next()
      : $('#slideshow img:first');

   $active.addClass('last-active');

   $next.css({opacity: 0.0})
      .addClass('active')
      .animate({opacity: 1.0}, 1000, function() {
           $active.removeClass('active last-active');
      });
}

$(function() {
   setInterval( "slideSwitch()", 3000 );
});
</script>


<style type="text/css">
#slideshow {
   position: relative;
   width:  100%; /* 画像の横幅に合わせて記述 */
   height: 100%; /* 画像の高さに合わせて記述 */
}
#slideshow img {
   position: absolute;
   top: 0;
   left:0;
   z-index: 8;
   opacity: 0.5;
}
#slideshow img.active {
   z-index: 10;
   opacity: 1.0;
}
#slideshow img.last-active {
   z-index: 9;
}

.welcome{

}

h3{
margin:0;
}

@media screen and (min-width:480px) {
    /*　画面サイズが480pxからはここを読み込む　*/
img { width:100%;
      height:100vh;
      }
}
@media screen and (min-width:768px) and ( max-width:1024px) {
    /*　画面サイズが768pxから1024pxまではここを読み込む　*/
p {}
}
@media screen and (min-width:1024px) {
    /*　画面サイズが1024pxからはここを読み込む　*/

}

</style>

<div class="welcome">
</div>

<p id="slideshow">
   <img src="img/TopPage/t0.jpg" alt="画像0" class="active">
   <img src="img/TopPage/t1.jpg" alt="画像1">
   <img src="img/TopPage/t2.jpg" alt="画像2">
   <img src="img/TopPage/t3.jpg" alt="画像3">
   <img src="img/TopPage/t4.jpg" alt="画像4">
   <img src="img/TopPage/t5.jpg" alt="画像5">

</p>

</div>
</div>
</body>
</html>