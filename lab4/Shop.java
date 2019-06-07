package lab4;

import java.io.Serializable;
import java.util.ArrayList;
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    private String product;
    private String unitOfMeasurement;
    private String amount;
    private String priceOfProduct;
    private String weight;
    private String dateOfArriving;
    private ArrayList<String> description = new ArrayList<String>();

    public Shop(String product, String unitOfMeasurement, String amount, String priceOfProduct, String weight, String dateOfArriving, ArrayList<String> description) {
        setShop(product, unitOfMeasurement, amount, priceOfProduct, weight, dateOfArriving, description);
    }

    private void setShop(String product, String unitOfMeasurement, String amount, String priceOfProduct, String weight, String dateOfArriving, ArrayList<String> description) {
        this.setProduct(product);
        this.setUnitOfMeasurement(unitOfMeasurement);
        this.setAmount(amount);
        this.setPriceOfProduct(priceOfProduct);
        this.setWeight(weight);
        this.setDateOfArriving(dateOfArriving);
        this.setDescription(description);
    }

    public Shop() {
    }

    public void print() {
        System.out.println("Product:" + getProduct() + "");
        System.out.println("Unit of measurement:" + getUnitOfMeasurement() + "");
        System.out.println("Amount:" + getAmount() + "");
        System.out.println("Price of product:" + getPriceOfProduct() + "");
        System.out.println("Weight:" + getWeight() + "");
        System.out.println("Date of arriving:" + getDateOfArriving() + "");
        System.out.println("Description:" + getDescription() + "");
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPriceOfProduct(String priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setDateOfArriving(String dateOfArriving) {
        this.dateOfArriving = dateOfArriving;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }


    public String getProduct() {
        return product;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public String getAmount() {
        return amount;
    }

    public String getPriceOfProduct() {
        return priceOfProduct;
    }

    public String getWeight() {
        return weight;
    }

    public String getDateOfArriving() {
        return dateOfArriving;
    }

    public ArrayList<String> getDescription() {
        return description;
    }
}
