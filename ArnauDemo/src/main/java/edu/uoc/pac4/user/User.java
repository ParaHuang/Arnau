package edu.uoc.pac4.user;

public abstract class User {
    private String email;
    private String name;
    private String surname;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public User(String email, String name, String surname) throws UserException {
        setEmail(email);
        setName(name);
        setSurname(surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UserException {
        if(email == null || !email.matches("\\w+@uoc[.]edu")) {    //\w:  0-9,a-z,A-Z,_
            throw new UserException(UserException.INVALID_EMAIL);
        }
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws UserException {
        if (name == null || name.trim().isEmpty()){
            throw new UserException(UserException.INVALID_NAME);
        }
        this.name = name.trim();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname == null){
            surname = "";
        }
        this.surname = surname.trim();
    }
}
