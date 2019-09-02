SHOW TABLES ;

CREATE DATABASE o2o;

SHOW DATABASES;
USE  o2o;

SHOW DATABASES ;

CREATE DATABASE sellSystem CHARACTER SET UTF8;

USE sellSystem;


CREATE TABLE  order_master(
  order_id VARCHAR(32) NOT NULL,
  buyer_name VARCHAR(32) NOT NULL COMMENT '买家名称',
  buyer_phone VARCHAR(32) NOT NULL COMMENT '买家电话',
  buyer_address VARCHAR(128) NOT NULL COMMENT '买家地址',
  buyer_openid VARCHAR(64) NOT NULL COMMENT '买家微信openID',
  order_amount DECIMAL(8,2) NOT NULL COMMENT '订单总金额',
  order_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '订单状态，默认为0新下单',
  pay_status TINYINT(3) NOT NULL DEFAULT '0' COMMENT '支付状态，默认为0未支付',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (order_id),
  KEY idx_buyer_openid(buyer_openid) COMMENT '索引'

) COMMENT '订单主表';

SHOW TABLES ;


CREATE TABLE product_category(
  category_id INT  AUTO_INCREMENT,
  category_name VARCHAR(64) NOT NULL COMMENT '类目名称',
  category_type INT NOT NULL COMMENT '类目编号',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  update_time TIMESTAMP NOT NULL DEFAULT  current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
   PRIMARY KEY (category_id),
   UNIQUE KEY unq_category_type(category_type)
) COMMENT '商品类目表';

CREATE TABLE order_detail(
  detail_id VARCHAR(32) NOT NULL,
  order_id VARCHAR(32) NOT NULL COMMENT '订单ID',
  product_id VARCHAR(32) NOT NULL COMMENT '商品ID',
  product_name VARCHAR(64) NOT NULL COMMENT '商品名称',
  product_price DECIMAL(8,2) NOT NULL COMMENT '商品价格',
  product_quantity INT NOT NULL COMMENT '商品数量',
  product_icon  VARCHAR(512) COMMENT  '商品图片',
  create_time TIMESTAMP NOT NULL DEFAULT  current_timestamp,
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE  CURRENT_TIMESTAMP ,
  PRIMARY KEY (detail_id),
  KEY idx_order_id (order_id) COMMENT '订单ID 作为索引'
) COMMENT '订单详情表';

CREATE TABLE product_info (
  product_id          VARCHAR(32)   NOT NULL,
  product_name        VARCHAR(64)   NOT NULL
  COMMENT '商品名称',
  product_price       DECIMAL(8, 2) NOT NULL
  COMMENT '商品价格',
  product_stock       INT           NOT NULL
  COMMENT '库存',
  product_description VARCHAR(64) COMMENT '商品描述',
  product_icon        VARCHAR(512) COMMENT '小图',
  product_status      TINYINT(3)    NOT NULL
  COMMENT '产品状态',
  category_type       INT           NOT NULL
  COMMENT '类目编号',
  create_time         TIMESTAMP     NOT NULL  DEFAULT current_timestamp
  COMMENT '创建时间',
  update_time         TIMESTAMP     NOT NULL  DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (product_id)
)COMMENT '商品信息表';

SHOW TABLES ;

SELECT * FROM product_info;




SHOW  CREATE TABLE seller_info;

SELECT * FROM product_category;

SELECT * FROM product_category WHERE category_type=1;

SHOW TABLES ;

CREATE TABLE tb_area(
  area_id INT NOT NULL AUTO_INCREMENT,
  area_name VARCHAR(100) NOT NULL COMMENT '地区名称',
  priority INT(2) NOT NULL DEFAULT 0 COMMENT '权重',
  area_desc VARCHAR(1000) DEFAULT NULL COMMENT '地区描述',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp,
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY(area_id),
  UNIQUE KEY UK_AREA(area_name)
) ENGINE InnoDB DEFAULT CHARACTER SET UTF8;


CREATE TABLE tb_person_info(
   user_id INT NOT NULL  AUTO_INCREMENT COMMENT '主键',
   name VARCHAR(32) DEFAULT NULL,
   profile_img VARCHAR(1024) DEFAULT NULL ,
  email VARCHAR(1024) DEFAULT NULL ,
  gender INT(2) DEFAULT NULL ,
  enalbe_status INT(2) NOT NULL  DEFAULT 0 COMMENT '0 禁止被使用 1可以使用',
  user_type INT(2) NOT NULL DEFAULT 1 COMMENT '1 顾客，2 店家 3 超级管理员',
  create_time TIMESTAMP NOT NULL DEFAULT current_timestamp,
  update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (user_id)

) ENGINE InnoDB DEFAULT CHARACTER SET UTF8;


CREATE  TABLE tb_wechat_auth(
    wechat_auth_id INT(10) NOT NULL AUTO_INCREMENT,
    user_id INT(10) NOT NULL,
     open_id VARCHAR(1024) NOT NULL ,
     crate_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     PRIMARY KEY (wechat_auth_id),
     CONSTRAINT fk_wechat_profile FOREIGN KEY (user_id) REFERENCES tb_person_info(user_id)
) ENGINE InnoDB DEFAULT CHARACTER SET UTF8;

CREATE TABLE tb_local_auth(
   local_auth_id INT(10) NOT NULL AUTO_INCREMENT,
   user_id INT(10) NOT NULL,
   user_name VARCHAR(128) NOT NULL ,
   password VARCHAR(128) NOT NULL ,
  create_time TIMESTAMP DEFAULT current_timestamp,
  update_time TIMESTAMP DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (local_auth_id),
  UNIQUE KEY  uk_local_profile (user_name),
  CONSTRAINT fk_local_profile FOREIGN KEY (user_id) REFERENCES tb_person_info(user_id)
) ENGINE InnoDB DEFAULT CHARACTER SET UTF8;

CREATE TABLE tb_head_line(
   line_id INT(100) NOT NULL AUTO_INCREMENT,
   line_name VARCHAR(1024) DEFAULT NULL ,
   line_link VARCHAR(1024)  NOT NULL ,
   line_img VARCHAR(1024) NOT NULL,
   priority INT(2) DEFAULT NULL ,
   enable_status INT(2) NOT NULL DEFAULT 0,
   create_time   TIMESTAMP NOT NULL DEFAULT current_timestamp,
   update_time TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (line_id)
) ENGINE InnoDB DEFAULT CHARACTER SET UTF8;


CREATE TABLE tb_phone_auth(
  phone_auth_id INT(10) NOT NULL AUTO_INCREMENT,
  user_id INT(10) NOT NULL,
  phone VARCHAR(128) COLLATE utf8_unicode_ci NOT NULL ,
  PRIMARY KEY (phone_auth_id),
  CONSTRAINT fk_phoneauth_profile FOREIGN KEY (user_id) REFERENCES tb_person_info(user_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `tb_shop_category` (
  `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
  `shop_category_name` varchar(100) NOT NULL DEFAULT '',
  `shop_category_desc` varchar(1000) DEFAULT '',
  `shop_category_img` varchar(2000) DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`shop_category_id`),
  KEY `fk_shop_category_self` (`parent_id`),
  CONSTRAINT `fk_shop_category_self` FOREIGN KEY (`parent_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;


CREATE TABLE `tb_shop` (
  `shop_id` int(10) NOT NULL AUTO_INCREMENT,
  `owner_id` int(10) NOT NULL COMMENT '店铺创建人',
  `area_id` int(5) DEFAULT NULL,
  `shop_category_id` int(11) DEFAULT NULL,
  `parent_category_id` int(11) DEFAULT NULL,
  `shop_name` varchar(256) COLLATE utf8_unicode_ci NOT NULL,
  `shop_desc` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_addr` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `shop_img` varchar(1024) COLLATE utf8_unicode_ci DEFAULT NULL,
  `longitude` double(16,12) DEFAULT NULL,
  `latitude` double(16,12) DEFAULT NULL,
  `priority` int(3) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `enable_status` int(2) NOT NULL DEFAULT '0',
  `advice` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`shop_id`),
  KEY `fk_shop_profile` (`owner_id`),
  KEY `fk_shop_area` (`area_id`),
  KEY `fk_shop_shopcate` (`shop_category_id`),
  KEY `fk_shop_parentcate` (`parent_category_id`),
  CONSTRAINT `fk_shop_area` FOREIGN KEY (`area_id`) REFERENCES `tb_area` (`area_id`),
  CONSTRAINT `fk_shop_parentcate` FOREIGN KEY (`parent_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`),
  CONSTRAINT `fk_shop_profile` FOREIGN KEY (`owner_id`) REFERENCES `tb_person_info` (`user_id`),
  CONSTRAINT `fk_shop_shopcate` FOREIGN KEY (`shop_category_id`) REFERENCES `tb_shop_category` (`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `tb_product_category` (
  product_category_id int(11) NOT NULL AUTO_INCREMENT,
  product_category_name varchar(100) NOT NULL,
  product_category_desc varchar(500) DEFAULT NULL,
  priority int(2) DEFAULT '0',
  create_time datetime DEFAULT NULL,
  update_time datetime DEFAULT NULL,
  shop_id int(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (product_category_id),
  KEY fk_procate_shop (`shop_id`),
  CONSTRAINT fk_procate_shop FOREIGN KEY (shop_id) REFERENCES tb_shop (shop_id)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE tb_product(
  product_id INT(10) NOT NULL  AUTO_INCREMENT,
  product_name VARCHAR(100) NOT NULL,
  product_desc VARCHAR(2000) DEFAULT NULL ,
  img_address VARCHAR(2000) DEFAULT '',
  normal_price VARCHAR(100) DEFAULT NULL ,
  promotion_price VARCHAR(100) DEFAULT NULL ,
  priority INT(2) NOT NULL DEFAULT 0,
  create_time TIMESTAMP DEFAULT current_timestamp,
  update_time TIMESTAMP DEFAULT current_timestamp ON UPDATE CURRENT_TIMESTAMP,
  enable_status INT(2) NOT NULL DEFAULT 0,
  point INT(10) DEFAULT NULL,
  product_category_id INT(11) DEFAULT NULL ,
  shop_id INT(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (product_id),
  KEY fk_product_shop(shop_id),
  KEY fk_product_procate (product_category_id),
  CONSTRAINT fk_product_procate FOREIGN KEY (product_category_id) REFERENCES tb_product_category(product_category_id)
)ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;


SHOW TABLES ;


