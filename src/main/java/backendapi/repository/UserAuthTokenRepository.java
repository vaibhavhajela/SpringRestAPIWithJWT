package backendapi.repository;

import backendapi.model.UserAuthTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthTokenRepository extends JpaRepository<UserAuthTokenEntity, String> {
  UserAuthTokenEntity findByUsername(String username);

  UserAuthTokenEntity findByToken(String token);

}
