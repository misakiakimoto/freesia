package com.internousdev.freesia.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.freesia.dao.AdminItemUpdateDAO;
import com.opensymphony.xwork2.ActionSupport;

@MultipartConfig(location="/tmp/")
@WebServlet("/src/com.internousdev.freesia.action/")

public class AdminItemUpdateAction extends ActionSupport


/**
 * 管理者が商品情報を編集するためのクラス
 * @author JUNNYA TAKENO
 * @since 2017/07/16
 * @version 1.0
 */
implements SessionAware,ServletRequestAware,ServletResponseAware {


    /**
     * セッション情報
     */
    private Map<String,Object> session;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * レスポンス
     */
    private HttpServletResponse response;

    /**
     * シリアルID
     */
    private static final long serialVersionUID = -2457344252220177410L;


    /**
     * 商品ID
     */
    private int userId;

    /**
     * 画像ファイル
     */
    private File tmpfile;

    /**
     * 商品名
     */
    private String herName;

    private String title;

    private String comment;

    /**
     * イメージパス
     */
    private String imagepath1;



    /**
     * アップロード情報
     */
    private boolean[] uploaded;

    /**
     * 表示画像
     */
    private BufferedImage imageData;



    /**
    * 商品情報を編集する実行メソッド
    * @author JUNNYA TAKENO
    * @since 2017/07/16
    * @return 成功ならSUCCESS それ以外はERROR

    */
    //public String execute() throws Exception{
        //result = ERROR;
        //AdminItemUpdateDAO dao= new AdminItemUpdateDAO();

      //  int i=0;
      //  int imagesetcount=0;
     //   int uploadcount=0;
     //   int deletecount=0;

     //   String basePath=request.getServletContext().getRealPath("/");


        //result = dao.insert(herId,herName,herDetail,imagepath1);
        //session.put("adminEditItemId", 0);
        //session.remove("adminEditItemData");
        //session.put("adminItemLoad", false);

       // result = SUCCESS;

     //   return result;
   // }//execute
    //class

    public String execute() throws Exception {

        String result = ERROR;
        AdminItemUpdateDAO dao = new AdminItemUpdateDAO();


        if (session.get("userId") != null) {
            userId = (int) session.get("userId");
            result= dao.insert(userId, herName, comment, title, imagepath1);
        }
        result = SUCCESS;


        return result;
    }


    public String uploadFile(int picno,int num,String basePath) throws Exception{
        String lastPath="img/collections"+(picno+1)+".png";
        String fileName=basePath+lastPath;

        tmpfile=new File(fileName);
        tmpfile.createNewFile();
        return lastPath;
    }

    public String renameFile(int picno,int num,String prevPath,String basePath) throws Exception{
        String lastPath="img/collections"+(picno+1)+".png";
        String fileName_new=basePath+lastPath;
        String fileName_old=basePath+prevPath;
        String fileName_copy=fileName_old+"_copy.png";

        File tmpfile_old=new File(fileName_old);
        File tmpfile_new=new File(fileName_new);
        File tmpfile_copy=new File(fileName_copy);
        tmpfile_copy.delete();

        if(fileName_old.indexOf("/ItemImage_")!=-1){
            tmpfile_old.renameTo(tmpfile_copy);
            tmpfile_new.delete();
            tmpfile_old.delete();
            if(tmpfile_copy.renameTo(tmpfile_new)){
                tmpfile_copy.delete();
                return lastPath;
            }else{
                return "failed";
            }
        }else{
            tmpfile_new.createNewFile();
            imageData=ImageIO.read(tmpfile_old);
            if(ImageIO.write(imageData, "png", tmpfile_new)){
                return lastPath;
            }else{
                return "failed";
            }
        }
    }
    /**
     * セッション情報を取得
     * @return session セッション情報
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * セッション情報を設定
     * @param session セッション情報
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * 商品IDを取得
     * @return itemId 商品ID
     */
    public int getUserId() {
        return userId;
    }

    /**
     * 商品IDを設定
     * @param itemId 商品ID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * 商品名を取得
     * @return itemName 商品名
     */
    public String getHerName() {
        return herName;
    }

    /**
     * 商品名を設定
     * @param itemName 商品名
     */
    public void setHerName(String herName) {
        this.herName = herName;
    }


    /**
     * 商品詳細を取得
     * @return itemDetail 商品詳細
     */
    public String getComment() {
        return comment;
    }

    /**
     * 商品詳細を設定
     * @param itemDetail 商品詳細
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * イメージパスを取得
     * @return imagePath イメージパス
     */
    public String getImagepath1() {
        return imagepath1;
    }

    /**
     * イメージパスを設定
     * @param imagePath イメージパス
     */
    public void setImagepath1(String imagepath1) {
        this.imagepath1 = imagepath1;
    }



    /**
     * アップロード情報を取得
     * @return uploaded アップロード情報
     */
    public boolean[] getUploaded() {
        return uploaded;
    }

    /**
     * アップロード情報を設定
     * @param uploaded アップロード情報
     */
    public void setUploaded(boolean[] uploaded) {
        this.uploaded = uploaded;
    }


    /**
     * リクエストを取得
     * @return request リクエスト
     */
    public HttpServletRequest getServletRequest() {
        return this.request;
    }

    /**
     * リクエストを設定
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request){
        this.request = request;
    }

    /**
     * レスポンスを取得
     * @return response レスポンス
     */
    public HttpServletResponse getServletResponse() {
        return this.response;
    }

    /**
     * レスポンスを設定
     * @param response レスポンス
     */
    public void setServletResponse(HttpServletResponse response){
        this.response = response;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
