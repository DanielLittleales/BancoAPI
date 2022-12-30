package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.Entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface iUserService {

    public Iterable<User> findAll();

    public Page<User> findAll(Pageable pageable);

    public Optional<User> findById(int id);

    public User save(User user);

    public void deleteById(int id);

}
