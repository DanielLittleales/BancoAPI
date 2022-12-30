package com.ejemplo.Banco.Banco.DAO;

import com.ejemplo.Banco.Banco.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iUserRepository extends JpaRepository<User, Integer> {

}
