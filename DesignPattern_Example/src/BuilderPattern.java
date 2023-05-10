import java.util.ArrayList;
import java.util.List;

public class BuilderPattern extends DesignPattern_Template{
    BuilderPattern(){
        pattern_name = "Builder Pattern";
        pattern_description = "Builder pattern builds a complex object using simple objects and using a step \n" +
                "by step approach. This type of design pattern comes under creational pattern as this pattern\n " +
                "provides one of the best ways to create an object.\n" +
                "\n" +
                "A Builder class builds the final object step by step. This builder is independent of other \n" +
                "objects.";
    }
    @Override
    public void showDemo(){

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());
    }
}
interface Item{
    public String name();
    public Packing packing();
    public float price();

}
interface Packing{
    public String pack();
}

class Wrapper implements Packing{
    @Override
    public String pack(){
        return "Wrapper";
    }
}
class Bottle implements Packing{
    @Override
    public String pack(){
        return "Bottle";
    }
}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

//Object
class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

//Object
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){

        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}