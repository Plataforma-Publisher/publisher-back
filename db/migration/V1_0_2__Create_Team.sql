CREATE TABLE team(
	Id SERIAL PRIMARY KEY,
	Description varchar(255) NOT NULL,
	Id_Creator int NOT NULL,
	Team_People varchar(255) NOT NULL,
	Project_Id int NOT NULL
);