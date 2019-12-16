package com.niit.Hproject.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Hproject.Dao.UserDaoImpl;
import com.niit.Hproject.Model.UserInfo;

@Configuration

@EnableTransactionManagement

@ComponentScan("com.niit.Hproject.Model")
public class HibernateConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setUrl("jdbc:mysql://localhost:3307/ramya");

		dataSource.setDriverClassName("com.mysql.jdbc.Driver");

		dataSource.setUsername("root");
		dataSource.setPassword("password@123");

		return dataSource;
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		//properties.put("hibernate.format_sql", "true");
	properties.put("hibernate.hbm2ddl.auto", "update");
		System.out.println("inn properties");
		return properties;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setAnnotatedClasses(UserInfo.class);
		//sessionFactory.setPackagesToScan(new String[] { "com.niit.Hproject.Model.Sub" });
		sessionFactory.setHibernateProperties(getHibernateProperties());
		System.out.println("session");
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "userDao")
	public UserDaoImpl getUserData(SessionFactory sf) {
		System.out.println("user dao");
		return new UserDaoImpl(sf);

	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

}

