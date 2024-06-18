package br.newtonpaiva.JWT_Security_RESTAPI.repository;

import br.newtonpaiva.JWT_Security_RESTAPI.model.LoginRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends MongoRepository<LoginRequest, String> {
    LoginRequest findByUsername(String username);

}