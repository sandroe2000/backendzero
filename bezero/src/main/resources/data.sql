insert into app_user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'ADMIN', 'Admin');
insert into app_access(fk_user, descr, value)values(1,'SEC_PRINCIPAL', 'V');
insert into app_access(fk_user, descr, value)values(1,'SEC_MODAL', 'V');
insert into app_access(fk_user, descr, value)values(1,'SEC_INSIDE_MODAL', 'V');
insert into app_access(fk_user, descr, value)values(1, 'FORMADETRATAMENTO', 'VWD');
insert into app_access(fk_user, descr, value)values(1, 'SEC_ADMIN', 'V');
insert into app_access(fk_user, descr, value)values(1, 'COMBO_BOX', 'VWD');
insert into app_access(fk_user, descr, value)values(1, 'COMBO_BOX_OPTIONS', 'VWD');
insert into app_access(fk_user, descr, value)values(1, 'DB_IMPORT_MODAL', 'VWD');

insert into app_user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'USER', 'Sandro');
insert into app_access(fk_user, descr, value)values(2,'SEC_PRINCIPAL', 'V');
insert into app_access(fk_user, descr, value)values(2,'SEC_MODAL', 'V');
insert into app_access(fk_user, descr, value)values(2,'SEC_INSIDE_MODAL', 'V');

insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1001, 'FISICA', 'CARLOS ALBERTO', '1992-02-03', '00000000000191', null, null, null);

insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1002, 'FISICA', '1-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003810', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1003, 'FISICA', '2-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003811', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1004, 'FISICA', '3-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003813', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1005, 'FISICA', '4-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003812', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1006, 'FISICA', '5-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003815', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1007, 'FISICA', '6-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003816', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1008, 'FISICA', '7-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003817', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1009, 'FISICA', '8-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003818', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1010, 'FISICA', '9-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003819', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1011, 'FISICA', '10-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003820', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1012, 'FISICA', '11-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03',  '18484003821', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1013, 'FISICA', '12-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003822', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1014, 'FISICA', '13-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003823', '377022950', 'habilitacao', '1234567890');

insert into email(fk_customer, is_principal, email)values(2, 'SIM', 'mariane.htinha@hotmail.com');

insert into phone(fk_customer, is_principal, phone)values(2, 'SIM', '21123456789');
insert into phone(fk_customer, is_principal, phone)values(2, null, '21987654321');

insert into address(fk_customer, is_principal, tipo_endereco, endereco, numero, complemento, bairro, cidade, uf, pais, cep) values (2, 'SIM', 'OUTROS', 'Rua Moura Brito', '189', 'apartamento 401', 'Tijuca', 'Rio de Janeiro', 'RJ', 'Brasil', '20520060');

insert into combo_box(descr, disabled)values('Tipo de publico', null);
insert into combo_box(descr, disabled)values('Pessoa', null);
insert into combo_box(descr, disabled)values('Genero', null);
insert into combo_box(descr, disabled)values('Forma de Tratamento', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'Prospect', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'Cliente', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'Contact', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(2, null, 'Física', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(2, null, 'Jurídica', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(3, null, 'Feminino', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(3, null, 'Masculino', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'Sr.', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'Sra.', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'Você', null);

--select * from combo_box_option where fk_combobox = 1;
--select * from information_schema.table_constraints where constraint_schema = 'cdr';
--select * from information_schema.key_column_usage where constraint_schema = 'cdr' and constraint_name like 'uk_klcl1bhfyvrdw4i9d3f14f6s2'
-- select * from forms_of_address;
-- drop table forms_of_address;
-- use cdr;
-- show tables;
