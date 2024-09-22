package com.redyhire.llmgateway.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDbBean
public class InternalUser {
  private String email;
  private String name;
  private String unitId;
  private String userId;

  @DynamoDbPartitionKey
  public String getUnitId() {
    return unitId;
  }

  @DynamoDbSortKey
  public String getUserId() {
    return userId;
  }
}
