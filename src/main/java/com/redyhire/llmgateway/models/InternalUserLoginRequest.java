package com.redyhire.llmgateway.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InternalUserLoginRequest {
    private String unitId;
    private String userId;
    private String oneTimePassword;
}
