DROP TABLE IF EXISTS fm_manager.document;
DROP TABLE IF EXISTS fm_manager.individual;
DROP TABLE IF EXISTS fm_manager.address;
DROP TABLE IF EXISTS fm_manager.work;
DROP TABLE IF EXISTS fm_manager.contact;
DROP TABLE IF EXISTS fm_manager.fop_info;
DROP TABLE IF EXISTS fm_manager.fm_info;

CREATE TABLE fm_manager.individual (
  id                INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  `client`          BIT(0)                          NOT NULL,
  first_name        VARCHAR(50)                     NOT NULL,
  last_name         VARCHAR(50)                     NOT NULL,
  middle_name       VARCHAR(50),
  ident_number      BIGINT,
  date_birth        DATE                            NOT NULL,
  place_birth       VARCHAR(50),
  resident          BIT(1)                          NOT NULL,
  citizenship       INTEGER(3),
  responsible       VARCHAR(50),
  pep               BIT(0),
  address_id        INTEGER UNSIGNED,
  work_id           INTEGER UNSIGNED,
  contact_id        INTEGER UNSIGNED,
  fop_info_id       INTEGER UNSIGNED,
  fm_info_id        INTEGER UNSIGNED,
  account_opener_id INTEGER UNSIGNED,
  representative_id INTEGER UNSIGNED
);

CREATE TABLE fm_manager.document (
  id          INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  type        INTEGER(1)                      NOT NULL,
  main        BIT(0)                          NOT NULL,
  name        VARCHAR(25)                     NOT NULL,
  series      VARCHAR(8),
  number      INTEGER                         NOT NULL,
  authority   VARCHAR(50)                     NOT NULL,
  date_issue  DATE                            NOT NULL,
  date_expire DATE,
  owner_id    INTEGER UNSIGNED
);
CREATE TABLE fm_manager.address (
  id          INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  postal_code INTEGER,
  country     INTEGER(3)                      NOT NULL,
  region      VARCHAR(50),
  district    VARCHAR(50),
  city        VARCHAR(50)                     NOT NULL,
  street      VARCHAR(50)                     NOT NULL,
  house       INTEGER(4)                      NOT NULL,
  apartment   INTEGER(4)
);
CREATE TABLE fm_manager.work (
  id                  INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name                VARCHAR(50)                     NOT NULL,
  identification_code INTEGER,
  position            VARCHAR(50)
);
CREATE TABLE fm_manager.contact (
  id               INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  home_telephone   VARCHAR(50),
  work_telephone   VARCHAR(50),
  mobile_telephone VARCHAR(50)                     NOT NULL,
  fax              VARCHAR(50),
  email            VARCHAR(50)
);
CREATE TABLE fm_manager.fop_info (
  id                  INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  registration_number INTEGER                         NOT NULL,
  authority           VARCHAR(50)                     NOT NULL,
  registration_date   DATE                            NOT NULL,
  activity            VARCHAR(50)                     NOT NULL
);
CREATE TABLE fm_manager.fm_info (
  id              INTEGER UNSIGNED AUTO_INCREMENT NOT NULL PRIMARY KEY,
  service_history VARCHAR(255)                    NOT NULL,
  month_income    BIGINT                          NOT NULL,
  financial_help  BIGINT UNSIGNED,
  securities      BIGINT UNSIGNED,
  assignment      BIGINT UNSIGNED,
  loans           BIGINT UNSIGNED,
  term_contracts  BIGINT UNSIGNED
);

ALTER TABLE fm_manager.individual
  ADD FOREIGN KEY (address_id) REFERENCES address (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (work_id) REFERENCES work (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (contact_id) REFERENCES contact (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (fop_info_id) REFERENCES fop_info (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (fm_info_id) REFERENCES fm_info (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (account_opener_id) REFERENCES individual (id)
  ON DELETE SET NULL,
  ADD FOREIGN KEY (representative_id) REFERENCES individual (id)
  ON DELETE SET NULL;

ALTER TABLE fm_manager.document
  ADD FOREIGN KEY (owner_id) REFERENCES individual (id)
  ON DELETE CASCADE;




