import java.util.Scanner;

public class Cinema {


    public static void main(String[] args) {


        int rows, numberOfSeats;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        System.out.print("> ");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        System.out.print("> ");
        numberOfSeats = scanner.nextInt();
        System.out.print("\n");

        Room a1 = new Room(rows, numberOfSeats);
        menu(a1);

    }


    public static void menu(Room room) {
        boolean loop = true;

        while (loop) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.print("> ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    room.printScheme();
                    break;
                case 2:
                    room.buyTicket();
                    break;
                case 0:
                    loop = false;
                    break;
                case 3:
                    room.getStatistics();
                default:
                    break;
            }
        }
    }

}
