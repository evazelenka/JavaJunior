package org.example.sem1.homework1;

import org.example.sem1.homework1.common.interfaces.Food;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food> {

    //region Методы

    /**
     * Балансировка корзины
     */
    public void cartBalancing() {
        boolean proteins = false;
        boolean fats = false;
        boolean carbohydrates = false;

        proteins = foodstuffs.stream().anyMatch(food -> food.getProteins());
        fats = foodstuffs.stream().anyMatch(food -> food.getFats());
        carbohydrates = foodstuffs.stream().anyMatch(food -> food.getCarbohydrates());

//        for (var food : foodstuffs) {
//            if (!proteins && food.getProteins())
//                proteins = true;
//            else if (!fats && food.getFats())
//                fats = true;
//            else if (!carbohydrates && food.getCarbohydrates())
//                carbohydrates = true;
//            if (carbohydrates && fats && proteins)
//                break;
//        }
        if (carbohydrates && fats && proteins) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }
        if(!proteins){
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(food -> food.getProteins()).findAny().get());
            proteins = true;
        }
        if (!fats) {
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(food -> food.getFats()).findAny().get());
            fats = true;
        }
        if (!carbohydrates) {
            foodstuffs.add((T) market.getThings(Food.class).stream().filter(food -> food.getCarbohydrates()).findAny().get());
            carbohydrates = true;
        }
        System.out.println((carbohydrates && fats && proteins) ? "Корзина сбалансирована по БЖУ." : "Невозможно сбалансировать корзину по БЖУ.");

//        for (var thing : market.getThings(Food.class)) {
//            if (!proteins && thing.getProteins()) {
//                proteins = true;
//                foodstuffs.add((T)thing);
//            }
//            else if (!fats && thing.getFats()) {
//                fats = true;
//                foodstuffs.add((T)thing);
//            }
//            else if (!carbohydrates && thing.getCarbohydrates()) {
//                carbohydrates = true;
//                foodstuffs.add((T)thing);
//            }
//            if (carbohydrates && fats && proteins)
//                break;
//        }
//        if(carbohydrates && fats && proteins){
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        } else
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }

    /**
     * Распечатать список товаров в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }
    public ArrayList<T> getFoodstuffs() {
        return foodstuffs;
    }
    //endregion

    //region Конструкторы
    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }
    //endregion

    //region Поля
    private final UMarket market;
    private final ArrayList<T> foodstuffs;
    private final Class<T> clazz;
    //endregion
}
