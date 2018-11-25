CREATE SEQUENCE SEQ_ID INCREMENT  1 START WITH 1;

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS country;
CREATE TABLE country (
  id BIGINT PRIMARY KEY,
  countryname varchar(255) DEFAULT NULL,
  countrycode varchar(255) DEFAULT NULL
);

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO country VALUES ('1', '中国', 'CN');
INSERT INTO country VALUES ('2', '美国', 'US');
INSERT INTO country VALUES ('3', '俄罗斯', 'RU');
INSERT INTO country VALUES ('4', '英国', 'GB');
INSERT INTO country VALUES ('5', '法国', 'FR');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS sys_dict;
CREATE TABLE sys_dict (
  id bigint PRIMARY KEY,
  code varchar(64) NOT NULL,
  name varchar(64) NOT NULL,
  value varchar(64) NOT NULL
);

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO sys_dict VALUES ('1', '性别', '男', '男');
INSERT INTO sys_dict VALUES ('2', '性别', '女', '女');
INSERT INTO sys_dict VALUES ('3', '季度', '第一季度', '1');
INSERT INTO sys_dict VALUES ('4', '季度', '第二季度', '2');
INSERT INTO sys_dict VALUES ('5', '季度', '第三季度', '3');
INSERT INTO sys_dict VALUES ('6', '季度', '第四季度', '4');

-- ----------------------------
-- Table structure for sys_privilege
-- ----------------------------
DROP TABLE IF EXISTS sys_privilege;
CREATE TABLE sys_privilege (
  id bigint PRIMARY KEY ,
  privilege_name varchar(50) DEFAULT NULL,
  privilege_url varchar(200) DEFAULT NULL
);

-- ----------------------------
-- Records of sys_privilege
-- ----------------------------
INSERT INTO sys_privilege VALUES ('1', '用户管理', '/users');
INSERT INTO sys_privilege VALUES ('2', '角色管理', '/roles');
INSERT INTO sys_privilege VALUES ('3', '系统日志', '/logs');
INSERT INTO sys_privilege VALUES ('4', '人员维护', '/persons');
INSERT INTO sys_privilege VALUES ('5', '单位维护', '/companies');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role (
  id bigint PRIMARY KEY,
  role_name varchar(50) DEFAULT NULL,
  enabled BIGINT DEFAULT NULL,
  create_by bigint DEFAULT NULL,
  create_time TIMESTAMP DEFAULT NULL
);

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO sys_role VALUES ('1', '管理员', '1', '1', '2016-04-01 17:02:14');
INSERT INTO sys_role VALUES ('2', '普通用户', '1', '1', '2016-04-01 17:02:34');

-- ----------------------------
-- Table structure for sys_role_privilege
-- ----------------------------
DROP TABLE IF EXISTS sys_role_privilege;
CREATE TABLE sys_role_privilege (
  role_id bigint DEFAULT NULL,
  privilege_id bigint DEFAULT NULL
);

-- ----------------------------
-- Records of sys_role_privilege
-- ----------------------------
INSERT INTO sys_role_privilege VALUES ('1', '1');
INSERT INTO sys_role_privilege VALUES ('1', '3');
INSERT INTO sys_role_privilege VALUES ('1', '2');
INSERT INTO sys_role_privilege VALUES ('2', '4');
INSERT INTO sys_role_privilege VALUES ('2', '5');


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id bigint PRIMARY KEY ,
  user_name varchar(50) DEFAULT NULL ,
  user_password varchar(50) DEFAULT NULL,
  user_email varchar(50) DEFAULT 'test@mybatis.tk',
  user_info text,
  head_img VARCHAR(100) ,
  create_time timestamp  DEFAULT NULL
) ;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES ('1', 'admin', '123456', 'admin@mybatis.tk', '管理员用户', 'Do', '2016-06-07 01:11:12');
INSERT INTO sys_user VALUES ('1001', 'test', '123456', 'test@mybatis.tk', '测试用户', 'Jiang', '2016-06-07 00:00:00');
-- -----------------------

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role (
  user_id bigint DEFAULT NULL ,
  role_id bigint DEFAULT NULL
) ;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO sys_user_role VALUES ('1', '1');
INSERT INTO sys_user_role VALUES ('1', '2');
INSERT INTO sys_user_role VALUES ('1001', '2');

-- ----------------------------
-- Table structure for user info
-- ----------------------------
DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info (
  id BIGINT NOT NULL,
  PRIMARY KEY (id)
);

-- ----------------------------
-- Records of user info
-- ----------------------------
