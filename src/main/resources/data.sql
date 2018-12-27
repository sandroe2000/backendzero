insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'ADMIN', 'admin');
insert into access(fk_user, descr, value)values(1,'secPrincipal', 'V');
insert into access(fk_user, descr, value)values(1,'secModal', 'V');
insert into access(fk_user, descr, value)values(1,'secInsideModal', 'V');
insert into access(fk_user, descr, value)values(1, 'formaDeTratamento', 'V');

insert into user(disabled, password, role, username)values(null, '$2a$10$EblZqNptyYvcLm/VwDCVAuBjzZOI7khzdyGPBr08PpIi0na624b8.', 'USER', 'sandro');
insert into access(fk_user, descr, value)values(2,'secInsideModal', 'V');
insert into access(fk_user, descr, value)values(2,'secModal', 'V');

insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1001, 'FISICA', 'CARLOS ALBERTO', '1992-02-03', 'carlos@gmail.com', '21965563148', null, '00000000000191', null, null, null);

insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '1-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane1@gmail.com', '1152158290', null, '18484003810', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '2-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane2@gmail.com', '1152158290', null, '18484003811', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '3-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane3@gmail.com', '1152158290', null, '18484003813', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '4-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane4@gmail.com', '1152158290', null, '18484003812', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '5-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane5@gmail.com', '1152158290', null, '18484003815', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '6-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane6@gmail.com', '1152158290', null, '18484003816', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '7-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane7@gmail.com', '1152158290', null, '18484003817', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '8-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane8@gmail.com', '1152158290', null, '18484003818', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '9-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane9@gmail.com', '1152158290', null, '18484003819', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '10-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane10@gmail.com', '1152158290', null, '18484003820', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '11-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane11@gmail.com', '1152158290', null, '18484003821', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '12-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane12@gmail.com', '1152158290', null, '18484003822', '377022950', 'HABILITACAO', '1234567890');
insert into customer(CORPORATE_ID, PFJ, NAME, BIRTHSDAY, EMAIL, CELLPHONE, COMMERCIAL_PHONE, CPF_CNPJ, RG_IE, DOCUMENT_TYPE, DOCUMENT)values(1000, 'FISICA', '13-MARIANE CAVALCANTI DI ESPINDULA', '1997-01-03', 'mariane13@gmail.com', '1152158290', null, '18484003823', '377022950', 'HABILITACAO', '1234567890');