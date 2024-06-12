package notebook.model.repository;

import notebook.model.User;

import java.util.List;
import java.util.Optional;

public interface GBRepository {
    void findAll(String lastName);
    String create(String user);
    Optional<User> findById(Long id);
}