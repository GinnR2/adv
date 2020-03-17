package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = UserServiceImpl.getInstance();
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = userService.getByEmail(email);
		Logger LOG = Logger.getLogger(Login.class);
		String resp;
		if(user==null) {
			resp="email dont exist";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}
		
		if(!user.getPassword().toString().equals(password)) {
			resp="wrong password";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("name", user.getEmail());
		session.setAttribute("userId", user.getId());
		session.setAttribute("group", user.getGroup().toString());
		
		UserLogin userLogin = new UserLogin();
		userLogin.destinationUrl = "profile.jsp";
		userLogin.email = user.getEmail();
		String json = new Gson().toJson(userLogin);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		LOG.debug(json);
		response.getWriter().write(json);
		

		
		
	}

}
