package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * Searches and returns all users.
     *
     * @return List of all users
     */
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";

        return executeSelect(sql);
    }

    /**
     * Searches and returns users based on last name.
     *
     * @param searchTerm the last name to search
     * @return List of users
     */
    public List<User> getUserLastName(String searchTerm) {
        String sql = " SELECT * "
                   + "   FROM users"
                   + "  WHERE last_name LIKE '" + searchTerm + "%'";

        return executeSelect(sql);
    }

    /**
     * Executes the query passed in and returns list of users.
     *
     * @param sql the last name to search
     * @return List of users
     */
    private List<User> executeSelect(String sql) {
        List<User> users = new ArrayList<User>();
        Database database = Database.getInstance();
        Connection connection = null;

        logger.info("SQL: " + sql);

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                User employee = createUserFromResults(results);
                users.add(employee);
            }
            database.disconnect();
        } catch (SQLException e) {
            System.out.println("SearchUser.getAllUsers()...SQL Exception: " + e);
        } catch (Exception e) {
            System.out.println("SearchUser.getAllUsers()...Exception: " + e);
        }
        return users;
    }

    /**
     * Searches and returns users based on last name.
     *
     * @param results the result of the query
     * @return a single user
     */
    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setUserid(results.getString("id"));
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setDateOfBirth(results.getDate("date_of_birth"));

        return user;
    }

}