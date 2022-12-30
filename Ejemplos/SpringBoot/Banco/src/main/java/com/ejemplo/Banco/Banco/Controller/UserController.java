package com.ejemplo.Banco.Banco.Controller;

import com.ejemplo.Banco.Banco.Entity.User;
import com.ejemplo.Banco.Banco.Service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/usuario")
@CrossOrigin(origins="http://localhost:8080")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> create(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable(value="id") int userId){
        Optional<User> oUser = userService.findById(userId);

        if(!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    @GetMapping
    public List<User> readAll(){
        return StreamSupport
                .stream(userService.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
