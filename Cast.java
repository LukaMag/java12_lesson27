package CLASSWORK27;

public class Cast {
    private String fullName;
    private String role;


    public Cast(String role, String fullName) {
        this.fullName = fullName;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
