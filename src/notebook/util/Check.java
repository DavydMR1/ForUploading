package notebook.util;

import notebook.model.User;

import java.util.Objects;

public class Check {
    private String user;

    public Check(String user) {
        this.user = user;
    }

    public boolean Confirm() {
        String[] banana = user.split(" ");
        if (banana.length < 6) {
            throw new RuntimeException("Недостаточно данных");
        }
        if (banana.length > 6) {
            throw new RuntimeException("Введены лишние данные");
        }
        String[] date = banana[3].split(",");
        if (Integer.parseInt(date[0]) > 31 && Integer.parseInt(date[0]) < 1) {
            throw new RuntimeException("Неверно введено число");
        }
        if (Integer.parseInt(date[1]) > 12 && Integer.parseInt(date[1]) < 1) {
            throw new RuntimeException("Неверно введен месяц");
        }
        int a = Integer.parseInt(date[2]);
        long b = Long.parseLong(banana[4]);
        if (!Objects.equals(banana[5], "Ж") && !Objects.equals(banana[5], "ж") && !Objects.equals(banana[5], "М") && !Objects.equals(banana[5], "м")) {
            throw new RuntimeException("Неверно указан пол");
        }
        return true;
    }
}
