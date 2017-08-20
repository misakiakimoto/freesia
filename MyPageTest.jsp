<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>

<html>
<head>
<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.sundia.property.myPageTest"
  var="lang" />

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">

<title><s:text name="lang.MyPageTest.title" /></title>


<!-- jQuery読み込み -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<script
  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">


<!-- cssの読み込み -->

<link href="css/Wallpaper.css" rel="stylesheet">
<link rel="stylesheet" href="./css/account.css">


<!-- Font awesome CSS -->
<link href="path/to/font-awesome/css/font-awesome.min.css"
  rel="stylesheet">

<!-- Bootstrap cdn -->
<link rel="stylesheet"
  href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- Javascripts
    ================================================== -->
<script src="js/jquery-3.2.1.min.js"></script>


</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">
  <!-- ヘッダーの読み込み -->
  <jsp:include page="Header.jsp" />

  <div align="center">
    <br>
    <div id="body">
      <h1>
        <s:text name="lang.MyPageTest.mypage" />
      </h1>
      <s:if test="#session.userLevel==3">
        <a href="Admin_main.jsp">
          <s:text name="lang.MyPageTest.toadmin" /></a>
      </s:if>
    </div>

    <!-- ユーザー情報の表示 -->
    <%-- === アカウント情報テーブル ============================= --%>
    <!-- アクション -->
    <s:action var="select" name="AccountAction" />
    <!-- イテレータ -->
    <s:iterator value="#select.UserList">

      <table class="account">
        <%-- ユーザーID --%>
        <tr class="tr1">
          <td class="item"><s:text name="lang.account.userId" /></td>
        </tr>
        <tr class="tr2">
          <td class="data"><s:property value="userId" /></td>
        </tr>
        <%-- 氏名(漢字) --%>
        <tr class="tr1">
          <td class="item"><s:text name="lang.account.NameKanji" /></td>
        </tr>
        <tr class="tr2">
          <td class="data"><s:property value="familyNameKanji" /> <s:property
              value="givenNameKanji" /></td>
        </tr>
        <%-- メールアドレス --%>
        <tr class="tr1">
          <td class="item"><s:text name="lang.account.email" /></td>
        </tr>
        <tr class="tr2">
          <td class="data"><s:property value="email" /></td>
        </tr>
      </table>
    </s:iterator>
  </div>

  <br>
  <br>

  <s:form action="AccountAction">
    <!-- 買い物を続ける -->
    <!-- 購入ボタンフォーム -->
    <button type="submit" class="btn btn-danger center-block">
       <s:text name="lang.MyPageTest.todetail" />
    </button>
  </s:form>
  <br>
  <s:form action="HistoryAction">
    <!-- 購入ボタンフォーム -->
    <button type="submit" class="btn btn-warning center-block">
      <s:text name="lang.MyPageTest.tohistory" />
    </button>
  </s:form>



  <footer>
    <s:include value="footerLoad.jsp" />
  </footer>

</body>

</html>

