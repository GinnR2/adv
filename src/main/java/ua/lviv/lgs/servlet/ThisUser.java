package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;


@WebServlet("/me")

//check session info
public class ThisUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		
		
		String name = (String) session.getAttribute("name");
		String role = (String) session.getAttribute("group");
		if(name==null) {
			response.getWriter().write("null");
			return;
		}
		String[] arr = { name, role };
		String json = new Gson().toJson(arr);
		//System.out.println(json);
		response.getWriter().write(json);
	}

	

}
//test