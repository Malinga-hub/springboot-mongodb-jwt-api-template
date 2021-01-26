package spring.security.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.security.api.Pojos.PasswordResetCode;

import java.util.Optional;


public interface PasswordResetCodeRepository extends MongoRepository<PasswordResetCode, String> {

    Optional<PasswordResetCode> findById(String id);
    PasswordResetCode findByEmail(String email);
    PasswordResetCode deleteByEmail(String email);
}
