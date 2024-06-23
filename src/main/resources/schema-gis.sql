DROP TABLE IF EXISTS service.building_polygon;
DROP TABLE IF EXISTS service.land_polygon;

CREATE TABLE service.building_polygon
(
    id            BIGINT AUTO_INCREMENT NOT NULL COMMENT 'PK',
    `polygon`     MULTIPOLYGON    DEFAULT NULL COMMENT 'polygon',
    `원천도형ID`      INTEGER         DEFAULT NULL COMMENT '원천도형ID',
    `GIS건물통합식별번호` CHAR(28)              NOT NULL COMMENT 'GIS건물통합식별번호',
    `고유번호`        CHAR(19)              NOT NULL COMMENT '고유번호',
    `법정동코드`       CHAR(10)              NOT NULL COMMENT '법정동코드',
    `법정동명`        VARCHAR(254)    DEFAULT NULL COMMENT '법정동명',
    `지번`          VARCHAR(10)           NOT NULL COMMENT '지번',
    `특수지코드`       CHAR(1)               NOT NULL COMMENT '특수지코드',
    `특수지구분명`      VARCHAR(254)          NOT NULL COMMENT '특수지구분명',
    `건축물용도코드`     VARCHAR(5)      DEFAULT NULL COMMENT '건축물용도코드',
    `건축물용도명`      VARCHAR(254)    DEFAULT NULL COMMENT '건축물용도명',
    `건축물구조코드`     CHAR(2)         DEFAULT NULL COMMENT '건축물구조코드',
    `건축물구조명`      VARCHAR(254)    DEFAULT NULL COMMENT '건축물구조명',
    `건축물면적`       DECIMAL(32, 15) DEFAULT NULL COMMENT '건축물면적',
    `사용승인일자`      DATE            DEFAULT NULL COMMENT '사용승인일자',
    `연면적`         DECIMAL(32, 15) DEFAULT NULL COMMENT '연면적',
    `대지면적`        DECIMAL(32, 15) DEFAULT NULL COMMENT '대지면적',
    `높이`          DECIMAL(32, 15) DEFAULT NULL COMMENT '높이',
    `건폐율`         DECIMAL(32, 15) DEFAULT NULL COMMENT '건폐율',
    `용적율`         DECIMAL(32, 15) DEFAULT NULL COMMENT '용적율',
    `건축물ID`       VARCHAR(28)     DEFAULT NULL COMMENT '건축물ID',
    `위반건축물여부`     VARCHAR(2)      DEFAULT NULL COMMENT '위반건축물여부',
    `참조체계연계키`     CHAR(17)        DEFAULT NULL COMMENT '참조체계연계키',
    `데이터기준일자`     DATE                  NOT NULL COMMENT '데이터기준일자',
    `원천시도시군구코드`   CHAR(5)               NOT NULL COMMENT '원천시도시군구코드',
    `건물명`         VARCHAR(254)    DEFAULT NULL COMMENT '건물명',
    `건물동명`        VARCHAR(254)    DEFAULT NULL COMMENT '건물동명',
    `지상층수`        INTEGER         DEFAULT NULL COMMENT '지상층수',
    `지하층수`        INTEGER         DEFAULT NULL COMMENT '지하층수',
    `데이터생성변경일자`   DATE            DEFAULT NULL COMMENT '데이터생성변경일자',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = 'GIS건물통합정보';

CREATE TABLE service.land_polygon
(
    `고유번호`      CHAR(19)     NOT NULL COMMENT '고유번호',
    `polygon`   MULTIPOLYGON    DEFAULT NULL COMMENT 'polygon',
    `법정동코드`     CHAR(10)     NOT NULL COMMENT '법정동코드',
    `법정동명`      VARCHAR(254) NOT NULL COMMENT '법정동명',
    `대장구분코드`    CHAR(1)      NOT NULL COMMENT '대장구분코드',
    `대장구분명`     VARCHAR(20)  NOT NULL COMMENT '대장구분명',
    `지번`        VARCHAR(10)  NOT NULL COMMENT '지번',
    `지번지목부호`    VARCHAR(200)    DEFAULT NULL COMMENT '지번지목부호',
    `기준연도`      CHAR(4)         DEFAULT NULL COMMENT '기준연도',
    `기준월`       CHAR(2)         DEFAULT NULL COMMENT '기준월',
    `개별공시지가`    INTEGER         DEFAULT NULL COMMENT '공시지가',
    `표준지여부`     CHAR(1)         DEFAULT NULL COMMENT '표준지여부',
    `지목코드`      VARCHAR(2)      DEFAULT NULL COMMENT '지목코드',
    `지목`        VARCHAR(20)     DEFAULT NULL COMMENT '지목',
    `토지면적`      DECIMAL(32, 15) DEFAULT NULL COMMENT '토지면적',
    `데이터기준일자`   DATE         NOT NULL COMMENT '데이터기준일자',
    `원천시도시군구코드` CHAR(5)      NOT NULL COMMENT '원천시도시군구코드',
    `과년도1공시지가`  INTEGER         DEFAULT NULL COMMENT '과년도1공시지가',
    `과년도2공시지가`  INTEGER         DEFAULT NULL COMMENT '과년도2공시지가',
    `과년도3공시지가`  INTEGER         DEFAULT NULL COMMENT '과년도3공시지가',
    `과년도4공시지가`  INTEGER         DEFAULT NULL COMMENT '과년도4공시지가',
    PRIMARY KEY (`고유번호`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '개별공시지가공간정보';

CREATE TABLE service.legal_polygon
(
    `법정동코드`     VARCHAR(10)  NOT NULL COMMENT '법정동코드',
    `polygon`   MULTIPOLYGON NOT NULL COMMENT 'polygon',
    `원천도형ID`    INTEGER      NOT NULL COMMENT '원천도형ID',
    `지역명`       VARCHAR(20) DEFAULT NULL COMMENT '지역명',
    `데이터기준일자`   VARCHAR(10)  NOT NULL COMMENT '데이터기준일자',
    `원천시도시군구코드` CHAR(5)      NOT NULL COMMENT '원천시도시군구코드',
    PRIMARY KEY (`법정동코드`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT = '법정구역정보';
