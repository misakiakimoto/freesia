<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- と宣言することで、JSPファイルとして機能させることが出来る -->
<!-- (<%%>を使うとJSPファイルの中でJava言語を使ってプログラムを書くことが出来る) -->

<!-- 国際化 -->
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 国際化 ※ここでは国を判別しています。
言語コード( ja,en など)を示すロケールID を取得します。-->
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.sundia.property.cart"
	var="lang" />


<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title><s:text name="lang.cart.title" /></title>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Font awesome CSS -->
<link href="path/to/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">

<!-- Bootstrap cdn -->
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

<!-- Custom CSS -->
<link href="css/Wallpaper.css" rel="stylesheet">

<!-- cart.css -->
<link rel="stylesheet" href="css/cart1.css">

<!-- header -->

<!-------------------------------------------- ↑↑↑↑↑header↑↑↑↑↑ -------------------------------------------->
<body>
	<div class="titlespace">
		<div class="title">
			<header>
				<s:include value="header.jsp" />
			</header>
		</div>
	</div>
	<div class="container">
		<div class="errorMessage"><s:property value="message"/></div>
		<table class="table table-bordered">
			<tbody>
				<s:iterator value="cartList">
					<tr>
						<td><br> <br>
							<h4>
								<s:property value="itemName" />
							</h4>
							<h4>
								<fmt:formatNumber value="${price}" pattern="###,###,###" />
								<s:text name="lang.cart.taxin" />
							</h4>
							<s:if test="stocks>10">
							<h6>
									<s:text name="lang.cart.avairable" />
								</h6>
							</s:if> <s:elseif test="stocks<10">
								<s:property value="stocks" />
								<div class=tdstyle><s:property value="quantities" /></div>
							</s:elseif>
							<td><img src="./<s:property value="imagePath"/>" height="100"
									width="100"></td>


						<td><div class="update">

									<s:form action="CartUpdateAction" id="form01">
									<s:hidden name="cartId" value="%{cartId}" />
									<s:hidden name="itemId" value="%{itemId}" />
									<s:hidden name="prevQuantities" value="%{quantities}" />
									<div class="row" style="width: 150px;">
										<div class="col-xs-4" style="padding: -5px;"></div>
										<div class="col-xs-4" style="padding: 0px 0px 0px 3px;">
											<div class="form-group">
												<input type="text"  style="width:70px"  class="form-control"  id="${cartId}"
													name="quantities" value="${quantities}" maxlength="2"
													<s:if test="stocks+quantities>=50"> pattern="([1-9])|([0-4][1-9])|(50)" placeholder="1-50"</s:if>
													<s:else>pattern="[1-<s:property value="quantities+stocks"/>]*" placeholder="1-<s:property value="quantities+stocks"/>"</s:else>
													/>

											</div>
										</div>
										<div class="col-xs-4" style="padding: 0px 5px;"></div>
									</div>
									<div class="col-xs-5" style="padding: 0px;">
										<button type="submit" style="" id="form01"
											class="btn btn-primary center-block">
											<s:text name="lang.cart.upload" />
										</button>
									</div>
								</s:form>
								</div>
							</td>


						<td><br> <br> <s:form action="CartDeleteAction">
								<s:hidden name="userId" value="%{userId}" />
								<s:hidden name="cartId" value="%{cartId}" />
								<button type="submit" class="btn btn-default">
									<s:text name="lang.cart.delete" />
								</button>
							</s:form></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<br> <br>
		<hr style="border: 2px solid grey;width100%;">
		<h2 class="text-danger text-right">
			<s:text name="lang.cart.bill" />
			<fmt:formatNumber value="${amountAll}" pattern="###,###,###" />
			<s:text name="lang.cart.taxin" />
		</h2>
		<br> <br>


		<s:form action="MainTopAction" style="height:50px">
			<!-- 買い物を続ける -->
			<button type="submit" class="btn btn-warning center-block">
				<s:text name="lang.cart.goshopping" />
			</button>
		</s:form>

		<s:form action="GoSettlementAction" style="height:50px">
			<!-- 購入ボタンフォーム -->
			<button type="submit" class="btn btn-danger center-block">
				<s:text name="lang.cart.payment" />
			</button>
		</s:form>

	</div>




	<script>
		if (window.history && window.history.pushState) {

			history.pushState("nohb", null, "");
			$(window).on("popstate", function(event) {

				if (!event.originalEvent.state) {

					history.pushState("nohb", null, "")
					alert("画面最上部のヘッター又は画面中央部ボタンからお戻り下さい。");

					return;
				}
			});
		}
	</script>

</body>

<!-------------------------------------------- ↓↓↓↓↓footer↓↓↓↓↓ -------------------------------------------->
<footer>
	<s:include value="footerLoad.jsp" />
</footer>
</html>
