package com.platformpublisher.config.db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.Statement;

public class V1_3_1__Create_Project extends BaseJavaMigration {

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		
		String createProjectSQL = "CREATE TABLE project(\n" +
				"\tId SERIAL PRIMARY KEY,\n" +
				"\tTeam_Id int NOT NULL,\n" +
				"\tName varchar(150) NOT NULL,\n" +
				"\tDescription varchar(255) NOT NULL,\n" +
				"\tVideo_Link varchar(255) NOT NULL,\n" +
				"\tImage_Links varchar(255) NOT NULL,\n" +
				"\tComments varchar(255) NOT NULL,\n" +
				"\tLikes varchar(255) NOT NULL\n" +
				");";
		
		Statement insert = context.getConnection().createStatement();
		insert.execute(createProjectSQL);
	}
	
}
