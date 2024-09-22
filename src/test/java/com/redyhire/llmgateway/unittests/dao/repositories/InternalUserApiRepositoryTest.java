package com.redyhire.llmgateway.unittests.dao.repositories;

import com.redyhire.llmgateway.dao.entities.InternalUser;
import com.redyhire.llmgateway.dao.repositories.InternalUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class InternalUserApiRepositoryTest {
  @Autowired InternalUserRepository internalUserRepository;

  @Test
  public void testTableGetItem() {
    String unitId = "1234";
    String userId = "123";
    Optional<InternalUser> internalUser = internalUserRepository.find(unitId, userId);
    assert internalUser.isPresent();
  }

  @Test
  public void saveTableItem() {
    internalUserRepository.save(
        InternalUser.builder()
            .unitId("1234")
            .userId("123")
            .email("rokerzsa@gmail.com")
            .name("Arif")
            .build());
  }
}
