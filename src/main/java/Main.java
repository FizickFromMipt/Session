import src.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Main extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //создали сессию
        HttpSession session = request.getSession();

//        Integer count = (Integer) session.getAttribute("count");
        Person person = (Person) session.getAttribute("person");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        if (person == null) {
            person = new Person(name, age);
        }

        session.setAttribute("person", person);
        getServletContext().getRequestDispatcher("/showCart.jsp").forward(request, response);
//        if (count == null) {
//            count = 1;
//        }
//        session.setAttribute("count", count + 1 );

//        PrintWriter pw = response.getWriter();
//        pw.println("<html>");
////        pw.println("<h1> Your count is  : " + count + "</h1>");
////        pw.println("<h1> Your count is  : " + count + "</h1>");
////        pw.println("Main");
//        pw.println("</html>");


//        RequestDispatcher dispatcher = request.getRequestDispatcher("https://google.com");
//        dispatcher.forward(request, response);
//        response.sendRedirect("https://google.com");
    }

    //сессии - http - несохраняет состояние

    //Авторизация  пользхователя с помощью сессий
    // при первос запросе- страница с авторизаций- при последдующих - целевую страницу

    //куку - пара строк ключ значения, которая храниться для каждого сайта- отправляетс сервером
    //сессии работают с помощью куки

    //JDBC- библиоткека для связывания СУБД с приложением
    //Недостатки с JDBC - неинформативные собщения об ошибках
    //- низкоуровневый способ взяимодействия с СУБД
    //- большое колличество самописного кода
    //- отстствие ORM
}