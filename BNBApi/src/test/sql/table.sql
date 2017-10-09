CREATE TABLE user_info
(
   TENANT_ID      varchar(35) NOT NULL,
   USER_ID        varchar(35) NOT NULL,
   PASSWORD       varchar(128) NOT NULL,
   USER_NAME      varchar(120) NOT NULL,
   DEPT_ID        varchar(35) DEFAULT NULL,
   DEPT_NAME      varchar(200) DEFAULT NULL,
   PICTURE_URL    varchar(256) DEFAULT NULL,
   POS_ID         varchar(35) DEFAULT NULL,
   RANK_ID        varchar(35) DEFAULT NULL,
   DUTY_ID        varchar(35) DEFAULT NULL,
   PRIMARY KEY(TENANT_ID, USER_ID)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE rank
(
   tenant_id        varchar(35) NOT NULL,
   rank_id          varchar(35) NOT NULL,
   rank_level       smallint(6) DEFAULT NULL,
   rank_name        varchar(120) DEFAULT NULL,
   rank_code        varchar(40) DEFAULT NULL,
   rank_name_eng    varchar(120) DEFAULT NULL,
   PRIMARY KEY(tenant_id, rank_id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE pos
(
   tenant_id       varchar(35) NOT NULL,
   pos_id          varchar(35) NOT NULL,
   sec_level       smallint(6) NOT NULL DEFAULT '0',
   pos_name        varchar(120) NOT NULL,
   pos_code        varchar(20) DEFAULT NULL,
   link_id         varchar(35) DEFAULT NULL,
   pos_name_eng    varchar(120) DEFAULT NULL,
   PRIMARY KEY(tenant_id, pos_id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE duty
(
   tenant_id    varchar(35) NOT NULL,
   duty_id      varchar(35) NOT NULL,
   seq          smallint(6) NOT NULL,
   duty_name    varchar(120) NOT NULL,
   duty_code    varchar(40) DEFAULT NULL,
   PRIMARY KEY(tenant_id, duty_id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE dept_info
(
   tenant_id        varchar(35) NOT NULL,
   dept_id          varchar(35) NOT NULL,
   dept_name        varchar(200) NOT NULL,
   par_id           varchar(35) NOT NULL,
   dept_code        varchar(20) DEFAULT NULL,
   seq              smallint(6) NOT NULL,
   status           char(1) NOT NULL DEFAULT '1',
   e_mail           varchar(128) DEFAULT NULL,
   link_id          varchar(35) DEFAULT NULL,
   dept_name_eng    varchar(200) DEFAULT NULL,
   comp_id          varchar(35) NOT NULL,
   modified_date    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY(tenant_id, dept_id)
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;

CREATE TABLE tenant_info
(
   tenant_id            varchar(35) NOT NULL,
   name                 varchar(60) NOT NULL,
   alias                varchar(60) NOT NULL,
   web_port             varchar(10) NOT NULL,
   firewall_web_port    varchar(10) NOT NULL,
   phone                varchar(40) DEFAULT NULL,
   fax                  varchar(40) DEFAULT NULL,
   home_url             varchar(128) DEFAULT NULL,
   e_mail               varchar(128) DEFAULT NULL,
   max_user             int(11) DEFAULT NULL,
   expiry_date          date DEFAULT NULL,
   default_locale       varchar(5) DEFAULT 'ko_KR',
   manager_id           varchar(35) DEFAULT NULL
)
ENGINE = InnoDB
DEFAULT CHARSET = utf8;