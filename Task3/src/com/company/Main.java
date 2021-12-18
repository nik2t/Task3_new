package com.company;



import com.company.resources.Const;
import com.development7.NewAssistent;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        RecipeList list = new RecipeList();
        AvailableProducts aproduct = new AvailableProducts();
        MissingProducts mproduct = new MissingProducts();
        User user = new User(aproduct, mproduct);

        System.out.println("Введите тип приема пищи:");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        type = "Завтрак";
        System.out.println("Введите обязательный продукт:");
        String product = scanner.nextLine();
        product = "Яйца крупные";
        ArrayList<String> allergy = new ArrayList<String>();
        System.out.println("На какое количество продуктов у вас аллергия?");
        int number = scanner.nextInt();
        System.out.println("На что у вас аллергия?");
        BufferedReader enter = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < number; i++){
            allergy.add(enter.readLine());
        }


        Assistant assistant = new NewAssistent(list, user, allergy);

        ArrayList<Recipe> answer = assistant.pick_up(type.toString(), product.toString());
        int counter = 0;
        for(Recipe ans: answer){
            counter++;
            System.out.println("Рецепт №" + counter);
            ans.print();
        }
        System.out.println("Выберите рецепт(укажите №):");
        int choice = scanner.nextInt();
        choice--;
        user.setLast_recipe(answer.get(choice));

        System.out.println("////////////////////////////////");
        user.print();

        Conductor conductor = new Conductor(list, user);
        conductor.demonstration();
        user.print();
        user.delLast_recipe();

        System.out.println("////////////////////////////////");
        user.print();

        System.out.println("////////////////////////////////");
        conductor = new Conductor(list, user);
        conductor.demonstration();
        user.print();

    }

}
