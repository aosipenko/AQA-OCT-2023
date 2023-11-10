package org.prog.sql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class BeanConfig {

    public final static String JENKINS = "jenkins";

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dmds =
                new DriverManagerDataSource(getSQLHost(), "user", "password");
        dmds.setDriverClassName("com.mysql.jdbc.Driver");
        return dmds;
    }

    private String getSQLHost() {
        String type = System.getProperty("driver.type", "local");
        if (JENKINS.equalsIgnoreCase(type)) {
            return "jdbc:mysql://mysql-db-1:3306/db";
        }
        return "jdbc:mysql://localhost:3306/db";
    }
}