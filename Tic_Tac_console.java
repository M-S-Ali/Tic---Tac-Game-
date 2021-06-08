// Tic Tac Toe Game in JAVA

package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    static String[][] data  = new String[][]{{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "} };
    static int[][] available = { {0,0,0},{0,0,0},{0,0,0} };


    static void board() {
        String emptyLine = '|' + " ".repeat(7) + "|" + " ".repeat(7) + '|' + " ".repeat(7) + "|";
        String underscoreLine = '|' + "_".repeat(7) + "|" + "_".repeat(7) + '|' + "_".repeat(7) + "|";
        String ln = " ".repeat(3) + '|' + " ".repeat(3);

        System.out.println(' ' + "_".repeat(7) + " " + "_".repeat(7) + ' ' + "_".repeat(7) + " ");
        System.out.println(emptyLine);
        System.out.println('|' + " ".repeat(3) + data[0][0] + ln + data[0][1] + ln + data[0][2] + " ".repeat(3) + '|');
        System.out.println(underscoreLine);
        System.out.println(emptyLine);
        System.out.println('|' + " ".repeat(3) + data[1][0] + ln + data[1][1] + ln + data[1][2] + " ".repeat(3) + '|');
        System.out.println(underscoreLine);
        System.out.println(emptyLine);
        System.out.println('|' + " ".repeat(3) + data[2][0] + ln + data[2][1] + ln + data[2][2] + " ".repeat(3) + '|');
        System.out.println(underscoreLine);
    }


    static void input_update(String mark) {
        Scanner scan = new Scanner(System.in);
        int r, c;
        while (true) {
            try {
                System.out.print("Enter the Row Number: ");
                r = scan.nextInt();
                System.out.print("Enter the Column Number: ");
                c = scan.nextInt();
            }
            catch (InputMismatchException exception) {
              System.out.println("Please Try Again");
                scan.nextLine();
                continue;
            }
            if (r < 4 && r > 0 && c < 4 && c > 0) {
                if (available[r - 1][c - 1] == 0) {
                    data[r - 1][c - 1] = mark;
                    available[r - 1][c - 1] = 1;
                    break;
                } else {
                    System.out.println("Move Unavailable, Please try again");
                }
            }
            else {
                System.out.println("Out of Range, Please try again");
            }
            }
        }


    static boolean check4victory() {
        return  (data[0][0].equals(data[0][1]) && data[0][0].equals(data[0][2]) && !data[0][1].equals(" ")) ||
                (data[1][0].equals(data[1][1]) && data[1][0].equals(data[1][2]) && !data[1][0].equals(" ")) ||
                (data[2][0].equals(data[2][1]) && data[2][0].equals(data[2][2]) && !data[2][0].equals(" ")) ||
                (data[0][0].equals(data[1][0]) && data[0][0].equals(data[2][0]) && !data[0][0].equals(" ")) ||
                (data[0][1].equals(data[1][1]) && data[0][1].equals(data[2][1]) && !data[0][1].equals(" ")) ||
                (data[0][2].equals(data[1][2]) && data[0][2].equals(data[2][2]) && !data[0][2].equals(" ")) ||
                (data[0][0].equals(data[1][1]) && data[0][0].equals(data[2][2]) && !data[0][0].equals(" ")) ||
                (data[2][0].equals(data[1][1]) && data[2][0].equals(data[0][2]) && !data[2][0].equals(" "));
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Tic Tac Toe Game");
            board();
            int i;
            int user = 1;
            for (i = 0; i < 9; i++) {
                String name;
                String mark;
                if (user == 1) {
                    mark = "X";
                    name = "Tic ";
                } else {
                    mark = "O";
                    name = "Tac ";
                }
                System.out.println(name + "Turn");
                input_update(mark);
                board();
                if (check4victory()) {
                    System.out.println(name + "WON");
                    break;
                }
                user = user * -1;
            }
            if (i == 9) {
                System.out.println(" Draw Game");
            }
            System.out.println("Play Again [Y/N]: ");
            String play_again = scan.next();
            if (play_again.equals("Y") || play_again.equals("y")) {
                for (i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        data[i][j] = " ";
                        available[i][j] = 0;
                    }
                }
                continue;
            }
            break;
        }
    }
}
