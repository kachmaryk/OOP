package lab5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
    public static BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
    private static final long serialVersionUID = 1L;

    private String product;
    private String unitOfMeasurement;
    private String amount;
    private String priceOfProduct;
    private String weight;
    private String dateOfArriving;
    private ArrayList<String> description = new ArrayList<String>();

    public Shop(String product, String unitOfMeasurement, String amount, String priceOfProduct, String weight, String dateOfArriving, ArrayList<String> description){
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

    public void setProduct(String product){
        if (!RegEx.isValidProduct(product)) {
            System.out.println("Product has wrong format!");
            this.product = "eror";
        } else {
            this.product = product;
        }
    }

    public void setUnitOfMeasurement(String unitOfMeasurement){
        String new_unitOfMeasurement = null;
        if (!RegEx.isValidUnitOfMeasurement(unitOfMeasurement)) {
            System.out.println("Unit of measurement has wrong format!");
            this.unitOfMeasurement = "eror";
        } else {
            this.unitOfMeasurement = unitOfMeasurement;
        }
    }

    public void setAmount(String amount){
        if (!RegEx.isValidAmount(amount)) {
            System.out.println("Amount has wrong format!");
            this.amount = "eror";
        } else {
            this.amount = amount;
        }
    }

    public void setPriceOfProduct(String priceOfProduct){
        if (!RegEx.isValidPriceOfProduct(priceOfProduct)) {
            System.out.println("Price of product has wrong format!");
            this.priceOfProduct = "eror";
        } else {
            this.priceOfProduct = priceOfProduct;
        }
    }

    public void setWeight(String weight){
        this.weight = weight;
        if (!RegEx.isValidWeight(weight)) {
            System.out.println("Weight has wrong format!");
            this.weight = "eror";
        } else {
            this.weight = weight;
        }
    }

    public void setDateOfArriving(String dateOfArriving){
        this.dateOfArriving = dateOfArriving;
        if (!RegEx.isValidDateOfArriving(dateOfArriving)) {
            System.out.println("Date of arriving has wrong format!");
            this.dateOfArriving = "eror";
        }
        else{
                this.dateOfArriving = dateOfArriving;
            }
        }

        public void setDescription (ArrayList < String > description) {
            this.description = description;
        }


        public String getProduct () {
            return product;
        }

        public String getUnitOfMeasurement () {
            return unitOfMeasurement;
        }

        public String getAmount () {
            return amount;
        }

        public String getPriceOfProduct () {
            return priceOfProduct;
        }

        public String getWeight () {
            return weight;
        }

        public String getDateOfArriving () {
            return dateOfArriving;
        }

        public ArrayList<String> getDescription () {
            return description;
        }
}

