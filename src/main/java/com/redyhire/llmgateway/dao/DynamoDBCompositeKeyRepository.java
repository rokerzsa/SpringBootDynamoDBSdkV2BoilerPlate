package com.redyhire.llmgateway.dao;

import java.util.List;
import java.util.Optional;

public interface DynamoDBCompositeKeyRepository<T> extends DynamoDBRepository<T> {
  /**
   * Get all the element in the same partition using the partition key of the table
   *
   * @param partitionKey partition key of the table
   * @return List of all the relevant items
   */
  List<T> find(String partitionKey);

  /**
   * Get item using partition key and sort key of the table
   *
   * @param partitionKey partition key of the table
   * @param sortKey sort keey of the table
   * @return
   */
  Optional<T> find(String partitionKey, String sortKey);

  /**
   * Delete item using partition key and sort key of the table
   *
   * @param partitionKey partition key of the table
   * @param sortKey sort keey of the table
   */
  void deleteItem(String partitionKey, String sortKey);
}
