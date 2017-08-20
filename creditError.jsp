<!-- 入力したカード情報に誤りがある場合のページ -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!-- ここから国際化 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ここまで国際化 -->

<!DOCTYPE html>
<html>
<head>

<!-- ここから国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.sundia.property.creditError" var="lang" />
<!-- ここまで国際化 -->

    <meta charset="utf-8">
    <title><s:text name="lang.creditError.title" /></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"  href="css/bootstrap.css">


    <!-- Stylesheet
    ================================================== -->
    <link rel="stylesheet" type="text/css"  href="css/style.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slick-theme.css">
    <link rel="stylesheet" href="css/payment.css">

    <!-- Javascripts
    ================================================== -->
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/jquery.slick.min.js"></script>

</head>

<body>

    <div class="container">
    <s:text name="lang.creditError.error" /><br>
    <s:text name="lang.creditError.retry" />
    <br><br>

    <p><button type="button" onclick="history.back()" class="btn btn-default"><s:text name="lang.creditError.backtopage" /></button></p>
    </div>



</body>
</html>