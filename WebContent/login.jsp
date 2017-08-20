<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- bootstrap -->
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- Bootstrap cdn -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<!-- css -->
<link rel="stylesheet" href="css/sidebar.css" type="text/css">
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="stylesheet" href="css/Account.css" type="text/css">
<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.freesia.log"
  var="lang" />

<meta charset="UTF-8">

  <!--  ヘッダー -->
  <jsp:include page="Header.jsp"/>


<title><s:text name="lang.log.login" /></title>
</head>
<body>
<div class="content">
  <div class="wrapper">
    <h2 class="errormsg">
      <s:property value="loginErrorMsg" />
    </h2>
    <div class="container">

      <div class="col-sm-4"> </div>
      <s:form action="LoginAction" method="post" theme="simple">
        <div class="col-sm-4">
          <table class="table table-bordered">
            <tr style="background-color: ;">
              <td><h3 class="login">Login</h3></td>
            </tr>
            <tr>
              <td>Email&emsp;<span style="color: red;"></span><input type="email"
                maxlength="40" required="required" name="email"  placeholder="email@gmail.com"/>
              </td>
            </tr>

            <tr>
              <td>pass&emsp;<span style="color: red;"></span><input type="password"
                required="required" maxlength="30" name="password" />
              </td>
            </tr>
            <tr>
              <td><button type="submit" class="btn btn-primary">Login</button></td>
            </tr>

           <!--  <tr>
              <td><s:url var="twitter" action="GoTwitterAction" /> <s:a
                href="%{twitter}">
                <img src="img/SNS/twitter.jpg" style="width: 200px">
               </s:a></td>
             </tr>

          <tr>
            <td><s:url var="facebook" action="GoFacebookAction" /> <s:a
                href="%{facebook}">
                <img src="img/SNS/facebook.jpg" style="width: 200px">
              </s:a></td>
          </tr>-->

          </table>
        </div>
      </s:form>
      </div>
</div>
</div>
</body>
<footer>
	<s:include value="footerLoad.jsp" />
</footer>
</html>