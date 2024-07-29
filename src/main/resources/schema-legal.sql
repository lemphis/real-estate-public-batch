DROP TABLE IF EXISTS service.legal_api;
DROP TABLE IF EXISTS service.legal_file;

CREATE TABLE service.legal_api
(
    `법정동코드`   VARCHAR(10) NOT NULL COMMENT '법정동코드',
    `시도명`     VARCHAR(10) NOT NULL COMMENT '시도명',
    `시군구명`    VARCHAR(10) DEFAULT NULL COMMENT '시군구명',
    `읍면동명`    VARCHAR(10) DEFAULT NULL COMMENT '읍면동명',
    `리명`      VARCHAR(10) DEFAULT NULL COMMENT '리명',
    `순위`      INTEGER     NOT NULL COMMENT '순위',
    `삭제일자`    VARCHAR(10) DEFAULT NULL COMMENT '삭제일자',
    `생성일자`    VARCHAR(10) DEFAULT NULL COMMENT '생성일자',
    `과거법정동코드` VARCHAR(10) DEFAULT NULL COMMENT '과거법정동코드',
    PRIMARY KEY (`법정동코드`)
) ENGINE = InnoDB COMMENT '국토교통부 전국 법정동';

CREATE TABLE service.legal_file
(
    `code`      CHAR(10)    NOT NULL COMMENT '법정동코드',
    `name`      VARCHAR(70) NOT NULL COMMENT '법정동명',
    `is_active` TINYINT     NOT NULL DEFAULT 1 COMMENT '사용여부',
    PRIMARY KEY (`code`)
) ENGINE = InnoDB COMMENT '행정표준코드관리시스템 법정동코드';


