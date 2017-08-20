<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="java.util.Optional" %>
<%
 Optional<String> url = Optional.ofNullable(request.getParameter("url"));
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

 <script type="text/javascript">
  var url='<%=url.orElse("")%>';
  if(!url.length>0){
    url = '<s:url value="toppage.jsp"/>';
  }
  window.location.href = url;
 </script>


このページで止まった場合、以下のボタンからトップページにお戻りください
<form>
 <input type="button" value="TOP" onclick='window.location.href="<s:url value="toppage.jsp"/>";'>
</form>

</body>
</html>