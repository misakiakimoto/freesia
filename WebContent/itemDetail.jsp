<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="">
<!-- StyleSheet
       ================================================== -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<link href="css/items.css" rel="stylesheet">
<link href="css/footer.css" rel="stylesheet">
<link href="css/Wallpaper.css" rel="stylesheet">

<!-- 国際化 ※ここでは国を判別しています。
       言語コード( ja,en など)を示すロケールID を取得します。-->
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.sundia.property.itemdetail"
	var="lang" />

<!-- Javascripts
     ================================================== -->
<script src="js/jquery-3.2.1.min.js"></script>


<title><s:text name="lang.itemdetail.gocart" /></title>
</head>

<body>
	<header>
		<s:include value="header.jsp" />
	</header>

	<div class="container">
		<div class="row">
			<s:iterator value="displayList">


				<div class="col-xs-12 col-sm-12 col-md-5 col-lg-6">
					<div id="sampleCarousel" class="carousel slide"
						data-ride="carousel" data-interval="6000">
						<ol class="carousel-indicators"></ol>
						<div class="carousel-inner" role="listbox">
							<div class="itemactive">
								<img src="./<s:property value="imagepath"/>" height="400"
									width="500" />
							</div>
						</div>
					</div>
				</div>

				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					<h2>
						<s:property value="itemName" />
					</h2>
					<h3>
						<fmt:formatNumber value="${price}" pattern="###,###,###" />
						<s:text name="lang.itemdetail.en" />
					</h3>
				</div>

				<div>
					<!--カートに入れる-->
					<s:if test="stocks ==0">
                    <h5><s:text name="lang.itemdetail.notavairable" /></h5>

       </s:if>
				</div>


				<s:elseif test="stocks>=10">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />
個数選択：
							<select name="quantities">
								<option>1</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
								<option>6</option>
								<option>7</option>
								<option>8</option>
								<option>9</option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
						<span style="color:red;"><s:text name="lang.itemdetail.attentionLimit" /></span>
					</div>
				</s:elseif>

				<s:elseif test="stocks==9">
					<!--カートに入れる-->
<br>
					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />
<br>
							<select name="quantities">
								<option><s:property value="stocks-8" /></option>
								<option><s:property value="stocks-7" /></option>
								<option><s:property value="stocks-6" /></option>
								<option><s:property value="stocks-5" /></option>
								<option><s:property value="stocks-4" /></option>
								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>



				<s:elseif test="stocks==8">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />
<br>
							<select name="quantities">

								<option><s:property value="stocks-7" /></option>
								<option><s:property value="stocks-6" /></option>
								<option><s:property value="stocks-5" /></option>
								<option><s:property value="stocks-4" /></option>
								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>


				<s:elseif test="stocks==7">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-6" /></option>
								<option><s:property value="stocks-5" /></option>
								<option><s:property value="stocks-4" /></option>
								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>


				<s:elseif test="stocks==6">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-6" /></option>
								<option><s:property value="stocks-5" /></option>
								<option><s:property value="stocks-4" /></option>
								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>



				<s:elseif test="stocks==5">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-4" /></option>
								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>


				<s:elseif test="stocks==4">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-3" /></option>
								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>

				<s:elseif test="stocks==3">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-2" /></option>
								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>

				<s:elseif test="stocks==2">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks-1" /></option>
								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">
						<!--   <p id="a"><s:text name="lang.itemdetail.attention" /><p>-->
					</div>
				</s:elseif>

				<s:elseif test="stocks==1">
					<!--カートに入れる-->

					<div class="bottun">
						<s:form action="AddToCartAction">
							<s:hidden theme="simple" name="itemId" value="%{itemId}"></s:hidden>
							<s:hidden name="price" value="%{price}"></s:hidden>
							<s:hidden name="stocks" value="%{stocks}"></s:hidden>
							<s:token />

							<select name="quantities">

								<option><s:property value="stocks" /></option>
							</select><br><br>
							<input type="submit" class="btn btn-warning"
								value="<s:text name = "lang.itemdetail.gocart" />">
						</s:form>
					</div>
					<div class="attention">

					</div>
				</s:elseif>



				<div class="text">
					<h4>
						<s:text name="lang.itemdetail.itemdetail" />
						：
					</h4>
					<p>
						<s:property escape="false" value="itemDetail" />
					</p>
				</div>

			</s:iterator>

		</div>
	</div>



	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

	<div class="footer" align="center">
		<s:include value="footerLoad.jsp" />
	</div>

</body>

</html>