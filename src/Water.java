//Class: Water is created to house our drink() method and pass water objects to our contender constructor
public class Water {
    //synchronized method drink will allow only one thread to access the method at a time
    public synchronized void drink(String name) {
        //method console logs message name is drinking, sleeps for predetermined time, then logs message that name is done
        System.out.println(name + " is drinking water.");
        //exception handling is necessary to catch interrupted threads
        try {
            if(name.equalsIgnoreCase("KrustyKrab")){
                Thread.sleep(350);
            }else if(name.equalsIgnoreCase("Chum Bucket")){
                Thread.sleep(450);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " has finished drinking.");
    }
}
