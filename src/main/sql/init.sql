CREATE DATABASE gaexam;

USE gaexam;

CREATE TABLE ga_user (
  id          BIGINT       NOT NULL AUTO_INCREMENT PRIMARY KEY
  COMMENT '用户标识',
  username    VARCHAR(100) NOT NULL
  COMMENT '用户名',
  password    VARCHAR(100) NOT NULL
  COMMENT '密码',
  name        VARCHAR(100) NOT NULL
  COMMENT '真实姓名',
  sex         TINYINT      NOT NULL
  COMMENT '性别，0表示女，1表示男',
  age         TINYINT      NOT NULL
  COMMENT '年龄，范围0-255',
  phone       BIGINT       NOT NULL
  COMMENT '联系电话',
  email       VARCHAR(40)  NOT NULL
  COMMENT '电子邮箱',
  create_date DATETIME              DEFAULT current_date
  COMMENT '创建时间',
  create_by   BIGINT       NOT NULL
  COMMENT '创建人',
  enabled     TINYINT               DEFAULT 1
  COMMENT '是否停用，0表示停用，1表示激活',
  KEY idx_username (username),
  KEY idx_name (name),
  KEY idx_age (age)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT ='用户表';

