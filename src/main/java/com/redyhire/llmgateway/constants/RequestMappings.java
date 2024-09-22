package com.redyhire.llmgateway.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public interface RequestMappings {
    String BASE_API_PATH = "/api/internal";
    String BASE_PATH = BASE_API_PATH + "/users";
    String LOGIN = "/login";
}
