import com.sun.net.httpserver.HttpServer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.sql.*;

public class BookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        //Подгружаем драйвер в JVM
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Открываем подключение к бд

        try {
            Connection  connection = DriverManager.getConnection("jdbc:postgresql://localhost:5433/java_ee_db",
                    "postgres",
                    "postgres");

            //Создаем объект для совершения запросов
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select title from book");

            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html>");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
                printWriter.println("<p>"+resultSet.getString("title")+"</p>");
            }
            printWriter.println("</html>");
            //подклюяение необходимо закрывать
            statement.close();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }

}
