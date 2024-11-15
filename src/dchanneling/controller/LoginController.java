package dchanneling.controller;

import auroraskincare.model.Login;
import auroraskincare.service.LoginService;
import java.sql.SQLException;

public class LoginController {

    private final LoginService loginService = new LoginService();

    public boolean login(String username, String password) {
        try {
            return loginService.authenticateUser(username, password);
        } catch (SQLException e) {
            System.err.println("Login failed: " + e.getMessage());
            return false;
        }
    }

    public void register(String username, String password) {
        Login newLogin = new Login(0, username, password);
        try {
            loginService.registerUser(newLogin);
        } catch (SQLException e) {
            System.err.println("Error registering user: " + e.getMessage());
        }
    }

    public void updateLoginDetails(int id, String username, String password) {
        Login login = new Login(id, username, password);
        try {
            loginService.updateUser(login);
        } catch (SQLException e) {
            System.err.println("Error updating login details: " + e.getMessage());
        }
    }
}
