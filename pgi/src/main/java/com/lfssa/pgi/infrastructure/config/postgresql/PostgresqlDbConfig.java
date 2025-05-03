package com.lfssa.pgi.infrastructure.config.postgresql;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Configuration(proxyBeanMethods = false)
public class PostgresqlDbConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.config")
    public HikariDataSource dataSource(DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

}
