
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        // Array of Video Cards for random choose 
        String [] videoCardArr = {"Nvidia", "AMD", "Intel", "MSI"};

        // Total price of all Devices
        double totalPrice = 0;
        // Total weight of all Devices
        double totalWeight = 0;

        // Input where user enter a random number from 1 to 20
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number from 1 to 20: ");
        int userNumber = sc.nextInt();
        
        ArrayList<Device> devices = new ArrayList<>();

        Random rand = new Random();

        // Loop for creating a Devices(Laptop, Smartphone, Tablet)
        for (int i = 0; i < userNumber; i++) {
            // Random choose from 0:Laptop, 1:Smartphone, 2:Tablet
            int type = rand.nextInt(3);

            if(type==0){ // create laptop
                int selectVideoCard = rand.nextInt(videoCardArr.length);
                Laptop l1 = new Laptop(rand.nextInt(1000) + 1, rand.nextInt(10) + 1, "Laptop", rand.nextInt(16) + 1, videoCardArr[selectVideoCard]);
                devices.add(l1);
            }
            else if(type==1){ // create smartphone
                Smartphone s1 = new Smartphone(rand.nextInt(500) + 1, rand.nextInt(5) + 1, "Smartphone", rand.nextInt(108) + 1, rand.nextBoolean());
                devices.add(s1);
            }
            else{ // create tablet
                Tablet t1 = new Tablet(rand.nextInt(700) + 1, rand.nextInt(7) + 1, "Tablet", rand.nextBoolean(), rand.nextInt(90) + 1);
                devices.add(t1);
            }
        }

        

        for ( Device device : devices){
            System.out.println(device);
            totalPrice += device.getPrice();
            totalWeight += device.getWeight();
        }


        // Answer
        System.out.println("The number of distinct device types created : " + devices.size());
        System.out.println("The total price of all devices: " + totalPrice + "$");
        System.out.println("The total weight of all devices: " + totalWeight);



        //Objects of Device class
        // Device d1 = new Device(10000, 1, "smartphone");
        // System.out.println(d1.toShow());

        // Laptop l1 = new Laptop(80000, 2, "Laptop", 8, "Nvidia GeForce GTX 550");
        // System.out.println(l1.toShow());

        // Smartphone s1 = new Smartphone(10000, 1, "Smartphone", 48, true);
        // System.out.println(s1.toShow());

        // Tablet t1 = new Tablet(15000, 2, "Tablet", false, 24);
        // System.out.println(t1.toShow());
    }
}
