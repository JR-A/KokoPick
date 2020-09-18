--------------------------------------------------------
--  파일이 생성됨 - 화요일-8월-25-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MENU
--------------------------------------------------------

  CREATE TABLE "C##EZEN"."MENU" 
   (	"BRANDID" NUMBER, 
	"NAME" VARCHAR2(50 BYTE), 
	"CATEGORY" NUMBER, 
	"PRICE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##EZEN.MENU
SET DEFINE OFF;
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'오리지날',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'허니 오리지날',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'레드 오리지날',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'웨지감자',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'콜라',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'황금 올리브치킨',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'황금 올리브 크리스피',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'핫 황금 올리브 크리스피',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'황금알치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'콜라',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'후라이드 치킨',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'마늘치킨',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'간장치킨',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'치즈돈까스',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'사이다',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'뿌링클',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'후라이드',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'맛초킹',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'뿌링핫도그',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'사이다',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'오리지널',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'갈비천왕',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'볼케이노',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'바게트볼',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'콜라',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'후라이드 치킨',0,16900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'간지 치킨',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'고추 치킨',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'콘치즈볼',1,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'사이다',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'레허 반반 순살',0,21000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'허니 콤보',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'교촌 살살 치킨',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'교촌 소이 살살',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'교촌 에그마니샐러드',1,2500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'사이다',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'자메이카 통다리 구이',0,19500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'소이 갈릭스',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'치즐링',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'핫 황금 올리브 블랙페퍼',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'더블치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'고구마치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'쇼콜라볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'맥주 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'사이다',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'반반치킨',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'뿌리고',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'순살파닭',0,20000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'미니핫도그',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'더블치즈볼',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'체다치즈볼',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'눈꽃치즈감자',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'콜라',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'생맥주 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'병맥주(카스)',2,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'골드킹',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'레드킹',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'블랙올리브',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'커리퀸',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'마라칸',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'콜팝치킨',1,2500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'뿌링클콜팝',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'뿌링소떡',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'케이준프라이',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'콜라',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'고추바사삭',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'허니멜로',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'굽네 딥치즈',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'양념치킨',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'매콤치즈 웨지감자',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'찹쌀 치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'달콤 치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'콘스프 웨지감자',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'갈비천왕 치즈치밥',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'볼케이노 치즈치밥',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'사이다',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'생맥주 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'더매운고추치킨',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'장스치킨',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'6초치킨',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'치즈스틱',1,3500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'똥집튀김',1,10000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'쫀득치즈볼',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'병맥주',2,4000);
--------------------------------------------------------
--  DDL for Index SYS_C007508
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##EZEN"."SYS_C007508" ON "C##EZEN"."MENU" ("BRANDID", "NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MENU
--------------------------------------------------------

  ALTER TABLE "C##EZEN"."MENU" MODIFY ("CATEGORY" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."MENU" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."MENU" ADD PRIMARY KEY ("BRANDID", "NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table MENU
--------------------------------------------------------

  ALTER TABLE "C##EZEN"."MENU" ADD CONSTRAINT "FK_MENUBRANDID" FOREIGN KEY ("BRANDID")
	  REFERENCES "C##EZEN"."BRAND" ("BRANDID") ON DELETE CASCADE ENABLE;
