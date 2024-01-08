class Voter {
    private String user;
    private String password;
    private String name;
    private boolean isvoted;
    Voter(String user, String password, String name) {
        this.user = user; 
        this.password = password;
        this.name = name;
        this.isvoted = false;
    }
    String getUser() {
        return user;
    }
    String getPassword() {
        return password;
    }
    String getName() {
        return name;
    }
    boolean voted() {
        return isvoted;
    }
    void setIsvoted(boolean isvoted) {
        this.isvoted = isvoted;
    }
}
