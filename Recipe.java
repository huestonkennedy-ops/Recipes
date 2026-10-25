import java.util.ArrayList;
public class Recipe {
    private String name;
    private int cookingTime;
    public ArrayList<String> ingredients;
    public Recipe(String name, int cookingTime, ArrayList<String> ingredients) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
    }
    public String toString() {
        return(name + ", cooking time: " + cookingTime);
    }
    public void printIngredients() {
        for(String i: ingredients) {
            System.out.println(i);
        }
    }
    public String name() {
        return this.name;
    }
    public int time() {
        return this.cookingTime;
    }
 }