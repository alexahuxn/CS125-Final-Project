package com.example.mainactivity;

public class User {

    /** Store user's username as a String. */
    private String username;

    /** Store user's password as a String. */
    private String password;

    /**
     * Constructor for class User
     * @param newUsername Takes in a user entered username
     * @param newPassword Takes in a user entered password
     */
    User(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }

    /**
     * Set user's password in User class
     * @param setPassword Takes in the password user entered
     */
    public void setPassword(String setPassword) {
        this.password = setPassword;
    }

    /**
     * Set user's username in User class
     * @param setUsername Takes in the username user entered
     */
    public void setUsername(String setUsername) {
        this.username = setUsername;
    }

    /**
     * Get user's username
     * @return Returns user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get user's password
     * @return Returns user's password
     */
    public String getPassword() {
        return password;
    }
}
