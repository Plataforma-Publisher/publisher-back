CREATE TABLE users(
	Id SERIAL PRIMARY KEY,
	Nome_Completo varchar(150) NOT NULL,
	Email varchar(50) NOT NULL,
	Senha varchar(50) NOT NULL,
	Data_criacao date NOT NULL,
	Atividade_Conta boolean NOT NULL,
	LinkedIn_Link varchar(255),
	Github_Link varchar(150)
);