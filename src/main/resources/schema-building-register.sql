DROP TABLE IF EXISTS service.summary;
DROP TABLE IF EXISTS service.complex;
DROP TABLE IF EXISTS service.building;
DROP TABLE IF EXISTS service.unit;
DROP TABLE IF EXISTS service.area;
DROP TABLE IF EXISTS service.floor;
DROP TABLE IF EXISTS service.sub_land;
DROP TABLE IF EXISTS service.land_regulation;

CREATE TABLE service.summary
(
    `관리건축물대장PK`   VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `관리상위건축물대장PK` VARCHAR(33)  DEFAULT NULL COMMENT '관리상위건축물대장PK [VARCHAR(33)]',
    `대장구분코드`      CHAR(1)      DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`     VARCHAR(100) DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`      CHAR(1)      DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`     VARCHAR(100) DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `대지위치`        VARCHAR(500) DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`     VARCHAR(400) DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`         VARCHAR(100) DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`       CHAR(5)     NOT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`       CHAR(5)     NOT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`      CHAR(1)      DEFAULT NULL COMMENT '대지구분코드 [CHAR(1)]',
    `번`           VARCHAR(4)   DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`           VARCHAR(4)   DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`        VARCHAR(200) DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`          VARCHAR(20)  DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`          VARCHAR(20)  DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `외필지수`        INTEGER      DEFAULT NULL COMMENT '외필지수 [NUMERIC(5)]',
    `새주소도로코드`     VARCHAR(12)  DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`    VARCHAR(5)   DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드`   CHAR(1)      DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`       INTEGER      DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`       INTEGER      DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `지역코드`        VARCHAR(6)   DEFAULT NULL COMMENT '지역코드 [VARCHAR(6)]',
    `지구코드`        VARCHAR(6)   DEFAULT NULL COMMENT '지구코드 [VARCHAR(6)]',
    `구역코드`        VARCHAR(6)   DEFAULT NULL COMMENT '구역코드 [VARCHAR(6)]',
    `지역코드명`       VARCHAR(100) DEFAULT NULL COMMENT '지역코드명 [VARCHAR(100)]',
    `지구코드명`       VARCHAR(100) DEFAULT NULL COMMENT '지구코드명 [VARCHAR(100)]',
    `구역코드명`       VARCHAR(100) DEFAULT NULL COMMENT '구역코드명 [VARCHAR(100)]',
    `생성일자`        VARCHAR(8)   DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 기본개요';

CREATE TABLE service.complex
(
    `관리건축물대장PK`  VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대장구분코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `신구대장구분코드`   VARCHAR(1)     DEFAULT NULL COMMENT '신구대장구분코드 [VARCHAR(1)]',
    `신구대장구분코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '신구대장구분코드명 [VARCHAR(100)]',
    `대지위치`       VARCHAR(500)   DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`    VARCHAR(400)   DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`        VARCHAR(100)   DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`      VARCHAR(5)     DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`      VARCHAR(5)     DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`          VARCHAR(4)     DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`          VARCHAR(4)     DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`       VARCHAR(200)   DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`         VARCHAR(20)    DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`         VARCHAR(20)    DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `외필지수`       INTEGER        DEFAULT NULL COMMENT '외필지수 [NUMERIC(5)]',
    `새주소도로코드`    VARCHAR(12)    DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`   VARCHAR(5)     DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드`  VARCHAR(1)     DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`      INTEGER        DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`      INTEGER        DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `대지면적`       DECIMAL(19, 9) DEFAULT NULL COMMENT '대지면적 [NUMERIC(19,9)]',
    `건축면적`       DECIMAL(19, 9) DEFAULT NULL COMMENT '건축면적 [NUMERIC(19,9)]',
    `건폐율`        DECIMAL(19, 9) DEFAULT NULL COMMENT '건폐율 [NUMERIC(19,9)]',
    `연면적`        DECIMAL(19, 9) DEFAULT NULL COMMENT '연면적 [NUMERIC(19,9)]',
    `용적률산정연면적`   DECIMAL(19, 9) DEFAULT NULL COMMENT '용적률산정연면적 [NUMERIC(19,9)]',
    `용적률`        DECIMAL(19, 9) DEFAULT NULL COMMENT '용적률 [NUMERIC(19,9)]',
    `주용도코드`      VARCHAR(5)     DEFAULT NULL COMMENT '주용도코드 [VARCHAR(5)]',
    `주용도코드명`     VARCHAR(100)   DEFAULT NULL COMMENT '주용도코드명 [VARCHAR(100)]',
    `기타용도`       VARCHAR(500)   DEFAULT NULL COMMENT '기타용도 [VARCHAR(500)]',
    `세대수`        INTEGER        DEFAULT NULL COMMENT '세대수 [NUMERIC(5)]',
    `가구수`        INTEGER        DEFAULT NULL COMMENT '가구수 [NUMERIC(5)]',
    `주건축물수`      INTEGER        DEFAULT NULL COMMENT '주건축물수 [NUMERIC(5)]',
    `부속건축물수`     INTEGER        DEFAULT NULL COMMENT '부속건축물수 [NUMERIC(5)]',
    `부속건축물면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '부속건축물면적 [NUMERIC(19,9)]',
    `총주차수`       INTEGER        DEFAULT NULL COMMENT '총주차수 [NUMERIC(7)]',
    `옥내기계식대수`    INTEGER        DEFAULT NULL COMMENT '옥내기계식대수 [NUMERIC(6)]',
    `옥내기계식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥내기계식면적 [NUMERIC(19,9)]',
    `옥외기계식대수`    INTEGER        DEFAULT NULL COMMENT '옥외기계식대수 [NUMERIC(6)]',
    `옥외기계식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥외기계식면적 [NUMERIC(19,9)]',
    `옥내자주식대수`    INTEGER        DEFAULT NULL COMMENT '옥내자주식대수 [NUMERIC(6)]',
    `옥내자주식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥내자주식면적 [NUMERIC(19,9)]',
    `옥외자주식대수`    INTEGER        DEFAULT NULL COMMENT '옥외자주식대수 [NUMERIC(6)]',
    `옥외자주식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥외자주식면적 [NUMERIC(19,9)]',
    `허가일`        VARCHAR(8)     DEFAULT NULL COMMENT '허가일 [VARCHAR(8)]',
    `착공일`        VARCHAR(8)     DEFAULT NULL COMMENT '착공일 [VARCHAR(8)]',
    `사용승인일`      VARCHAR(8)     DEFAULT NULL COMMENT '사용승인일 [VARCHAR(8)]',
    `허가번호년`      VARCHAR(4)     DEFAULT NULL COMMENT '허가번호년 [VARCHAR(4)]',
    `허가번호기관코드`   CHAR(7)        DEFAULT NULL COMMENT '허가번호기관코드 [CHAR(7)]',
    `허가번호기관코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '허가번호기관코드명 [VARCHAR(100)]',
    `허가번호구분코드`   VARCHAR(4)     DEFAULT NULL COMMENT '허가번호구분코드 [VARCHAR(4)]',
    `허가번호구분코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '허가번호구분코드명 [VARCHAR(100)]',
    `호수`         INTEGER        DEFAULT NULL COMMENT '호수 [NUMERIC(5)]',
    `에너지효율등급`    VARCHAR(4)     DEFAULT NULL COMMENT '에너지효율등급 [VARCHAR(4)]',
    `에너지절감율`     DECIMAL(19, 9) DEFAULT NULL COMMENT '에너지절감율 [NUMERIC(19,9)]',
    `에너지EPI점수`   INTEGER        DEFAULT NULL COMMENT '에너지EPI점수 [NUMERIC(5)]',
    `친환경건축물등급`   CHAR(1)        DEFAULT NULL COMMENT '친환경건축물등급 [CHAR(1)]',
    `친환경건축물인증점수` INTEGER        DEFAULT NULL COMMENT '친환경건축물인증점수 [NUMERIC(5)]',
    `지능형건축물등급`   CHAR(1)        DEFAULT NULL COMMENT '지능형건축물등급 [CHAR(1)]',
    `지능형건축물인증점수` INTEGER        DEFAULT NULL COMMENT '지능형건축물인증점수 [NUMERIC(5)]',
    `생성일자`       VARCHAR(8)     DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 총괄표제부';

CREATE TABLE service.building
(
    `관리건축물대장PK`  VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대장구분코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `대지위치`       VARCHAR(500)   DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`    VARCHAR(400)   DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`        VARCHAR(100)   DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`      VARCHAR(5)     DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`      VARCHAR(5)     DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`     VARCHAR(1)     DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`          VARCHAR(4)     DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`          VARCHAR(4)     DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`       VARCHAR(200)   DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`         VARCHAR(20)    DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`         VARCHAR(20)    DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `외필지수`       INTEGER        DEFAULT NULL COMMENT '외필지수 [NUMERIC(5)]',
    `새주소도로코드`    VARCHAR(12)    DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`   VARCHAR(5)     DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드`  VARCHAR(1)     DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`      INTEGER        DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`      INTEGER        DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `동명`         VARCHAR(100)   DEFAULT NULL COMMENT '동명 [VARCHAR(100)]',
    `주부속구분코드`    CHAR(1)        DEFAULT NULL COMMENT '주부속구분코드 [CHAR(1)]',
    `주부속구분코드명`   VARCHAR(100)   DEFAULT NULL COMMENT '주부속구분코드명 [VARCHAR(100)]',
    `대지면적`       DECIMAL(19, 9) DEFAULT NULL COMMENT '대지면적 [NUMERIC(19,9)]',
    `건축면적`       DECIMAL(19, 9) DEFAULT NULL COMMENT '건축면적 [NUMERIC(19,9)]',
    `건폐율`        DECIMAL(19, 9) DEFAULT NULL COMMENT '건폐율 [NUMERIC(19,9)]',
    `연면적`        DECIMAL(19, 9) DEFAULT NULL COMMENT '연면적 [NUMERIC(19,9)]',
    `용적률산정연면적`   DECIMAL(19, 9) DEFAULT NULL COMMENT '용적률산정연면적 [NUMERIC(19,9)]',
    `용적률`        DECIMAL(19, 9) DEFAULT NULL COMMENT '용적률 [NUMERIC(19,9)]',
    `구조코드`       VARCHAR(2)     DEFAULT NULL COMMENT '구조코드 [VARCHAR(2)]',
    `구조코드명`      VARCHAR(100)   DEFAULT NULL COMMENT '구조코드명 [VARCHAR(100)]',
    `기타구조`       VARCHAR(500)   DEFAULT NULL COMMENT '기타구조 [VARCHAR(500)]',
    `주용도코드`      VARCHAR(5)     DEFAULT NULL COMMENT '주용도코드 [VARCHAR(5)]',
    `주용도코드명`     VARCHAR(100)   DEFAULT NULL COMMENT '주용도코드명 [VARCHAR(100)]',
    `기타용도`       VARCHAR(500)   DEFAULT NULL COMMENT '기타용도 [VARCHAR(500)]',
    `지붕코드`       VARCHAR(2)     DEFAULT NULL COMMENT '지붕코드 [VARCHAR(2)]',
    `지붕코드명`      VARCHAR(100)   DEFAULT NULL COMMENT '지붕코드명 [VARCHAR(100)]',
    `기타지붕`       VARCHAR(500)   DEFAULT NULL COMMENT '기타지붕 [VARCHAR(500)]',
    `세대수`        INTEGER        DEFAULT NULL COMMENT '세대수 [NUMERIC(5)]',
    `가구수`        INTEGER        DEFAULT NULL COMMENT '가구수 [NUMERIC(5)]',
    `높이`         DECIMAL(19, 9) DEFAULT NULL COMMENT '높이 [NUMERIC(19,9)]',
    `지상층수`       INTEGER        DEFAULT NULL COMMENT '지상층수 [NUMERIC(5)]',
    `지하층수`       INTEGER        DEFAULT NULL COMMENT '지하층수 [NUMERIC(5)]',
    `승용승강기수`     INTEGER        DEFAULT NULL COMMENT '승용승강기수 [NUMERIC(5)]',
    `비상용승강기수`    INTEGER        DEFAULT NULL COMMENT '비상용승강기수 [NUMERIC(5)]',
    `부속건축물수`     INTEGER        DEFAULT NULL COMMENT '부속건축물수 [NUMERIC(5)]',
    `부속건축물면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '부속건축물면적 [NUMERIC(19,9)]',
    `총동연면적`      DECIMAL(19, 9) DEFAULT NULL COMMENT '총동연면적 [NUMERIC(19,9)]',
    `옥내기계식대수`    INTEGER        DEFAULT NULL COMMENT '옥내기계식대수 [NUMERIC(6)]',
    `옥내기계식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥내기계식면적 [NUMERIC(19,9)]',
    `옥외기계식대수`    INTEGER        DEFAULT NULL COMMENT '옥외기계식대수 [NUMERIC(6)]',
    `옥외기계식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥외기계식면적 [NUMERIC(19,9)]',
    `옥내자주식대수`    INTEGER        DEFAULT NULL COMMENT '옥내자주식대수 [NUMERIC(6)]',
    `옥내자주식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥내자주식면적 [NUMERIC(19,9)]',
    `옥외자주식대수`    INTEGER        DEFAULT NULL COMMENT '옥외자주식대수 [NUMERIC(6)]',
    `옥외자주식면적`    DECIMAL(19, 9) DEFAULT NULL COMMENT '옥외자주식면적 [NUMERIC(19,9)]',
    `허가일`        VARCHAR(8)     DEFAULT NULL COMMENT '허가일 [VARCHAR(8)]',
    `착공일`        VARCHAR(8)     DEFAULT NULL COMMENT '착공일 [VARCHAR(8)]',
    `사용승인일`      VARCHAR(8)     DEFAULT NULL COMMENT '사용승인일 [VARCHAR(8)]',
    `허가번호년`      VARCHAR(4)     DEFAULT NULL COMMENT '허가번호년 [VARCHAR(4)]',
    `허가번호기관코드`   CHAR(7)        DEFAULT NULL COMMENT '허가번호기관코드 [CHAR(7)]',
    `허가번호기관코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '허가번호기관코드명 [VARCHAR(100)]',
    `허가번호구분코드`   VARCHAR(4)     DEFAULT NULL COMMENT '허가번호구분코드 [VARCHAR(4)]',
    `허가번호구분코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '허가번호구분코드명 [VARCHAR(100)]',
    `호수`         INTEGER        DEFAULT NULL COMMENT '호수 [NUMERIC(5)]',
    `에너지효율등급`    VARCHAR(4)     DEFAULT NULL COMMENT '에너지효율등급 [VARCHAR(4)]',
    `에너지절감율`     DECIMAL(19, 9) DEFAULT NULL COMMENT '에너지절감율 [NUMERIC(19,9)]',
    `에너지EPI점수`   INTEGER        DEFAULT NULL COMMENT '에너지EPI점수 [NUMERIC(5)]',
    `친환경건축물등급`   CHAR(1)        DEFAULT NULL COMMENT '친환경건축물등급 [CHAR(1)]',
    `친환경건축물인증점수` INTEGER        DEFAULT NULL COMMENT '친환경건축물인증점수 [NUMERIC(5)]',
    `지능형건축물등급`   CHAR(1)        DEFAULT NULL COMMENT '지능형건축물등급 [CHAR(1)]',
    `지능형건축물인증점수` INTEGER        DEFAULT NULL COMMENT '지능형건축물인증점수 [NUMERIC(5)]',
    `생성일자`       VARCHAR(8)     DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    `내진설계적용여부`   VARCHAR(1)     DEFAULT NULL COMMENT '내진설계적용여부 [VARCHAR(1)]',
    `내진능력`       VARCHAR(200)   DEFAULT NULL COMMENT '내진능력 [VARCHAR(200)]',
    PRIMARY KEY (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 표제부';

CREATE TABLE service.unit
(
    `관리건축물대장PK` VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대장구분코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`   VARCHAR(100) DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`   VARCHAR(100) DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `대지위치`      VARCHAR(500) DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`   VARCHAR(400) DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`       VARCHAR(100) DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`     VARCHAR(5)   DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`     VARCHAR(5)   DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`         VARCHAR(4)   DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`         VARCHAR(4)   DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`      VARCHAR(200) DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`        VARCHAR(20)  DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`        VARCHAR(20)  DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `새주소도로코드`   VARCHAR(12)  DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`  VARCHAR(5)   DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드` VARCHAR(1)   DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`     INTEGER      DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`     INTEGER      DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `동명`        VARCHAR(100) DEFAULT NULL COMMENT '동명 [VARCHAR(100)]',
    `호명`        VARCHAR(100) DEFAULT NULL COMMENT '호명 [VARCHAR(100)]',
    `층구분코드`     VARCHAR(2)   DEFAULT NULL COMMENT '층구분코드 [VARCHAR(2)]',
    `층구분코드명`    VARCHAR(100) DEFAULT NULL COMMENT '층구분코드명 [VARCHAR(100)]',
    `층번호`       INTEGER      DEFAULT NULL COMMENT '층번호 [NUMERIC(4)]',
    `생성일자`      VARCHAR(8)   DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 전유부';

CREATE TABLE service.area
(
    `id`        BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `관리건축물대장PK` VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대장구분코드`    VARCHAR(1)     DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`   VARCHAR(100)   DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`    VARCHAR(1)     DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`   VARCHAR(100)   DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `대지위치`      VARCHAR(500)   DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`   VARCHAR(400)   DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`       VARCHAR(100)   DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`     VARCHAR(5)     DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`     VARCHAR(5)     DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`    VARCHAR(1)     DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`         VARCHAR(4)     DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`         VARCHAR(4)     DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`      VARCHAR(200)   DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`        VARCHAR(20)    DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`        VARCHAR(20)    DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `새주소도로코드`   VARCHAR(12)    DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`  VARCHAR(5)     DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드` VARCHAR(1)     DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`     INTEGER        DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`     INTEGER        DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `동명`        VARCHAR(100)   DEFAULT NULL COMMENT '동명 [VARCHAR(100)]',
    `호명`        VARCHAR(100)   DEFAULT NULL COMMENT '호명 [VARCHAR(100)]',
    `층구분코드`     VARCHAR(2)     DEFAULT NULL COMMENT '층구분코드 [VARCHAR(2)]',
    `층구분코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '층구분코드명 [VARCHAR(100)]',
    `층번호`       INTEGER        DEFAULT NULL COMMENT '층번호 [NUMERIC(4)]',
    `전유공용구분코드`  CHAR(1)        DEFAULT NULL COMMENT '전유공용구분코드 [CHAR(1)]',
    `전유공용구분코드명` VARCHAR(100)   DEFAULT NULL COMMENT '전유공용구분코드명 [VARCHAR(100)]',
    `주부속구분코드`   CHAR(1)        DEFAULT NULL COMMENT '주부속구분코드 [CHAR(1)]',
    `주부속구분코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '주부속구분코드명 [VARCHAR(100)]',
    `층번호명`      VARCHAR(100)   DEFAULT NULL COMMENT '층번호명 [VARCHAR(100)]',
    `구조코드`      VARCHAR(2)     DEFAULT NULL COMMENT '구조코드 [VARCHAR(2)]',
    `구조코드명`     VARCHAR(100)   DEFAULT NULL COMMENT '구조코드명 [VARCHAR(100)]',
    `기타구조`      VARCHAR(500)   DEFAULT NULL COMMENT '기타구조 [VARCHAR(500)]',
    `주용도코드`     VARCHAR(5)     DEFAULT NULL COMMENT '주용도코드 [VARCHAR(5)]',
    `주용도코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '주용도코드명 [VARCHAR(100)]',
    `기타용도`      VARCHAR(500)   DEFAULT NULL COMMENT '기타용도 [VARCHAR(500)]',
    `면적`        DECIMAL(19, 9) DEFAULT NULL COMMENT '면적 [NUMERIC(19,9)]',
    `생성일자`      VARCHAR(8)     DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`id`),
    INDEX (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 전유공용면적';

CREATE TABLE service.floor
(
    `id`        BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `관리건축물대장PK` VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대지위치`      VARCHAR(500)   DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`   VARCHAR(400)   DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`       VARCHAR(100)   DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`     VARCHAR(5)     DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`     VARCHAR(5)     DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`    VARCHAR(1)     DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`         VARCHAR(4)     DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`         VARCHAR(4)     DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`      VARCHAR(200)   DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`        VARCHAR(20)    DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`        VARCHAR(20)    DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `새주소도로코드`   VARCHAR(12)    DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`  VARCHAR(5)     DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드` VARCHAR(1)     DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`     INTEGER        DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`     INTEGER        DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `동명`        VARCHAR(100)   DEFAULT NULL COMMENT '동명 [VARCHAR(100)]',
    `층구분코드`     VARCHAR(2)     DEFAULT NULL COMMENT '층구분코드 [VARCHAR(2)]',
    `층구분코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '층구분코드명 [VARCHAR(100)]',
    `층번호`       INTEGER        DEFAULT NULL COMMENT '층번호 [NUMERIC(4)]',
    `층번호명`      VARCHAR(100)   DEFAULT NULL COMMENT '층번호명 [VARCHAR(100)]',
    `구조코드`      VARCHAR(2)     DEFAULT NULL COMMENT '구조코드 [VARCHAR(2)]',
    `구조코드명`     VARCHAR(100)   DEFAULT NULL COMMENT '구조코드명 [VARCHAR(100)]',
    `기타구조`      VARCHAR(500)   DEFAULT NULL COMMENT '기타구조 [VARCHAR(500)]',
    `주용도코드`     VARCHAR(5)     DEFAULT NULL COMMENT '주용도코드 [VARCHAR(5)]',
    `주용도코드명`    VARCHAR(100)   DEFAULT NULL COMMENT '주용도코드명 [VARCHAR(100)]',
    `기타용도`      VARCHAR(500)   DEFAULT NULL COMMENT '기타용도 [VARCHAR(500)]',
    `면적`        DECIMAL(19, 9) DEFAULT NULL COMMENT '면적 [NUMERIC(19,9)]',
    `주부속구분코드`   VARCHAR(1)     DEFAULT NULL COMMENT '주부속구분코드 [VARCHAR(1)]',
    `주부속구분코드명`  VARCHAR(100)   DEFAULT NULL COMMENT '주부속구분코드명 [VARCHAR(100)]',
    `면적제외여부`    VARCHAR(1)     DEFAULT NULL COMMENT '면적제외여부 [VARCHAR(1)]',
    `생성일자`      VARCHAR(8)     DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`id`),
    INDEX (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 층별개요';

CREATE TABLE service.sub_land
(
    `id`        BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `관리건축물대장PK` VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대장구분코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대장구분코드 [VARCHAR(1)]',
    `대장구분코드명`   VARCHAR(100) DEFAULT NULL COMMENT '대장구분코드명 [VARCHAR(100)]',
    `대장종류코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대장종류코드 [VARCHAR(1)]',
    `대장종류코드명`   VARCHAR(100) DEFAULT NULL COMMENT '대장종류코드명 [VARCHAR(100)]',
    `대지위치`      VARCHAR(500) DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`   VARCHAR(400) DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `건물명`       VARCHAR(100) DEFAULT NULL COMMENT '건물명 [VARCHAR(100)]',
    `시군구코드`     VARCHAR(5)   DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`     VARCHAR(5)   DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`    VARCHAR(1)   DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`         VARCHAR(4)   DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`         VARCHAR(4)   DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`      VARCHAR(200) DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`        VARCHAR(20)  DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`        VARCHAR(20)  DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `새주소도로코드`   VARCHAR(12)  DEFAULT NULL COMMENT '새주소도로코드 [VARCHAR(12)]',
    `새주소법정동코드`  VARCHAR(5)   DEFAULT NULL COMMENT '새주소법정동코드 [VARCHAR(5)]',
    `새주소지상지하코드` VARCHAR(1)   DEFAULT NULL COMMENT '새주소지상지하코드 [VARCHAR(1)]',
    `새주소본번`     INTEGER      DEFAULT NULL COMMENT '새주소본번 [NUMERIC(5)]',
    `새주소부번`     INTEGER      DEFAULT NULL COMMENT '새주소부번 [NUMERIC(5)]',
    `부속대장구분코드`  CHAR(1)      DEFAULT NULL COMMENT '부속대장구분코드 [CHAR(1)]',
    `부속대장구분코드명` VARCHAR(100) DEFAULT NULL COMMENT '부속대장구분코드명 [VARCHAR(100)]',
    `부속시군구코드`   VARCHAR(5)   DEFAULT NULL COMMENT '부속시군구코드 [VARCHAR(5)]',
    `부속법정동코드`   VARCHAR(5)   DEFAULT NULL COMMENT '부속법정동코드 [VARCHAR(5)]',
    `부속대지구분코드`  CHAR(1)      DEFAULT NULL COMMENT '부속대지구분코드 [CHAR(1)]',
    `부속번`       VARCHAR(4)   DEFAULT NULL COMMENT '부속번 [VARCHAR(4)]',
    `부속지`       VARCHAR(4)   DEFAULT NULL COMMENT '부속지 [VARCHAR(4)]',
    `부속특수지명`    VARCHAR(200) DEFAULT NULL COMMENT '부속특수지명 [VARCHAR(200)]',
    `부속블록`      VARCHAR(20)  DEFAULT NULL COMMENT '부속블록 [VARCHAR(20)]',
    `부속로트`      VARCHAR(20)  DEFAULT NULL COMMENT '부속로트 [VARCHAR(20)]',
    `부속기타지번명`   VARCHAR(300) DEFAULT NULL COMMENT '부속기타지번명 [VARCHAR(300)]',
    `생성일자`      VARCHAR(8)   DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`id`),
    INDEX (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 부속지번';

CREATE TABLE service.land_regulation
(
    `id`          BIGINT      NOT NULL AUTO_INCREMENT COMMENT 'PK',
    `관리건축물대장PK`   VARCHAR(33) NOT NULL COMMENT '관리건축물대장PK [VARCHAR(33)]',
    `대지위치`        VARCHAR(500) DEFAULT NULL COMMENT '대지위치 [VARCHAR(500)]',
    `도로명대지위치`     VARCHAR(400) DEFAULT NULL COMMENT '도로명대지위치 [VARCHAR(400)]',
    `시군구코드`       VARCHAR(5)   DEFAULT NULL COMMENT '시군구코드 [VARCHAR(5)]',
    `법정동코드`       VARCHAR(5)   DEFAULT NULL COMMENT '법정동코드 [VARCHAR(5)]',
    `대지구분코드`      VARCHAR(1)   DEFAULT NULL COMMENT '대지구분코드 [VARCHAR(1)]',
    `번`           VARCHAR(4)   DEFAULT NULL COMMENT '번 [VARCHAR(4)]',
    `지`           VARCHAR(4)   DEFAULT NULL COMMENT '지 [VARCHAR(4)]',
    `특수지명`        VARCHAR(200) DEFAULT NULL COMMENT '특수지명 [VARCHAR(200)]',
    `블록`          VARCHAR(20)  DEFAULT NULL COMMENT '블록 [VARCHAR(20)]',
    `로트`          VARCHAR(20)  DEFAULT NULL COMMENT '로트 [VARCHAR(20)]',
    `지역지구구역구분코드`  VARCHAR(1)   DEFAULT NULL COMMENT '지역지구구역구분코드 [VARCHAR(1)]',
    `지역지구구역구분코드명` VARCHAR(100) DEFAULT NULL COMMENT '지역지구구역구분코드명 [VARCHAR(100)]',
    `지역지구구역코드`    VARCHAR(6)   DEFAULT NULL COMMENT '지역지구구역코드 [VARCHAR(6)]',
    `지역지구구역코드명`   VARCHAR(100) DEFAULT NULL COMMENT '지역지구구역코드명 [VARCHAR(100)]',
    `대표여부`        VARCHAR(1)   DEFAULT NULL COMMENT '대표여부 [VARCHAR(1)]',
    `기타지역지구구역`    VARCHAR(300) DEFAULT NULL COMMENT '기타지역지구구역 [VARCHAR(300)]',
    `생성일자`        VARCHAR(8)   DEFAULT NULL COMMENT '생성일자 [VARCHAR(8)]',
    PRIMARY KEY (`id`),
    INDEX (`관리건축물대장PK`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb3 COMMENT ='건축물대장 지역지구구역';
