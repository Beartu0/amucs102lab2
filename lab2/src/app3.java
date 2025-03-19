import java.util.Scanner;
public class app3 {
    public static void main(String[] args){
        Scanner scanner= new Scanner(System.in);
        System.out.print("Enter the number of floors: ");
        int floors = scanner.nextInt();
        System.out.print("Enter the number of rooms per floor: ");
        int roomsPerFloor = scanner.nextInt();

        // 2D oda dizisini oluştur ve başlat
        boolean[][] rooms = new boolean[floors][roomsPerFloor];
        System.out.println(rooms.length);
        System.out.println(rooms[0].length);
    }
}
