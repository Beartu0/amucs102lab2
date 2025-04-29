import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("please enter the floor of hotel");
        int floor= scanner.nextInt();
        System.out.println("please enter the room number per floor");
        int room= scanner.nextInt();
        boolean rooms[][]=new boolean[floor][room];
        
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

            int sec = scanner.nextInt();
            if (sec==7) 
                break;
              
            switch (sec){case 1:
                print(rooms);
                break;
            case 2:
                bookARoom(rooms,floor,room);
                break;
            case 3:                                     
                firstFree(rooms);
                break;
            case 4:
                freeARoom(rooms,floor,room);
                break;
            case 5:
                firstFree(rooms);
                break;
            case 6:
                System.out.println("Total occupied rooms: " + occupiedCount(rooms));
                break;
            case 7:
                System.out.println("exiting system");
                break;
            default:
                System.out.println("Invalid choice. Try again.");
        }} 
    }
    
    public static int findThree(boolean[][]occupied)
    {
        for (int j=0; j<occupied.length;j++)
            for(int i=0;i<occupied[j].length-2;++i)
            {
                if(occupied[j][i]==false && occupied[j][i+1]==false && occupied[j][i+2]==false)
                    return i;
            }
        return -1;
    }  
    public static void freeARoom(boolean occupied[][],int floor, int room)
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("please select the floor");
        int flor=scanner.nextInt()-1;
        System.out.println("please select the room");
        int rom=scanner.nextInt()-1;   
        if(rom>=0 && rom<occupied[0].length &&flor>=0 && flor<occupied.length)
        {
            if(occupied[flor][rom])
            {
               occupied[flor][rom]=false; 
            }
               
            
        }
            
    }
    public static int occupiedCount(boolean occupied[][])
    {
        int count=0;
        
        for (int j=0; j<occupied.length; j++){
            for(int i=0;i<occupied[j].length;++i)
            {
                if(occupied[j][i])
                    ++count;
            }
        }
            return  count;

    }
    public static void bookARoom(boolean occupied[][],int floor, int room)
    {   
        Scanner scanner= new Scanner(System.in);
        System.out.println("please select the floor");
        int flor=scanner.nextInt()-1;
        System.out.println("please select the floor");
        int rom=scanner.nextInt()-1;
        if(rom>=0 && rom<occupied[0].length &&flor>=0 && flor<occupied.length)
        {
            if(!occupied[flor][rom])
            {
               occupied[flor][rom]=true; 
            }
            else
                System.out.println("Room  is occupied and cannot be booked!");
               
            
        }
            
    }   
    public static void initRooms(boolean occupied[][])
    {
        for(int j=0; j<occupied.length; j++){
            for(int i=0;i<occupied[j].length;++i)
            {
                if(i%2==1)
                    occupied[j][i]=false;
                else
                    occupied[j][i]=true;
            }
        }   
    }   
    public static void print(boolean occupied[][])
    {   
        for (int j=0; j<occupied.length; j++){
            System.out.print("floor["+(j+1)+"]: ");
            for(int i=0;i<occupied.length;++i)
                if(occupied[j][i]){
                    System.out.print("x");
                }
                else
                System.out.print("O");
            System.out.println();    
        }
    }   
    public static void firstFree(boolean occupied[][])
    {
        Scanner scanner= new Scanner(System.in);
        System.out.println("başlangıç ve bitiş veriniz");
        int start=scanner.nextInt()-1;
        int end=scanner.nextInt()-1;
        System.out.println("please select a floor to search");
        int j=scanner.nextInt()-1;   
        for(int i=start;i<=end;++i)
        {
            if(!occupied[j][i]){
                System.out.println(j+"katındaki ilkboş oda"+(i+1)+"nolu oda");
                return;
            }

        }
        System.out.println("seçtiğiniz katta boş oda yok");
        
    }      
    
    
}
