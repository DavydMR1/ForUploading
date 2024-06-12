package notebook;

import notebook.controller.UserController;
import notebook.model.dao.impl.FileOperation;
import notebook.model.repository.GBRepository;
import notebook.model.repository.impl.UserRepository;
import notebook.view.UserView;


public class Main {
    public static void main(String[] args) {
        GBRepository repository = new UserRepository();
        UserController controller = new UserController(repository);
        UserView view = new UserView(controller);
        view.run();
    }
}
//https://github.com/DavydMR1/ForUploading.git