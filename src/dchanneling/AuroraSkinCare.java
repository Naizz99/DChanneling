package dchanneling;

import auroraskincare.view.LoginForm;
import auroraskincare.view.MainUI;
import java.sql.Connection;

public class AuroraSkinCare {

    private static Connection con = null;
    public static void main(String[] args) {
        LoginForm login = new LoginForm();
        login.setVisible(true);

//        MainUI mainUi = new MainUI();
//        mainUi.setVisible(true);
    }
    
}
