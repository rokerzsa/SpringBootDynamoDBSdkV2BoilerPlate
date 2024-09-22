package com.redyhire.llmgateway.dao.repositories;

import com.redyhire.llmgateway.dao.DynamoDBCompositeKeyRepository;
import com.redyhire.llmgateway.dao.entities.InternalUser;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;

@Repository
public class InternalUserRepository implements DynamoDBCompositeKeyRepository<InternalUser> {
  private static final String tableName = "RedyhireInternalUsers";
  private final DynamoDbTable<InternalUser> table;

  @Autowired
  InternalUserRepository(DynamoDbEnhancedClient dynamoDbEnhancedClient) {
    this.table = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(InternalUser.class));
  }

  @Override
  public List<InternalUser> find(String partitionKey) {
    QueryConditional queryConditional =
        QueryConditional.keyEqualTo(k -> k.partitionValue(partitionKey));
    return table.query(request -> request.queryConditional(queryConditional)).items().stream()
        .toList();
  }

  @Override
  public Optional<InternalUser> find(String partitionKey, String sortKey) {
    return Optional.ofNullable(table.getItem(
            request -> request.key(key -> key.partitionValue(partitionKey).sortValue(sortKey))));
  }

  @Override
  public void deleteItem(String partitionKey, String sortKey) {
    table.deleteItem(
        request -> request.key(key -> key.partitionValue(partitionKey).sortValue(sortKey)));
  }

  @Override
  public void save(InternalUser internalUser) {
    table.putItem(internalUser);
  }

  @Override
  public List<InternalUser> findByIndex(String partitionKey) {
    QueryConditional queryConditional =
        QueryConditional.keyEqualTo(k -> k.partitionValue(partitionKey));
    return table.query(request -> request.queryConditional(queryConditional)).items().stream()
        .toList();
  }

  @Override
  public List<InternalUser> findByIndex(String partitionKey, String sortKey) {
    QueryConditional queryConditional =
        QueryConditional.keyEqualTo(k -> k.partitionValue(partitionKey));
    return table.query(request -> request.queryConditional(queryConditional)).items().stream()
        .toList();
  }
}
