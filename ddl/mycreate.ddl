CREATE SCHEMA IF NOT EXISTS etheder;
CREATE TABLE etheder.RESEARCHQUEUE (ID  UUID NOT NULL, INDEXID INTEGER NOT NULL, TICKS INTEGER, PLAYERID UUID, RESEARCHID BIGINT, PRIMARY KEY (ID));
CREATE TABLE etheder.UNITDATA (ID BIGINT NOT NULL, ARMOUR INTEGER, ATTACK INTEGER, COSTFOOD INTEGER, COSTGOLD INTEGER, COSTIRON INTEGER, COSTSTONE INTEGER, COSTWOOD INTEGER, DEFENSIVE INTEGER, DESCRIPTION VARCHAR(255), HEALTH INTEGER, unitLevel INTEGER, NAME VARCHAR(255), SPEED INTEGER, TICKS INTEGER, UNITTYPE VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE etheder.BUILDING (ID  UUID NOT NULL, BUILDINGDATA_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE etheder.PLAYER (ID  UUID NOT NULL, ARCHERTECHLEVEL INTEGER, CAVALRYTECHLEVEL INTEGER, NAME VARCHAR(255), COUNTRY VARCHAR(255), FOOD BIGINT, GOLD BIGINT, INFANTRYTECHLEVEL INTEGER, IRON BIGINT, SIEGETECHLEVEL INTEGER, STONE BIGINT, WOOD BIGINT, USERID UUID, PRIMARY KEY (ID));
CREATE TABLE etheder.BUILDINGQUEUE (ID  UUID NOT NULL, TICKS INTEGER, CITYID UUID, BUILDING_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE etheder.CITY (ID  UUID NOT NULL, ACRES INTEGER, CITYLEVEL INTEGER, FARMERS INTEGER, IRONMINERS INTEGER, LUMBERJACKS INTEGER, MERCHANTS INTEGER, NAME VARCHAR(255), POPULATION BIGINT, STONEMASONS INTEGER, PlayerId UUID, ArmyId UUID, PRIMARY KEY (ID));
CREATE TABLE etheder.BUILDINGDATA (ID BIGINT NOT NULL, COSTFOOD INTEGER, COSTGOLD INTEGER, COSTIRON INTEGER, COSTSTONE INTEGER, COSTWOOD INTEGER, DESCRIPTION VARCHAR(255), MAXNUMBER INTEGER, NAME VARCHAR(255), POPULATIONCAPACITY INTEGER, TICKS INTEGER, UNITTYPE VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE etheder.LOGINS (ID  UUID NOT NULL, USERNAME VARCHAR(255) NOT NULL UNIQUE, PASSWORDHASH VARCHAR(255), TOKEN UUID, TOKENEXPIREDATE TIMESTAMP, PRIMARY KEY (ID));
CREATE TABLE etheder.USERS (ID  UUID NOT NULL, AGE INTEGER, COUNTRY VARCHAR(255), EMAIL VARCHAR(255), FIRSTNAME VARCHAR(255), LASTNAME VARCHAR(255), LOGINID UUID, PRIMARY KEY (ID));
CREATE TABLE etheder.ARMY (ID  UUID NOT NULL, DEFAULTARMY BOOLEAN, NAME VARCHAR(255), NROFARCHER INTEGER, NROFCAVALRY INTEGER, NROFINFANTRY INTEGER, NROFSIEGE INTEGER, PLAYERID UUID, PRIMARY KEY (ID));
CREATE TABLE etheder.UNIT (ID  UUID NOT NULL, ARMOUR INTEGER, ATTACK INTEGER, DEFENSIVE INTEGER, HEALTH INTEGER, SPEED INTEGER, UNITDATA_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE etheder.UNITQUEUE (ID  UUID NOT NULL, NROFUNITS INTEGER, TICKS INTEGER, CITYID UUID, UNIT_ID BIGINT, PRIMARY KEY (ID));
CREATE TABLE etheder.RESEARCH (ID  BIGINT NOT NULL, COSTFOOD INTEGER, COSTGOLD INTEGER, COSTIRON INTEGER, COSTSTONE INTEGER, COSTWOOD INTEGER, DESCRIPTION VARCHAR(255), researchLevel INTEGER, NAME VARCHAR(255), TICKS INTEGER, UNITTYPE VARCHAR(255), PRIMARY KEY (ID));
CREATE TABLE etheder.PLAYER_CITYLIST (PLAYERID UUID, CITYID UUID);
CREATE TABLE etheder.CITY_ARMYLIST (ARMYID UUID, CITY_ID UUID);
CREATE TABLE etheder.CITY_BUILDINGLIST (CITY_ID UUID, BUILDINGID UUID);

ALTER TABLE etheder.BUILDING ADD CONSTRAINT FK_BUILDING_BUILDINGDATA_ID FOREIGN KEY (BUILDINGDATA_ID) REFERENCES etheder.BUILDINGDATA (ID);
ALTER TABLE etheder.BUILDINGQUEUE ADD CONSTRAINT FK_BUILDINGQUEUE_BUILDING_ID FOREIGN KEY (BUILDING_ID) REFERENCES etheder.BUILDINGDATA (ID);
ALTER TABLE etheder.BUILDINGQUEUE ADD CONSTRAINT FK_BUILDINGQUEUE_CITYID FOREIGN KEY (CITYID) REFERENCES etheder.CITY (ID);
ALTER TABLE etheder.RESEARCHQUEUE ADD CONSTRAINT FK_RESEARCHQUEUE_PLAYERID FOREIGN KEY (PLAYERID) REFERENCES etheder.PLAYER (ID);
ALTER TABLE etheder.RESEARCHQUEUE ADD CONSTRAINT FK_RESEARCHQUEUE_RESEARCHID FOREIGN KEY (RESEARCHID) REFERENCES etheder.RESEARCH (ID);
ALTER TABLE etheder.ARMY ADD CONSTRAINT FK_ARMY_PLAYER_ID FOREIGN KEY (PLAYERID) REFERENCES etheder.PLAYER (ID);
ALTER TABLE etheder.CITY ADD CONSTRAINT FK_CITY_ARMY_ID FOREIGN KEY (ArmyId) REFERENCES etheder.ARMY (ID);
ALTER TABLE etheder.CITY ADD CONSTRAINT FK_CITY_PLAYER_ID FOREIGN KEY (PlayerId) REFERENCES etheder.PLAYER (ID);
ALTER TABLE etheder.UNIT ADD CONSTRAINT FK_UNIT_UNITDATA_ID FOREIGN KEY (UNITDATA_ID) REFERENCES etheder.UNITDATA (ID);
ALTER TABLE etheder.UNITQUEUE ADD CONSTRAINT FK_UNITQUEUE_UNIT_ID FOREIGN KEY (UNIT_ID) REFERENCES etheder.UNITDATA (ID);
ALTER TABLE etheder.USERS ADD CONSTRAINT FK_USERS_LOGINID FOREIGN KEY (LOGINID) REFERENCES etheder.LOGINS (ID);
ALTER TABLE etheder.PLAYER ADD CONSTRAINT FK_PLAYER_USERID FOREIGN KEY (USERID) REFERENCES etheder.USERS (ID);
ALTER TABLE etheder.PLAYER_CITYLIST ADD CONSTRAINT FK_Player_CITYLIST_PLAYERID FOREIGN KEY (PLAYERID) REFERENCES etheder.PLAYER (ID);
ALTER TABLE etheder.PLAYER_CITYLIST ADD CONSTRAINT FK_Player_CITYLIST_CITYId FOREIGN KEY (CITYID) REFERENCES etheder.CITY (ID);
ALTER TABLE etheder.CITY_ARMYLIST ADD CONSTRAINT FK_CITY_ARMYLIST_CITYID FOREIGN KEY (CITY_ID) REFERENCES etheder.CITY (ID);
ALTER TABLE etheder.CITY_ARMYLIST ADD CONSTRAINT FK_CITY_ARMYLIST_ARMYID FOREIGN KEY (ARMYID) REFERENCES etheder.ARMY (ID);
ALTER TABLE etheder.CITY_BUILDINGLIST ADD CONSTRAINT FK_CITY_BUILDINGLIST_CITY_ID FOREIGN KEY (CITY_ID) REFERENCES etheder.CITY (ID);
ALTER TABLE etheder.CITY_BUILDINGLIST ADD CONSTRAINT FK_CITY_BUILDINGLIST_BUILDING_ID FOREIGN KEY (BUILDINGID) REFERENCES etheder.BUILDING (ID);
