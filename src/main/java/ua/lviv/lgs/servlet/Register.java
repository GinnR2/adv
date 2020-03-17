package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.lviv.lgs.dao.impl.UserDaoImpl;
import ua.lviv.lgs.domain.Groups;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.UserService;
import ua.lviv.lgs.service.impl.UserServiceImpl;

@WebServlet("/Register")

//Registration servlet
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = UserServiceImpl.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Logger LOG = Logger.getLogger(UserDaoImpl.class);
		String resp;
		User user = new User(email, name, surname, Groups.USER.toString(), password);
		
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		
		LOG.debug("post debug");
		
		if (email==null || name==null || surname==null || password==null) {
			resp="something went wrong";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}
		
		if (email.isEmpty() || name.isEmpty() || surname.isEmpty() || password.isEmpty()) {
			resp="emptry fields";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}

		if (userService.getByEmail(email) != null) {
			resp="this email exists";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}

		user = userService.add(user);
		
		resp="Success \nGot "+user.toString();
		LOG.debug(resp);
		response.getWriter().write(resp);
	}

}
