package com.redyhire.llmgateway.dao;

import java.util.Optional;

public interface DynamoDBSingleKeyRepository<T> extends DynamoDBRepository<T> {
    /**
     * Get element using partition key of the table
     *
     * @param partitionKey partition key of the table
     * @return Item with the partition key
     */
    Optional<T> find(String partitionKey);
    /**
     * Delete item using partition key and sort key of the table
     *
     * @param partitionKey partition key of the table
     */
    void deleteItem(String partitionKey);
}
