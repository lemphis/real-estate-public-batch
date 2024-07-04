DROP TABLE IF EXISTS service.legal;

CREATE TABLE service.legal
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
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='국토교통부 전국 법정동';
