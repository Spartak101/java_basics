import java.sql.*;

public class DBConnection {

    private static Connection connection;

    private static String dbName = "learn";
    private static String dbUser = "root";
    private static String dbPass = "testtest";
    private static StringBuilder insertQuery = new StringBuilder();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/" + dbName +
                                "?user=" + dbUser + "&password=" + dbPass);
                connection.createStatement().execute("DROP TABLE IF EXISTS voter_count");
                connection.createStatement().execute("CREATE TABLE voter_count(" +
                                "id INT NOT NULL AUTO_INCREMENT, " +
                                "name TINYTEXT NOT NULL, " +
                                "birthDate DATE NOT NULL, " +
                                "hash INT NOT NULL, " +
                        "PRIMARY KEY(id))");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void executeMultiInsert() throws SQLException {
        String sql =
                "INSERT INTO voter_count(name, birthDate, hash) " +
                        "VALUES" + insertQuery.toString();
        DBConnection.getConnection().createStatement().execute(sql);
        insertQuery.setLength(0);
    }

    public static void countVoter(String name, String birthDay, int hash) throws SQLException {
        birthDay = birthDay.replace('.', '-');


        insertQuery.append((insertQuery.length() == 0 ? "" : ",") +
                "('" + name + "','" + birthDay + "','" + hash + "')");
    }

    public static void printVoterCounts() throws SQLException {
        String sql = "SELECT name, birthDate, count(hash) AS count_all\n" +
                "FROM learn.voter_count\n" +
                "group by name, birthDate\n" +
                "HAVING count_all > 1\n" +
                "order by count_all DESC";
        ResultSet rs = DBConnection.getConnection().createStatement().executeQuery(sql);
        while (rs.next()) {
            System.out.println("\t" + rs.getString("name") + " (" +
                    rs.getString("birthDate") + ") - " + rs.getInt("count_all"));
        }
        rs.close();
    }
}
