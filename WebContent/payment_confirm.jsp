<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<!-- ここから国際化 -->
<fmt:setBundle
  basename="com.internousdev.freesia.property.payment_confirm" var="lang" />
<!-- ここまで国際化 -->

<title><s:text name="lang.payment_confirm.title" /></title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./css/bootstrap.min.css" rel="stylesheet">
<link href="./css/style.css" rel="stylesheet">
<link href="css/Wallpaper.css" rel="stylesheet">
<link href="css/footer.css" rel="stylesheet">
<link href="css/payment_confirm.css" rel="stylesheet">


<!-- jQuery読み込み -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- BootstrapのJS読み込み -->
<script src="./js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/jquery.pagination.js"></script>


<script>
  $(function($) {

    $('.list2').pagination({
      element : '.table tr td',
      prevText : '前',
      nextText : '後',
      firstText : '最初',
      lastText : '最後',
      ellipsisText : '・・・',
      viewNum : 24,
      pagerNum : 3,
      ellipsis : true,
      linkInvalid : true,
      goTop : true,
      firstLastNav : true,
      prevNextNav : true
    });
  });
</script>




<!-- スマートフォン対応 -->
<meta name="viewport"
  content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
</head>

<body>
  <!-- ヘッダーここから -->
  <s:include value="Header.jsp" />
  <!-- ここまで -->

  <div class="container">
    <!-- ログイン時 -->
    <s:if test="%{#session.userId != null}">
      <!-- ここまで -->
      <br>

      <div class="col-sm-12 centered">
        <s:text name="lang.payment_confirm.subtitle" />
        <br>
        <s:text name="lang.payment_confirm.confirm" />
        <br>
        <h1>
          <s:text name="lang.payment_confirm.order" />
        </h1>
      </div>
      <br>
      <br>


      <div class="col-sm-10 col-sm-offset-1 scrollbar">
        <div class="list2">
          <table class="table table-scroll table-bordered">

            <tr>

              <th><s:text name="lang.payment_confirm.itemname" /></th>
              <th><s:text name="lang.payment_confirm.itemprice" /></th>
              <th><s:text name="lang.payment_confirm.numberitems" /></th>
            </tr>
            <s:iterator value="cartList">
              <tr>

                <td><s:property value="itemName" /></td>
                <td><fmt:formatNumber value="${price}"
                    pattern="###,###,###" /> <s:text
                    name="lang.payment_confirm.en" /></td>
                <td><s:property value="quantities" /></td>

              </tr>


            </s:iterator>
          </table>


          <div class="pager"></div>
          <div class="pageNum">
            <span class="nownum"></span><span class="totalnum"></span>
          </div>
        </div>

        <br>
      </div>

      <table class="col-sm-12 centered">
        <tr>
          <!-- 商品の数の合計
          <td colspan="2">
            <!--品物数-<s:text name="lang.payment_confirm.numberOfItems" />：<s:property
              value="amountAll" />
            <s:text name="lang.payment_confirm.itemnumber" />
          </td>-->
        </tr>

        <tr>
          <!-- すべての商品の単価の合計を表示 -->
          <td colspan="2">
            <!--商品計--> <s:text name="lang.payment_confirm.totalAmount" />：<s:property
              value="amountAll" /> <s:text name="lang.payment_confirm.yen" />
          </td>
        </tr>


        <tr>

          <!-- 小計＋送料＋消費税 -->
          <td colspan="2">
            <!--合計-->
            <h1 style="margin-bottom: 60px">
              <s:text name="lang.payment_confirm.totalPrice" />
              ：
              <s:property value="amountAll" />
              <s:text name="lang.payment_confirm.yen" />
            </h1>
          </td>
        </tr>

      </table>
      <br>
      <br>
      <br>
      <div class="col-sm-12">
        <hr style="border: 1px solid grey;width100%;" />
        <br> <br> <br>
        <h1>
          <s:text name="lang.payment_confirm.settlementinfo" />
        </h1>
      </div>


      <div class="col-sm-12 grey-background">

        <div
          class="col-sm-10 col-sm-offset-1 height-adjust white-background">

          <div class="col-sm-4 col-sm-offset-4">

            <!--          カードの種類 -->
            <s:text name="lang.payment_confirm.cardtype" />
            ：
            <s:property value="creditBrand" />
            <br>
            <!--          名義人 -->
            <s:text name="lang.payment_confirm.cardname" />
            ：
            <s:property value="nameE" />
            <br>
            <!--          カードナンバー -->
            <s:text name="lang.payment_confirm.cardnumber" />
            ：
            <s:set var="number">
              <s:property value="creditNumber" />
            </s:set>
            **** **** ****
            ${number.length()==16?number.substring(12,16):number.substring(11,15)}
            <br>
            <!--          期限　年 -->
            <s:text name="lang.payment_confirm.limit" />
            ：
            <s:property value="expirationYear" />
            <br>
            <!--          期限　月 -->
            <s:text name="lang.payment_confirm.limit" />
            ：
            <s:property value="expirationMonth" />
            <br>
            <!--          セキュリティコード -->
            <s:text name="lang.payment_confirm.securitycode" />
            ：
            <s:set var="code">
              <s:property value="securityCode" />
            </s:set>
            <s:set var="three">***</s:set>
            <s:set var="four">****</s:set>
            ${code.length()==3?three:four} <br>

          </div>
        </div>
      </div>

      <div class="col-sm-12">
        <br> <br> <br> <br>
      </div>

      <div class="col-sm-6 col-sm-offset-3 button">
        <br> <br>

        <div class="col-sm-4">
          <s:submit class=" btn btn-default" type="button">
            <a href="Payment.jsp"><s:text
                name="lang.payment_confirm.BackToInput" /></a>
          </s:submit>
        </div>

        <div class="col-sm-4 col-sm-offset-4"></div>
        <s:form action="PurchaseCompleteAction">


          <input type="hidden" name="creditNumber"
            value="<s:property value="creditNumber"/>">
          <input type="hidden" name="creditId"
            value="<s:property value="creditId"/>">
          <input type="hidden" name="totalPrice"
            value="<s:property value="totalPrice" />">


          <input type="submit"
            value="<s:text name="%{getText('lang.payment_confirm.CheckOut')}"/>"
            class="btn btn-warning" />
        </s:form>


      </div>

      <div class="col-sm-12">
        <br> <br> <br> <br>
      </div>



    </s:if>
    <!-- 未ログイン時 -->
    <s:else>
      <s:text name="lang.payment_confirm.afterlogin" />
    </s:else>
    <!-- ここまで -->

  </div>

  <!-- フッター -->

  <!-- ここまで -->

</body>

<footer style="text-align: center">
  <s:include value="footerLoad.jsp" />
</footer>

</html>