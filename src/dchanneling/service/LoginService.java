package auroraskincare.service;

import auroraskincare.model.Login;
import auroraskincare.repository.LoginRepository;
import java.sql.SQLException;

public class LoginService {

    private final LoginRepository repo = new LoginRepository();

    public boolean authenticateUser(String username, String password) throws SQLException {
        Login login = repo.getLoginByUsername(username);
        if (login != null) {
            return login.getPassword().equals(password);
        }
        return false;
    }

    public void registerUser(Login login) throws SQLException {
        repo.addLogin(login);
    }

    public void updateUser(Login login) throws SQLException {
        repo.updateLogin(login);
    }
}
