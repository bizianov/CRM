package project.model;

/**
 * Created by slava23 on 11/21/2016.
 */
public enum Roles {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
