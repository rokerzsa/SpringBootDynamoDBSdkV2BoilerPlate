package com.redyhire.llmgateway.unittests.dao;

import com.redyhire.llmgateway.dao.DynamoDBConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;

@SpringBootTest
public class TestDynamoDBConfig {
    @Autowired
    private DynamoDbClient dynamoDbClient;
    @Test
    public void testConfigInitialization(){
            ListTablesResponse listTablesResponse = dynamoDbClient.listTables();
            listTablesResponse.tableNames().forEach(System.out::println);
    }
}
