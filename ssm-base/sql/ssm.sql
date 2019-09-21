/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-06-10 15:42:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
`id`  int(12) NOT NULL AUTO_INCREMENT COMMENT '瑙掕壊ID' ,
`role_name`  varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '瑙掕壊鍚嶇О' ,
`note`  varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '瑙掕壊鏍囨敞' ,
PRIMARY KEY (`id`),
INDEX `ind_roleName` (`role_name`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=2

;

-- ----------------------------
-- Records of t_role
-- ----------------------------
BEGIN;
INSERT INTO `t_role` VALUES ('1', 'MANAGER', 'ROLE');
COMMIT;


DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `id` INT(12) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` VARCHAR(60) NOT NULL COMMENT '用户名称',
	`password` VARCHAR(60) NOT NULL COMMENT '用户密码',
	`sex`	CHAR(1) NOT NULL COMMENT '性别',
	`mobile` VARCHAR(20) NOT NULL COMMENT '手机号码',
	`tel` VARCHAR(20) COMMENT '固定电话',
	`email` VARCHAR(60) COMMENT '邮箱',
  `note` varchar(512) DEFAULT NULL COMMENT '用户标注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES ('1', 'zhangsan', '123456', '0', '13699988874', '0755-88888888', 'zhangsan@l63.com', 'note ..... ..');
COMMIT;

-- ----------------------------
-- Auto increment value for `t_role`
-- ----------------------------
ALTER TABLE `t_role` AUTO_INCREMENT=2;

-- ----------------------------
-- Auto increment value for `t_user`
-- ----------------------------
ALTER TABLE `t_user` AUTO_INCREMENT=2;

# DROP TABLE IF EXISTS t_role;
CREATE TABLE t_role (
	id					INT(12) NOT NULL auto_increment COMMENT '角色ID',
	role_name		VARCHAR(60) NOT NULL COMMENT '角色名称',
	note				VARCHAR(512) COMMENT '角色标注',
	PRIMARY KEY (id),
	INDEX ind_roleName(role_name)
)
DROP TABLE IF EXISTS t_employee_task;
DROP TABLE IF EXISTS t_female_health_form;
DROP TABLE IF EXISTS t_male_health_form;
DROP TABLE IF EXISTS t_work_card;
DROP TABLE IF EXISTS t_task;
DROP TABLE IF EXISTS t_employee;

/*==============================================================*/
/* Table : t_employee */
/*==============================================================*/
CREATE TABLE t_employee(
	id INT (12) NOT NULL AUTO_INCREMENT,
	real_name VARCHAR(60) NOT NULL,
	sex INT(2) NOT NULL COMMENT '1 －男 0 - 女',
	birthday DATE NOT NULL,
	mobile VARCHAR(20) NOT NULL,
	email VARCHAR(60) NOT NULL,
	position VARCHAR(20) NOT NULL,
	note VARCHAR (256),
	PRIMARY KEY (id)
);

/*==============================================================*/
/* Table : t_task */
/*==============================================================*/
CREATE TABLE t_task(
	id INT(12) NOT NULL,
	title VARCHAR(60) NOT NULL,
	context VARCHAR(256) NOT NULL,
	note VARCHAR(256),
	PRIMARY KEY (id)
);

/*==============================================================*/
/* Table: t_employee_task */
/*==============================================================*/
CREATE TABLE t_employee_task(
	id INT(12) NOT NULL,
	emp_id INT(12) NOT NULL,
	task_id INT(12) NOT NULL,
	task_name VARCHAR(60) NOT NULL,
	note VARCHAR (256),
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY FK_Reference_4 (emp_id)
	REFERENCES t_employee(id) ON DELETE RESTRICT ON UPDATE RESTRICT,
	CONSTRAINT FOREIGN KEY FK_Reference_8 (task_id)
	REFERENCES t_task(id) ON DELETE RESTRICT ON UPDATE RESTRICT
)ENGINE = INNODB;

/*==============================================================*/
/* Table: t_female_health_form */
/*==============================================================*/
CREATE TABLE t_female_health_form(
	id INT(12) NOT NULL AUTO_INCREMENT,
	emp_id INT(12) NOT NULL,
	heart VARCHAR(64) NOT NULL,
	liver VARCHAR(64) NOT NULL,
	spleen VARCHAR(64) NOT NULL,
	lung VARCHAR(64) NOT NULL,
	kidney VARCHAR(64) NOT NULL,
	uterus VARCHAR(64) NOT NULL,
	note VARCHAR(256),
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY FK_Reference_5 (emp_id)
	REFERENCES t_employee(id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

/*==============================================================*/
/* Table: t_male_health_form */
/*==============================================================*/
CREATE TABLE t_male_health_form(
	id INT(12) NOT NULL AUTO_INCREMENT,
	emp_id INT(12) NOT NULL,
	heart VARCHAR(64) NOT NULL,
	liver VARCHAR(64) NOT NULL,
	spleen VARCHAR(64) NOT NULL,
	lung VARCHAR(64) NOT NULL,
	kidney VARCHAR(64) NOT NULL ,
	prostate VARCHAR(64) NOT NULL,
	note VARCHAR(256),
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY FK_Reference_6 (emp_id)
	REFERENCES t_employee (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

/*==============================================================*/
/* Table : t_work_card */
/*==============================================================*/
CREATE TABLE t_work_card(
	id INT(12) NOT NULL AUTO_INCREMENT,
	emp_id INT(12) NOT NULl,
	real_name VARCHAR(60) NOT NULL,
	department VARCHAR(20) NOT NULL,
	mobile VARCHAR(20) NOT NULL,
	position VARCHAR(30) NOT NULL,
	note VARCHAR(256),
	PRIMARY KEY (id),
	CONSTRAINT FOREIGN KEY (emp_id)
	REFERENCES t_employee (id) ON DELETE RESTRICT ON UPDATE RESTRICT
);

/*----------------------------------*/
-- 1
INSERT INTO t_user
insert into t_user (id , user_name, `password`, sex, mobile , tel ,email, note)values(1,'zhangsan', '123456','1','13699988874',
'0755-88888888', 'zhangsan@l63.com', 'note ..... ..')

-- 2
alter table t_user modify sex varchar(10);
update t_user set sex = 'FEMALE' where sex = 1;

-- 3
update t_user set sex='0' where sex = 'FEMALE';
update t_user set sex='1' where sex = 'MALE';
alter table t_user modify sex int(10);

