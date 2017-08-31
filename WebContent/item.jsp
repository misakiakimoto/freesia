<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/item.css" rel="stylesheet">

    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>items</h3>
<div class="container">
            <div class="col-lg-0">
            <div class="row">
            <s:include value="header.jsp" />
            </div>
            </div>

        <div class="col-lg-12">
                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
                <s:iterator value="itemList">
				<div class="template">
					<div class="item_img">
						<a
							href="<s:url action="GoItemDetailAction"><s:param name="itemId" value="%{itemId}"/></s:url>"><img
							class="item_img" src="<s:property value="imagepath"/>"
							height="250px"> <s:hidden value="itemId" /> </a>
					</div>
					<div class="item_name">
						<s:property value="itemName" />
					</div>
					<div class="item_price">
						￥
						<fmt:formatNumber value="${price}" pattern="###,###,###" />
					</div>
				</div>
			</s:iterator>

                </div>

            </div>
        </div>
</div>
</body>
</html>