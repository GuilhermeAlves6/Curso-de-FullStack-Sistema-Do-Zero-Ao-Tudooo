INSERT INTO NPL_USUARIO (ID, NOME, LOGIN, SENHA, EMAIL) VALUES ('1','Rogério','rogerio','1234','rogerionj@gmail.com');

ALTER SEQUENCE NPL_USUARIO_ID_SEQ RESTART WITH 2; 

INSERT INTO NPL_PERFIL(ID, DESCRICAO) VALUES ('1','Administrador');

ALTER SEQUENCE NPL_PERFIL_SEQ RESTART WITH 2;