package bva.tusur.dz.config;

import org.jooq.ExecuteListener;
import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class DbConfig {

    @Value("${spring.datasource.driver-class-name}")
    private String driverName;
    @Value("${spring.datasource.url}")
    private String dataSourceUrl;
    @Value("${spring.datasource.username}")
    private String dataSourceUser;
    @Value("${spring.datasource.password}")
    private String dataSourcePassword;
    @Value("${jooq.sql.dialect}")
    private String sqlDialectName;
    @Value("${application.tours-schema}")
    private String toursSchema;

    /**
     * ...
     *
     * @return datasource
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverName);
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUser);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }

    /**
     * ...
     *
     * @return transactionAwareDataSource
     */
    @Bean
    public TransactionAwareDataSourceProxy transactionAwareDataSource() {
        return new TransactionAwareDataSourceProxy(dataSource());
    }

    /**
     * DataSourceTransactionManager bean.
     *
     * @return transactionManager
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * ...
     *
     * @return connectionProvider
     */
    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(transactionAwareDataSource());
    }

    /**
     * ...
     *
     * @return DSLContext
     */
    @Bean(name = "DSLContext")
    public DefaultDSLContext dsl() {
        return new DefaultDSLContext(configuration());
    }

    /**
     * ...
     *
     * @return jooqConfiguration
     */
    @Bean(name = "jooqConfig")
    public DefaultConfiguration configuration() {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration
                .settings()
                .setRenderMapping(
                        new RenderMapping()
                                .withSchemata(
                                        new MappedSchema()
                                                .withInput("tours")
                                                .withOutput(toursSchema)));
        jooqConfiguration.set(connectionProvider());
        ExecuteListener provider = new DefaultExecuteListener();
        jooqConfiguration.set(new DefaultExecuteListenerProvider(provider));

        SQLDialect dialect = SQLDialect.valueOf(sqlDialectName);
        jooqConfiguration.set(dialect);

        return jooqConfiguration;
    }
}
