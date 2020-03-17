package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dto.BucketDto;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.service.ProductService;
import ua.lviv.lgs.service.impl.BucketServiceImpl;
import ua.lviv.lgs.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class BucketsControl
 */
@WebServlet("/buckets")
public class BucketsControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private	BucketService bucketService = BucketServiceImpl.getBucketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bucket> buckets = bucketService.getAll();
		Map<Integer, Product> idToProduct = productService.getAllMap();
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		List<BucketDto> listOfBucketDtos = map2(buckets, idToProduct,userId);
		
		
		String json = new Gson().toJson(listOfBucketDtos);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	
	
	public List<BucketDto> map(List<Bucket> buckets, Map<Integer, Product> idToProduct){

		return	buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.purchaseDate = bucket.getDate();
		   
			Product product = idToProduct.get(bucket.getProduct_id());
		    bucketDto.name = product.getName();
		    bucketDto.desc = product.getDesc();
		    bucketDto.price = product.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList());
		
	}
	
	public List<BucketDto> map2(List<Bucket> buckets, Map<Integer, Product> idToProduct, int userId){

		return	buckets.stream().map(bucket->{
			BucketDto bucketDto = new BucketDto();
			bucketDto.bucketId = bucket.getId();
			bucketDto.userId = bucket.getUser_id();
			bucketDto.purchaseDate = bucket.getDate();
		   
			Product product = idToProduct.get(bucket.getProduct_id());
		    bucketDto.name = product.getName();
		    bucketDto.desc = product.getDesc();
		    bucketDto.price = product.getPrice();
			
			return bucketDto;
		}).collect(Collectors.toList()).stream().filter(bucketDto -> bucketDto.userId==userId).collect(Collectors.toList());
		
	}
}
