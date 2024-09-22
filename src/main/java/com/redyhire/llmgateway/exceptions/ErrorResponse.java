package com.redyhire.llmgateway.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private int statusCode;
    private String message;
    @Builder.Default
    private long timestamp = System.currentTimeMillis();
}
