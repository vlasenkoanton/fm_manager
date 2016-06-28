DELETE FROM fm_manager.document;
DELETE FROM fm_manager.client;
DELETE FROM fm_manager.address;
DELETE FROM fm_manager.work;
DELETE FROM fm_manager.contact;

ALTER TABLE fm_manager.document AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.client AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.address AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.work AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.contact AUTO_INCREMENT = 1;
ALTER TABLE fm_manager.entrepreneurInfo AUTO_INCREMENT = 1;

INSERT INTO fm_manager.address (postCode, country, region, district, city, street, house, apartment) VALUES
  (111111, 980, 'Cherkassy', 'USR', 'Cherkassy', 'Sumgaitska', 45, 23),
  (222222, 980, '', 'Sviatoshynskiy', 'Kiev', 'Rykova', 5, 6),
  (333333, 980, '', 'Obolonskiy', 'Kiev', 'G. Stalingrada', 25, 62);

INSERT INTO fm_manager.work (name, identCode, position) VALUES
  ('First Corporation', 236589, 'Programmer'),
  ('Second Company', 158421, 'Lawyer'),
  ('Commercial Bank', 256348, 'Client service specialist');

INSERT INTO fm_manager.contact (homeTel, workTel, mobileTel, fax, email) VALUES
  ('044-254-44-55', '044-125-52-63', '063-562-32-52', NULL, 'anton_antonenko@e.mail'),
  ('044-222-20-39', '044-564-99-21', '050-503-78-87', NULL, 'ivan_ivanenko@e.mail'),
  ('044-325-32-47', '044-889-02-31', '073-564-22-13', NULL, 'petr_petrenko@e.mail');

INSERT INTO fm_manager.entrepreneur (regNumber, authority, regDate, activity) VALUES
  (123654789, 'fop registration', '2006-3-26', 'legal activity');

INSERT INTO fm_manager.client (firstName, lastName, middleName, identNumber, dateBirth, placeBirth, resident, citizenship, responsible, pep, address_id, work_id, contact_id, entrepreneurInfo_id) VALUES
  ('Anton', 'Antonenko', 'Antonovych', 12365474, '1988-5-5', 'Cherkassy', TRUE, 980, 'Vasya Pupkin', FALSE,
            (SELECT id FROM fm_manager.address WHERE postCode=111111),
            (SELECT id FROM fm_manager.work WHERE identCode=236589),
            (SELECT id FROM fm_manager.contact WHERE email='anton_antonenko@e.mail'), NULL ),
  ('Ivan', 'Ivanenko', 'Ivanovych', 25412548, '1994-7-24', 'Cherkassy', TRUE, 980, 'Vasya Pupkin', FALSE,
           (SELECT id FROM fm_manager.address WHERE postCode=222222),
           (SELECT id FROM fm_manager.work WHERE identCode=158421),
           (SELECT id FROM fm_manager.contact WHERE email='ivan_ivanenko@e.mail'),
           (SELECT id FROM fm_manager.entrepreneurInfo WHERE id=1)),
  ('Petr', 'Petrenko', 'Petrovych', 45216, '1986-2-15', 'Chernigov', TRUE, 980, 'Vasya Pupkin', FALSE,
           (SELECT id FROM fm_manager.address WHERE postCode=333333),
           (SELECT id FROM fm_manager.work WHERE identCode=256348),
           (SELECT id FROM fm_manager.contact WHERE email='petr_petrenko@e.mail'), NULL);

INSERT INTO fm_manager.document (type, main, name, series, number, authority, dateIssue, dateExpire, owner_id) VALUES
  (1, TRUE, 'National Passport', 'KK', 123654, 'some authority', '1996-5-8', NULL, (SELECT id FROM fm_manager.client WHERE client.identNumber=12365474)),
  (1, TRUE, 'National Passport', 'FF', 456932, 'some another authority', '2005-8-28', NULL, (SELECT id FROM fm_manager.client WHERE client.identNumber=25412548)),
  (2, FALSE, 'Foreign Passport', 'GR', 1254874, 'foreign embassy', '2010-2-1', '2020-1-31', (SELECT id FROM fm_manager.client WHERE client.identNumber=25412548));