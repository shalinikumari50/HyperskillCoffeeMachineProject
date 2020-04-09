package coffeeMachine;

import java.util.Scanner;
public class CoffeeMachine {
    int disposableCups = 9;
    int water = 400;
    int milk = 540;
    int beans = 120;
    int money = 550;

    public void printMaterials(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water\n" + milk + " of milk\n" + beans + " of coffee beans\n" + disposableCups +
                " of disposable cups\n" + money + " of money" );
    }

    public void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = Integer.parseInt(scanner.nextLine());
        water += addWater;
        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = Integer.parseInt(scanner.nextLine());
        milk += addMilk;
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addBeans = Integer.parseInt(scanner.nextLine());
        beans += addBeans;
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addDisposableCups = Integer.parseInt(scanner.nextLine());
        disposableCups += addDisposableCups;

    }

    public void buy(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.nextLine();

        switch(choice){
            case "1" :
                if(water >= 250  ){
                    if(beans >= 16)
                    {
                        System.out.println("I have enough resources, making you a coffee!");
                        water-=250;
                        beans-=16;
                        money+=4;
                        disposableCups -=1;}
                    else{
                        System.out.println("Sorry, not enough beans!");
                    }
                }else{
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2" :
                if(water >= 350 ){
                    if(milk >= 75)
                    {if(beans >= 20)
                    {System.out.println("I have enough resources, making you a coffee!");
                        water -= 350;
                        milk -= 75;
                        beans -= 20;
                        money += 7;
                        disposableCups -=1;}else{
                        System.out.println("Sorry, not enough beans!");
                    }}
                    else{
                        System.out.println("Sorry, not enough milk!");
                    }
                }else{
                    System.out.println("Sorry, not enough water!");
                }break;
            case "3" :
                if(water >= 200  ){
                    if(milk >= 100)
                    {
                        if(beans >= 12)
                        {System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            money += 6;
                            disposableCups -=1;}else{
                            System.out.println("Sorry, not enough beans!");
                        }
                    }else{
                        System.out.println("Sorry, not enough milk!");
                    }
                }else{
                    System.out.println("Sorry, not enough water!");
                } break;
            case "back" :
                break;

        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        boolean exit = false;
        while(!exit)
        {System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String input = scanner.nextLine();
            switch(input){
                case "buy" :
                    coffeeMachine.buy();
                    break;
                case "fill" :
                    coffeeMachine.fill();
                    break;
                case "take" :
                    coffeeMachine.take();
                    break;
                case "remaining" :
                    coffeeMachine.printMaterials();
                    break;
                case "exit" :
                    exit = true;
                    break;
            }}



    }
    public static void inputIngredients(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int water = Integer.parseInt(scanner.nextLine());
        int waterEnoughFor = water/200;
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = Integer.parseInt(scanner.nextLine());
        int milkEnoughFor = milk/50;
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = Integer.parseInt(scanner.nextLine());
        int beansEnoughFor = beans/15;
        int cups = Math.min(Math.min(waterEnoughFor,milkEnoughFor),beansEnoughFor);
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOfCoffee = Integer.parseInt(scanner.nextLine());
        if(cups==cupsOfCoffee){
            System.out.println("Yes, I can make that amount of coffee");
        }else if(cups>cupsOfCoffee){
            System.out.println("Yes, I can make that amount of coffee (and even "+  (cups-cupsOfCoffee) +" more than that)");
        }else{
            System.out.println("No, I can make only "+ cups +" cup(s) of coffee");
        }

    }


    public static void printRecipe(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
