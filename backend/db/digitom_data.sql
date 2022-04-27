INSERT INTO digi_tom.role (name)
VALUES ('Admin');
INSERT INTO digi_tom.role (name)
VALUES ('Inspector');
INSERT INTO digi_tom.role (name)
VALUES ('User');

INSERT INTO digi_tom.user (email, password)
VALUES ('kirillp1988@gmail.com', '123');
INSERT INTO digi_tom.user (email, password)
VALUES ('ergotammel@gmail.com', '456');
INSERT INTO digi_tom.user (email, password)
VALUES ('silversomma@gmail.com', '789');

INSERT INTO digi_tom.contact (id, user_id, phone_number, first_name, middle_name, last_name)
VALUES (DEFAULT, 1, '5656', 'Kirill', null, 'Pavlov');
INSERT INTO digi_tom.contact (id, user_id, phone_number, first_name, middle_name, last_name)
VALUES (DEFAULT, 2, '5757', 'Silver', 'Tiit', 'Somma');
INSERT INTO digi_tom.contact (id, user_id, phone_number, first_name, middle_name, last_name)
VALUES (DEFAULT, 3, '5858', 'Ergo', null, 'Tammel');

INSERT INTO digi_tom.company (id, name, reg_number)
VALUES (DEFAULT, 'Merko Ehitus', 1400001);
INSERT INTO digi_tom.company (id, name, reg_number)
VALUES (DEFAULT, 'Astlanda Ehitus', 1400002);
INSERT INTO digi_tom.company (id, name, reg_number)
VALUES (DEFAULT, 'Nordecon', 1400003);
INSERT INTO digi_tom.company (id, name, reg_number)
VALUES (DEFAULT, 'YIT Eesti', 1400004);
INSERT INTO digi_tom.company (id, name, reg_number)
VALUES (DEFAULT, 'Mapri Ehitus', 1400005);

INSERT INTO digi_tom.company_user (id, company_id, user_id) VALUES (DEFAULT, 1, 1);
INSERT INTO digi_tom.company_user (id, company_id, user_id) VALUES (DEFAULT, 2, 2);
INSERT INTO digi_tom.company_user (id, company_id, user_id) VALUES (DEFAULT, 3, 3);

INSERT INTO digi_tom.construction_site (id, name, address, latitude, longitude) VALUES (DEFAULT, 'Tehnopol', 'Ehitajate tee 127', 59.416906, 24.653828);
INSERT INTO digi_tom.construction_site (id, name, address, latitude, longitude) VALUES (DEFAULT, 'PERH', 'Sütiste tee 12', 55.216906, 22.653828);
INSERT INTO digi_tom.construction_site (id, name, address, latitude, longitude) VALUES (DEFAULT, 'Balti jaam', 'Toompuiestee 31', 42.416906, 22.653828);
INSERT INTO digi_tom.construction_site (id, name, address, latitude, longitude) VALUES (DEFAULT, 'Viru keskus', 'Viru 2', 52.416906, 24.653828);
INSERT INTO digi_tom.construction_site (id, name, address, latitude, longitude) VALUES (DEFAULT, 'TTÜ', 'Ehitajate tee 121', 59.516906, 24.853828);

INSERT INTO digi_tom.company_construction_site (id, company_id, construction_site_id, main_contractor) VALUES (DEFAULT, 1, 1, true);
INSERT INTO digi_tom.company_construction_site (id, company_id, construction_site_id, main_contractor) VALUES (DEFAULT, 2, 2, false);
INSERT INTO digi_tom.company_construction_site (id, company_id, construction_site_id, main_contractor) VALUES (DEFAULT, 3, 3, false);
INSERT INTO digi_tom.company_construction_site (id, company_id, construction_site_id, main_contractor) VALUES (DEFAULT, 4, 4, false);
INSERT INTO digi_tom.company_construction_site (id, company_id, construction_site_id, main_contractor) VALUES (DEFAULT, 5, 5, false);

INSERT INTO digi_tom.user_role (id, user_id, role_id) VALUES (DEFAULT, 1, 1);
INSERT INTO digi_tom.user_role (id, user_id, role_id) VALUES (DEFAULT, 2, 2);
INSERT INTO digi_tom.user_role (id, user_id, role_id) VALUES (DEFAULT, 3, 3);

INSERT INTO digi_tom.report (id, construction_site_id, date) VALUES (DEFAULT, 1, '2022-04-27');
INSERT INTO digi_tom.report (id, construction_site_id, date) VALUES (DEFAULT, 2, '2022-04-26');
INSERT INTO digi_tom.report (id, construction_site_id, date) VALUES (DEFAULT, 3, '2022-04-25');
INSERT INTO digi_tom.report (id, construction_site_id, date) VALUES (DEFAULT, 4, '2022-04-24');
INSERT INTO digi_tom.report (id, construction_site_id, date) VALUES (DEFAULT, 5, '2022-04-22');

INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 1, 'Kukkumisohu vältimine, varinguoht, uppumisoht');
INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 2, 'Tellingud, redelid, liikumisteed');
INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 3, 'Ehitusmasinad, tõsteseadmed ja käsitööriistad');
INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 4, 'Elekter ja valgustus');
INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 5, 'Üldine kord, sh. olme ja jäätmekäitlus');
INSERT INTO digi_tom.safety_field (id, field_number, field_description) VALUES (DEFAULT, 6, 'Ehitustöölised');

INSERT INTO digi_tom.incident (id, safe, safety_field_id, report_id) VALUES (DEFAULT, true, 1, 1);
INSERT INTO digi_tom.incident (id, safe, safety_field_id, report_id) VALUES (DEFAULT, true, 3, 2);
INSERT INTO digi_tom.incident (id, safe, safety_field_id, report_id) VALUES (DEFAULT, false, 5, 3);
INSERT INTO digi_tom.incident (id, safe, safety_field_id, report_id) VALUES (DEFAULT, true, 6, 4);
INSERT INTO digi_tom.incident (id, safe, safety_field_id, report_id) VALUES (DEFAULT, false, 6, 5);

INSERT INTO digi_tom.task (id, safety_field_id, report_id, description, deadline, is_done) VALUES (DEFAULT, 5, 3, 'Ekskavaator ripub kolmanda korruse aknast välja', '2022-04-29', false);
INSERT INTO digi_tom.task (id, safety_field_id, report_id, description, deadline, is_done) VALUES (DEFAULT, 6, 5, 'Inimväljaheited kolmandas trepikojas igal trepiastmel', '2022-04-28', false);

INSERT INTO digi_tom.report_picture (id, report_id, task_id, description, base64) VALUES (DEFAULT, 3, 1, 'Koristage ära', 'Bytea siia panna');
INSERT INTO digi_tom.report_picture (id, report_id, task_id, description, base64) VALUES (DEFAULT, 5, 2, 'Koristage ära', 'Bytea siia panna');

INSERT INTO digi_tom.task_response (id, task_id, description, time) VALUES (DEFAULT, 1, 'Tehtud', '2022-04-27 15:19:15.000000');
INSERT INTO digi_tom.task_response (id, task_id, description, time) VALUES (DEFAULT, 2, 'Tehtud', '2022-04-28 11:21:43.000000');

INSERT INTO digi_tom.task_response_picture (id, task_response_id, base64) VALUES (DEFAULT, 1, 'Bytea värk siia');
INSERT INTO digi_tom.task_response_picture (id, task_response_id, base64) VALUES (DEFAULT, 2, 'Bytea värk siia');