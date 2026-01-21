//Class: Contender is created to describe our contenders and what they will be doing during competition
//the class imports random library to generate random numbers, and implements runnable to utilize run()

import java.util.Random;

public class Contender implements Runnable {

    //private attributes name, customers (number served at a time), total customers, and max rest needed
    private String name;
    private int customers;
    private int totalCustomersServed;
    private int maxRest;
    //create water object called water to pass into constructor to utilize drink() method
    Water water;

    //constructor to create a contender
    public Contender(String name, int customers, int totalCustomersServed, int maxRest, Water water) {
        this.name = name;
        this.customers = customers;
        this.totalCustomersServed = totalCustomersServed;
        this.maxRest = maxRest;
        this.water = water;

    }

    //getters and setter (not really needed for this program, but included to for the habit of making/using)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public int getTotalCustomersServed() {
        return totalCustomersServed;
    }

    public void setTotalCustomersServed(int totalCustomersServed) {
        this.totalCustomersServed = totalCustomersServed;
    }

    public int getMaxRest() {
        return maxRest;
    }

    public void setMaxRest(int maxRest) {
        this.maxRest = maxRest;
    }


    //boolean flag to use in while loop during competition
    //static so that it is shared between all child objects
    //volatile so that it updates for all threads simultaneously
    public static volatile boolean winner = false;

    //override toString to be more descriptive (Not used in this program)
    @Override
    public String toString() {
        return name + " has served " + totalCustomersServed + " customers.";
    }

    //create new random object to call random methods later
    Random random = new Random();

    //override run() to describe what contenders will do in runtime
    @Override
    public void run() {
        //try catch block for thread interruption exception handling
        try {

            //while loop during competition while we have no winner
            while (!winner) {

                //check for winner clause (200 guests served)
                if (totalCustomersServed >= 200) {
                    //if >= 200 win clause is true, log winner to the console and break out of loop
                    winner = true;
                    System.out.println(name + " has served 200 or more customers. " + name + " is the winner!");
                    break;
                }

                //if no winner try to serve guests by rolling random number (1-100)
                int tryToServe = random.nextInt(100) + 1;

                //if random number is >= guests are served successfully
                if (tryToServe >= 50) {
                    //increment our total count by how many guests our child can serve at a time
                    totalCustomersServed += customers;
                    //log our current status
                    System.out.println(name + " has served " + totalCustomersServed + " customers.");

                    //after we serve guests try to drink by rolling random number (1-100)
                    int tryToDrink = random.nextInt(100) + 1;

                    //if random number is >= 75 we successfully drink
                    if(tryToDrink >= 75) {
                        //synchronized wrapper to ensure only one thread accesses this method at a time
                        synchronized (water) {
                            //pass name to the method so our console logs print properly
                            water.drink(name);
                        }
                    }
                }
                //after each cycle we sleep for a random time between 1ms -> maxRest
                int sleepTime = random.nextInt(maxRest) + 1;

                    Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e){
            //exception logging if we get a thread interrupt
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted");
        }
    }
}
