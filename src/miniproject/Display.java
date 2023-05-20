package miniproject;

import java.util.*;
import static miniproject.MiniProject.initialResponse;

public class Display {
    private static int displayResponse = 0;
    private static int loginSignupResponse = 0;
    private static int userResponse = 0;
    private static int ownerResponse = 0;
    private static int AdminResponse = 0;

    public static int initialDisplay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Press 1 for User");
        System.out.println("Press 2 for Bussiness Owner");
        System.out.println("Press 3 for Admin");
        System.out.println("Press 4 for Exit");

        int response = scan.nextInt();
        displayResponse = response;
        return response;
    }

    public static int loginSignup() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Press 1 for login");
        System.out.println("Press 2 for Signup");
        System.out.println("Press 3 to go to main menu");

        int secondResponse = scan1.nextInt();
        loginSignupResponse = secondResponse;
        return (secondResponse);
    }

    public static int businessOwnerDisplay() {
        Scanner scan3 = new Scanner(System.in);
        System.out.println("press 1 for Cinema");
        System.out.println("press 2 for Restaurant");
        System.out.println("press 3 for airplane");
        System.out.println("press 4 for conference room");
        int OwnerResponse = scan3.nextInt();
        ownerResponse = OwnerResponse;
        return OwnerResponse;
    }

    public static int userDisplay() {
        Scanner scan3 = new Scanner(System.in);
        System.out.println("press 1 for Booking Cinema Seat");
        System.out.println("press 2 for Booking Restaurant Seat");
        System.out.println("press 3 for Booking Airplane Seat");
        System.out.println("press 4 for Booking conference Room Seat");
        System.out.println("press 5 for to Canceling Booking");
        System.out.println("press 6 for Reselling Seat");
        System.out.println("press 7 for sending a message to another user");
        System.out.println("press 8 for sending a message to the Admin");
        System.out.println("press 9 to LogOut");
        int roomType = scan3.nextInt();
        // System.out.println(roomType);
        int sellerType = 0;
        if ((roomType == 1) || (roomType == 2) || (roomType == 3) || (roomType == 4)) {
            System.out.println("press 1 for Booking directly from Owner");
            System.out.println("press 2 for Booking from a reseller");
            sellerType = scan3.nextInt();
            if (roomType == 1 && sellerType == 1) {
                userResponse = 1;
                return 1;
            }
            if (roomType == 1 && sellerType == 2) {
                userResponse = 2;
                return 2;
            }
            if (roomType == 2 && sellerType == 1) {
                userResponse = 3;
                return 3;
            }
            if (roomType == 2 && sellerType == 2) {
                userResponse = 4;
                return 4;
            }
            if (roomType == 3 && sellerType == 1) {
                userResponse = 5;
                return 5;
            }
            if (roomType == 3 && sellerType == 2) {
                userResponse = 6;
                return 6;
            }
            if (roomType == 4 && sellerType == 1) {
                userResponse = 7;
                return 7;
            }
            if (roomType == 4 && sellerType == 2) {
                userResponse = 8;
                return 8;
            }
        }

        else if (roomType == 5) {
            userResponse = 9;
            return 9;
        } else if (roomType == 6) {
            userResponse = 10;
            return 10;
        } else if (roomType == 7) {
            userResponse = 11;
            return 11;
        } else if (roomType == 8) {
            userResponse = 12;
            return 12;
        }

        else if (roomType == 9) {
            userResponse = 13;
            return 13;
        }
        return 0;
        //
    }

    public static int adminDisplay() {
        System.out.println("press 1 for reading messages");
        System.out.println("press 2 for blocking a user");
        System.out.println("press 3 for blocking a owner");
        System.out.println("press 4 for booked seats List");
        System.out.println("press 5 for resell seats List");
        System.out.println("press 6 to Log Out");

        Scanner scan11 = new Scanner(System.in);
        System.out.println(" ");

        int adminResponse = scan11.nextInt();
        AdminResponse = adminResponse;
        return adminResponse;

    }
}
