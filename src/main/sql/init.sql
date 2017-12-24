CREATE DATABASE ga_exam;
USE ga_exam;

# 用户表
DROP TABLE IF EXISTS ga_user;
CREATE TABLE ga_user (
  id                       BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT '用户标识',
  username                 VARCHAR(100) NOT NULL
  COMMENT '用户名',
  password                 VARCHAR(100) NOT NULL
  COMMENT '密码',
  name                     VARCHAR(100) NOT NULL
  COMMENT '真实姓名',
  sex                      TINYINT      NOT NULL
  COMMENT '性别，0表示女，1表示男',
  age                      TINYINT      NOT NULL
  COMMENT '年龄',
  phone                    BIGINT       NOT NULL
  COMMENT '联系电话',
  email                    VARCHAR(40)  NOT NULL
  COMMENT '电子邮箱',
  last_password_reset_date TIMESTAMP             DEFAULT current_timestamp
  COMMENT '上次修改密码的日期',
  create_date              TIMESTAMP             DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by                BIGINT       NOT NULL
  COMMENT '创建人',
  enabled                  TINYINT               DEFAULT 1
  COMMENT '是否停用，0表示停用，1表示激活',
  KEY idx_username (username),
  KEY idx_name (name),
  KEY idx_age (age)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT ='用户表';

INSERT INTO ga_user (username, password, name, sex, age, phone, email, create_by, enabled)
VALUES ('admin', '123456', '超级管理员', 1, 23, 18814146666, 'admin@gaexam.com', 1, 1);
INSERT INTO ga_user (username, password, name, sex, age, phone, email, create_by, enabled)
VALUES ('teacher', '123456', '薛老师', 1, 23, 18814146666, 'teacher@gaexam.com', 1, 1);
INSERT INTO ga_user (username, password, name, sex, age, phone, email, create_by, enabled)
VALUES ('student1', '123456', '王同学', 1, 23, 18814146666, 'student@gaexam.com', 1, 1);
INSERT INTO ga_user (username, password, name, sex, age, phone, email, create_by, enabled)
VALUES ('student2', '123456', '李同学', 0, 23, 18814146666, 'student@gaexam.com', 1, 0);

# 角色表
DROP TABLE IF EXISTS ga_role;
CREATE TABLE ga_role (
  id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT '角色标识',
  role_name   VARCHAR(100) NOT NULL
  COMMENT '角色名称',
  authority   VARCHAR(50)           DEFAULT ''
  COMMENT '角色的权限',
  create_date TIMESTAMP             DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT       NOT NULL
  COMMENT '创建人',
  KEY idx_role_name (role_name)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT ='角色表';

INSERT INTO ga_role (role_name, authority, create_by) VALUES ('管理员', 'ADMIN', 1);
INSERT INTO ga_role (role_name, authority, create_by) VALUES ('教师', 'TEACHER', 1);
INSERT INTO ga_role (role_name, authority, create_by) VALUES ('学生', 'STUDENT', 1);

# 用户角色关联表
DROP TABLE IF EXISTS ga_user_role;
CREATE TABLE ga_user_role (
  id      BIGINT NOT NULL AUTO_INCREMENT
  COMMENT '关联关系标识',
  user_id BIGINT NOT NULL
  COMMENT '用户id',
  role_id BIGINT NOT NULL
  COMMENT '角色id',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (role_id) REFERENCES ga_role (id),
  KEY idx_user_id (user_id),
  KEY idx_role_id (role_id),
  KEY idx_user_role_id (user_id, role_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='用户角色关联表';

INSERT INTO ga_user_role (user_id, role_id) VALUES (1, 1), (1, 2), (2, 2), (3, 3);



