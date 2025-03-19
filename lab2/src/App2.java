import java.util.Scanner;
import java.util.Random;

public class App2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of floors: ");
        int floors = scanner.nextInt();
        System.out.print("Enter the number of rooms per floor: ");
        int roomsPerFloor = scanner.nextInt();

        
        boolean[][] rooms = new boolean[floors][roomsPerFloor];
        initRooms(rooms);

        
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1) Display hotel floor plan");
            System.out.println("2) Book a room");
            System.out.println("3) Find the first free room");
            System.out.println("4) Free a room");
            System.out.println("5) Find three consecutive free rooms");
            System.out.println("6) Show total occupied rooms");
            System.out.println("7) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    print(rooms);
                    break;
                case 2:
                    bookRoom(rooms, scanner);
                    break;
                case 3:
                    findFirstFree(rooms, scanner);
                    break;
                case 4:
                    freeRoom(rooms, scanner);
                    break;
                case 5:
                    findThreeFreeRooms(rooms);
                    break;
                case 6:
                    System.out.println("Total occupied rooms: " + occupiedCount(rooms));
                    break;
                case 7:
                    System.out.println("exiting system");
                    break;
                default:

                    System.out.println("Invalid choice. Try again.");
            }
            if(choice==7)
            break;
        }

    }

 //--------------------------------------------------------------------------------------------------------------------------------------------------------------------
    public static void initRooms(boolean[][] rooms) {
        Random random = new Random();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = random.nextBoolean(); // Rastgele oda durumu belirle
            }
        }
    }

   
    public static void print(boolean[][] rooms) {
        System.out.println("\nHotel Floor Plan:");
        for (int i = 0; i < rooms.length; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(rooms[i][j] ? "X " : "O ");
            }
            System.out.println();
        }
    }

   
    public static void bookRoom(boolean[][] rooms, Scanner scanner) {
        System.out.print("Enter floor number: ");
        int floor = scanner.nextInt() - 1;
        System.out.print("Enter room number: ");
        int room = scanner.nextInt() - 1;

        if (isValidRoom(rooms, floor, room)) {
            if (!rooms[floor][room]) {
                rooms[floor][room] = true;
                System.out.println("Room " + (room + 1) + " on floor " + (floor + 1) + " booked successfully.");
            } else {
                System.out.println("Room is already occupied.");
            }
        }
    }

    
    public static void findFirstFree(boolean[][] rooms, Scanner scanner) {
        System.out.print("Enter start floor: ");
        int startFloor = scanner.nextInt() - 1;
        System.out.print("Enter end floor: ");
        int endFloor = scanner.nextInt() - 1;

        for (int i = startFloor; i <= endFloor; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (!rooms[i][j]) {
                    System.out.println("First available room: Floor " + (i + 1) + ", Room " + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No available room found in the given range.");
    }

    
    public static void freeRoom(boolean[][] rooms, Scanner scanner) {
        System.out.print("Enter floor number: ");
        int floor = scanner.nextInt() - 1;
        System.out.print("Enter room number: ");
        int room = scanner.nextInt() - 1;

        if (isValidRoom(rooms, floor, room)) {
            if (rooms[floor][room]) {
                rooms[floor][room] = false;
                System.out.println("Room " + (room + 1) + " on floor " + (floor + 1) + " is now free.");
            } else {
                System.out.println("Room is already free.");
            }
        }
    }

   
    public static int occupiedCount(boolean[][] rooms) {
        int count = 0;
        for (boolean[] floor : rooms) {
            for (boolean room : floor) {
                if (room) count++;
            }
        }
        return count;
    }

   
    public static void findThreeFreeRooms(boolean[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length - 2; j++) {
                if (!rooms[i][j] && !rooms[i][j + 1] && !rooms[i][j + 2]) {
                    System.out.println("Three consecutive free rooms found: Floor " + (i + 1) +
                            ", Rooms " + (j + 1) + ", " + (j + 2) + ", " + (j + 3));
                    return;
                }
            }
        }
        System.out.println("No block of three free rooms found.");
    }

    
    public static boolean isValidRoom(boolean[][] rooms, int floor, int room) {
        if (floor < 0 || floor >= rooms.length || room < 0 || room >= rooms[floor].length) {
            System.out.println("Invalid room selection.");
            return false;
        }
        return true;
    }
}
