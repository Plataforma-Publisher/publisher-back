package com.platformpublisher.config.db.migration;

import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_2_1__Create_Team extends BaseJavaMigration {

	public void migrate(Context context) throws Exception {		
		
		String createTeamSQL = "CREATE TABLE teams(\n" +
				"\tid SERIAL PRIMARY KEY,\n" +
				"\tteam_description varchar(255) NOT NULL,\n" +
				"\tid_team_creator int NOT NULL, \n" +
                                "\tteam_active boolean NOT NULL \n" +
				");";
		
		Statement insert = context.getConnection().createStatement();
		insert.execute(createTeamSQL);
	}
	
}
