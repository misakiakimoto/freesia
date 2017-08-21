package com.internousdev.freesia.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.ConInquiryDAO;
import com.internousdev.freesia.dto.ConInquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 *管理画面でお問い合わせを検索、表示するアクションクラス
 * @author  MIKIO KAN
 * @since 2017/07/18
 * @version 1.0
 */

public class ConInquiryAction extends ActionSupport implements SessionAware {

    /**
     *シリアルID
     */
    private static final long serialVersionUID = 1524555947613444860L;

    /**
     *ユーザー名
     */
    private String userName;

    /**
     *メールアドレス
     */
    private String email;

    /**
     *電話番号
     */
    private String userTellNumber;

    /**
     *件名
     */
    private String title;

    /**
     *問い合わせ内容
     */
    private String comment;

    /**
     *セッション情報
     */
    private Map<String, Object> session;

    /**
     * 実行メソッド
     * 処理内容と順番
     * 1：リスト化
     * 2：session確認
     * 3：サクセスで値を返す
     */
    public String execute() {
        String result = ERROR;

        ArrayList<ConInquiryDTO> allList = new ArrayList<ConInquiryDTO>();
        ConInquiryDAO dao = new ConInquiryDAO();

        String searchName;
        if(userName!=null){
            searchName = userName;
        }else {
            searchName = "";
        }

        allList = dao.display(searchName);

        session.put("userList", allList);
        result = SUCCESS;
        return result;

    }

    /**
     * 名前を取得するメソッド
     * @return userName ユーザー名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 名前を格納するメソッド
     * @param userName ユーザー名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * emailを取得するメソッド
     * @return email メールアドレス
     */
    public String getEmail() {
        return email;
    }

    /**
     * emailを格納するメソッド
     * @param email メールアドレス
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 電話番号を取得するメソッド
     * @return userTellNumber 電話番号
     */
    public String getUserTellNumber() {
        return userTellNumber;
    }

    /**
     * 電話番号を格納するメソッド
     * @param userTellNumber 電話番号
     */
    public void setPhone_number(String userTellNumber) {
        this.userTellNumber = userTellNumber;
    }

    /**
     * 件名を取得するメソッド
     * @return title 件名
     */
    public String setTitle() {
        return title;
    }

    /**
    * 件名を格納するメソッド
    * @param title 件名
    */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
    *お問い合わせを取得すメソッド
    *@return comment お問い合わせ
    */
    public String getComment() {
        return comment;
    }

    /**
    * お問い合わせを格納するメソッド
    * @param comment お問い合わせ
    */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
    * sessionを格納するメソッド
    * @return session セッション
    */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
    *  sessionを格納するメソッド
    * @param session セッショ
    */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}