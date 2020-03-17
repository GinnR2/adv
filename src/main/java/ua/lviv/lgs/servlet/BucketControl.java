package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;

/**
 * delete bucket servlet
 */
@WebServlet("/bucket")
public class BucketControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	Logger LOG = Logger.getLogger(BucketControl.class);
	String resp;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		
		String productId = request.getParameter("productId");
		
		HttpSession session = request.getSession();
		
		Integer userId = (Integer)session.getAttribute("userId");
		
		if(userId==null) {
			resp="Plese log in";
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}
		
		Bucket bucket = new Bucket(userId, Integer.parseInt(productId),new Date(System.currentTimeMillis()));
		bucketService.add(bucket);
		
		resp="Added '"+productId+"' to the bucket";
		LOG.debug(resp);
		response.getWriter().write(resp);
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bucketId = request.getParameter("bucketId");
		bucketService.delete(Integer.parseInt(bucketId));
		
		resp="Deleted '"+bucketId+"' from the bucket";
		LOG.debug(resp);
		response.getWriter().write("Success");
	}

}
