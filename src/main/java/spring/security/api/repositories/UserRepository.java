package spring.security.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import spring.security.api.Pojos.UserModel;

import java.util.List;

public interface UserRepository extends MongoRepository<UserModel, String> {

    @Query("{username : ?0}")
    UserModel findByUsername(String username);

    @Query("{email : ?0}")
    UserModel findByEmail(String email);

    @Query("{phoneNumber : ?0}")
    UserModel findByPhoneNumber(String phoneNumber);

    List<UserModel> findAllByOrderByCreatedAtDesc();


}
