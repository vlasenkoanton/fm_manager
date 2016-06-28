DROP TABLE IF EXISTS fm_manager.document;
DROP TABLE IF EXISTS fm_manager.client;
DROP TABLE IF EXISTS fm_manager.address;
DROP TABLE IF EXISTS fm_manager.work;
DROP TABLE IF EXISTS fm_manager.contact;
DROP TABLE IF EXISTS fm_manager.entrepreneurInfo;

CREATE TABLE fm_manager.client (
  id              INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  firstName       VARCHAR(50)                     NOT NULL,
  lastName        VARCHAR(50)                     NOT NULL,
  middleName      VARCHAR(50),
  identNumber     INTEGER,
  dateBirth       DATE                            NOT NULL,
  placeBirth      VARCHAR(50)                     NOT NULL,
  resident        BIT(1)                          NOT NULL,
  citizenship     INTEGER(3)                      NOT NULL,
  responsible     VARCHAR(50),
  pep             BIT(0)                          NOT NULL,
  address_id      INTEGER UNSIGNED,
  work_id         INTEGER UNSIGNED,
  contact_id      INTEGER UNSIGNED,
  entrepreneurInfo_id INTEGER UNSIGNED
);
CREATE TABLE fm_manager.document (
  id         INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  type       INTEGER(1)                      NOT NULL,
  main       BIT(0)                          NOT NULL,
  name       VARCHAR(25)                     NOT NULL,
  series     VARCHAR(8),
  number     INTEGER                         NOT NULL,
  authority  VARCHAR(50)                     NOT NULL,
  dateIssue  DATE                            NOT NULL,
  dateExpire DATE,
  owner_id   INTEGER UNSIGNED
);
CREATE TABLE fm_manager.address (
  id        INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  postCode  INTEGER,
  country   INTEGER(3)                      NOT NULL,
  region    VARCHAR(50),
  district  VARCHAR(50),
  city      VARCHAR(50)                     NOT NULL,
  street    VARCHAR(50)                     NOT NULL,
  house     INTEGER(4)                      NOT NULL,
  apartment INTEGER(4)
);
CREATE TABLE fm_manager.work (
  id        INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name      VARCHAR(50)                     NOT NULL,
  identCode INTEGER,
  position  VARCHAR(50)
);
CREATE TABLE fm_manager.contact (
  id        INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  homeTel   VARCHAR(50),
  workTel   VARCHAR(50),
  mobileTel VARCHAR(50)                     NOT NULL,
  fax       VARCHAR(50),
  email     VARCHAR(50)
);
CREATE TABLE fm_manager.entrepreneurInfo (
  id        INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  regNumber INTEGER                         NOT NULL,
  authority VARCHAR(50)                     NOT NULL,
  regDate   DATE                            NOT NULL,
  activity  VARCHAR(50)                     NOT NULL
);

#Following are Foreign Key settings:
ALTER TABLE fm_manager.client
  ADD FOREIGN KEY (address_id) REFERENCES address (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (work_id) REFERENCES work (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (contact_id) REFERENCES contact (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (entrepreneurInfo_id) REFERENCES entrepreneurInfo (id)
  ON DELETE SET NULL;

ALTER TABLE fm_manager.document
  ADD FOREIGN KEY (owner_id) REFERENCES client (id)
  ON DELETE CASCADE;