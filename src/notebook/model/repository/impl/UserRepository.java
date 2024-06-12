package notebook.model.repository.impl;

import notebook.model.User;
import notebook.model.dao.impl.FileOperation;
import notebook.model.repository.GBRepository;
import notebook.util.Check;
import notebook.util.mapper.impl.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements GBRepository {
    private final UserMapper mapper;
    private FileOperation operation;

    public UserRepository() {
        this.mapper = new UserMapper();
    }

    @Override
    public void findAll(String lastName) {
        List<String> lines = operation.readAll(lastName);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    @Override
    public String create(String user) {
        Check check = new Check(user);
        check.Confirm();
        write(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    private void write(String users) {
        String[] a = users.split(" ");
        operation = new FileOperation(a[1]);
        operation.saveAll(users);
    }

}