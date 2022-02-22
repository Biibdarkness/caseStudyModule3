package dao;

import model.Product;

import java.util.List;

public interface IProductDAO {
    public List<Product> selectAllProduct();
    public List<Product> selectProductInStock();
    public List<Product> selectProductOutOfStock();
    public Product selectProduct(int id);
    public void addProduct(Product newProduct);
    public void editProduct(Product editProduct);
    public void stopTradingProduct(int id);
    public void tradingProduct(int id);
    public List<Product> selectProductByName(String check);

}
