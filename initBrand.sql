--------------------------------------------------------
--  파일이 생성됨 - 화요일-8월-25-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BRAND
--------------------------------------------------------

  CREATE TABLE "C##EZEN"."BRAND" 
   (	"BRANDID" NUMBER, 
	"NAME" VARCHAR2(20 BYTE), 
	"TELEPHONE" VARCHAR2(15 BYTE), 
	"LOCATION" VARCHAR2(100 BYTE), 
	"CEONAME" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##EZEN.BRAND
SET DEFINE OFF;
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (1,'교촌치킨','1577-1991','경기도 오산시 동부대로 436번길 55-18','소진세');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (2,'BBQ치킨','1588-9282','서울시 송파구 중대로 64(문정동)','윤경주');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (3,'멕시카나치킨','02-3433-1857','서울시 송파구 송파대로 34길 35(송파동, 멕시카나빌딩)','최광은');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (4,'BHC치킨','02-6204-3406','서울시 송파구 올림픽로 299(신천동 7-23번지) 대한제당B/D 2층','임금옥');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (5,'굽네치킨','02-2648-2005','서울특별시 양천구 공항대로 644 (목동 515-12)','정태용');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (6,'60계치킨','02-582-5289','서울특별시 서초구 매헌로 40','장조웅');
Insert into C##EZEN.BRAND (BRANDID,NAME,TELEPHONE,LOCATION,CEONAME) values (7,'네네치킨','02-6919-3062','서울특별시 도봉구 노해로 391','현광식');
--------------------------------------------------------
--  DDL for Index SYS_C007491
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##EZEN"."SYS_C007491" ON "C##EZEN"."BRAND" ("BRANDID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007492
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##EZEN"."SYS_C007492" ON "C##EZEN"."BRAND" ("NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table BRAND
--------------------------------------------------------

  ALTER TABLE "C##EZEN"."BRAND" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."BRAND" ADD PRIMARY KEY ("BRANDID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##EZEN"."BRAND" ADD UNIQUE ("NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
