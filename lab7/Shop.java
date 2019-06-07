package lab7;

import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable{
    public static final long serialVersionUID = 1L;
    private String product;
    private String unitOfMeasurement;
    private String amount;
    private String priceOfProduct;
    private String weight;
    private String dateOfArriving;
    private ArrayList<String> description = new ArrayList<String>();
    public Shop() {}
    public Shop(String name,String unitOfMeasurement, String amount, String priceOfProduct, String weight, String dateOfArriving, ArrayList <String> description) {
        this.product = name;
        this.unitOfMeasurement = unitOfMeasurement;
        this.amount = amount;
        this.priceOfProduct = priceOfProduct;
        this.weight = weight;
        this.dateOfArriving = dateOfArriving;
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

    @Override
    public String toString() {
        return "\n         Product = " + product  +
                "\n         Unit of measurement = " + unitOfMeasurement +
                "\n         Amount = " + amount +
                "\n         Price of product = " + priceOfProduct +
                "\n         Weight = " + weight +
                "\n         Date of arriving = " + dateOfArriving +
                "\n         Description = "+description +
                "\n___________________________________________________________";
    }
}