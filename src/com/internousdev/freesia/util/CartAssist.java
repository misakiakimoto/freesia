/**
 *
 */
package com.internousdev.freesia.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.freesia.dao.GoItemDetailDAO;
import com.internousdev.freesia.dto.CartDTO;
import com.internousdev.freesia.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * カート全般の処理と決済のときの処理を補助するクラス
 * @author MISA OHTSUKA
 * @since 2017/08/02
 * @version 1.0
 */
public class CartAssist extends ActionSupport{

	/**
	 * シリアルID
	 */
	private static final long serialVersionUID = -7319753971378037381L;
	/**
	 * カート内の価格合計
	 */
	private int total_price;

	/**
	 * 商品数合計
	 */
	private int totalOrder;

	/**
	 * 注文数と商品の在庫数を計算した値
	 */
	private int totalNumber;

	/**
	 * カートに入ってる商品の合計金額を計算して返すメソッド
	 *
	 * @param cartList カート内商品
	 * @return payment 合計金額
	 */
	public float total_price(List<CartDTO> cartList) {
		cartList.forEach(cart -> total_price += cart.getPrice() * cart.getQuantities());
		return total_price;
	}

	/**
	 * カートに入ってる商品数を合計して返すメソッド
	 *
	 * @param cartList カート内商品
	 * @return totalOrder 商品数合計
	*/
	public int totalOrder(List<CartDTO> cartList) {
		cartList.forEach(cart -> totalOrder += cart.getQuantities());
		return totalOrder;
	}


	/**
	 * 注文数と商品在庫を比較して在庫より上回らないように計算してセットするメソッド
	 * なお在庫が99個以上あっても最大99個までしか買えないようにしてます。
	 * @param cartId カートID
	 * @param quantities 商品の注文数
	 * @param itemId 商品ID
	 * @return totalNumber 注文数と商品の在庫数を計算した値
	 * @throws SQLException 例外
	 */
	public int totalNumber(int cartId,int quantities, int itemId) throws SQLException {
		GoItemDetailDAO itemStock = new GoItemDetailDAO();
		List<ItemDTO> itemList = new ArrayList<>();
		itemList = itemStock.selectbyItem(itemId);
		int stock = Math.min(itemList.get(0).getStocks(), 99);
		this.totalNumber = Math.min(cartId + quantities, stock);
		return this.totalNumber;
	}



}