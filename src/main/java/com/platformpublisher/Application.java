package com.platformpublisher;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.Location;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext App = SpringApplication.run(Application.class, args);
		
		String url = "jdbc:postgresql://localhost:5440/publisher";
		String user = "postgres";
		String password = "postgres";
		Location migrationLoc = new Location("com/platformpublisher/config/db/migration");
		
		Flyway flyway = Flyway
				.configure()
				.dataSource(url,user,password)
				.locations(migrationLoc)
				.load();
		
		flyway.clean();

		flyway.migrate();
		flyway.info();
	}

}
