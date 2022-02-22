package model;

public class OrderDetail {
    private int idOD;
    private int idO;
    private int idP;
    private int quantityOD;

    public OrderDetail() {
    }

    public OrderDetail(int idOD, int idO, int idP, int quantityOD) {
        this.idOD = idOD;
        this.idO = idO;
        this.idP = idP;
        this.quantityOD = quantityOD;
    }

    public int getIdOD() {
        return idOD;
    }

    public void setIdOD(int idOD) {
        this.idOD = idOD;
    }

    public int getIdO() {
        return idO;
    }

    public void setIdO(int idO) {
        this.idO = idO;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public int getQuantityOD() {
        return quantityOD;
    }

    public void setQuantityOD(int quantityOD) {
        this.quantityOD = quantityOD;
    }
}
