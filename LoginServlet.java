

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("menu.html").include(request,response);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		boolean status=password.equals("admin123");
		if(status)
		{
			out.print("<h1>Login page</h1>");
			out.print("hello"+name);
			HttpSession session=request.getSession();
			session.setAttribute("name", name);
		}
		else
		{
			out.print("sorry,username or password error!");
		}
		out.close();
	}

}
