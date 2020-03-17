package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

/**
 * products crud servlet
 */
@WebServlet("/product")
public class ProductControl extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = ProductServiceImpl.getProductService();

	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}

	// to create resource (product)
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String description = request.getParameter("desc");
		String price = request.getParameter("price");
		Logger LOG = Logger.getLogger(ProductControl.class);
		String resp;

		
		if (name == null || description == null || price == null) {
			resp = "something went wrong " + name + " " + price + " " + description;
			LOG.debug(resp);
			response.getWriter().write(resp);
			return;
		}

		Product product = new Product(name, description, getValidatedPrice(price));
		productService.add(product);

		resp = "Success";
		LOG.debug(resp);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(resp);

	}

	// to get resource (product)
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		String productId = request.getParameter("id");
		
		Product product = productService.get(Integer.parseInt(productId));
		
		request.setAttribute("product", product);
		request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
	}

	// to update resource (product)
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}

	// to delete resource (product)
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}