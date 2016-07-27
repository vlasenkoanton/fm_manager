DELETE FROM fm_manager.document;
DELETE FROM fm_manager.account;
DELETE FROM fm_manager.individual;
DELETE FROM fm_manager.address;
DELETE FROM fm_manager.work;
DELETE FROM fm_manager.contact;
DELETE FROM fm_manager.fop_info;
DELETE FROM fm_manager.fm_info;
DELETE FROM fm_manager.user_roles;
DELETE FROM fm_manager.user;

ALTER TABLE fm_manager.document AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.account AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.individual AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.address AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.work AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.contact AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.fop_info AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.fm_info AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.user AUTO_INCREMENT = 1;

INSERT INTO fm_manager.address (postal_code, country, region, district, city, street, house, apartment) VALUES
  (111111, 980, 'Cherkassy', 'USR', 'Cherkassy', 'Sumgaitska', 45, 23),
  (222222, 980, '', 'Sviatoshynskiy', 'Kiev', 'Rykova', 5, 6),
  (333333, 980, '', 'Obolonskiy', 'Kiev', 'G. Stalingrada', 25, 62);

INSERT INTO fm_manager.work (name, identification_code, position) VALUES
  ('First Corporation', 236589, 'Programmer'),
  ('Second Company', 158421, 'Lawyer'),
  ('Commercial Bank', 256348, 'Client service specialist');

INSERT INTO fm_manager.contact (home_telephone, work_telephone, mobile_telephone, fax, email) VALUES
  ('044-254-44-55', '044-125-52-63', '063-562-32-52', NULL, 'anton_antonenko@e.mail'),
  ('044-222-20-39', '044-564-99-21', '050-503-78-87', NULL, 'ivan_ivanenko@e.mail'),
  ('044-325-32-47', '044-889-02-31', '073-564-22-13', NULL, 'petr_petrenko@e.mail');

INSERT INTO fm_manager.fop_info (registration_number, authority, registration_date, activity) VALUES
  (123654789, 'fop registration', '2006-3-26', 'legal activity');

INSERT INTO fm_manager.fm_info (service_history, month_income, financial_help, securities, assignment, loans, term_contracts) VALUES
  ('normal client', 1200000, 200000, 0, 0, 100000, 900000),
  ('all right', 1500000, 0, 500000, 0, 0, 700000),
  ('suspicious activity that not relates to month income', 2800000, 300000, 0, 150000, 350000, 2000000);

INSERT INTO fm_manager.user (login, password, first_name, last_name, middle_name, office_telephone, position) VALUES
  ('user', 'user123', 'Employee', 'Employ', 'Employevich', '18-25', 'senior client manager');

INSERT INTO fm_manager.user_roles (role, user_id) VALUES
  ('ROLE_USER', 1);

INSERT INTO fm_manager.individual (`client`, first_name, last_name, middle_name, ident_number, date_birth, place_birth, resident, citizenship, pep, initial_profile_fill, responsible_id, address_id, work_id, contact_id, fop_info_id, fm_info_id, account_opener_id, representative_id) VALUES
  (TRUE,'Anton', 'Antonenko', 'Antonovych', '12365474', '1988-5-5', 'Cherkassy', TRUE, 980, FALSE, '2016-6-18', 1, 1, 1, 1, NULL, 1, NULL, NULL),
  (TRUE,'Ivan', 'Ivanenko', 'Ivanovych', '25412548', '1994-7-24', 'Cherkassy', TRUE, 980, FALSE, '2016-6-22', 1, 2, 2, 2, 1, 2, NULL, NULL),
  (TRUE,'Petr', 'Petrenko', 'Petrovych', '45216', '1986-2-15', 'Chernigov', TRUE, 980, FALSE, '2016-7-21', 1, 3, 3, 3, NULL, 3, 1, 2);

INSERT INTO fm_manager.document (type, main, name, series, number, authority, date_issue, date_expire, owner_id) VALUES
  (1, TRUE, 'National Passport', 'KK', 123654, 'some authority', '1996-5-8', NULL, 1),
  (1, TRUE, 'National Passport', 'FF', 456932, 'some another authority', '2005-8-28', NULL, 2),
  (2, FALSE, 'Foreign Passport', 'GR', 1254874, 'foreign embassy', '2010-2-1', '2020-1-31', 2);

INSERT INTO fm_manager.account (name, number, balance, opened, updated, closed, owner_id) VALUES
  ('current account', 26200000000001, 5000, '2016-7-27 15:53:45', '2016-7-27 15:53:45', NULL, 1),
  ('deposit account', 26300000000001, 700000, '2016-7-27 15:56:23', '2016-7-27 15:56:23', NULL, 1);


