create table privilegeTypes(	-- 权限分类
	id integer primary key auto_increment,
	name varchar(50),
	description varchar(200),
	sort integer
);
create table privileges(	-- 权限
	id integer primary key auto_increment,
	privilegeTypeId integer,
	name varchar(50),
	description varchar(200),
	sort integer,
	urls varchar(200)
);

create table roles(	-- 角色
	id integer primary key auto_increment,
	name varchar(50),
	description varchar(200),
	privilegeIds varchar(200),
	sort integer
);

create table departments(   -- 部门
	id integer primary key auto_increment,
	parentId integer,  -- 父节点
	name varchar(50),   -- 名称
	sort integer		-- 排序
);
create table users(		-- 用户
	id integer primary key auto_increment,
	departmentId integer,
	name varchar(50),
	sex varchar(10),
	login varchar(50),
	password varchar(50),
	moNumber varchar(50),	-- 手机号码
	shortNumber varchar(50),-- 手机短号
	inTime datetime,		-- 入职时间
	outTime datetime,		-- 离职时间
	roleIds varchar(200)
);
create table userRoles(	-- 用户所拥有角色
	id integer primary key auto_increment,
	userId integer,
	roleId integer
);
create table sessions(
	id integer primary key auto_increment,
	userId integer,
	sessionId varchar(200),
	loginTime datetime
);
