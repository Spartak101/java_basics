
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "testtest";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, (q.c_course / c.c_all) AS effect\n" +
                    "FROM (SELECT DISTINCT course_name, MONTH(subscription_date) AS c_course\n" +
                    "FROM skillbox.purchaselist\n" +
                    "WHERE subscription_date IN (\n" +
                    "SELECT max(subscription_date)\n" +
                    "FROM skillbox.purchaselist\n" +
                    "GROUP BY course_name)) AS q\n" +
                    "JOIN\n" +
                    "(SELECT DISTINCT course_name AS cn, count(subscription_date) AS c_all\n" +
                    "FROM skillbox.purchaselist\n" +
                    "GROUP BY course_name) AS c\n" +
                    "ON q.course_name = c.cn");
            while (resultSet.next()){

                String courseName = resultSet.getString("course_name");
                String coursePrise = resultSet.getString("effect");
                System.out.println(courseName + " - " + coursePrise);
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
