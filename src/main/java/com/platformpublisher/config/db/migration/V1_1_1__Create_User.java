package com.platformpublisher.config.db.migration;

import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_1_1__Create_User extends BaseJavaMigration {

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		String createTableUserSQL = "CREATE TABLE users(\n" +
				"\tid SERIAL PRIMARY KEY,\n" +
				"\tfull_name varchar(150) NOT NULL,\n" +
				"\tname_user varchar(30),\n" +
				"\temail varchar(50) NOT NULL,\n" +
				"\tpassword varchar(50) NOT NULL,\n" +
				"\tcreated_at date NOT NULL,\n" +
				"\taccount_activity boolean NOT NULL,\n" +
				"\tlinked_in varchar(100),\n" +
				"\tgithub varchar(100)\n" +
				");";
		
		Statement create = context.getConnection().createStatement();
		create.execute(createTableUserSQL);
	}
	
}
