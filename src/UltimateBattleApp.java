//Name: Steven Petocz
//Course: COP3330C - 13949
//Date: 09/28/25
//Module 04: Threads and Concurrency
//Program Objective: This simple program is displaying the concepts of Threads and Concurrency in Object-Oriented Programming
//Inputs: This program requires two objects of type contender to be instantiated to battle to showcase multiple threads
//Outputs: This program will output console logs of our contenders performing their action, their drinking, and winning states

//Class: UltimateBattleApp is our main class where we instantiate our contenders, create our threads, and start our threads
public class UltimateBattleApp {
    //call main method
    public static void main(String[] args) {

        //create water object to pass into constructor to call drink method in contender class run()
        Water water = new Water();

        //instantiate two objects of class contender, in our case the KrustyKrab and the ChumBucket whose goal is to serve
        //200 guests first. The KrustyKrab attracts more guests at a time, but require more rest, whereas the ChumBucket
        //attracts fewer guests at a time but requires less sleep as they have more automated help in the form of Plankton's
        //robot wife Karen.
        Contender KrustyKrab = new Contender("KrustyKrab", 8, 0, 500, water);
        Contender ChumBucket = new Contender("Chum Bucket", 6, 0, 200, water);

        //create two different threads for our two different contenders
        Thread thread1 = new Thread(KrustyKrab);
        Thread thread2 = new Thread(ChumBucket);

        //start out threads to compete
            thread1.start();
            thread2.start();
        }
    }
