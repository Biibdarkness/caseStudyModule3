package dao;

import model.PType;
import model.Product;
import model.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

public class ProductDAO implements IProductDAO {
    DecimalFormat formatter = new DecimalFormat("###,###,###" + "đ");
    Connection connection = null;
    private String  SELECTALL = "select * from product;";
    private String SELECTACTIVE = "select * from product where PStatus='1';";
    private String ADD = "insert into product(PType,PName,PQuantity,PPrice,PDescription,PStatus) values(?, ?, ?, ?, ?, 1);";
    private String UPDATE = "UPDATE product SET PType=?, PName=?, PQuantity=?, PPrice=?, PDescription=? WHERE PId=?;";
    private String SETSTATUS = "UPDATE product SET PStatus=? WHERE PId=?;";
    private String TRADING = "UPDATE product SET PStatus='1' WHERE PId=?;";
    private String SELECTDEACTIVE = "select * from product where PStatus='0';";
    private String SEARCH = "select * from eadb.product where PName like ?;";
    private String SHOWSTATUS = "select product.PStatus from product where PId =?;";

//    public static void main(String[] args) {
//        ProductDAO p = new ProductDAO();
//        p.editProduct(new Product(1,"a","b",1,"2","c"));
//    }
    @Override
    public List<Product> selectAllProduct() {
        Status statusP = null;
        List<Product> productList = new ArrayList<>();
        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTALL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Pid");
                String type = rs.getString("PType");
                String name = rs.getString("PName");
                int quantity = rs.getInt("PQuantity");
                String price =  formatter.format(rs.getLong("PPrice"));
                String description = rs.getString("PDescription");
                int status = rs.getInt("PStatus");
                statusP = Status.parseStatus(status);
                productList.add(new Product(id, type, name, quantity, price, description, statusP));
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> selectProductByName(String check) {
        List<Product> productList = new ArrayList<>();
        Status statusP = null;
        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%"+check+"%" );
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PId");
                String type = rs.getString("PType");
                String name = rs.getString("PName");
                int quantity = rs.getInt("PQuantity");
                String price =  formatter.format(rs.getLong("PPrice"));

                String description = rs.getString("PDescription");
                int status = rs.getInt("PStatus");
                statusP = Status.parseStatus(status);
                productList.add(new Product(id,type,name,quantity,price,description,statusP));
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> selectProductInStock() {
        Status statusP;
        List<Product> productList = new ArrayList<>();
        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTACTIVE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PId");
                String type = rs.getString("PType");
                String name = rs.getString("PName");
                int quantity = rs.getInt("PQuantity");
                String price =  formatter.format(rs.getLong("PPrice"));
                String description = rs.getString("PDescription");
                int status = rs.getInt("PStatus");
                statusP = Status.parseStatus(status);
                productList.add(new Product(id, type, name, quantity, price, description, statusP));

            }
            preparedStatement.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> selectProductOutOfStock() {
        Status statusP;
        List<Product> productList = new ArrayList<>();
        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTDEACTIVE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("PId");
                String type = rs.getString("PType");
                String name = rs.getString("PName");
                int quantity = rs.getInt("PQuantity");
                String price =  formatter.format(rs.getLong("PPrice"));
                String description = rs.getString("PDescription");
                int status = rs.getInt("PStatus");
                statusP = Status.parseStatus(status);
                productList.add(new Product(id, type, name, quantity, price, description, statusP));
            }
            preparedStatement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product selectProduct(int id) {
        List<Product> productList = selectAllProduct();
        for (Product product : productList) {
            if (product.getIdP() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product newProduct) {
        try  {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(ADD);
            System.out.println(newProduct);
            preparedStatement.setString(1, newProduct.getTypeP());
            preparedStatement.setString(2, newProduct.getNameP());
            preparedStatement.setInt(3, newProduct.getQuantityP());
            preparedStatement.setString(4, newProduct.getPriceP());
            preparedStatement.setString(5, newProduct.getDescriptionP());

//            preparedStatement.setString(6, newProduct.getStatusP());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void editProduct(Product editProduct) {

        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, editProduct.getTypeP());
            preparedStatement.setString(2, editProduct.getNameP());
            preparedStatement.setInt(3, editProduct.getQuantityP());
            preparedStatement.setString(4, editProduct.getPriceP());
            preparedStatement.setString(5, editProduct.getDescriptionP());
            preparedStatement.setInt(6, editProduct.getIdP());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void stopTradingProduct(int id) {
        try {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement;
             preparedStatement = connection.prepareStatement(SETSTATUS);
            PreparedStatement check =  connection.prepareStatement(SHOWSTATUS);
            check.setInt(1, id);
//            check.executeUpdate();
            ResultSet rs = check.executeQuery();
            while (rs.next()) {
                int status = rs.getInt("PStatus");

                int newStatus = status == 1 ? 0:1;
                preparedStatement.setInt(1, newStatus);
                preparedStatement.setInt(2, id);

                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
            check.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void tradingProduct(int id) {
        try  {
            connection = MySQLConnUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TRADING);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}

