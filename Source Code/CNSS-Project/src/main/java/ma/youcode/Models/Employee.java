package ma.youcode.Models;

public class Employee {
    private String id;
    private String email;
    private String password;
    private int daysWorked;

    public Employee(String id, String email, String password, int daysWorked) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.daysWorked = daysWorked;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDaysWorked() {
        return daysWorked;
    }

    public void setDaysWorked(int daysWorked) {
        this.daysWorked = daysWorked;
    }
}
