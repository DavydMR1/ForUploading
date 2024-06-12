package notebook.util.mapper.impl;

import notebook.model.User;
import notebook.util.mapper.Mapper;

public class UserMapper implements Mapper {
    @Override
    public String toInput(User user) {
        return String.format("%s,%s,%s", user.getFirstName(), user.getLastName(), user.getPhone());
    }

    @Override
    public User toOutput(String s) {
        String[] lines = s.split(",");
        return new User(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5]);
    }

    private boolean isDigit(String s) throws NumberFormatException {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}