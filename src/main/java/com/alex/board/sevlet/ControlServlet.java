package com.alex.board.sevlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alex.board.dao.CategoryDAO;
import com.alex.board.dao.ItemDAO;
import com.alex.board.dao.SellerDAO;
import com.alex.board.entity.Category;
import com.alex.board.entity.Item;
import com.alex.board.entity.Seller;

/**
 * Servlet implementation class ControlServlet
 */
@WebServlet("/Control")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath() + "</pre>");
		try {
		String reqFrom = request.getParameter("doRequest");
		
		String name;
		
		switch(reqFrom) {
		case "newCategory":
			
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			addNewCategory(name);
			response.sendRedirect("addItem.jsp");
			break;
			
		case "newSeller":
			
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String surname = new String(request.getParameter("surname").getBytes("ISO-8859-1"),"UTF-8");
			addNewSeller(name, surname);
			response.sendRedirect("addItem.jsp");
			break;
			
		case "newItem":
			
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String seller = request.getParameter("seller");
			String[] categories = request.getParameterValues("categories");
			Long price = Long.parseLong(request.getParameter("price"));
			addNewItem(name, price, seller, categories);
			response.sendRedirect("index.jsp");
			break;
			
		case "removeItemId":
			
			String id = request.getParameter("id");
			removeItem(id);
			response.sendRedirect("index.jsp");
			break;
		}
		
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().print(
					"<h4>Servlet's exception</h4><p style='color: red;'> "
					+ ""+ e.toString() + "</p><pre>");
		}
		
		
		
	}

	

	

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void addNewCategory(String name) {
		Category newCategory = new Category(name);
		newCategory.addCategory();
	}
	
	private void addNewSeller(String name, String surname) {
		Seller newSeller = new Seller(name, surname);
		newSeller.addSeller();
		
	}
	
	private void addNewItem(String name, Long price, String seller, String[] categories) {
		
		Seller s = SellerDAO.getSellerWithId(seller);
		List<Category> c = CategoryDAO.getListCategoriesWithListIds(categories);
		Item newItem = new Item(name, price, s, c);
		newItem.addItem();
	}
	
	private void removeItem(String id) {
		
		ItemDAO.removeItem(id);
		
	}

}
