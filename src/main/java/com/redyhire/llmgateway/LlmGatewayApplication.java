package com.redyhire.llmgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.GetItemRequest;
import software.amazon.awssdk.services.dynamodb.model.GetItemResponse;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class LlmGatewayApplication implements ApplicationRunner {
  @Autowired DynamoDbClient dynamoDbClient;

  public static void main(String[] args) {
    SpringApplication.run(LlmGatewayApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    //setup
  }

}
