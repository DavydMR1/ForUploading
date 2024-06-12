package notebook.model.dao;

import java.util.List;

/**
 * Data Access Object (DAO) слой, с методами для работы с БД
 */
public interface Operation {
    List<String> readAll(String filename);
    void saveAll(String data);
}