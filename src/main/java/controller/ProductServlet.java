package controller;

import dao.ProductDAO;
import model.Product;
import model.Status;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }
//    private final ProductDAO productDAO = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "stop":
                stopTrading(req, resp);
                break;
            case "active":
                trading(req, resp);
                break;
            case "showActive":
                showActiveProduct(req, resp);
                break;
            case "showDeActive":
                showDeActiveProduct(req, resp);
                break;
            case "products":
            default:
                listProduct(req, resp);
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(req, resp);
                break;
            case "edit":
                editProduct(req, resp);
                break;
            case "showActive":
                showActiveProduct(req, resp);
                break;
            case "showDeActive":
                showDeActiveProduct(req, resp);
                break;
            case "search":
                search(req, resp);
                break;
        }

    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("key");
        List<Product> products = productDAO.selectProductByName(name);
//        if (products == null){
//            req.setAttribute("message", "Không Tìm Thấy User Với country Là : " +name);
//        }else {
//            req.setAttribute("message", "Đã Tìm Thấy User Với country Là:" +name);
//        }
        req.setAttribute("productList", products);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
        dispatcher.forward(req, resp);
    }

    private void showDeActiveProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productDAO.selectProductOutOfStock();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
        dispatcher.forward(req, resp);
    }

    private void    showActiveProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productDAO.selectProductInStock();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
        dispatcher.forward(req, resp);
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("idP"));
            String type = req.getParameter("typeP");
            String name = req.getParameter("nameP");
            int quantity = Integer.parseInt(req.getParameter("quantityP"));
            String price = req.getParameter("priceP");
            String description = req.getParameter("descriptionP");
            Product editProduct = new Product(id, type, name, quantity, price, description);
            productDAO.editProduct(editProduct);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/updateDone.jsp");
//            dispatcher.forward(req, resp);
        resp.sendRedirect(req.getContextPath()+ "/products");
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String type = req.getParameter("typeP");
            String name = req.getParameter("nameP");
            int quantity = Integer.parseInt(req.getParameter("quantityP"));
            String price = req.getParameter("priceP");
            String description = req.getParameter("descriptionP");
            Product newProduct = new Product(type, name, quantity, price, description);
            productDAO.addProduct(newProduct);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/updateDone.jsp");
//            dispatcher.forward(req, resp);
        resp.sendRedirect(req.getContextPath()+ "/products");

    }

    private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productList = productDAO.selectAllProduct();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
        dispatcher.forward(req, resp);
    }

    private void trading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.tradingProduct(id);
        List<Product> productList = productDAO.selectAllProduct();
        req.setAttribute("productList", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
        dispatcher.forward(req, resp);
    }

    private void stopTrading(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.stopTradingProduct(id);
        List<Product> productList = productDAO.selectAllProduct();
        req.setAttribute("productList", productList);
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/listProduct.jsp");
//        dispatcher.forward(req, resp);
        resp.sendRedirect(req.getContextPath()+ "/products");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/editProduct.jsp");
        req.setAttribute("product", product);
        dispatcher.forward(req, resp);

    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/resource/product/createProduct.jsp");
        dispatcher.forward(req, resp);
    }


}
