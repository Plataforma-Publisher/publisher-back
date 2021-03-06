CREATE TABLE project(
	Id SERIAL PRIMARY KEY,
	Team_Id int NOT NULL,
	Name varchar(150) NOT NULL,
	Description varchar(255) NOT NULL,
	Video_Link varchar(255) NOT NULL,
	Image_Links varchar(255) NOT NULL,
	Comments varchar(255) NOT NULL,
	Likes varchar(255) NOT NULL
);