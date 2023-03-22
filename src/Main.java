

import java.util.Scanner;

class Room {

    int rows, numberOfSeats;
    int totalSeats;
    int tickets = 0, currentIncome = 0, totalIncome;
    char[][] seats;

    public Room(int rows, int numberOfSeats) {
        this.rows = rows;
        this.numberOfSeats = numberOfSeats;
        this.totalSeats = rows * numberOfSeats;
        this.seats = initSeats(rows, numberOfSeats);
        this.totalIncome = calculateProfit();
    }

    public char[][] initSeats(int rows, int numberOfSeats) {
        char[][] seats = new char[rows][numberOfSeats];
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'S';
            }
        }
        return seats;
    }

    private void printRow(char[][] seats, int row) {
        for (int i = 0; i < seats[row].length; i++) {
            System.out.print(seats[row][i] + " ");
        }
    }
    public void printScheme() {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i <= this.seats[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < this.seats.length; i++) {
            System.out.print(i+1 + " ");
            printRow(this.seats, i);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void buyTicket() {
        int row, seat, ticketPrice;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row number:");
        System.out.print("> ");
        row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        System.out.print("> ");
        seat = scanner.nextInt();
        System.out.print("\n");

        if (row > this.rows || seat > this.numberOfSeats) {
            System.out.println("Wrong input!");
            buyTicket();
        } else {
            if (this.totalSeats <= 60) {
                ticketPrice = 10;
            } else {
                ticketPrice = row <= this.seats.length / 2 ? 10 : 8;
            }

            if (this.seats[row-1][seat-1] == 'B') {
                System.out.println("That ticket has already been purchased!\n");
                buyTicket();
            } else {
                System.out.printf("Ticket price: $%d\n", ticketPrice);
                this.seats[row-1][seat-1] = 'B';
                this.currentIncome += ticketPrice;
                this.tickets++;
            }
        }

    }

    private int calculateProfit() {
        int income;
        int rows = this.seats.length;
        int seatsPerRow = this.seats[0].length;

        if (this.totalSeats <= 60) {
            income = this.totalSeats * 10;
        } else {
            int front = rows / 2;
            int back = rows % 2 == 0 ? rows / 2 : rows / 2 + 1;
            income = 10 * (front * seatsPerRow) + 8 * (back * seatsPerRow);
        }

        return income;
    }

    public void getStatistics() {
        System.out.printf("Number of purchased tickets: %d\n", this.tickets);
        double percent = ((double)this.tickets / (double)this.totalSeats) * 100;
        System.out.printf("Percentage: %.2f%%\n", percent);
        System.out.printf("Current income: $%d\n", this.currentIncome);
        System.out.printf("Total income: $%d\n", this.totalIncome);
    }
}