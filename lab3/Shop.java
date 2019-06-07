package lab3;

import java.util.HashMap;

public class Shop {
    public String product;
    public String unitOfMeasurement;
    public int amount;
    public int priceOfProduct;
    public int weight;
    public String dateOfArriving;
    public HashMap<String, String> description;

    public Shop() {}

    public void setProduct(String product){
        this.product = product;
    }
    public void setUnitOfMeasurement(String unitOfMeasurement){
        this.unitOfMeasurement = unitOfMeasurement;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public void setPriceOfProduct(int priceOfProduct){
        this.priceOfProduct = priceOfProduct;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setDateOfArriving(String dateOfArriving){
        this.dateOfArriving = dateOfArriving;
    }
    public void setDescription(HashMap<String, String> description){
        this.description = description;
    }



    public String getProduct(){
        return product;
    }
    public String getUnitOfMeasurement(){
        return unitOfMeasurement;
    }
    public int getAmount(){
        return amount;
    }
    public int getPriceOfProduct(){
        return priceOfProduct;
    }
    public int getWeight(){
        return weight;
    }
    public String getDateOfArriving(){
        return dateOfArriving;
    }
    public HashMap<String, String> getDescription(){
        return description;
    }
}


