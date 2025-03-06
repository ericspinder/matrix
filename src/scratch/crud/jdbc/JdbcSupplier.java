/*
 * * Pinder's Matrix © 2025 by Eric S Pinder is licensed under Creative Commons
 *  Attribution-NonCommercial-NoDerivatives 4.0 International. To view a copy of this
 *  license, visit https://creativecommons.org/licenses/by-nc-nd/4.0/
 * /
 */

package crud.jdbc;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

public class JdbcSupplier  {

    private final String name;
    private final String url;
    private final String username;
    private final String password;

    public JdbcSupplier(String name, String driverClassName, String url, String username, String password) {
        this.name = name;
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }
//    public Connection getConnection() throws SQLException {
//        return DriverManager.getConnection(url, username, password);
//    }


    public String getName() {
        return this.name;
    }

    public static class H2 extends JdbcSupplier {

        public H2(String name, String url, String userName, String password) {
            super(name, "org.h2.Driver", url, userName, password);
        }
    }
}
