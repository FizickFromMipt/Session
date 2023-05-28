import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteCookiesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        //Что бы удалить куки - хих надо перезаписать и сделать срок дейстия 0 секунд
        Cookie cookie = new Cookie("id", "");
        cookie.setMaxAge(0);

        //при данном значении куки будут удалять при закрыти браузера
//        cookie.setMaxAge(-1);

        response.addCookie(cookie);
    }
}
