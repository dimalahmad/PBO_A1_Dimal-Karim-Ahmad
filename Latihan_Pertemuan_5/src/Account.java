public class Account {
    private String name;
    private int password;
    int padding = 150;

    public void setPassword(int password) {
        int newPassword = password + padding;
        this.password = newPassword;
    }
    public int getPassword() {
        int originalPassword = this.password - padding;
        return originalPassword;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
