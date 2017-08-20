<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.sundia.property.log"
  var="lang" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="lang.log.title" /></title>
</head>

<!-- cssの読み込み -->
<link href="css/Wallpaper.css" rel="stylesheet">

<!-- Bootstrap cdn -->
<link rel="stylesheet"
  href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- Javascripts
    ================================================== -->
<script src="js/jquery-3.2.1.min.js"></script>

<!--jQuery呼び出し-->
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>

<body>
 <jsp:include page="Header.jsp" />

     <br><br><br><br><br><br><br>

    <div class="container">
        <div class="row">
            <div class="col-md-12">
            <h1><s:text name="lang.log.complete" /></h1>
            </div>
         </div>
         <br><br>
  </div>
  <footer><s:include value="footerLoad.jsp" /></footer>

  <!--jQueryでブラウザの「戻る」を不可にする-->
<script>
if (window.history && window.history.pushState) {

  history.pushState("nohb", null, "");
  $(window).on("popstate", function(event) {

    if (!event.originalEvent.state) {


      history.pushState("nohb", null, "")
      alert("画面最下部のフッターからお戻り下さい。");

      return;
    }
  });
}
</script>

 </body>


</html>