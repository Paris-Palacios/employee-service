//package com.commerce.employeeservice.configurations;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
//import org.springframework.data.cassandra.config.SchemaAction;
//import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
//import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
//import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;
//import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;
//
//import java.util.List;
//
//@Configuration
//@EnableReactiveCassandraRepositories
//public class CassandraConfiguration extends AbstractReactiveCassandraConfiguration {
//
//    @Value("${spring.data.cassandra.keyspace-name}")
//    private String keySpace;
//    @Value("${spring.data.cassandra.contact-points}")
//    String contactPoints;
//
//    @Override
//    protected String getKeyspaceName() {
//        return keySpace;
//    }
//
//    @Override
//    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
//
//        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(getKeyspaceName())
//                .ifNotExists()
//                .with(KeyspaceOption.DURABLE_WRITES, true);
//
//        return List.of(specification);
//    }
//
//    @Override
//    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
//        return List.of(DropKeyspaceSpecification.dropKeyspace(keySpace));
//    }
//
//    @Override
//    protected String getContactPoints() {
//        return contactPoints;
//    }
//
//    @Override
//    public SchemaAction getSchemaAction() {
//        return SchemaAction.RECREATE;
//    }
//}
