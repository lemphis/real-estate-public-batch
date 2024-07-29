DROP TABLE IF EXISTS service.land;

CREATE TABLE service.land
(
    `고유번호`      CHAR(19)       NOT NULL COMMENT '고유번호',
    `법정동코드`     CHAR(10)       NOT NULL COMMENT '법정동코드',
    `법정동명`      VARCHAR(100) DEFAULT NULL COMMENT '법정동명',
    `지번`        VARCHAR(9)     NOT NULL COMMENT '지번',
    `대장구분코드`    CHAR(1)        NOT NULL COMMENT '대장구분코드',
    `대장구분명`     CHAR(4)        NOT NULL COMMENT '대장구분명',
    `지목코드`      VARCHAR(2)     NOT NULL COMMENT '지목코드',
    `지목명`       VARCHAR(5)     NOT NULL COMMENT '지목명',
    `면적`        DECIMAL(15, 5) NOT NULL COMMENT '면적',
    `소유구분코드`    VARCHAR(2)   DEFAULT NULL COMMENT '소유구분코드',
    `소유구분명`     VARCHAR(15)  DEFAULT NULL COMMENT '소유구분명',
    `소유인수`      INTEGER      DEFAULT NULL COMMENT '소유(공유)인수',
    `축척구분코드`    VARCHAR(2)   DEFAULT NULL COMMENT '축척구분코드',
    `축척구분명`     VARCHAR(6)   DEFAULT NULL COMMENT '축척구분명',
    `데이터기준일자`   DATE           NOT NULL COMMENT '데이터기준일자',
    `원천시도시군구코드` CHAR(5)        NOT NULL COMMENT '원천시도시군구코드',
    PRIMARY KEY (`고유번호`)
) ENGINE = InnoDB COMMENT '토지임야정보';
