package com.redyhire.llmgateway.dao;

import java.util.List;

public interface DynamoDBRepository<T> {
    /**
     * Save table item to dynamodb
     */
    void save(T item);
    /**
     * Find all the items in a table using the partition key in within a secondary index
     *
     * @param partitionKey partition key of the secondary indexed table
     * @return List of all the relevant items
     */
    List<T> findByIndex(String partitionKey);

  /**
   * Find all the items in a table using the partition key in within a secondary index
   *
   * @param partitionKey partition key of the table
   * @param sortKey sort key of the secondary indexed table
   * @return List of all the relevant items
   */
  List<T> findByIndex(String partitionKey, String sortKey);
}
