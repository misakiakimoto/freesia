<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- 国際化 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<%-- 国際化 --%>
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.freesia.property.account" var="lang" />

<title>freesia-アカウント</title>
<meta charset="utf-8">

<%-- たぶんBootstrap --%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<%-- タイトル --%>
<title><s:text name = "lang.account.title"/></title>

<%-- またしてもBootstrap --%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Font awesome CSS -->
<link href="path/to/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Bootstrap cdn -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- Custom CSS -->
<link rel="stylesheet" href="./css/account.css">
<link rel="stylesheet" href="css/header.css">
<link href="css/Wallpaper.css" rel="stylesheet">


<%-- ======================================================
  === 以下ヘッダー ======================================= --%>

<jsp:include page="Header.jsp"/>


<%-- ======================================================
  === 以下ボディー ========================================--%>

<div class="body">
<%-- === ページタイトル ============================= --%>
  <h1><s:text name = "lang.account.header1"/></h1>

<%-- === アカウント情報テーブル ============================= --%>
<!-- アクション -->
  <s:action var="select" name="AccountAction" />
<!-- イテレータ -->
  <s:iterator value="#select.UserList">
    <table class="account">
    <%-- ユーザーID --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.userId"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "userId"/></td>
      </tr>
    <%-- 氏名(漢字) --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.NameKanji"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value="familyNameKanji"/> <s:property value="givenNameKanji"/></td>
      </tr>
    <%-- 氏名(ふりがな) --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.NameKana"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "familyNameKana"/> <s:property value ="givenNameKana"/></td>
      </tr>
    <%-- 郵便番号 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.postal"/></td>
      </tr>
      <tr class="tr2">
      <td class="data"><s:property value="postal"/></td>
      </tr>
    <%-- 住所 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.address"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value="address"/></td>
      </tr>
    <%-- 電話番号 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.phoneNumber"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "phoneNumber"/></td>
      </tr>
    <%-- メールアドレス --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.email"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "email"/></td>
      </tr>
    <%-- 携帯電話番号 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.mobileNumber"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "mobileNumber"/></td>
      </tr>
    <%-- 携帯メールアドレス --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.mobileEmail"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "mobileEmail"/></td>
      </tr>
    <%-- 性別 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.sex"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "sex"/></td>
      </tr>
    <%-- 生年月日 --%>
      <tr class="tr1">
        <td class="item"><s:text name = "lang.account.birthday"/></td>
      </tr>
      <tr class="tr2">
        <td class="data"><s:property value = "birthday"/></td>
      </tr>
    </table>
  </s:iterator>
</div>


<%-- ======================================================
  === 以下フッター ========================================--%>



  <footer>
    <s:include value="footerLoad.jsp" />
  </footer>


<%-- ======================================================
  === その他情報 ========================================--%>

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Scrolling Nav JavaScript -->
<script src="js/jquery.easing.min.js"></script>
<script src="js/scrolling-nav.js"></script>
