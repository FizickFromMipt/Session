import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie1 = new Cookie("id", "123");
        Cookie cookieName = new Cookie("name", "Alex");

        //Срок действия куки - обязательно
        cookie1.setMaxAge(24*60*60);
        cookieName.setMaxAge(24*60*60);

        //передаем в ответ куки
        response.addCookie(cookie1);
        response.addCookie(cookieName);

    }
}
