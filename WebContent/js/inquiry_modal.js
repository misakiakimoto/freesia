/*******************************************************************************
 *
 * SYNCER 〜 知識、感動をみんなと同期(Sync)するブログ
 *
 * 配布場所 https://syncer.jp/jquery-modal-window
 *
 * 最終更新日時 2015/08/17 15:55
 *
 * 作者 あらゆ
 *  * 連絡先 Twitter: https://twitter.com/arayutw Facebook:
 * https://www.facebook.com/arayutw Google+:
 * https://plus.google.com/114918692417332410369/ E-mail: info@syncer.jp
 *  ※ バグ、不具合の報告、提案、ご要望など、お待ちしております。 ※ 申し訳ありませんが、ご利用者様、個々の環境における問題はサポートしていません。
 *
 ******************************************************************************/

$(function() {

  // モーダルウィンドウを出現させるクリックイベント
  $("#modal-open").click(
      function() {

        // オーバーレイを構築させる
        $("#modal-overlay").fadeIn("slow");

        // コンテンツをフェードインする

        $("#modal-content").fadeIn("slow");

        /*
        * フォームに入力された値をモーダルウィンドウに表示するイベント郡 参照元
        * http://phiary.me/js-form-value-accessor/
        */

        var result = "success";

        var error_text = "Warning!";
        var flg = $('#flg').val();

        $('#modal_name').html($('#name').val());

        var $email = $('#email').val();

        if($email.match("@") ==null){
          $('#modal_email').html(error_text).css('color', 'red');
            result = "error";
        }else
            if(flg =="false" &&$email==''){
          $('#modal_email').html(error_text).css('color', 'red');
            result = "error";
        }else {
          $('#modal_email').html($email).css('color', 'black');
        }

        $('#modal_tell').html($('#tell').val());

        var $blank = $('#text').val();
        if ($blank == '') {
          $('#modal_text').html(error_text).css('color', 'red');
          result = "error";

        } else {
          $('#modal_text').html($blank).css('color', 'black');
        }

        var $str = $('#contact').val();
        if ($str == '') {
          $('#modal_comment').html(error_text).css('color', 'red');
          result = "error";

        } else {
          $('#modal_comment').html($str.replace(/\r?\n/g, '<br>'))
              .css('color', 'black');
        }

        if (result == "error") {
          $('#inquiry_ok').css('display', 'none');
        } else if(result=="success"){
          $('#inquiry_ok').css('display', 'block');
        }

      });

  // [#modal-overlay]、または[#modal-close]をクリックしたら…
  $("#modal-overlay,#modal-close").unbind().click(function() {

    // [#modal-content]と[#modal-overlay]をフェードアウトした後に…
    $("#modal-content,#modal-overlay").fadeOut("slow")

  });

  // リサイズされたら、センタリングをする関数[centeringModalSyncer()]を実行する
  $(window).resize(centeringModalSyncer);

  // センタリングを実行する関数
  function centeringModalSyncer() {

    // 画面(ウィンドウ)の幅、高さを取得
    var w = $(window).width();
    var h = $(window).height();

    // コンテンツ(#modal-content)の幅、高さを取得
    // jQueryのバージョンによっては、引数[{margin:true}]を指定した時、不具合を起こします。
    // var cw = $( "#modal-content" ).outerWidth( {margin:true} );
    // var ch = $( "#modal-content" ).outerHeight( {margin:true} );
    var cw = $("#modal-content").outerWidth();
    var ch = $("#modal-content").outerHeight();

  }

});
