package com.jovan.sgparkingv2.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Profile("!dev")
@EnableJpaRepositories(basePackages = "com.jovan.sgparkingv2")
public class ProdDataSourceConfig {

    @Bean
    public DataSourceProperties prodDataSourceProperties(){
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl(System.getProperty("datasourceUrl"));
        dataSourceProperties.setUsername(System.getProperty("datasourceUsername"));
        dataSourceProperties.setPassword(System.getProperty("datasourcePassword"));
        return dataSourceProperties;
    }

    @Bean
    public DataSource prodDataSource(@Qualifier("prodDataSourceProperties") DataSourceProperties dataSourceProperties){
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }
}
