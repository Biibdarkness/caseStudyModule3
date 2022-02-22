package model;

public class Order {
    private int idO;
    private int idC;
    private String dateO;
    private long totalPriceO;

    public Order() {
    }

    public Order(int idO, int idC, String dateO, long totalPriceO) {
        this.idO = idO;
        this.idC = idC;
        this.dateO = dateO;
        this.totalPriceO = totalPriceO;
    }

    public int getIdO() {
        return idO;
    }

    public void setIdO(int idO) {
        this.idO = idO;
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getDateO() {
        return dateO;
    }

    public void setDateO(String dateO) {
        this.dateO = dateO;
    }

    public long getTotalPriceO() {
        return totalPriceO;
    }

    public void setTotalPriceO(long totalPriceO) {
        this.totalPriceO = totalPriceO;
    }
}
