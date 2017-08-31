package com.internousdev.freesia.dto;

/**
 * 商品情報を格納するためのDTOクラス
 * @author TAKUMI MISAWA
 * @since 2017/7/4
 * @version 1.1
 */

public class ItemDTO {

    /**
     * 商品ID
     */
    private int itemId;

    /**
     * 商品名
     */
    private String itemName;

    /**
     * カテゴリーID
     */
    private int categoryId;

    /**
     * 価格
     */
    private float price;

    /**
     * 在庫数
     */
    private int stocks;

    /**
     * 売り上げ
     */
    private int sales;

    /**
     * 商品詳細
     */
    private String itemDetail;

    /**
     * デリートキー
     */
    private boolean isDeleted;

    /**
     * 登録日
     */
    private String createdAt;

    /**
     * 更新日
     */
    private String updatedAt;

    /**
     * イメージパス
     */
    private String imagepath ;

    /**
     * 登録日イメージ
     */
    private String imageCreatedAt;

    /**
     * 更新日イメージ
     */
    private String imageUpdatedAt;

    /**
     * インデックス
     */
    private int index;

    private int quantities;



    /**
     * 商品IDを取得するメソッド
     * @return itemId 商品ID
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * 商品IDを格納するメソッド
     * @param itemId セットする 商品ID
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * 商品名を取得するメソッド
     * @return itemName 商品名
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 商品名を格納するメソッド
     * @param itemName セットする 商品名
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * カテゴリーIDを取得するメソッド
     * @return categoryId カテゴリーID
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * カテゴリーIDを格納するメソッド
     * @param categoryId セットする カテゴリーID
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 価格を取得するメソッド
     * @return price 価格
     */
    public float getPrice() {
        return price;
    }

    /**
     * 価格を格納するメソッド
     * @param price セットする 価格
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * 在庫数を取得するメソッド
     * @return stocks 在庫数
     */
    public int getStocks() {
        return stocks;
    }

    /**
     * 在庫数を格納するメソッド
     * @param stocks セットする 在庫数
     */
    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    /**
     * 売り上げを取得するメソッド
     * @return sales 売り上げ
     */
    public int getSales() {
        return sales;
    }

    /**
     * 売り上げを格納するメソッド
     * @param sales セットする 売り上げ
     */
    public void setSales(int sales) {
        this.sales = sales;
    }

    /**
     * 商品詳細を取得するメソッド
     * @return itemDetail 商品詳細
     */
    public String getItemDetail() {
        return itemDetail;
    }

    /**
     * 商品詳細を格納するメソッド
     * @param itemDetail セットする 商品詳細
     */
    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
    }

    /**
     * デリートキーを取得するメソッド
     * @return isDeleted デリートキー
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * デリートキーを格納するメソッド
     * @param isDeleted セットする デリートキー
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 登録日を取得するメソッド
     * @return createdAt 登録日
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * 登録日を格納するメソッド
     * @param createdAt セットする 登録日
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 更新日を取得するメソッド
     * @return updatedAt 更新日
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 更新日を格納するメソッド
     * @param updatedAt セットする 更新日
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * イメージパスを取得するメソッド
     * @return imagePath イメージパス
     */
    public String getImagepath() {
        return imagepath;
    }

    /**
     * イメージパスを格納するメソッド
     * @param imagePath セットする イメージパス
     */
    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }



    /**
     * 登録日イメージを取得するメソッド
     * @return imageCreatedAt 登録日イメージ
     */
    public String getImageCreatedAt() {
        return imageCreatedAt;
    }

    /**
     * 登録日イメージを格納するメソッド
     * @param imageCreatedAt セットする 登録日イメージ
     */
    public void setImageCreatedAt(String imageCreatedAt) {
        this.imageCreatedAt = imageCreatedAt;
    }

    /**
     * 更新日イメージを取得するメソッド
     * @return imageUpdatedAt 更新日イメージ
     */
    public String getImageUpdatedAt() {
        return imageUpdatedAt;
    }

    /**
     * 更新日イメージを格納するメソッド
     * @param imageUpdatedAt セットする 更新日イメージ
     */
    public void setImageUpdatedAt(String imageUpdatedAt) {
        this.imageUpdatedAt = imageUpdatedAt;
    }

    /**
     * インデックスを取得するメソッド
     * @return index インデックス
     */
    public int getIndex() {
        return index;
    }

    /**
     * インデックスを格納するメソッド
     * @param index セットする インデックス
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return quantities
     */
    public int getQuantities() {
        return quantities;
    }

    /**
     * @param quantities セットする quantities
     */
    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

}
