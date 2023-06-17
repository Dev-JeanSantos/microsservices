package com.fourtk.userapi.repositories;

import com.fourtk.userapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByCpf(String cpf);

    @Query(value="SELECT * FROM user u WHERE u.name LIKE %?%", nativeQuery=true)
    List<User> getUsersByName(String name);
}
