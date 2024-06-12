package notebook.model;

public class User {
    private String firstName;
    private String lastName;;
    private String anotherName;;
    private String birthDate;
    private String phone;
    private String gender;

    public User(String firstName, String lastName, String anotherName, String birthDate, String phone, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.anotherName = anotherName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String lastName) {
        this.anotherName = anotherName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String lastName) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s,\nФамилия: %s,\nОтчество: %s, \nДата рождения: %s, \nТелефон: %s", firstName, lastName, anotherName, birthDate, phone);
    }
}