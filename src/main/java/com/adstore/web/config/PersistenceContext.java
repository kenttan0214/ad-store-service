package com.adstore.web.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.adstore.web.repository" })
public class PersistenceContext {
	private static final String[] ENTITY_PACKAGES = { "com.adstore.web.entity" };

	private static final String PROPERTY_NAME_DB_DRIVER_CLASS = "db.driver";
	private static final String PROPERTY_NAME_DB_PASSWORD = "db.password";
	private static final String PROPERTY_NAME_DB_URL = "db.url";
	private static final String PROPERTY_NAME_DB_USER = "db.username";
	private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "hibernate.dialect";
	private static final String PROPERTY_NAME_HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
	private static final String PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private static final String PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY = "hibernate.ejb.naming_strategy";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";

	/**
	 * Creates and configures Hikari data source
	 * 
	 * @param env
	 * @return
	 */
	@Bean
	DataSource dataSource(Environment env) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getRequiredProperty(PROPERTY_NAME_DB_DRIVER_CLASS));
		dataSource.setUrl(env.getRequiredProperty(PROPERTY_NAME_DB_URL));
		dataSource.setUsername(env.getRequiredProperty(PROPERTY_NAME_DB_USER));
		dataSource.setPassword(env.getRequiredProperty(PROPERTY_NAME_DB_PASSWORD));
		
		return dataSource;
	}

	/**
	 * Creates the bean that creates the JPA entity manager factory.
	 * 
	 * @param dataSource
	 *            The datasource that provides the database connections.
	 * @param env
	 *            The runtime environment of our application.
	 * @return
	 */
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan(ENTITY_PACKAGES);

		Properties jpaProperties = new Properties();

		// Configures the used database dialect. This allows Hibernate to create
		// SQL
		// that is optimized for the used database.
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_DIALECT, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_DIALECT));

		// Specifies the action that is invoked to the database when the
		// Hibernate
		// SessionFactory is created or closed.
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_HBM2DDL_AUTO));

		// Configures the naming strategy that is used when Hibernate creates
		// new database objects and schema elements
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_NAMING_STRATEGY));

		// If the value of this property is true, Hibernate writes all SQL
		// statements to the console.
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_SHOW_SQL));

		// If the value of this property is true, Hibernate will use prettyprint
		// when it writes SQL to the console.
		jpaProperties.put(PROPERTY_NAME_HIBERNATE_FORMAT_SQL,
				env.getRequiredProperty(PROPERTY_NAME_HIBERNATE_FORMAT_SQL));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	/**
	 * Creates the transaction manager bean that integrates the used JPA
	 * provider with the Spring transaction mechanism.
	 * 
	 * @param entityManagerFactory
	 *            The used JPA entity manager factory.
	 * @return
	 */
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}
