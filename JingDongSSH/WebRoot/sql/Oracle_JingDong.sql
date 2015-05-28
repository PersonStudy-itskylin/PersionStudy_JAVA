--������ռ�
CREATE TABLESPACE jingdong
DATAFILE 'C:\Database\jingdong.DBF'
SIZE 5M
AUTOEXTEND ON NEXT 1M 
MAXSIZE UNLIMITED
LOGGING;

--�����û�
CREATE USER jingdong IDENTIFIED BY jingdong DEFAULT TABLESPACE jingdong;

--����Ȩ��
GRANT CONNECT,RESOURCE TO jingdong;

--�����û���
CREATE TABLE users
(	
		id INT PRIMARY KEY NOT NULL,		--����
		name VARCHAR2(50) UNIQUE NOT NULL,		--�˺�
		password VARCHAR2(50) NOT NULL,		--����
		shoppingCar_id INT	--���ﳵ 
);

--�����û�������
CREATE SEQUENCE users_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--��Ʒ
CREATE TABLE goods
(
		id INT PRIMARY KEY NOT NULL,		--����
		type VARCHAR2(100) NOT NULL,		--��Ʒ��
		title VARCHAR2(200) NOT NULL,		--����
		price NUMBER(9,2) NOT NULL,		--����
		imgURL VARCHAR2(100) NOT NULL,		--ͼƬ��ַ
		manufacturer VARCHAR2(50) NOT NULL,		--����
		evaluate INT CHECK(evaluate >= 0) NOT NULL		--���
);

--�����û�������
CREATE SEQUENCE goods_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--������
CREATE TABLE orders
(
		id INT PRIMARY KEY NOT NULL,		--����
    no_id NUMBER(13) NOT NULL,      --�����Ķ������
		consignee VARCHAR2(50) NOT NULL,		--�ջ���
		address VARCHAR2(100) NOT NULL,		--��ַ
		phone VARCHAR2(50) NOT NULL,	--�绰
		email VARCHAR2(50) NOT NULL,		--����
		payWay VARCHAR2(50) NOT NULL,	--֧����ʽ
		times DATE DEFAULT(SYSDATE) NOT NULL,	--����ʱ��
    u_id INT REFERENCES users(id) --���û��Ĺ�ϵ
)

--��������������
CREATE SEQUENCE order_sequence
START WITH 1000
INCREMENT BY 1
NOMAXVALUE
CACHE 1000;

--��������Ʒ�Ĺ�����
CREATE TABLE order_goods
(
		o_id NUMBER(13) REFERENCES orders(id),
		g_id INT REFERENCES goods(id),
    list_index INT NOT NULL,
    --������������
    PRIMARY KEY (o_id,g_id)
)


--�����������
INSERT INTO users VALUES (users_sequence.nextval,'admin','admin',null);

/** �����Ʒ **/
INSERT INTO goods VALUES(goods_sequence.nextval, 'ƽ�����','���ǣ�SAMSUNG��UA46EH5000R 46Ӣ��ȫ����LEDҺ�����ӣ���ɫ������1600�������¿񳱵ڶ�����Ϯ������������ߣ�ֱ��ʽLED����Դ��������46��LED��',4399.00,'image/ds_1.jpg','����',100 );
INSERT INTO goods VALUES(goods_sequence.nextval, 'ƽ�����','���ᣨSONY�� KLV-42EX410 42Ӣ�� ȫ����LEDҺ������ ��ɫ������Ʒ����,3799�ɽ�(�µ�����700)��2000̨��������,�ű�LED,ÿIP��ID����1̨,����2̨ɾ��',4499.00,'image/ds_2.jpg','����',200 );
INSERT INTO goods VALUES(goods_sequence.nextval, 'ƽ�����','���ţ�Hisense�� LED42T36P 42Ӣ��ȫ���� ������LEDҺ�����ӣ���ɫ���������ػݼۣ���ǿ������������USB���룬��������LED�������LED��һ�������Ҳ�Ǽ��õģ���������',2999.00,'image/ds_3.jpg','����',50 );
INSERT INTO goods VALUES(goods_sequence.nextval, 'ƽ�����','����(SHARP) LCD-60LX540A 60Ӣ�� ȫ���� ����LEDҺ�����ӣ���ɫ���൱��9999��10499�ɽ���������ɺ��500��ȯ����100HZ˫���٣��ձ�ԭװҺ����壡',10499.00,'image/ds_4.jpg','����',1000 );
INSERT INTO goods VALUES(goods_sequence.nextval, 'ƽ�����','���ѣ�KONKA�� LC42MS96PD 42Ӣ�� IPSӲ��3D Һ�����ӣ���ɫ������Ʒ���գ�ֱ��1400Ԫ��ԭװIPSӲ��������ʽ3D��֧��2Dת3D���ţ����õ���+2��3D�۾�',2599.00,'image/ds_5.jpg','����',300 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֻ�','ƻ����APPLE��iPhone 4S 16G�� 3G�ֻ�����ɫ��WCDMA/GSMѧӢ����Siri~',4799.00,'image/sj_1.jpg','ƻ��',1000 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֻ�','���ǣ�SAMSUNG��I9100G 3G�ֻ�����ɫ��WCDMA/GSM�����Ż�ȯ���´��~����ӣ�http://sale.360buy.com/p14773.html�����������ϻ�Ա��',3799.00,'image/sj_2.jpg','����',500 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֻ�','���壨MEIZU��MX 16G 3G�ֻ�����ɫ��WCDMA/GSM��ʱ�ͱ����ף�����֮����1.4GHz˫��CPU,960*640�ֱ��ʣ�4��ASV����800�����أ�',2399.00,'image/sj_3.jpg','����',10 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֻ�','Ħ��������Motorola��XT615 3G�ֻ�����ɫ��WCDMA/GSM',2098.00,'image/sj_4.jpg','Ħ������',15 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֻ�','ŵ���ǣ�NOKIA��Lumia 800 3G�ֻ�������ɫ��WCDMA/GSM �Ƕ���',3599.00,'image/sj_5.jpg','ŵ����',89 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ʼǱ�','ThinkPad E420��1141-A83��14Ӣ��ʼǱ����ԣ�i3-2350M 2G 500G HD6470M 1G���� ���� ����ͷ��2012��6��8��-6��18����ʱ�����������ؼۣ������¾�����Ա�������ջ��ᣬ�ܾ�����',3299.00,'image/dn_1.jpg','����',120 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ʼǱ�','��˶��ASUS��A53XI267SM-SL 15.6Ӣ��ʼǱ����ԣ�i7-2670QM 4G 7200ת500G GT630M 2G���� USB3.0 ů��ɫ�������� ��Ա�����ͼ�! ��������,����7200תӲ��,��4G��4G,��6��,��˶�����һǹ!!',5099.00,'image/dn_2.jpg','��˶',300 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ʼǱ�','���ᣨSONY��VPCEH38EC/P 15.5Ӣ������ʼǱ����ԣ�i5-2450M 2G 640G 1G���� D�� HDMI WIN7 �ۣ���̲ŵ���ף�����i5���Դ󱾾����۴�����',4099.00,'image/dn_3.jpg','����',600 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ʼǱ�','���ǣ�SAMSUNG��NP530U3B-A01CN 13.3Ӣ�糬���� (i5-2467M 4G 500G+SSD16G Win7 ������̩̹��',5999.00,'image/dn_4.jpg','����',800 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ʼǱ�','��֥��TOSHIBA��C805-S21R 14Ӣ��ʼǱ����ԣ�i3-2350M 2G 640G HD 7610M 1G���� USB3.0 Win7�� Ұõ��������ػ�ֱ��400��������ǿ��HD7610M 1G���ԣ���Ƭ��Ϸhigh������΢���������ٵ����һö��',3299.00,'image/dn_5.jpg','��֥',77 );
INSERT INTO goods VALUES(goods_sequence.nextval, '����','�޼���Logitech��G19 ��Ϸ����',1385.00,'image/jp_1.jpg','�޼�',50 );
INSERT INTO goods VALUES(goods_sequence.nextval, '����','ӣ�ң�Cherry��G80-3494LYCUS-2 ��е����(��ɫ����3494)�����û�֮�֣�����Ψ�������',999.00,'image/jp_2.jpg','ӣ��',600 );
INSERT INTO goods VALUES(goods_sequence.nextval, '����','���ߣ�Razer��BlackWidow �ڹѸ���е��Ϸ���̣��ռ��棩�����Եĸ߹���Ⱦ��澫�ӹ���ñ���߱���ȫ�ɱ�̰�������ӳ��ű��⣬�ɾ����������ϷʥƷ��',899.00,'image/jp_3.jpg','����',1200 );
INSERT INTO goods VALUES(goods_sequence.nextval, '����','TT��thermaltake�� esports MEKA G-UNIT �ػ���G-UNIT�羺����',819.00,'image/jp_4.jpg','TT',1 );
INSERT INTO goods VALUES(goods_sequence.nextval, '����','���ѿͣ�Saitek������ʨ MADCATZ ��ʴ����ý���ɫ�����������',1385.00,'image/jp_5.jpg','���ѿ�',160 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֱ�','��Ÿ�ֱ�ST8004ZG�Զ��ɷ�˫������Ƥ�����е���ӷ��� �б�',138000.00,'image/sb_1.jpg','��Ÿ',30 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֱ�','�״��RADO����ϵ����װ���ʯӢ��� R13723711ȫ��������μ��հ���299Ԫ��618��ȯ���һ���һ�Σ�',37999.00,'image/sb_2.jpg','�״�',420 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֱ�','LONGINES �����ֱ�PrimaLuna ����ϵ��ʯӢŮ�� L8.110.5.89.6�μ��հ��������200-40��ȯ������켴�ã�',29040.00,'image/sb_3.jpg','����',500 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֱ�','�쿥TANGIN18K��͸�ӻ�о���������T3002GYKJSBȫ��������μ��հ���299Ԫ��618��ȯ���һ���һ�Σ�',14062.00,'image/sb_4.jpg','�쿥',3000 );
INSERT INTO goods VALUES(goods_sequence.nextval, '�ֱ�','ѩ����Certina��ھ�ϵ��DS Podium��װ��е��� C674.7129.42.66ȫ��������μ��հ���299Ԫ��618��ȯ���һ���һ�Σ�',8931.00,'image/sb_5.jpg','ѩ����',25);

SELECT * FROM users;
SELECT * FROM goods;
SELECT * FROM orders;
SELECT * FROM order_goods;






