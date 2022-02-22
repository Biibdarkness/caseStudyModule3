package model;

public class Customer {
    private int idCus;
    private String nameCus;
    private String phoneCus;
    private String emailCus;
    private String addressCus;

    public Customer() {
    }

    public Customer(int idCus, String nameCus, String phoneCus, String emailCus, String addressCus) {
        this.idCus = idCus;
        this.nameCus = nameCus;
        this.phoneCus = phoneCus;
        this.emailCus = emailCus;
        this.addressCus = addressCus;
    }

    public int getIdCus() {
        return idCus;
    }

    public void setIdCus(int idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getPhoneCus() {
        return phoneCus;
    }

    public void setPhoneCus(String phoneCus) {
        this.phoneCus = phoneCus;
    }

    public String getEmailCus() {
        return emailCus;
    }

    public void setEmailCus(String emailCus) {
        this.emailCus = emailCus;
    }

    public String getAddressCus() {
        return addressCus;
    }

    public void setAddressCus(String addressCus) {
        this.addressCus = addressCus;
    }
}
