package net.mariasoft.administrations;

import net.mariasoft.administrations.utils.MariasoftProperies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ MariasoftProperies.class })
public class MariasoftAdministrationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MariasoftAdministrationsApplication.class, args);
    }

}
