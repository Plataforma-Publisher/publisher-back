package com.platformpublisher.config.db.migration;

import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_2_1__Create_Team extends BaseJavaMigration {

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		
		String createTeamSQL = "CREATE TABLE team(\n" +
				"\tId SERIAL PRIMARY KEY,\n" +
				"\tDescription varchar(255) NOT NULL,\n" +
				"\tId_Creator int NOT NULL,\n" +
				"\tTeam_People varchar(255) NOT NULL,\n" +
				"\tProject_Id int NOT NULL\n" +
				");";
		
		Statement insert = context.getConnection().createStatement();
		insert.execute(createTeamSQL);
	}
	
}
