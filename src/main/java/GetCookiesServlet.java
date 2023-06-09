import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //запросили кики от клиента
        Cookie[] cookies = request.getCookies();
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        for (Cookie cookie : cookies) {
            pw.println("<h1>"+ cookie.getName() + ":" + cookie.getValue()+ "</h1>");
        }
        pw.println("</html>");
    }
}
