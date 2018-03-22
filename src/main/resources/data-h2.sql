--------------------------------------------------------
--  DDL for Sequence TRAINEE_ID_SEQUENCE
--------------------------------------------------------
--In case a table needs to be created. Commented out because it creates more problems than it solves.
DROP TABLE IF EXISTS CALIBER_CLIENT;
CREATE TABLE IF NOT EXISTS CALIBER_CLIENT (CLIENT_ID INT(11) PRIMARY KEY,CLIENT_NAME VARCHAR(256) NOT NULL);
DROP SEQUENCE IF EXISTS CLIENT_ID_SEQUENCE;
CREATE SEQUENCE  IF NOT EXISTS  CLIENT_ID_SEQUENCE  MINVALUE 5600  INCREMENT BY 1 START WITH 5600;




Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (1,'InfoSys');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5500,'ABBTECH');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5501,'Accenture, Fannie Mae');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5502,'Accenture, Highmark');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5503,'Accenture Federal Services');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5504,'Accenture LLP (Commercial)');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5505,'FINRA');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5506,'Revature LLC');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5507,'Tech, Mahindra');
Insert into CALIBER_CLIENT (CLIENT_ID,CLIENT_NAME) values (5508,'Virtusa');