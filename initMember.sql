--------------------------------------------------------
--  ������ ������ - ȭ����-8��-25-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MEMBER
--------------------------------------------------------

  CREATE TABLE "C##EZEN"."MEMBER" 
   (	"USERID" NUMBER, 
	"SEX" VARCHAR2(10 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(30 BYTE), 
	"NAME" VARCHAR2(20 BYTE), 
	"PHONE" VARCHAR2(20 BYTE) DEFAULT 000-0000-0000
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into C##EZEN.MEMBER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C007495
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##EZEN"."SYS_C007495" ON "C##EZEN"."MEMBER" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007496
--------------------------------------------------------

  CREATE UNIQUE INDEX "C##EZEN"."SYS_C007496" ON "C##EZEN"."MEMBER" ("EMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table MEMBER
--------------------------------------------------------

  ALTER TABLE "C##EZEN"."MEMBER" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."MEMBER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."MEMBER" ADD PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##EZEN"."MEMBER" ADD UNIQUE ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "C##EZEN"."MEMBER" MODIFY ("SEX" NOT NULL ENABLE);
  ALTER TABLE "C##EZEN"."MEMBER" MODIFY ("NAME" NOT NULL ENABLE);