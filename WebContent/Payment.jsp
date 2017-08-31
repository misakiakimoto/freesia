<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!--国際化ここから-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<fmt:setLocale value="${pageContext.request.locale.language}" />
<fmt:setBundle basename="com.internousdev.freesia.property.payment" var="lang" />
<!-- ここまで -->

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title><s:text name="lang.payment.paymentScreen" /></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


    <!-- Bootstrap -->
    <link rel="stylesheet" type="text/css"  href="css/bootstrap.css">


    <!-- Stylesheet
    ================================================== -->
    <link rel="stylesheet" type="text/css"  href="css/style.css">
    <link rel="stylesheet" href="css/slick.css">
    <link rel="stylesheet" href="css/slick-theme.css">
    <link rel="stylesheet" href="css/payment.css">
    <link rel="stylesheet" href="css/validationEngine.jquery.css">


    <!-- Javascripts
    ================================================== -->
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/jquery.slick.min.js"></script>
    <!-- ↓クレジットカードの期限を自動算出するプログラム↓ -->
    <script src="js/creditDate.js"></script>
    <!-- ↓セキュリティコードの説明がスライドされるプログラム↓ -->
    <script src="js/slide.js"></script>
    <script src="js/creditDateCheck.js"></script>
    <!-- ↓入力フォームをチェックするプログラム↓ -->
    <script src="js/jquery.validationEngine.js"></script>
    <script src="js/jquery.validationEngine-ja.js"></script>
    <script>
      $(function(){
        //チェックプログラムを適用するidを選択
        jQuery("#creditPay").validationEngine('attach', {
            promptPosition:"centerRight"
        });
      });
    </script>

  </head>

  <body>
    <s:include value="header.jsp" />
      <div class="container">
       <h2><s:text name="lang.payment.payment" /></h2>
           <div class="formarea">
           <h3><s:text name="lang.payment.fillin" /></h3>
           <s:form action="CheckCreditInfomationAction" id="creditPay">

            <table class="payment">
              <tr>
                <td><s:text name="lang.payment.cardType" /></td>
                <td><input type="radio" name="creditBrand" value="1" checked>Visa
                    <input type="radio" name="creditBrand" value="2">Master
                    <input type="radio" name="creditBrand" value="3">AmericanExpress
                </td>
              </tr>
              <tr>
                <td><s:text name="lang.payment.cardNumber" /><br><s:text name="lang.payment.cardHankaku" /></td>
                <td><input type="text" name="creditNumber" class="validate[required,minSize[15],maxSize[16],custom[onlyNumberSp]] text-input" id="creditNumber"><br>
                   <div class="example">
                   <s:text name="lang.payment.anExample" />1111222233334444
                   </div></td>
              </tr>
               <tr>
                <td><s:text name="lang.payment.cardHolder" /><br><s:text name="lang.payment.romanLetter" />
                    </td>
                    <td><input type="text" name="nameE" size="20" class="validate[required,custom[onlyLetterSp]] text-input" id="nameE"><br>
                      <div class="example"><s:text name="lang.payment.anExample" />JIRO UEDA</div>
                    </td>
                  </tr>
                  <tr>
                    <td><s:text name="lang.payment.cardDeadline" /></td>
                    <td><select id="year" name="expirationYear"></select><s:text name="lang.payment.year" />
                        <select id="month" name="expirationMonth"></select><s:text name="lang.payment.month" /><br>
                  <div id="dateError"></div>
                   </td>
                 </tr>
                 <tr>
                   <td><s:text name="lang.payment.securityCode" /><br><s:text name="lang.payment.securityHankaku" /></td>
                   <td><input type="text" name="securityCode" size="6" class="validate[required,minSize[3],maxSize[4],custom[onlyNumberSp]]" id="securityCode"><br>
                    <div class="example">><s:text name="lang.payment.anExample" />123</div></td>
                </tr>
             </table>
              <div class="security"><s:text name="lang.payment.whatIsSecurityCode" /></div>

              <!-- クリックするとスライド -->
                <div id="securityBox">
                  <s:text name="lang.payment.descriptionOfSecurityCode" /><br>
                    <img src="img/security_code.gif" class="security">
                    <br><br>
                    <div class="security"><s:text name="lang.payment.closeThisExplanation" /></div>
                </div>
              <!-- ここまで -->
              <br>
              <br>
              <button type="submit" class="btn btn-default"><s:text name="lang.payment.toTheOrderConfirmationScreen" /></button>

             </s:form>
           </div>
         </div>


  </body>
  <footer style="text-align:center">
  <s:include value="footerLoad.jsp"/>
  </footer>

</html>


