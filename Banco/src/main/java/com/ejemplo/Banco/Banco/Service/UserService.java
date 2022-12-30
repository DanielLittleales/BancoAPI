package com.ejemplo.Banco.Banco.Service;

import com.ejemplo.Banco.Banco.DAO.iUserRepository;
import com.ejemplo.Banco.Banco.Entity.User;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService implements iUserService {

    @Autowired
    private iUserRepository repository;

    @Override
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<User> findById(int id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
