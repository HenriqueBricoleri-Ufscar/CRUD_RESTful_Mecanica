package CRUD_RESTful_Mecanica.main.model;

public class User {

    public enum Role {
        USER,
        ADMIN;
    }
    
    private String id;
    private String name;
    private String contact;
    private Role role;
    private String email;
    private String password;

    public User() {}

    public User(String id, String name, String email, String password, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.role = Role.USER;
        this.email = email;
        this.password = password;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    //Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    //funcs
    public boolean isAdmin(){
        return this.role == Role.ADMIN;
    }
}
