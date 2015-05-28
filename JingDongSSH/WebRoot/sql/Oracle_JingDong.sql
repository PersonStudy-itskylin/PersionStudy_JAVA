--创建表空间
CREATE TABLESPACE jingdong
DATAFILE 'C:\Database\jingdong.DBF'
SIZE 5M
AUTOEXTEND ON NEXT 1M 
MAXSIZE UNLIMITED
LOGGING;

--创建用户
CREATE USER jingdong IDENTIFIED BY jingdong DEFAULT TABLESPACE jingdong;

--赋予权限
GRANT CONNECT,RESOURCE TO jingdong;

--创建用户表
CREATE TABLE users
(	
		id INT PRIMARY KEY NOT NULL,		--序列
		name VARCHAR2(50) UNIQUE NOT NULL,		--账号
		password VARCHAR2(50) NOT NULL,		--密码
		shoppingCar_id INT	--购物车 
);

--创建用户表序列
CREATE SEQUENCE users_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--商品
CREATE TABLE goods
(
		id INT PRIMARY KEY NOT NULL,		--序列
		type VARCHAR2(100) NOT NULL,		--商品名
		title VARCHAR2(200) NOT NULL,		--标题
		price NUMBER(9,2) NOT NULL,		--单价
		imgURL VARCHAR2(100) NOT NULL,		--图片地址
		manufacturer VARCHAR2(50) NOT NULL,		--产商
		evaluate INT CHECK(evaluate >= 0) NOT NULL		--库存
);

--创建用户表序列
CREATE SEQUENCE goods_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--订单表
CREATE TABLE orders
(
		id INT PRIMARY KEY NOT NULL,		--序列
    no_id NUMBER(13) NOT NULL,      --真正的订单编号
		consignee VARCHAR2(50) NOT NULL,		--收货人
		address VARCHAR2(100) NOT NULL,		--地址
		phone VARCHAR2(50) NOT NULL,	--电话
		email VARCHAR2(50) NOT NULL,		--邮箱
		payWay VARCHAR2(50) NOT NULL,	--支付方式
		times DATE DEFAULT(SYSDATE) NOT NULL,	--订单时间
    u_id INT REFERENCES users(id) --跟用户的关系
)

--创建订单表序列
CREATE SEQUENCE order_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--订单跟商品的关联表
CREATE TABLE order_goods
(
		o_id NUMBER(13) REFERENCES orders(id),
		g_id INT REFERENCES goods(id),
    list_index INT NOT NULL,
    --建立联合主键
    PRIMARY KEY (o_id,g_id)
)


--插入测试数据
INSERT INTO users VALUES (users_sequence.nextval,'admin','admin',null);

/** 添加商品 **/
INSERT INTO goods VALUES(goods_sequence.nextval, '平板电视','三星（SAMSUNG）UA46EH5000R 46英寸全高清LED液晶电视（黑色）爆降1600！红六月狂潮第二波来袭！跌跛心理底线！直下式LED背光源，最划算大牌46吋LED！',4399.00,'image/ds_1.jpg','三星',100 );
INSERT INTO goods VALUES(goods_sequence.nextval, '平板电视','索尼（SONY） KLV-42EX410 42英寸 全高清LED液晶电视 黑色红六月品牌日,3799成交(下单立减700)超2000台好评机器,炫薄LED,每IP、ID限抢1台,购买超2台删单',4499.00,'image/ds_2.jpg','索尼',200 );
INSERT INTO goods VALUES(goods_sequence.nextval, '平板电视','海信（Hisense） LED42T36P 42英寸全高清 互联网LED液晶电视（黑色）红六月特惠价！超强互联网，蓝光USB解码，超薄节能LED才是真的LED！一代神机！也是极好的（含底座）',2999.00,'image/ds_3.jpg','海信',50 );
INSERT INTO goods VALUES(goods_sequence.nextval, '平板电脑','夏普(SHARP) LCD-60LX540A 60英寸 全高清 智能LED液晶电视（黑色）相当于9999（10499成交，订单完成后得500京券）！100HZ双倍速！日本原装液晶面板！',10499.00,'image/ds_4.jpg','夏普',1000 );
INSERT INTO goods VALUES(goods_sequence.nextval, '平板电脑','康佳（KONKA） LC42MS96PD 42英寸 IPS硬屏3D 液晶电视（黑色）康佳品牌日，直降1400元！原装IPS硬屏！不闪式3D！支持2D转3D播放！内置底座+2副3D眼镜',2599.00,'image/ds_5.jpg','康佳',300 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手机','苹果（APPLE）iPhone 4S 16G版 3G手机（黑色）WCDMA/GSM学英语找Siri~',4799.00,'image/sj_1.jpg','苹果',1000 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手机','三星（SAMSUNG）I9100G 3G手机（黑色）WCDMA/GSM三星优惠券六月大促~活动链接：http://sale.360buy.com/p14773.html；限铁牌以上会员！',3799.00,'image/sj_2.jpg','三星',500 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手机','魅族（MEIZU）MX 16G 3G手机（黑色）WCDMA/GSM限时送保护套！梦想之作，1.4GHz双核CPU,960*640分辨率，4寸ASV屏，800万像素！',2399.00,'image/sj_3.jpg','魅族',10 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手机','摩托罗拉（Motorola）XT615 3G手机（黑色）WCDMA/GSM',2098.00,'image/sj_4.jpg','摩托罗拉',15 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手机','诺基亚（NOKIA）Lumia 800 3G手机（湖蓝色）WCDMA/GSM 非定制',3599.00,'image/sj_5.jpg','诺基亚',89 );
INSERT INTO goods VALUES(goods_sequence.nextval, '笔记本','ThinkPad E420（1141-A83）14英寸笔记本电脑（i3-2350M 2G 500G HD6470M 1G独显 蓝牙 摄像头）2012年6月8号-6月18号限时抢购，劲爆特价，红六月京东会员独享，把握机会，拒绝观望',3299.00,'image/dn_1.jpg','联想',120 );
INSERT INTO goods VALUES(goods_sequence.nextval, '笔记本','华硕（ASUS）A53XI267SM-SL 15.6英寸笔记本电脑（i7-2670QM 4G 7200转500G GT630M 2G独显 USB3.0 暖金色）红六月 会员独享超低价! 金属机身,定制7200转硬盘,买4G送4G,红6月,华硕打响第一枪!!',5099.00,'image/dn_2.jpg','华硕',300 );
INSERT INTO goods VALUES(goods_sequence.nextval, '笔记本','索尼（SONY）VPCEH38EC/P 15.5英寸宽屏笔记本电脑（i5-2450M 2G 640G 1G独显 D刻 HDMI WIN7 粉）抢滩诺曼底！索尼i5独显大本惊爆价促销！',4099.00,'image/dn_3.jpg','索尼',600 );
INSERT INTO goods VALUES(goods_sequence.nextval, '笔记本','三星（SAMSUNG）NP530U3B-A01CN 13.3英寸超极本 (i5-2467M 4G 500G+SSD16G Win7 蓝牙）泰坦银',5999.00,'image/dn_4.jpg','三星',800 );
INSERT INTO goods VALUES(goods_sequence.nextval, '笔记本','东芝（TOSHIBA）C805-S21R 14英寸笔记本电脑（i3-2350M 2G 640G HD 7610M 1G独显 USB3.0 Win7） 野玫红红六月特惠直降400限量抢！强悍HD7610M 1G独显，看片游戏high到爆！微软助力，再得鼠标一枚！',3299.00,'image/dn_5.jpg','东芝',77 );
INSERT INTO goods VALUES(goods_sequence.nextval, '键盘','罗技（Logitech）G19 游戏键盘',1385.00,'image/jp_1.jpg','罗技',50 );
INSERT INTO goods VALUES(goods_sequence.nextval, '键盘','樱桃（Cherry）G80-3494LYCUS-2 机械键盘(黑色红轴3494)聆听敲击之乐，感受唯美震颤！',999.00,'image/jp_2.jpg','樱桃',600 );
INSERT INTO goods VALUES(goods_sequence.nextval, '键盘','雷蛇（Razer）BlackWidow 黑寡妇机械游戏键盘（终极版）革命性的高光泽度镜面精加工键帽、具备完全可编程按键，外加超炫背光，成就秀外慧中游戏圣品！',899.00,'image/jp_3.jpg','雷蛇',1200 );
INSERT INTO goods VALUES(goods_sequence.nextval, '键盘','TT（thermaltake） esports MEKA G-UNIT 拓荒者G-UNIT电竞键盘',819.00,'image/jp_4.jpg','TT',1 );
INSERT INTO goods VALUES(goods_sequence.nextval, '键盘','赛钛客（Saitek）美加狮 MADCATZ 日蚀三多媒体多色触摸背光键盘',1385.00,'image/jp_5.jpg','赛钛客',160 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手表','海鸥手表ST8004ZG自动飞返双历鳄鱼皮表带机械表陀飞轮 男表',138000.00,'image/sb_1.jpg','海鸥',30 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手表','雷达表RADO银钻系列男装大款石英腕表 R13723711全民疯抢，参加日百满299元返618东券活动，一年仅一次！',37999.00,'image/sb_2.jpg','雷达',420 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手表','LONGINES 浪琴手表PrimaLuna 心月系列石英女表 L8.110.5.89.6参加日百免费领用200-40东券活动，即领即用！',29040.00,'image/sb_3.jpg','浪琴',500 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手表','天骏TANGIN18K金透视机芯表盘男腕表T3002GYKJSB全民疯抢，参加日百满299元返618东券活动，一年仅一次！',14062.00,'image/sb_4.jpg','天骏',3000 );
INSERT INTO goods VALUES(goods_sequence.nextval, '手表','雪铁纳Certina表冠军系列DS Podium男装机械腕表 C674.7129.42.66全民疯抢，参加日百满299元返618东券活动，一年仅一次！',8931.00,'image/sb_5.jpg','雪铁纳',25);

SELECT * FROM users;
SELECT * FROM goods;
SELECT * FROM orders;
SELECT * FROM order_goods;






