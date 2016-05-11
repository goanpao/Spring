package com.savio;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.convert.CassandraConverter;
import org.springframework.data.cassandra.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.mapping.BasicCassandraMappingContext;
import org.springframework.data.cassandra.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import com.savio.model.Person;

@SpringBootApplication
@Configuration
@PropertySource(value = { "classpath:cassandra.properties" })
@EnableCassandraRepositories(basePackages = { "com.savio.model" })
public class SpringCassandraApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SpringCassandraApplication.class);

	@Autowired
	private Environment env;

	@Autowired
	private CassandraOperations cassandraOperations;

	@Bean
	public CassandraClusterFactoryBean cluster() {

		CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();
		cluster.setContactPoints(env.getProperty("cassandra.contactpoints"));
		cluster.setPort(Integer.parseInt(env.getProperty("cassandra.port")));

		return cluster;
	}

	@Bean
	public CassandraMappingContext mappingContext() {
		return new BasicCassandraMappingContext();
	}

	@Bean
	public CassandraConverter converter() {
		return new MappingCassandraConverter(mappingContext());
	}

	@Bean
	public CassandraSessionFactoryBean session() throws Exception {

		CassandraSessionFactoryBean session = new CassandraSessionFactoryBean();
		session.setCluster(cluster().getObject());
		session.setKeyspaceName(env.getProperty("cassandra.keyspace"));
		session.setConverter(converter());
		session.setSchemaAction(SchemaAction.NONE);

		return session;
	}

	@Bean
	public CassandraOperations cassandraTemplate() throws Exception {
		return new CassandraTemplate(session().getObject());
	}

	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			cassandraOperations.insert(new Person("123123123", "Alison"));
			
			String cqlAll = "select * from Person";

			List<Person> results = cassandraOperations.select(cqlAll, Person.class);
			for (Person p : results) {
				LOG.info(String.format("Found People with Name [%s] for id [%s]", p.getName(), p.getpId()));
			}
			
			String cqlOne = "select * from person where id = '123123123'";

			Person p = cassandraOperations.selectOne(cqlOne, Person.class);
			LOG.info(String.format("Found Person with Name [%s] for id [%s]", p.getName(), p.getpId()));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCassandraApplication.class, args);
	}
}
