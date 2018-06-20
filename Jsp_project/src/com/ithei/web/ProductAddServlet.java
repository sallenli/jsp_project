package com.ithei.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.management.RuntimeErrorException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ithei.service.ProductService;
import com.ithei.service.ProductServiceImp;
import com.itheima.domain.Product;

/**
 * Servlet implementation class ProductAddServlet
 */
@WebServlet("/productAddServlet")
public class ProductAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		boolean checkForm = ServletFileUpload.isMultipartContent(request);
		Product p=new Product();
		p.setPid(UUID.randomUUID().toString().replace("-", ""));
		if(!checkForm)
		{
			throw new RuntimeException("form表单MIME格式错误,应该为multipart/form-data");
		}
		else
		{
			DiskFileItemFactory factory = new DiskFileItemFactory();
		
			ServletFileUpload upload = new ServletFileUpload(factory);
			  try {
				  
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem fileItem : items) {
					
					if(fileItem.isFormField())
					{
						if("pname".equalsIgnoreCase(fileItem.getFieldName()))
						{
						p.setPname(fileItem.getString("utf-8"));
						}
						if("is_hot".equalsIgnoreCase(fileItem.getFieldName()))
						{
							p.setIs_hot(Integer.parseInt(fileItem.getString("utf-8")));
						}
						if("cid".equalsIgnoreCase(fileItem.getFieldName()))
						{
							p.setCid(fileItem.getString("utf-8"));
						}
						if("market_price".equalsIgnoreCase(fileItem.getFieldName()))
						{
							p.setMarket_price(Double.parseDouble(fileItem.getString("utf-8")));
						}
						if("shop_price".equalsIgnoreCase(fileItem.getFieldName()))
						{
							p.setShop_price(Double.parseDouble(fileItem.getString("utf-8")));
						}
						if("pdesc".equalsIgnoreCase(fileItem.getFieldName()))
						{
							p.setPdesc(fileItem.getString("utf-8"));
						}
						
					}
					else
					{
						ServletContext servletContext =  getServletContext();
						String realpath = servletContext.getRealPath("/products/1");
						
						File file = new File(realpath);
						if(file.exists())
						{
							fileItem.write(new File(file,fileItem.getName()));
							fileItem.delete();
						}
						p.setPimage("products/1/"+fileItem.getName());
						
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
		}
		ProductService ps=new ProductServiceImp();
		ps.add(p);
		response.sendRedirect(request.getContextPath()+"/productServlet");
		
	}
}
