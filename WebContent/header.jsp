<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel='stylesheet'
	href='http://fonts.googleapis.com/css?family=PT+Sans'>
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Droid+Serif:regular,bold" />
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Alegreya+Sans:regular,italic,bold,bolditalic" />
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Nixie+One:regular,italic,bold,bolditalic" />
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Alegreya+SC:regular,italic,bold,bolditalic" />

<link rel="stylesheet" type="text/css" href="css/menu.css">
</head>
<body>


	<!----------------------- ログイン時 ----------------------->
	<s:if test="#session.userId != null && #session.loginFlg != 0">

			<div class="container1">
				<div class="area"></div>
				<div class="clear"></div>
				<nav class="main-menu">
					<div class="menu_logo">menu</div>
					<ul>

						<li><a href="toppage.jsp"> <i class="fa fa-home fa-2x"></i>
								<span class="nav-text"> Home </span>
						</a></li>

						<li><a href="<s:url action="ItemViewAction"/>"> <i class="fa fa-female fa-2x"></i> <span
								class="nav-text"> Items </span>
						</a></li>

						<li class="#cinte"><a href="itemUpload.jsp"> <i
								class="fa fa-upload fa-2x"></i> <span class="nav-text">
									Post </span>
						</a></li>
						<li class="has-subnav"><a href="<s:url action="GoCartAction"/>"> <i
								class="fa fa-shopping-cart fa-2x"></i> <span class="nav-text">
									Cart </span>
						</a></li>
						<li class="has-subnav"><a href="<s:url action="GoCollectionsAction"/>"> <i
								class="fa fa-book fa-2x"></i> <span class="nav-text">Gallary
							</span>
						</a></li>

						<!--
			<li><a href="#"> <i class="fa fa-bar-chart-o fa-2x"></i> <span
					class="nav-text"> Graphs and Statistics </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-font fa-2x"></i> <span
					class="nav-text"> Typography and Icons </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-table fa-2x"></i> <span
					class="nav-text"> Tables </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-map-marker fa-2x"></i> <span
					class="nav-text"> Maps </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-info fa-2x"></i> <span
					class="nav-text"> Documentation </span>
			</a></li>-->
					</ul>

					<ul class="logout">
						<li><a href="<s:url action="logoutAction"/>"> <i
								class="fa fa-power-off fa-2x"></i> <span class="nav-text">
									Logout </span>
						</a></li>
					</ul>
				</nav>
			</div>

	</s:if>


	<s:else>


			<div class="container1">

				<div class="area"></div>
				<div class="clear"></div>
				<nav class="main-menu">
					<div class="menu_logo">menu</div>
					<ul>

						<li><a href="toppage.jsp"> <i class="fa fa-home fa-2x"></i>
								<span class="nav-text"> Home </span>
						</a></li>

						<li><a href="login.jsp"> <i class="fa  fa-sign-in fa-2x"></i> <span
								class="nav-text"> login </span>
						</a></li>

						<li class="has-subnav"><a href="#"> <i
								class="fa fa-book fa-2x"></i> <span class="nav-text">Gallary
							</span>
						</a></li>
					</ul>

				</nav>



			</div>
			<!-- /.container -->


		</div>


	</s:else>


</body>

</body>
</html>