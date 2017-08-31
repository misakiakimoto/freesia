<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Optional"%>
<!-- 国際化 -->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle
  basename="com.internousdev.sundia.property.admin_itemedit" var="lang" />
<%
Optional<String> editid = Optional.ofNullable(request.getParameter("id"));
%>

<!DOCTYPE html>
 <html>
   <head>
     <meta http-equiv="Pragma" content="no-cache">
     <meta http-equiv="Cache-Control" content="no-cache">
     <meta http-equiv="Expires" content="0">
     <meta name="viewport" content="width=device-width,initial-scale=1.0" />
     <meta charset="UTF-8">
     <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
     <link rel="stylesheet" href="css/flexslider.css" type="text/css">
     <link href="css/Admin_itemEdit.css" rel="stylesheet">

<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Font awesome CSS -->
  <link href="path/to/font-awesome/css/font-awesome.min.css" rel="stylesheet">

<!-- Bootstrap cdn -->
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- Custom CSS -->
  <link href="css/itemUpload.css" rel="stylesheet">
     <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>


     <title><s:text name="lang.admin_itemedit.title"/></title>
   </head>

<body>

<header><s:include value="header.jsp" /></header>

<div class="container">
<h3 style="text-align:left">item upload</h3>
<h4>アップロードした写真はGarallyに投稿されます♪</h4>
<s:form action="AdminItemUpdateAction" enctype="multipart/form-data">

<input type="hidden" name="userId"/>
             <p> name</p>
             <input class="editbox editbox_long" type="text" name="herName"/><br><br>

             <p> title</p>
             <input class="editbox editbox_long" type="text" name="title"/><br><br>

             <p> description</p>
             <textarea class="editbox editbox_big" wrap="soft" name="comment"></textarea><br><br>
             <div class="center" style="text-align:center">
<input style="text-align:center" type="file" id="upfile" name="imagepath1"
                   accept="image/*"></div>


<table class="imagelist">
           <tr>
             <s:iterator value="#session.adminEditItemData.imagePath" var="path"
               status="imglist">
             <td><s:text name="lang.admin_itemedit.image" /> <s:property
                         value="#imglist.count" /></td>
             </s:iterator>

           </tr>
           </table>
<script>

          $('#upfile').change(function(){
              if (this.files.length > 0) {
                // 選択されたファイル情報を取得
                var file = this.files;
                // readerのresultプロパティに、データURLとしてエンコードされたファイルデータを格納
                var reader = new FileReader();
                reader.readAsDataURL(file);
                reader.onload = function() {
                  $('#thumbnail').attr('background', reader.result )
                }
              }
            });

        </script>


<br>
        <div class="btn_center">
        <input type="submit" class="editbtn" value='送信'/>
        </div>
</s:form>
</div>
</body>
</html>