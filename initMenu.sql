--------------------------------------------------------
--  ������ ������ - ȭ����-8��-25-2020   
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
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'��������',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'��� ��������',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���� ��������',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'��������',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'�ݶ�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'Ȳ�� �ø���ġŲ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'Ȳ�� �ø��� ũ������',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'�� Ȳ�� �ø��� ũ������',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'Ȳ�ݾ�ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'�ݶ�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�Ķ��̵� ġŲ',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'����ġŲ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'����ġŲ',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'ġ��',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'���̴�',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�Ѹ�Ŭ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�Ķ��̵�',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'����ŷ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�Ѹ��ֵ���',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'���̴�',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'��������',0,15000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'����õ��',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'�����̳�',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'�ٰ�Ʈ��',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'�ݶ�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'�Ķ��̵� ġŲ',0,16900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'���� ġŲ',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'���� ġŲ',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'��ġ�',1,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'���̴�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���� �ݹ� ����',0,21000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'��� �޺�',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���� ��� ġŲ',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���� ���� ���',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���� ���׸��ϻ�����',1,2500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (1,'���̴�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'�ڸ���ī ��ٸ� ����',0,19500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'���� ������',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'ġ��',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'�� Ȳ�� �ø��� ������',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'����ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'����ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'���ݶ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'���� 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (2,'���̴�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�ݹ�ġŲ',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�Ѹ���',0,19000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�����Ĵ�',0,20000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�̴��ֵ���',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'����ġ�',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'ü��ġ�',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'����ġ���',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'�ݶ�',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'������ 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (3,'������(ī��)',2,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'���ŷ',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'����ŷ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'���ø���',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'Ŀ����',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'����ĭ',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'����ġŲ',1,2500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�Ѹ�Ŭ����',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�Ѹ��Ҷ�',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'������������',1,3000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (4,'�ݶ�',2,1500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���߹ٻ��',0,16000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'��ϸ��',0,18000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���� ��ġ��',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���ġŲ',0,17000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'����ġ�� ��������',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���� ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���� ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'�ܽ��� ��������',1,4000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'����õ�� ġ��ġ��',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'�����̳� ġ��ġ��',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'���̴�',2,2000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'������ 1000cc',2,6000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'���ſ����ġŲ',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'�彺ġŲ',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'6��ġŲ',0,18900);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'ġ�ƽ',1,3500);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'����Ƣ��',1,10000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (6,'�˵�ġ�',1,5000);
Insert into C##EZEN.MENU (BRANDID,NAME,CATEGORY,PRICE) values (5,'������',2,4000);
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
