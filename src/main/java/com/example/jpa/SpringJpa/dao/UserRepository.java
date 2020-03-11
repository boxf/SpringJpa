package com.example.jpa.SpringJpa.dao;

import com.example.jpa.SpringJpa.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends CrudRepository <User, Long> {
List<User> findByLastName(String lastname);
@Query("SELECT u FROM User u WHERE u.email= :param")
User getUserByEmail(@Param("param") String email);
@Query ("SELECT u.imageName FROM User u WHERE u.id= :param")
String getImageNameById(@Param("param")Long id);
}
