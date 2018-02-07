package raip.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages= {"raip.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

		private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
		private final static String DATABASE_DRIVER = "org.h2.Driver";
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
		private final static String DATABASE_USERNAME = "sa";
		private final static String DATABASE_PASSWORD = "";
		
		@Bean
		private DataSource getDataSource() {
			BasicDataSource datasource = new BasicDataSource();
			datasource.setDriverClassName(DATABASE_DRIVER);
			datasource.setUrl(DATABASE_URL);
			datasource.setUsername(DATABASE_USERNAME);
			datasource.setPassword(DATABASE_PASSWORD);
			
			return datasource;
			
		}
		
		@Bean 
		public SessionFactory getSessionFactory(DataSource datasource) {
			
			LocalSessionFactoryBuilder session = new LocalSessionFactoryBuilder(datasource);
			session.scanPackages("raip.shoppingbackend.dto");
			return session.buildSessionFactory();
			
		}
		
		private Properties getHibernateProperties() {
			Properties props = new Properties();
			props.put("hibernate.dialect",DATABASE_DIALECT);
			props.put("hibernate.show_sql", "true");
			props.put("hibernate.format_sql", "true");
			
			return props;
			
		}
		
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			HibernateTransactionManager transactionmnger= new HibernateTransactionManager(sessionFactory);
			return transactionmnger;
		}

}
