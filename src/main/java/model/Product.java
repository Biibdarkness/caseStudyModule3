package model;

public class Product {
    private int idP;
    private String typeP;
    private String nameP;
    private int quantityP;
    private String priceP;
    private String descriptionP;
    private Status statusP;

    public Product() {
    }

    public Product(int idP, String typeP, String nameP, int quantityP, String priceP, String descriptionP, Status statusP) {
        this.idP = idP;
        this.typeP = typeP;
        this.nameP = nameP;
        this.quantityP = quantityP;
        this.priceP = priceP;
        this.descriptionP = descriptionP;
        this.statusP = statusP;
    }

    public Product(int idP, String typeP, String nameP, int quantityP, String priceP, String descriptionP) {
        this.idP = idP;
        this.typeP = typeP;
        this.nameP = nameP;
        this.quantityP = quantityP;
        this.priceP = priceP;
        this.descriptionP = descriptionP;
    }

    public Product(String typeP, String nameP, int quantityP, String priceP, String descriptionP) {
        this.typeP = typeP;
        this.nameP = nameP;
        this.quantityP = quantityP;
        this.priceP = priceP;
        this.descriptionP = descriptionP;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getTypeP() {
        return typeP;
    }

    public void setTypeP(String typeP) {
        this.typeP = typeP;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public int getQuantityP() {
        return quantityP;
    }

    public void setQuantityP(int quantityP) {
        this.quantityP = quantityP;
    }

    public String getPriceP() {
        return priceP;
    }

    public void setPriceP(String priceP) {
        this.priceP = priceP;
    }

    public String getDescriptionP() {
        return descriptionP;
    }

    public void setDescriptionP(String descriptionP) {
        this.descriptionP = descriptionP;
    }

    public Status getStatusP() {
        return statusP;
    }

    public void setStatusP(Status statusP) {
        this.statusP = statusP;
    }


    @Override
    public String toString() {
        return "Product{" +
                "idP=" + idP +
                ", typeP='" + typeP + '\'' +
                ", nameP='" + nameP + '\'' +
                ", quantityP=" + quantityP +
                ", priceP=" + priceP +
                ", descriptionP='" + descriptionP + '\'' +
                ", statusP=" + statusP +
                '}';
    }
}
