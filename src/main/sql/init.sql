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
  sex                      TINYINT      NOT NULL DEFAULT 1
  COMMENT '性别，0表示女，1表示男',
  age                      TINYINT      NOT NULL DEFAULT ''
  COMMENT '年龄',
  phone                    BIGINT       NOT NULL DEFAULT ''
  COMMENT '联系电话',
  email                    VARCHAR(40)  NOT NULL DEFAULT ''
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
  KEY idx_age (age),
  UNIQUE KEY `uk_user_username` (`username`)
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
  COMMENT '角色的权限CODE',
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

INSERT INTO ga_role (role_name, authority, create_by) VALUES ('管理员', 'ROLE_ADMIN', 1);
INSERT INTO ga_role (role_name, authority, create_by) VALUES ('教师', 'ROLE_TEACHER', 1);
INSERT INTO ga_role (role_name, authority, create_by) VALUES ('学生', 'ROLE_STUDENT', 1);

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

# 角色菜单
DROP TABLE IF EXISTS ga_role_menu;
DROP TABLE IF EXISTS ga_menu;

CREATE TABLE ga_menu (
  id          BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '菜单id',
  parent_id   BIGINT       NOT NULL DEFAULT 0
  COMMENT '父菜单id',
  title       VARCHAR(100) NOT NULL
  COMMENT '菜单主题',
  description VARCHAR(255)          DEFAULT ''
  COMMENT '菜单描述',
  path        VARCHAR(255)          DEFAULT ''
  COMMENT '菜单路径',
  component   VARCHAR(255)          DEFAULT ''
  COMMENT '对应菜单组件',
  url         VARCHAR(255)          DEFAULT ''
  COMMENT '菜单网址（比如百度）',
  icon        VARCHAR(100)          DEFAULT 'ion-navicon-round'
  COMMENT '按钮图标',
  sort        INT(4)                DEFAULT 9999
  COMMENT '菜单排序',
  create_date TIMESTAMP             DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT       NOT NULL DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  KEY idx_parent_id (parent_id),
  KEY idx_order (sort),
  KEY idx_create_date (create_date)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='菜单表';

CREATE TABLE ga_role_menu (
  id          BIGINT NOT NULL AUTO_INCREMENT
  COMMENT '角色菜单关联表id',
  role_id     BIGINT NOT NULL
  COMMENT '角色id',
  menu_id     BIGINT NOT NULL
  COMMENT '菜单id',
  create_date TIMESTAMP       DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT NOT NULL DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES ga_role (id),
  FOREIGN KEY (menu_id) REFERENCES ga_menu (id),
  KEY idx_menu_id (menu_id),
  KEY idx_role_id (role_id),
  KEY idx_role_id_menu_id (role_id, menu_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='角色菜单关联表';

INSERT INTO ga_menu (id, parent_id, title, description, path, icon, `sort`) VALUES
  (1, 0, '仪表盘', '面板', 'dashboard', 'ion-navicon-round', 1),
  (1, 0, '用户管理', '学生、教师以及管理员的管理', '', 'ion-navicon-round', 10),
  (9, 1, '学生管理', '学生信息管理', 'UserManager/studentList', 'ion-navicon-round', 1),
  (10, 1, '教师管理', '教师信息管理', 'UserManager/teacherList', 'ion-navicon-round', 2),
  (11, 1, '系统管理员管理', '系统管理员信息管理', 'UserManager/adminList', 'ion-navicon-round', 3),
  (2, 0, '系统管理', '系统公告、通用数据的管理', '', 'ion-navicon-round', 20),
  (12, 2, '系统公告', '学生信息管理', 'SystemManager/systemNotice', 'ion-navicon-round', 1),
  (13, 2, '通用数据管理', '教师信息管理', 'SystemManager/dataList', 'ion-navicon-round', 2),
  (14, 13, '标签管理', '教师信息管理', 'SystemManager/dataList', 'ion-navicon-round', 1),
  (15, 13, '知识点管理', '教师信息管理', 'SystemManager/dataList', 'ion-navicon-round', 2),
  (16, 13, '科目管理', '教师信息管理', 'SystemManager/dataList', 'ion-navicon-round', 3),
  (17, 13, '院系管理', '教师信息管理', 'SystemManager/dataList', 'ion-navicon-round', 4),
  (3, 0, '题库管理', '题库列表、添加试题、导入试题', 'QuestionsManager/questionsList', 'ion-navicon-round', 30),
  (18, 3, '试题列表', '题库列表、添加试题、导入试题', 'QuestionsManager/questionsList', 'ion-navicon-round', 1),
  (19, 3, '添加试题', '题库列表、添加试题、导入试题', 'QuestionsManager/questionsList', 'ion-navicon-round', 2),
  (20, 3, '试题导入', '题库列表、添加试题、导入试题', 'QuestionsManager/questionsList', 'ion-navicon-round', 3),
  (4, 0, '试卷管理', '试卷列表、组卷、下载试卷', 'PaperManager/paperList', 'ion-navicon-round', 40),
  (21, 4, '试卷列表', '试卷列表、组卷、下载试卷', 'PaperManager/paperList', 'ion-navicon-round', 1),
  (22, 4, '创建试卷', '试卷列表、组卷、下载试卷', 'PaperManager/paperList', 'ion-navicon-round', 2),
  (23, 4, '下载试卷', '试卷列表、组卷、下载试卷', 'PaperManager/paperList', 'ion-navicon-round', 3),
  (5, 0, '考试管理', '考试列表、发布考试', 'ExamManager/examList', 'ion-navicon-round', 50),
  (24, 5, '考试列表', '考试列表、发布考试', 'ExamManager/examList', 'ion-navicon-round', 1),
  (25, 5, '发布考试', '考试列表、发布考试', 'ExamManager/examList', 'ion-navicon-round', 2),
  (6, 0, '评估调整', '试卷评估、系数调整', 'AnalyticalAdjust/paperAnalytical', 'ion-navicon-round', 60),
  (26, 6, '试卷评估', '试卷评估、系数调整', 'AnalyticalAdjust/paperAnalytical', 'ion-navicon-round', 1),
  (27, 6, '系数调整', '试卷评估、系数调整', 'AnalyticalAdjust/paperAnalytical', 'ion-navicon-round', 2),
  (7, 0, '考试记录', '考试历史、错题本、统计分析', 'ExamRecord/examHistory', 'ion-navicon-round', 70),
  (28, 7, '考试历史', '考试历史、错题本、统计分析', 'ExamRecord/examHistory', 'ion-navicon-round', 1),
  (29, 7, '错题本', '考试历史、错题本、统计分析', 'ExamRecord/examHistory', 'ion-navicon-round', 2),
  (30, 7, '统计分析', '考试历史、错题本、统计分析', 'ExamRecord/examHistory', 'ion-navicon-round', 3),
  (8, 0, '个人设置', '修改基本资料、修改密码', 'Setting/updateInfomation', 'ion-navicon-round', 80),
  (31, 8, '修改资料', '修改基本资料、修改密码', 'Setting/updateInfomation', 'ion-navicon-round', 1),
  (32, 8, '修改密码', '修改基本资料、修改密码', 'Setting/updateInfomation', 'ion-navicon-round', 2);

CREATE TABLE ga_academy (
  id           BIGINT    AUTO_INCREMENT
  COMMENT '学院id',
  academy_name VARCHAR(50) NOT NULL
  COMMENT '学院名称',
  create_date  TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by    BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='学院信息表';

CREATE TABLE ga_class (
  id             BIGINT               AUTO_INCREMENT
  COMMENT '班级id',
  class_name     VARCHAR(50) NOT NULL
  COMMENT '班级名称',
  academy_id     BIGINT      NOT NULL
  COMMENT '所属学院',
  student_number INT(4)      NOT NULL DEFAULT 0
  COMMENT '班级人数',
  create_date    TIMESTAMP            DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by      BIGINT               DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (academy_id) REFERENCES ga_academy (id),
  KEY idx_academy_id (academy_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='班级信息表';


CREATE TABLE ga_student (
  id          BIGINT       AUTO_INCREMENT
  COMMENT '学员id',
  user_id     BIGINT      NOT NULL
  COMMENT '用户id',
  grade       VARCHAR(100) DEFAULT ''
  COMMENT '第几级',
  class_id    BIGINT COMMENT '班级id',
  academy_id  BIGINT COMMENT '学院id',
  student_no  VARCHAR(32) NOT NULL
  COMMENT '学号',
  create_date TIMESTAMP    DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT       DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (class_id) REFERENCES ga_class (id),
  FOREIGN KEY (academy_id) REFERENCES ga_academy (id),
  KEY idx_class_id (class_id),
  KEY idx_academy_id (academy_id),
  KEY idx_academy_id_class_id (academy_id, class_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='学生信息表';

CREATE TABLE ga_teacher (
  id          BIGINT       AUTO_INCREMENT
  COMMENT '教师id',
  user_id     BIGINT NOT NULL
  COMMENT '用户id',
  academy_id  BIGINT COMMENT '学院id',
  title       VARCHAR(100) DEFAULT ''
  COMMENT '职称',
  create_date TIMESTAMP    DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT       DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (academy_id) REFERENCES ga_academy (id),
  KEY idx_user_id (user_id),
  KEY idx_academy_id (academy_id),
  KEY idx_academy_id_user_id (academy_id, user_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='教师信息表';


CREATE TABLE ga_question_type (
  id          BIGINT    AUTO_INCREMENT
  COMMENT '试题类型id',
  type_name   VARCHAR(50) NOT NULL
  COMMENT '试题类型名称',
  subjective  TINYINT COMMENT '是否是主观题，0代表客观题，1代表主观题',
  create_date TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='试题类型表';

CREATE TABLE ga_course (
  id          BIGINT    AUTO_INCREMENT
  COMMENT '课程id',
  course_name VARCHAR(50) NOT NULL
  COMMENT '课程名称',
  teacher_id  BIGINT      NOT NULL
  COMMENT '课程所属教师',
  create_date TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (teacher_id) REFERENCES ga_teacher (id),
  KEY idx_teacher_id (teacher_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='课程信息表';

CREATE TABLE ga_knowledge (
  id             BIGINT    AUTO_INCREMENT
  COMMENT '知识点id',
  knowledge_name VARCHAR(50) NOT NULL
  COMMENT '知识点名称',
  course_id      BIGINT      NOT NULL
  COMMENT '知识点所属课程',
  create_date    TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by      BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES ga_course (id),
  KEY idx_course_id (course_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='知识点信息表';

CREATE TABLE ga_question (
  id               BIGINT    AUTO_INCREMENT
  COMMENT '试题id',
  stem             VARCHAR(255) NOT NULL
  COMMENT '试题名称',
  content          TEXT         NOT NULL
  COMMENT '试题内容',
  question_type_id BIGINT       NOT NULL
  COMMENT '试题类型id',
  course_id        BIGINT       NOT NULL
  COMMENT '所属课程id',
  knowledge_ids    VARCHAR(255) NOT NULL
  COMMENT '知识点id，格式为1,2,3',
  difficulty       FLOAT(5, 2)  NOT NULL
  COMMENT '难度系数',
  answer           TEXT         NOT NULL
  COMMENT '试题答案',
  analysis         TEXT         NOT NULL
  COMMENT '答案解析',
  create_date      TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by        BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES ga_course (id),
  FOREIGN KEY (question_type_id) REFERENCES ga_question_type (id),
  KEY idx_course_id (course_id),
  KEY idx_question_type_id (question_type_id),
  KEY idx_course_question_type_id (course_id, question_type_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='试题表';


CREATE TABLE ga_rule (
  id                BIGINT AUTO_INCREMENT
  COMMENT '规则id',
  rule_type         TINYINT      NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         DEFAULT 1
  COMMENT '组卷方式，0为手动，1为自动',
  question_info     TEXT         NOT NULL
  COMMENT '试题信息，根据组卷方式有不同格式，手动组卷包含（questionId,questionType,score），自动组卷包括（questionType, number，score）',
  total_score       FLOAT(5, 2)  NOT NULL DEFAULT 0
  COMMENT '试卷总分',
  exp_difficulty    FLOAT(5, 2) COMMENT '期望难度系数',
  exp_knowledge_ids VARCHAR(255) NOT NULL
  COMMENT '期望覆盖知识点id，格式为1,2,3',
  course_id         BIGINT       NOT NULL
  COMMENT '期望覆盖知识点所属课程id',
  create_date       TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by         BIGINT DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES ga_course (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='组卷规则表';

CREATE TABLE ga_paper (
  id                 BIGINT AUTO_INCREMENT
  COMMENT '试卷id',
  paper_name         VARCHAR(255)  NOT NULL
  COMMENT '试卷名称',
  question_ids       VARCHAR(255)  NOT NULL
  COMMENT '试题id，格式为1,2,3',
  knowledge_ids      VARCHAR(255)  NOT NULL
  COMMENT '知识点id，格式为1,2,3',
  duration           INT           NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       DEFAULT 0
  COMMENT '建议考试时长',
  pass_score         FLOAT(5, 2)   NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       DEFAULT 60
  COMMENT '试卷及格分',
  status             TINYINT       NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       DEFAULT 0
  COMMENT '试卷状态，0未完成 -> 1已完成 -> 2已发布 （已发布的无法再修改）',
  subjective         TINYINT       NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       DEFAULT 1
  COMMENT '为1表示为包含主观题的试卷，需阅卷',
  description        VARCHAR(1000) NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                DEFAULT ''
  COMMENT '试卷描述',
  difficulty         FLOAT(5, 2)   NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                DEFAULT 0
  COMMENT '难度系数',
  adaptation_degree  FLOAT(5, 2) COMMENT '适应度',
  knowledge_coverage FLOAT(5, 2) COMMENT '知识点覆盖率',
  course_id          BIGINT        NOT NULL
  COMMENT '所属课程id',
  rule_id            BIGINT        NOT NULL
  COMMENT '所属课程id',
  create_date        TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by          BIGINT DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (course_id) REFERENCES ga_course (id),
  FOREIGN KEY (rule_id) REFERENCES ga_rule (id),
  KEY idx_course_id (course_id),
  KEY idx_rule_id (rule_id),
  KEY idx_paper_name (paper_name)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='试卷表';

CREATE TABLE ga_exam_room (
  id          BIGINT    AUTO_INCREMENT
  COMMENT '考场id',
  seating     INT(4)      NOT NULL
  COMMENT '座位数',
  room_no     VARCHAR(50) NOT NULL
  COMMENT '考场编号',
  create_date TIMESTAMP DEFAULT current_timestamp
  COMMENT '创建时间',
  create_by   BIGINT    DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考场表';

CREATE TABLE ga_exam (
  id                 BIGINT                AUTO_INCREMENT
  COMMENT '考试id',
  exam_name          VARCHAR(255) NOT NULL
  COMMENT '考试名称',
  paper_id           BIGINT       NOT NULL
  COMMENT '试卷id',
  status             TINYINT      NOT NULL
  COMMENT '考试状态，0未开始->1进行中->2已结束',
  start_date         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP
  COMMENT '考试开始时间',
  end_date           TIMESTAMP             DEFAULT CURRENT_TIMESTAMP
  COMMENT '考试结束时间',
  exam_room_ids      VARCHAR(255) NOT NULL
  COMMENT '考场id，格式为1,2,3',
  exam_classes       VARCHAR(255) NOT NULL
  COMMENT '班级id，格式为1,2,3',
  total_exam_number  INT(4)       NOT NULL
  COMMENT '考试总人数',
  exam_room_capacity INT(4)       NOT NULL
  COMMENT '考场总容量',
  create_date        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by          BIGINT                DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (paper_id) REFERENCES ga_paper (id),
  KEY idx_status (status),
  KEY idx_end_date(end_date),
  KEY idx_start_end_date (start_date, end_date)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考试表';

CREATE TABLE ga_user_exam_record (
  id               BIGINT               AUTO_INCREMENT
  COMMENT '记录id',
  user_id          BIGINT      NOT NULL
  COMMENT '考生id',
  paper_id         BIGINT      NOT NULL
  COMMENT '试卷id',
  exam_id          BIGINT      NOT NULL
  COMMENT '考试id',
  exam_room_no     VARCHAR(50) NOT NULL
  COMMENT '考场编号',
  exam_seat_no     INT(4)      NOT NULL
  COMMENT '考场座位号',
  status           TINYINT     NOT NULL
  COMMENT '考试状态, ，0等待考试，1考试进行中，2考试中途退出, 3考试完成',
  result           TINYINT COMMENT '考试结果，0未参与，1不及格，2及格，3等待结果中',
  subjective_score FLOAT(5, 2)          DEFAULT 0
  COMMENT '主观题得分',
  objective_score  FLOAT(5, 2)          DEFAULT 0
  COMMENT '客观题得分',
  begin_date       DATETIME COMMENT '开始考试时间',
  finished_date    DATETIME COMMENT '结束考试时间',
  answer_sheet     TEXT COMMENT '答题卡',
  create_date      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by        BIGINT               DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (paper_id) REFERENCES ga_paper (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (exam_id) REFERENCES ga_exam (id),
  KEY idx_status (status),
  KEY idx_exam_room_no(exam_room_no),
  UNIQUE KEY `pk_user_exam_paper` (`user_id`, `exam_id`, `paper_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考生考试记录表';

CREATE TABLE ga_notice (
  id          BIGINT                                                                                                                                                                                       AUTO_INCREMENT
  COMMENT '公告id',
  title   VARCHAR(255)  NOT NULL                                                                                                                                                                        DEFAULT ''
  COMMENT '标题',
  content VARCHAR(3000) NOT NULL                                                                                                                                                                       DEFAULT ''
  COMMENT '公告内容',
  #   read_count     INT(4)      NOT NULL DEFAULT 0
  #   COMMENT '阅读量',
  create_date TIMESTAMP NOT NULL                                                                                                                                                                           DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by   BIGINT                                                                                                                                                                                       DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='公告表';

CREATE TABLE ga_user_question_record (
  id             BIGINT               AUTO_INCREMENT
  COMMENT '记录id',
  user_id BIGINT             NOT NULL
  COMMENT '考生id',
  exam_id BIGINT NOT NULL
  COMMENT '考试id',
  question_id BIGINT NOT NULL
  COMMENT '试题id',
  question_score FLOAT(5, 2) NOT NULL DEFAULT 0
  COMMENT '试题分数',
  gain_score     FLOAT(5, 2) NOT NULL DEFAULT 0
  COMMENT '获得分数',
  is_right       TINYINT     NOT NULL DEFAULT -1
  COMMENT '是否正确, -1表示初始值，0不正确，1正确',
  subjective     TINYINT COMMENT '是否是主观题，0代表客观题，1代表主观题',
  create_date    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by      BIGINT               DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (exam_id) REFERENCES ga_exam (id),
  FOREIGN KEY (question_id) REFERENCES ga_question (id),
  UNIQUE KEY `pk_user_exam_question` (`user_id`, `exam_id`, question_id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考生试题作答记录表';


CREATE TABLE ga_student_card (
  id          BIGINT             AUTO_INCREMENT
  COMMENT '记录id',
  card_no VARCHAR(64)   NOT NULL
  COMMENT '卡号',
  user_id BIGINT      NOT NULL
  COMMENT '用户id',
  student_id BIGINT   NOT NULL
  COMMENT '学生id',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by   BIGINT             DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  KEY index_card_no (card_no),
  FOREIGN KEY (student_id) REFERENCES ga_student (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  UNIQUE KEY `pk_student_card_no` (`student_id`, `card_no`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='学生卡片关联表';

CREATE TABLE ga_exam_sign_in (
  id          BIGINT             AUTO_INCREMENT
  COMMENT '记录id',
  exam_id BIGINT        NOT NULL
  COMMENT '考试id',
  room_no VARCHAR(50) NOT NULL
  COMMENT '考场编号',
  card_no VARCHAR(64) NOT NULL
  COMMENT '卡号',
  user_id BIGINT      NOT NULL
  COMMENT '用户id',
  student_id BIGINT   NOT NULL
  COMMENT '学生id',
  create_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  create_by   BIGINT             DEFAULT 1
  COMMENT '创建人',
  PRIMARY KEY (id),
  KEY index_card_no (card_no),
  FOREIGN KEY (student_id) REFERENCES ga_student (id),
  FOREIGN KEY (user_id) REFERENCES ga_user (id),
  FOREIGN KEY (exam_id) REFERENCES ga_exam (id)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT ='考试签到表';

