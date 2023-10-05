package ma.youcode.Models;

// Entreprise.java
public class Entreprise {
    private int id;
    private String name;
    private String password;

    public Entreprise(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
