package com.internousdev.freesia.dto;

/**
 * 商品情報を格納するためのDTOクラス
 * @author TAKUMI MISAWA
 * @since 2017/07/04
 * @version 1.0
 */

public class CategoryDTO {

    /**
     * カテゴリーID
     */
    private int categoryId;

    /**
     * カテゴリー名
     */
    private String categoryName;

    /**
     * 表示名
     */
    private String displayName;

    /**
     * 登録日
     */
    private String createdAt;

    /**
     * 更新日
     */
    private String updatedAt;


    /**
     * カテゴリーIDを取得するメソッド
     * @return CategoryId カテゴリーID
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * カテゴリーIDを格納するメソッド
     * @param categoryId セットする categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * カテゴリー名を取得するメソッド
     * @return categoryName カテゴリー名
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * カテゴリー名を格納するメソッド
     * @param categoryName カテゴリー名
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
     * @param createdAt セットする createdAt
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
     * @param updatedAt セットする updatedAt
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 表示名を取得するメソッド
     * @return displayName 表示名
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 表示名を格納するメソッド
     * @param displayName セットする displayName
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
