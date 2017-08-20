<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!-- ここから国際化 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- ここまで国際化 -->

<!DOCTYPE html>
<html>
  <head>
  <!-- ここから国際化 -->
  <fmt:setLocale value="${pageContext.request.locale.language}" />
  <fmt:setBundle basename="com.internousdev.sundia.property.ConInquiry" var="lang" />
  <!-- ここまで国際化 -->

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title><s:text name="lang.admin_item.title"/></title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <title>Sundia - 問い合わせフォーム</title>
  <link href="css/Contop-gamen.style.css" rel="stylesheet" type="text/css" >
  <link href="css/Coninquiry.css" rel="stylesheet" type="text/css" >

 <!-- BootstrapのCSS読み込み -->
 <link rel="stylesheet" href="css/bootstrap.min.css">

 <!-- BootstrapのjQuery読み込み -->
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>

 <!-- Bootstrapのjsの読み込み -->
  <script src='js/bootstrap.js'></script>
  <script src="js/bootstrap.min.js"></script>

  </head>
  <body>
  <header><s:include value="Admin_Header.jsp" /></header>
  <div class="container">
    <div class="row">
      <h1 class="col-md-4 col-md-offset-4 text-center">管理者・問い合わせ</h1>
      <div class="kennsaku">
        <s:form action="ConInquiryAction">
          <s:text name="lang.ConInquiry.inputname" />
          <input type="text" name="userName" id="SearchAction_user_name" style="margin: 20px; width: 300px;">
          <input type="submit" class="btn btn-primary pull-right" value="<s:text name="lang.ConInquiry.search"/>" style="margin-top:15px">
        </s:form>
      </div>
    </div>

    <div class="row">
      <div class="kakka">
        <div class="outline col-md-12">
          <table id="table">
            <tr class="tr2">
              <th class="th1"><s:text name = "コードネーム"/></th>
              <th class="th2"><s:text name = "メールアドレス"/></th>
              <th class="th3"><s:text name = "電話番号"/></th>
              <th class="th4"><s:text name = "件名"/></th>
              <th class="the"><s:text name = "お問い合わせ"/></th>
            </tr>

            <s:iterator value="#session.userList">
            <s:hidden value="users"/>
              <tr class="tr2">
                <td  class="td1"><s:property value="userName"/></td>
                <td class="td2" ><s:property value="email"/></td>
                <td class="td3"><s:property value="userTellNumber"/></td>
                <td class="td4"><s:property value="title"/></td>
                <td class="td5"><s:property value="comment"/></td>
              </tr>
            </s:iterator>
          </table>
        </div>
      </div>
    </div>
  </div>
  </body>
</html>