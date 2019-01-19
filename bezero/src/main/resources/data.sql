insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'ADMIN', 'admin');
insert into access(fk_user, descr, value)values(1,'SEC_PRINCIPAL', 'V');
insert into access(fk_user, descr, value)values(1,'SEC_MODAL', 'V');
insert into access(fk_user, descr, value)values(1,'SEC_INSIDE_MODAL', 'V');
insert into access(fk_user, descr, value)values(1, 'FORMADETRATAMENTO', 'VWD');
insert into access(fk_user, descr, value)values(1, 'SEC_ADMIN', 'V');
insert into access(fk_user, descr, value)values(1, 'COMBO_BOX', 'VWD');
insert into access(fk_user, descr, value)values(1, 'COMBO_BOX_OPTIONS', 'VWD');
insert into access(fk_user, descr, value)values(1, 'DB_IMPORT_MODAL', 'VWD');

insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'USER', 'sandro');
insert into access(fk_user, descr, value)values(2,'SEC_PRINCIPAL', 'V');
insert into access(fk_user, descr, value)values(2,'SEC_MODAL', 'V');
insert into access(fk_user, descr, value)values(2,'SEC_INSIDE_MODAL', 'V');

insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1001, 'fisica', 'carlos alberto', '1992-02-03', '00000000000191', null, null, null);

insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1002, 'fisica', '1-mariane cavalcanti di espindula', '1997-01-03', '18484003810', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1003, 'fisica', '2-mariane cavalcanti di espindula', '1997-01-03', '18484003811', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1004, 'fisica', '3-mariane cavalcanti di espindula', '1997-01-03', '18484003813', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1005, 'fisica', '4-mariane cavalcanti di espindula', '1997-01-03', '18484003812', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1006, 'fisica', '5-mariane cavalcanti di espindula', '1997-01-03', '18484003815', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1007, 'fisica', '6-mariane cavalcanti di espindula', '1997-01-03', '18484003816', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1008, 'fisica', '7-mariane cavalcanti di espindula', '1997-01-03', '18484003817', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1009, 'fisica', '8-mariane cavalcanti di espindula', '1997-01-03', '18484003818', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1010, 'fisica', '9-mariane cavalcanti di espindula', '1997-01-03', '18484003819', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1011, 'fisica', '10-mariane cavalcanti di espindula', '1997-01-03', '18484003820', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1012, 'fisica', '11-mariane cavalcanti di espindula', '1997-01-03',  '18484003821', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1013, 'fisica', '12-mariane cavalcanti di espindula', '1997-01-03', '18484003822', '377022950', 'habilitacao', '1234567890');
insert into customer(corporate_id, pfj, name, birthsday, cpf_cnpj, rg_ie, document_type, document)values(1014, 'fisica', '13-mariane cavalcanti di espindula', '1997-01-03', '18484003823', '377022950', 'habilitacao', '1234567890');

insert into email(fk_customer, is_principal, email)values(2, 'SIM', 'mariane.htinha@hotmail.com');

insert into phone(fk_customer, is_principal, phone)values(2, 'SIM', '21123456789');
insert into phone(fk_customer, is_principal, phone)values(2, null, '21987654321');

insert into address(
	fk_customer,
	is_principal,
	tipo_endereco,
	endereco,
	numero,
	complemento,
	bairro,
	cidade,
	uf,
	pais,
	cep)
values(
	2,
	'SIM',
	'outros',
	'rua moura brito',
	'189',
	'apartamento 401',
	'tijuca',
	'rio de janeiro',
	'rj',
	'brasil',
	'20520060');

insert into combo_box(descr, disabled)values('tipo de publico', null);
insert into combo_box(descr, disabled)values('pessoa', null);
insert into combo_box(descr, disabled)values('genero', null);
insert into combo_box(descr, disabled)values('forma de tratamento', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'prospect', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'cliente', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(1, null, 'contact', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(2, null, 'física', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(2, null, 'jurídica', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(3, null, 'feminino', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(3, null, 'masculino', null);

insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'sr.', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'sra.', null);
insert into combo_box_option(fk_combo_box, corporate_id, descr, disabled)values(4, null, 'você', null);


insert into db_import_connection (connection, driver, host, port, db_name, owner, user_name, password, url)
values ('bradesco dsv', 'oracle', '10.205.106.36', 1521, 'd005.bseguros', 'crmp', 'apstnvca', 'apstnvca', 'jdbc:oracle:thin:@10.205.106.36:1521/d005.bseguros');


--select * from combo_box_option where fk_combobox = 1;
--select * from information_schema.table_constraints where constraint_schema = 'cdr';
--select * from information_schema.key_column_usage where constraint_schema = 'cdr' and constraint_name like 'uk_klcl1bhfyvrdw4i9d3f14f6s2'
-- select * from forms_of_address;
-- drop table forms_of_address;
-- use cdr;
-- show tables;