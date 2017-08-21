<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%-- 国際化 --%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
  <%-- 国際化 --%>
    <fmt:setLocale value="${pageContext.request.locale.language}" />
    <fmt:setBundle basename="com.internousdev.freesia.property.history" var="lang" />

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title><s:text name = "lang.history.title"/></title>

  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

  <!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

  <!-- Font awesome CSS -->
  <link href="path/to/font-awesome/css/font-awesome.min.css" rel="stylesheet">

  <!-- Bootstrap cdn -->
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

  <!-- Custom CSS -->
  <link href="./css/history.css" rel="stylesheet">
  <link rel="stylesheet" type="text/css"  href="css/header.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->
  <link rel="stylesheet" type="text/css" href="history.css"/>
  <!-- Bootstrapのcss読み込み -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- jQuery読み込み -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- BootstrapのJS読み込み -->
  <script src="js/bootstrap.min.js"></script>
</head>
<!-- The #page-top ID is part of the scrolling feature - the data-spy and data-target are part of the built-in Bootstrap scrollspy function -->

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">


<%-- ======================================================
  === 以下ヘッダー ======================================== --%>

<jsp:include page="Header.jsp"/>


<%-- ======================================================
  === 以下ボディー ========================================--%>

<!--
  <div class="row">
    <div class="col-sm-2" style="background-color:red;">red</div>
    <div class="col-sm-8" style="background-color:blue;">blue</div>
    <div class="col-sm-2" style="background-color:yellow;">yellow</div>
  </div>-->

<!-- 購入履歴 -->
<div class="container-title">
  <div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8"><h1><s:text name = "lang.history.oderList"/></h1></div>
    <div class="col-sm-2"></div>
  </div>
</div>

  <div class="container">
    <table class="table table-striped">
      <thead>
        <tr>
          <th><s:text name = "lang.history.date"/></th>
          <th><s:text name = "lang.history.itemName"/></th>
          <th><s:text name = "lang.history.subtotal"/></th>
        </tr>
      </thead>
      <s:action var="select" name="HistoryAction" />
      <s:iterator value="purList">
          <tr>
            <td><s:property value = "createdAt"/></td>
            <td><s:property value = "itemName"/></td>
            <td><s:property value = "multipliedPrice"/></td>
          </tr>
      </s:iterator>
    </table>
  </div>


<%-- ======================================================
  === 以下フッター ========================================--%>

  <footer>
    <s:include value="footerLoad.jsp" />
  </footer>

  <%--
  　　<jsp:include page=""/>
　 --%>

<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Scrolling Nav JavaScript -->
<script src="js/jquery.easing.min.js"></script>
<script src="js/scrolling-nav.js"></script>

</body>

</html>
