package fiek.unipr.stayfit.model;

public class Nutritions {
    String energy;
    String protein;
    String fat;
    String saturated_fat;
    String carbohydrate;
    String sugars;
    String dietary_fibre;
    String sodium;

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSaturated_fat() {
        return saturated_fat;
    }

    public void setSaturated_fat(String saturated_fat) {
        this.saturated_fat = saturated_fat;
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public String getDietary_fibre() {
        return dietary_fibre;
    }

    public void setDietary_fibre(String dietary_fibre) {
        this.dietary_fibre = dietary_fibre;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getSomeValues(){
        return this.energy + " " + this.fat + " " + this.protein;
    }
}
