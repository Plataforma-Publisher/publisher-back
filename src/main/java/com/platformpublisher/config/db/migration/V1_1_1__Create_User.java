package com.platformpublisher.config.db.migration;

import java.sql.ResultSet;
import java.sql.Statement;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

public class V1_1_1__Create_User extends BaseJavaMigration {

	public void migrate(Context context) throws Exception {
		// TODO Auto-generated method stub
		
		String createTableUserSQL = "CREATE TABLE users(\n" +
				"\tId SERIAL PRIMARY KEY,\n" +
				"\tNome_Completo varchar(150) NOT NULL,\n" +
				"\tEmail varchar(50) NOT NULL,\n" +
				"\tSenha varchar(50) NOT NULL,\n" +
				"\tData_criacao date NOT NULL,\n" +
				"\tAtividade_Conta boolean NOT NULL,\n" +
				"\tLinkedIn_Link varchar(255),\n" +
				"\tGithub_Link varchar(150)\n" +
				");";
		
		Statement create = context.getConnection().createStatement();
		create.execute(createTableUserSQL);
	}
	
}
