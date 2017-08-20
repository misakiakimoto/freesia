<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>

<html>


<head>
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.freesia.property.header" var="lang" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

 <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"  href="css/bootstrap.css">

  <!-- Stylesheet
    ================================================== -->
     <link rel="stylesheet" type="text/css"  href="css/header.css">
     <!--<link rel="stylesheet" type="text/css"  href="css/header.css">-->

</head>
<body>
 <s:if test="#session.userId != null && #session.loginFlg != 0">
      <nav class="navbar navbar-default navbar-fixed-top" role="navigation">

<div id="navigation">
  <div id="toggle"><a href="#">menu</a></div>
  <div id="menu">
    <h3>ログアウト</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
      <li><a href="#">menu6</a></li>
    </ul>
    <h3>マイカート</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
    </ul>
    <h3>フォトアップ</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
    </ul>
    <h3>お問い合わせ</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
    </ul>
  </div>
  </div>
  </nav>
  </s:if>
  <s:else>
    <div class="navbar-wrapper">
   <div class="container">
        <nav class="navbar navbar-default navbar-fixed-top headerbody" role="navigation">
   <div id="toggle"><a href="#">menu</a></div>
  <div id="menu">
    <h3>ログイン</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
      <li><a href="#">menu6</a></li>
    </ul>
    <h3>アイテム</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
    </ul>
    <h3>ギャラリー</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
    </ul>
    <h3>お問い合わせ</h3>
    <ul>
      <li><a href="#">menu1</a></li>
      <li><a href="#">menu2</a></li>
      <li><a href="#">menu3</a></li>
      <li><a href="#">menu4</a></li>
      <li><a href="#">menu5</a></li>
    </ul>
  </div>
  </nav>
</div>
</div>

</s:else>

</body>
</html>