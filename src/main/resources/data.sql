insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'ADMIN', 'admin');
insert into access(fk_user, descr, value)values(1,'secPrincipal', 'V');
insert into access(fk_user, descr, value)values(1,'secModal', 'V');
insert into access(fk_user, descr, value)values(1,'secInsideModal', 'V');
insert into access(fk_user, descr, value)values(1, 'formaDeTratamento', 'VWD');
insert into access(fk_user, descr, value)values(1, 'secAdminstracao', 'V');
insert into access(fk_user, descr, value)values(1, 'customerTipoDePublico', 'V');
insert into access(fk_user, descr, value)values(1, 'customerFormaDeTratamento', 'V');
insert into access(fk_user, descr, value)values(1, 'formaDeTratamentoComboBox', 'V');

insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'USER', 'sandro');
insert into access(fk_user, descr, value)values(2,'secInsideModal', 'V');
insert into access(fk_user, descr, value)values(2,'secModal', 'V');

insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1001, 'FISICA', 'CARLOS ALBERTO', '1992-02-03', '00000000000191', null, null, null);

insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1002, 'FISICA', '1-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003810', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1003, 'FISICA', '2-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003811', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1004, 'FISICA', '3-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003813', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1005, 'FISICA', '4-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003812', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1006, 'FISICA', '5-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003815', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1007, 'FISICA', '6-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003816', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1008, 'FISICA', '7-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003817', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1009, 'FISICA', '8-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003818', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1010, 'FISICA', '9-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003819', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1011, 'FISICA', '10-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003820', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1012, 'FISICA', '11-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03',  '18484003821', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1013, 'FISICA', '12-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003822', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1014, 'FISICA', '13-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', '18484003823', '377022950', 'HABILITACAO', '1234567890');

insert into email(FK_CUSTOMER, IS_PRINCIPAL, EMAIL)values(2, 'SIM', 'mariane.htinha@hotmail.com');

insert into phone(FK_CUSTOMER, IS_PRINCIPAL, PHONE)values(2, 'SIM', '21123456789');
insert into phone(FK_CUSTOMER, IS_PRINCIPAL, PHONE)values(2, null, '21987654321');

insert into ADDRESS(
	FK_CUSTOMER, 
	IS_PRINCIPAL, 
	TIPO_ENDERECO, 
	ENDERECO, 
	NUMERO, 
	COMPLEMENTO, 
	BAIRRO, 
	CIDADE, 
	UF, 
	PAIS, 
	CEP)
values(
	2, 
	'SIM', 
	'OUTROS', 
	'RUA MOURA BRITO', 
	'189', 
	'APARTAMENTO 401', 
	'TIJUCA', 
	'RIO DE JANEIRO', 
	'RJ', 
	'BRASIL', 
	'20520060');

-------- ADMIN --------------------------------
	

------- COMBOBOX ------------------

insert into COMBO_BOX(DESCR, DISABLED)values('Tipo de publico', null);
insert into COMBO_BOX(DESCR, DISABLED)values('Pessoa', null);
insert into COMBO_BOX(DESCR, DISABLED)values('Genero', null);
insert into COMBO_BOX(DESCR, DISABLED)values('Forma de Tratamento', null);

insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(1, null, 'Prospect', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(1, null, 'Cliente', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(1, null, 'Contact', null);

insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(2, null, 'Física', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(2, null, 'Jurídica', null);

insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(3, null, 'Feminino', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(3, null, 'Masculino', null);

insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(4, null, 'Sr.', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(4, null, 'Sra.', null);
insert into COMBO_BOX_OPTION(FK_COMBO_BOX, CORPORATE_ID, DESCR, DISABLED)values(4, null, 'Você', null);


/*
 
 SELECT * FROM COMBO_BOX_OPTION WHERE fk_combobox = 1;
 
select * from information_schema.table_constraints where constraint_schema = 'cdr';

select * from information_schema.key_column_usage where constraint_schema = 'cdr' and CONSTRAINT_NAME like 'UK_klcl1bhfyvrdw4i9d3f14f6s2'
 
 */
-- SELECT * FROM FORMS_OF_ADDRESS;
-- DROP TABLE FORMS_OF_ADDRESS;
-- USE CDR;
-- SHOW TABLES;