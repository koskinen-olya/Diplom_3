public class BodyForLoginUser {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;


    public BodyForLoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public BodyForLoginUser() {
    }
}
