package by.iba.badenkova;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    public boolean validateUser (String user, String password) {
        return user.equalsIgnoreCase("admin") && password.equals("admin");
            }
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
                             throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (validateUser(name, password)) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Invalid Login and password!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
                        }


    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
    }

    }
