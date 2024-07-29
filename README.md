# 부동산 관련 공공 데이터 적재 배치 애플리케이션

건축물대장, 토지 등의 부동산 관련 공공 데이터를 적재할 수 있는 배치 애플리케이션입니다.
각 데이터셋은 명확한 기준이 되는 Key가 존재하는 경우 해당 키를 Primary Key로 설정하였고, 명확한 키가 없는 경우에는 Alternate Key를 Primary Key로 설정했습니다.
각 데이터셋 적재 배치의 ItemProcessor에서 데이터로서 가치가 없다고 판단되는 케이스에 대해 filter 처리하였고, empty string과 같은 case에서는 NULL로 변경하여 적재하는 등 기본적인 가공 처리가 되어 있습니다.

## 데이터 다운로드 페이지 (파일 이용 배치)

- [건축데이터 민간개방 시스템](https://open.eais.go.kr/opnsvc/opnSvcInqireView.do?viewType=7)
  - 기본개요
  - 총괄표제부
  - 표제부
  - 전유부
  - 전유공용면적
  - 층별개요
  - 부속지번
  - 지역지구구역
  - 주택가격
  - 오수정화시설
- [브이월드 (V-WORLD)](https://www.vworld.kr/dtna/dtna_fileDataList_s001.do)
  - 토지임야정보
  - GIS건물통합정보
  - 개별공시지가공간정보
  - 법정구역정보
- [행정표준코드관리시스템](https://www.code.go.kr/index.do)
  - 법정동코드

## API 제공 페이지

- [공공데이터포털](https://www.data.go.kr/tcs/dss/selectDataSetList.do?dType=API&keyword=&operator=AND&detailKeyword=&publicDataPk=&recmSe=&detailText=&relatedKeyword=&commaNotInData=&commaAndData=&commaOrData=&must_not=&tabId=&dataSetCoreTf=&coreDataNm=&sort=updtDt&relRadio=&orgFullName=&orgFilter=&org=&orgSearch=&currentPage=1&perPage=10&brm=&instt=&svcType=&kwrdArray=&extsn=&coreDataNmArray=&pblonsipScopeCode=)
  - 국토교통부 전국 법정동

## 데이터셋 소개

각 괄호 내에 있는 것은 테이블명(패키지명)을 의미합니다.
각 배치는 job directory 하위에 있습니다.

- 건축물대장 (building_register)
  - 기본개요 (summary)
  - 총괄표제부 (complex)
  - 표제부 (building)
  - 전유부 (unit)
  - 전유공용면적 (area)
  - 층별개요 (floor)
  - 부속지번 (sub_land)
  - 지역지구구역 (land_regulation)
  - 주택가격 (house_price)
  - 오수정화시설 (wastewater_treatment_plant)
- 토지 (land)
  - 토지임야대장
- GIS (gis)
  - GIS건물통합정보 (building_polygon)
  - 개별공시지가공간정보 (land_polygon)
  - 법정구역정보 (legal_polygon)
- 지역 (legal)
  - 법정동코드 (code)
    - API 조회 (api)
    - file 적재 (file)

## 사용 방법

MySQL 기준이며, Docker가 설치된 환경에서 사용 가능합니다.

### 파일 이용

1. 원하는 데이터셋을 위 사이트에 접속하여 다운로드 받습니다.
2. 각 배치의 ItemReader에서 파일을 읽는 경로를 수정하거나, ItemReader에 설정되어 있는 경로에 파일명을 적절히 수정하여 놓습니다.
3. `docker compose up` 명령을 실행하여 MySQL을 실행합니다.
4. Spring Batch 패키지 내에 있는 `schema-mysql.sql`을 실행하여 배치 메타 테이블을 생성합니다.
5. 각 데이터셋에 해당하는 테이블 생성 DDL을 실행합니다.
   - 건축물대장 관련 데이터: `schema-building-register.sql`
   - GIS 관련 데이터: `schema-gis.sql`
6. Program Argument에 각 배치 Job 이름을 부여하고 실행합니다. (key: job.name)
   - ex) --job.name=buildingPolygonLoadJob

### API 이용

1. 적재하고 싶은 데이터셋을 제공하는 페이지에서 API KEY를 발급받습니다.
2. `docker compose up` 명령을 실행하여 MySQL을 실행합니다.
3. Spring Batch 패키지 내에 있는 `schema-mysql.sql`을 실행하여 배치 메타 테이블을 생성합니다.
4. 각 데이터셋에 해당하는 테이블 생성 DDL을 실행합니다.
    - 전국 법정동코드 관련 데이터: `schema-legal.sql`
5. application-auth.yml 파일을 생성하고, `ApiKeyProperties` 클래스에서 API KEY 정보를 참조할 수 있도록 설정합니다.
6. Program Argument에 각 배치 Job 이름을 부여하고 실행합니다. (key: job.name)
    - ex) --job.name=legalLoadJob
