package com.redyhire.llmgateway.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InternalUserLoginSuccessResponse {
    private String userId;
}
