package notebook.controller;

import notebook.model.User;
import notebook.model.repository.GBRepository;

import java.util.List;
import java.util.Objects;

public class UserController {
    private final GBRepository repository;

    public UserController(GBRepository repository) {
        this.repository = repository;
    }

    public void saveUser(String user) {
        repository.create(user);
    }

    public void readUser(String lastname) throws Exception {
        try {
            repository.findAll(lastname);
        }
        catch (NullPointerException e) {
            throw new RuntimeException("User not found");
        }
    }
}