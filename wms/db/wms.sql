create table depots(    -- 仓库
	id integer primary key auto_increment,
	code varchar(50),
	name varchar(50),
	remark varchar(300)
);
create table measureUnits( -- 计量单位
	id integer primary key auto_increment,
	code varchar(50),
	name varchar(50),
	remark varchar(300)
);
create table goodTypes(    -- 商品分类
	id integer primary key auto_increment,
	parentId integer,
	code varchar(50),
	name varchar(50),
	remark varchar(200),
	sort integer
);
create table goods( -- 商品资料
	id integer primary key auto_increment,
	goodTypeId integer,
	code varchar(50),
	name varchar(50),
	remark varchar(300),    -- 商品说明
	unit varchar(10),   -- 计量单位
	model varchar(100), -- 型号
	spec varchar(100),  -- 规格
	color varchar(100), -- 颜色
	brand varchar(100), -- 品牌
	place varchar(100), -- 产地
	vender varchar(300),    -- 厂家
	barcode varchar(100),    -- 条形码
	countUp integer,	-- 库存上限
	countDown integer,	-- 库存下限
	help varchar(10)    -- 助记码
);
create table intercourseTypes(	-- 往来单位分类
	id integer primary key auto_increment,
	parentId integer,
	code varchar(50),
	name varchar(50),
	remark varchar(300),
	sort integer
);
create table intercourses(  -- 往来单位
	id integer primary key auto_increment,
	intercourseTypeId integer,
	code varchar(50),
	shortName varchar(300),	-- 简称
	fullName varchar(300),	-- 全称
	remark varchar(300),	-- 备注
	addr varchar(300),		-- 地址
	postcode varchar(6),	-- 邮编
	phone varchar(200),		-- 电话
	fax varchar(200),		-- 传真
	www varchar(200),		-- 网址
	email varchar(200),		-- 电子邮箱
	answerMan varchar(50),	-- 负责人
	contactMan varchar(50),	-- 联系人
	licence varchar(200),   -- 营业执照号
	bank varchar(200),  	-- 开户银行
	taxCode varchar(200),	-- 税务编码
	account varchar(200),   -- 银行帐号
	help varchar(10),		-- 助记码
	recvCost decimal(18,4),	-- 应收款
	payCost decimal(18,4)	-- 应付款
);
create table bills(			-- 通用单据
	id integer primary key auto_increment,
	billType integer,		-- 单据类型：1采购入库单，11采购退货单，2出库单，3调拨单
	intercourseId integer,  -- 往来单位
	depotId integer,		-- 仓库
	depot2Id integer,		-- 仓库2
	code varchar(50),   	-- 单据编号
	summary varchar(200),   -- 摘要
	remark varchar(200),    -- 附加说明
	billCount integer,  	-- 总数量
	billCost decimal(18,4), -- 金额
	writeUserId integer,  	-- 编制人
	checkUserId integer, 	-- 审核人
	writeDate datetime,
	checkDate datetime,
	billDate date, 			-- 单据日期
	status integer  		-- 状态：0编制1未审核2已审核
);
create table billDetails(	-- 通用单据明细
	id integer primary key auto_increment,
	billId integer,
	goodId integer,    		-- 商品
	billCount integer,  	-- 数量
	billPrice decimal(18,4),-- 单价
	basePrice decimal(18,4),-- 出库时成本单价
	rtnCount integer,		-- 退货数量
	billDetailId integer,	-- 对应的单据明细ID，采购退货时对应采购入库ID，销售退货时对应销售出库ID
	remark varchar(300) 	-- 备注
);
create table stocks(    	-- 商品库存
	id integer primary key auto_increment,
	goodId integer,
	depotId integer,
	count integer,
	price decimal(18,4),
	cost decimal(18,4)
);
