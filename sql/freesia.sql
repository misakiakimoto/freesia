set names utf8;
set foreign_key_checks=0;
drop database if exists freesia;
create database freesia;
use freesia;

create table categories(/*洋服のカテゴリ*/
categories_id int primary key auto_increment,/*カテゴリID*/
categories_title varchar(50) not null,/*カテゴリのタイトル*/
categories_img varchar(255) not null,/*イメージパス*/
created_at datetime not null  default current_timestamp,/*登録日*/
updated_at datetime not null  default current_timestamp on update current_timestamp/*更新日*/
);

create table collections(
user_id int not null primary key,
her_name varchar(50) not null,
title varchar(50) not null,
comment varchar(255) not null,
img_path1 varchar(255) not null,
created_at datetime not null default current_timestamp,/*登録日*/
updated_at datetime not null default current_timestamp,/*更新日*/
foreign key (user_id)references openconnect.users(user_id)
);



create table items(/*商品情報*/
items_id int primary key auto_increment,/*商品ID*/
items_name varchar(100) not null,/*商品名*/
price decimal(9,2) not null,/*単価*/
stocks int not null,/*在庫数*/
sales int default 0,/*売上数*/
items_detail text not null,/*商品詳細*/
img_path varchar(255) not null,/*イメージパス*/
/*items_img01 varchar(255) not null,商品画像01*/
/*items_img02 varchar(255) not null,商品画像02*/
categories_id int not null,/*種類ID*/
del_key boolean default false,/*デリートキー*/
created_at datetime not null  default current_timestamp,/*登録日*/
updated_at datetime not null  default current_timestamp on update current_timestamp,/*更新日*/
foreign key (categories_id)references categories(categories_id)
);

create table carts(/*カート*/
user_id int not null,/*ユーザーID*/
cart_id int primary key auto_increment,/*カートID*/
items_id int not null,/*商品ID*/
quantities int not null default 1,/*数量*/
is_deleted boolean default false,/*商品選択削除*/
created_at datetime not null  default current_timestamp,/*登録日*/
updated_at datetime not null  default current_timestamp on update current_timestamp,/*更新日*/
foreign key (user_id)references openconnect.users(user_id),
foreign key(items_id) references items(items_id)
);


create table purchases(/*購入情報*/
purchase_id int primary key auto_increment,/*購入ID*/
user_id int not null,/*ユーザーID*/
total_price decimal(9,2) not null default 0,/*価格合計*/
created_at datetime not null default current_timestamp,/*登録日*/
updated_at datetime not null default current_timestamp on update current_timestamp,/*更新日*/
foreign key (user_id) references openconnect.users(user_id)on delete cascade
);

create table purchases_details (
	purchase_id int not null,/*購入ID*/
	purchase_no int not null auto_increment primary key,/*購入NO*/
	user_id int not null,/*ユーザーID*/
	items_id int not null,/*商品ID*/
	unit_price decimal(9,2) not null default 0,/*単価*/
	quantities int not null default 1,/*数量*/
	multiplied_price decimal(9,2) not null,/*価格計*/
	purchased_at datetime not null default current_timestamp,/*購入日*/
	created_at datetime not null default current_timestamp,/*登録日*/
	updated_at datetime not null default current_timestamp,/*更新日*/

	foreign key(purchase_id) references purchases(purchase_id),
	foreign key(user_id) references openconnect.users(user_id),
	foreign key(items_id) references items(items_id)

);

create table credits(/*クレジット*/
user_id int not null,/*ユーザーID*/
credit_id int not null,/*クレジット種類*/
credit_number varchar(16) not null,/*クレジット番号*/
name_e varchar(50) not null,/*姓名(ローマ字)*/
security_code varchar(4) not null,/*セキュリティコード*/
expiration_month int not null,/*有効期限(月)*/
expiration_year int not null,/*有効期限(年)*/
created_at datetime not null  default current_timestamp,/*登録日*/
updated_at datetime not null  default current_timestamp on update current_timestamp,/*更新日*/
foreign key (user_id) references openconnect.users (user_id) on delete cascade);


create table temporary_credits(/*クレジット(一時保存)*/
credit_name int not null,/*クレジットの種類*/
credit_number varchar(16) not null,/*クレジットの番号*/
name_e varchar(50) not null,/*姓名(ローマ字)*/
security_code varchar(4) not null,/*セキュリティコード*/
use_day date,/*ご利用日*/
expiration_month int not null,/*有効期限(月)*/
expiration_year int not null,/*有効期限(年)*/
division varchar(10),/*支払区分*/
split int,/*分割回数*/
spend decimal(9,2) not null,/*ご利用金額*/
created_at datetime not null  default current_timestamp,/*登録日*/
updated_at datetime not null  default current_timestamp on update current_timestamp);/*更新日*/


use freesia;
insert into categories(categories_id,categories_title,categories_img)
values(1,'トップス/tops','img/tomato01.jpg'),
(2,'ボトムス/pants','img/p-man03.jpg'),
(3,'スカート/skirt','img/papurika01.jpg'),
(4,'アクセサリ/accesories','img/kyuuri02.jpg'),
(5,'その他/others','img/corn01.jpg'
);

insert into items(items_id,items_name,price,stocks,items_detail,img_path,categories_id)
values
(1,'スポーティージップジャンパー',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/001.jpg',1),
(2,'小花柄ゆるふわカットソー・全2色',1980,100,'清楚なイメージを連想させるフレアなこのトップスはポイントで入っている優しいブルーカラーの柄がポイント。首元のフリルがさらに上品で軽やかな印象を与えてくれます。','img/Product/063.jpg',1),
(3,'インナーセットネイビーワンピース',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/003.jpg',1),
(4,'リボンウエストサロペット・全2色',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/009.jpg',1),
(5,'ワイドネック6分袖ボーダーカットソー',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/012.jpg',1),
(6,'シシュウバルンチュニック',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/014.jpg',1),
(7,'6分袖ロゴチュニック',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/015.jpg',1),
(8,'カットオフワイドサロペット',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/019.jpg',1),
(9,'ストライプVネックホワイトワンピース',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/020.jpg',1),
(10,'マリンボーダーパーカー',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/025.jpg',1),
(11,'フリル袖セットコーデワンピース',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/026.jpg',1),
(12,'ウエストゴム膝下デニムスカート',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/031.jpg',1),
(13,'ウエストゴムボヘミアンカットオフデニムスカート・全2色',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/037.jpg',1),
(14,'ショート丈フレアホワイトスカート',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/045.jpg',1),
(15,'七分袖Vネックカットソー',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/046.jpg',1),
(16,'セットコーデフリルワンピース',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/049.jpg',1),
(17,'ボーダーロゴ六分袖シャツ・全2色',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/050.jpg',1),
(18,'ワイドネックポケットTシャツ',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/058.jpg',1),
(19,'ウエストゴム膝下ネイビーフレアスカート',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/059.jpg',1),
(20,'スポーティージップジャンパー',1980,100,'透け感が魅力的なこのブルゾンはハードめのロゴもポイント。カジュアルなスポーティースタイルにオススメの上着です。','img/Product/061.jpg',1);


insert into collections(user_id,her_name,title,comment,img_path1)
values
(1,'hana','ootd','you can follow me','img/collections/1.jpg'),
(2,'erika','ootd','you can follow me','img/collections/2.jpg'),
(3,'suzu','ootd','you can follow me','img/collections/3.jpg'),
(4,'@mm','ootd','you can follow me','img/collections/4.jpg'),
(5,'yuzu','ootd','you can follow me','img/collections/5.jpg'),
(6,'sunny','ootd','you can follow me','img/collections/6.jpg'),
(7,'myu','ootd','you can follow me','img/collections/7.jpg'),
(8,'anna','ootd','you can follow me','img/collections/8.jpg'),
(9,'hitomi','ootd','you can follow me','img/collections/9.jpg'),
(10,'sakura','ootd','you can follow me','img/collections/10.jpg'),
(11,'kiki','ootd','you can follow me','img/collections/11.jpg'),
(12,'mimmy','ootd','you can follow me','img/collections/12.jpg')
;
/*商品の追加、変更*/
/*商品ID、商品名、単価、在庫、商品詳細、イメージファイルパス、種類ID*/

