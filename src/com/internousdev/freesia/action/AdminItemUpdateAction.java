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
     * リザルト
     */
    private String result;

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * カテゴリーID
     */
    private int categoryId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * 単価
     */
    private float price;

    /**
     * 在庫数
     */
    private int stocks;

    /**
     * 商品詳細
     */
    private String itemDetail;

    /**
     * イメージパス
     */
    private String[] imagePath={"","","","",""};

    /**
     * プレビューパス
     */
    private String[] prevPath;

    /**
     * 画像削除情報
     */
    private int[] imageDelete={-50};

    /**
     * アップロード情報
     */
    private boolean[] uploaded;

    /**
     * 画像配列
     */
    private File[] image={new File("nullfile")};

    /**
     * 表示画像
     */
    private BufferedImage imageData;

    /**
     * 画像ファイル
     */
    private File tmpfile;


    /**
    * 商品情報を編集する実行メソッド
    * @author JUNNYA TAKENO
    * @since 2017/07/16
    * @return 成功ならSUCCESS それ以外はERROR
    */
    public String execute() throws Exception{
        result = ERROR;
        AdminItemUpdateDAO dao= new AdminItemUpdateDAO();

        int i=0;
        int imagesetcount=0;
        int uploadcount=0;
        int deletecount=0;

        String basePath=request.getServletContext().getRealPath("/");

        for(i=0;i<imagePath.length;i++){


            if(imageDelete[0]>=0&&deletecount<imageDelete.length&&i==imageDelete[deletecount]){
                if(uploaded[i]){
                    uploadcount++;
                }
                deletecount++;
                continue;
            }else if(uploaded[i]){
                imagePath[imagesetcount]=uploadFile(imagesetcount,uploadcount,basePath);
                uploadcount++;
                if(imagePath[imagesetcount]=="failed"){
                    imagePath[imagesetcount]="";
                    continue;
                }else{
                    imagesetcount++;
                }
            }else if(prevPath[i].length()>0){
                imagePath[imagesetcount]=renameFile(imagesetcount,i,prevPath[i],basePath);
                if(imagePath[imagesetcount]=="failed"){
                    imagePath[imagesetcount]="";
                    continue;
                }else{
                    imagesetcount++;
                }
            }
        }

        result = dao.update(itemId,categoryId,itemName,price,stocks,itemDetail,imagePath);
        session.put("adminEditItemId", 0);
        session.remove("adminEditItemData");
        session.put("adminItemLoad", false);

        result = SUCCESS;

        return result;
    }//execute
    //class


    /**
    * 商品画像を追加する実行メソッド
    * @param picno 商品画像番号
    * @param num 送信画像番号
    * @param basePath 送信元画像パス
    * @return 成功なら画像パス それ以外はERROR
    * @throws Exception 例外
    */
    public String uploadFile(int picno,int num,String basePath) throws Exception{
        String lastPath="img/items/ItemImage_"+itemId+"_"+(picno+1)+".png";
        String fileName=basePath+lastPath;

        tmpfile=new File(fileName);
        tmpfile.delete();
        tmpfile.createNewFile();

        imageData=ImageIO.read(image[num]);

        if(ImageIO.write(imageData, "png", tmpfile)){
            return lastPath;
        }else{
            return "failed";
        }
    }


    /**
    * する実行メソッド
    * @param picno 商品画像番号
    * @param num 送信画像番号
    * @param prevPath プレビューパス
    * @param basePath 送信元画像パス
    * @return 成功なら画像パス それ以外はfailed
    */
    public String renameFile(int picno,int num,String prevPath,String basePath){
        String lastPath="img/items/ItemImage_"+itemId+"_"+(picno+1)+".png";
        String fileName_new=basePath+lastPath;
        String fileName_old=basePath+prevPath;
        String fileName_copy=fileName_old+"_copy.png";

        File tmpfile_old=new File(fileName_old);
        File tmpfile_new=new File(fileName_new);
        File tmpfile_copy=new File(fileName_copy);
        tmpfile_copy.delete();

        tmpfile_old.renameTo(tmpfile_copy);
        tmpfile_new.delete();
        tmpfile_old.delete();

        if(tmpfile_copy.renameTo(tmpfile_new)){
            tmpfile_copy.delete();
            return lastPath;
        }else{
            return "failed";
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
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを設定
     * @param itemId 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * カテゴリーIDを取得
     * @return categoryId カテゴリーID
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * カテゴリーIDを設定
     * @param categoryId カテゴリーID
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 商品名を取得
     * @return itemName 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を設定
     * @param itemName 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 単価を取得
     * @return price 単価
     */
    public float getPrice() {
        return price;
    }

    /**
     * 単価を設定
     * @param price 単価
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 在庫数を取得
     * @return stocks 在庫数
     */
    public int getStocks() {
        return stocks;
    }

    /**
     * 在庫数を設定
     * @param stocks 在庫数
     */
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    /**
     * 商品詳細を取得
     * @return itemDetail 商品詳細
     */
    public String getItemDetail() {
        return itemDetail;
    }

    /**
     * 商品詳細を設定
     * @param itemDetail 商品詳細
     */
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    /**
     * イメージパスを取得
     * @return imagePath イメージパス
     */
    public String[] getImagePath() {
        return imagePath;
    }

    /**
     * イメージパスを設定
     * @param imagePath イメージパス
     */
    public void setImagePath(String[] imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * プレビューパスを取得
     * @return prevPath プレビューパス
     */
    public String[] getPrevPath() {
        return prevPath;
    }

    /**
     * プレビューパスを設定
     * @param prevPath プレビューパス
     */
    public void setPrevPath(String[] prevPath) {
        this.prevPath = prevPath;
    }

    /**
     * 画像削除情報を取得
     * @return imageDelete 画像削除情報
     */
    public int[] getImageDelete() {
        return imageDelete;
    }

    /**
     * 画像削除情報を設定
     * @param imageDelete 画像削除情報
     */
    public void setImageDelete(int[] imageDelete) {
        this.imageDelete = imageDelete;
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
     * 画像配列を取得
     * @return image 画像配列
     */
    public File[] getImage() {
        return image;
    }

    /**
     * 画像配列を設定
     * @param image 画像配列
     */
    public void setImage(File[] image) {
        this.image = image;
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
}
