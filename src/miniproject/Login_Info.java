
package miniproject;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Login_Info {
    static String storeUsername;
    static private String customerUserName = "";
    static private String customerPassword = "";
    static private String ownerUserName = "";
    static private String ownerPassword = "";
    static private String adminUserName = "";
    static private String adminPassword = "";
    static public String newUserName, newPassword, confirmPassword;
     public static int userSignup() {
        Scanner userSignupScan = new Scanner(System.in);
        System.out.println("Enter new username");
        newUserName = userSignupScan.nextLine();
        System.out.println("Enter new password");
        newPassword = userSignupScan.nextLine();
        System.out.println("Confirm Password");
        String conpass = userSignupScan.nextLine();
        confirmPassword = conpass;
        if (newPassword.equals(conpass)) {
            System.out.println("User Successfully Created");
            try (FileWriter fw = new FileWriter("user.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                out.println(newUserName + "," + newPassword);
                out.close();
                return 1;
               
            } catch (IOException e) {
            }
        } else {
            System.out.println("The password and new password does not match");
            System.out.println("Press 1 to retry");
            int a = userSignupScan.nextInt();
            if (a == 1) {
                return 0;

            }
        }
        return 0;
    }

    public static int ownerSignup() {
        Scanner ownerSignupScan = new Scanner(System.in);
        System.out.println("Enter new username");
        newUserName = ownerSignupScan.nextLine();
        System.out.println("Enter new password");
        newPassword = ownerSignupScan.nextLine();
        System.out.println("Confirm Password");
        String conpass = ownerSignupScan.nextLine();
        confirmPassword = conpass;
        if (newPassword.equals(conpass)) {
            System.out.println("User Successfully Created");
            try (FileWriter fw = new FileWriter("owner.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter out = new PrintWriter(bw)) {
                // more code
                out.println(newUserName + "," + newPassword);
                // out.close();
                return 1;
                // more code
            } catch (IOException e) {
                // exception handling left as an exercise for the reader
            }

        } else {
            System.out.println("The password and new password does not match");
            System.out.println("Press 1 to retry");
            int a = ownerSignupScan.nextInt();
            if (a == 1) {
                return 0;

            }
        }
        return 0;
    }

    public static int UserLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter Username");
        String username = scan.nextLine();
        System.out.println("Enter Password");
        String password = scan.nextLine();
        customerUserName = username;
        customerPassword = password;
        storeUsername = username;
        try {
            File insert = new File("user.txt");
            BufferedReader userCompare = new BufferedReader(new FileReader(insert));

            String strLine, tempName, tempPass;
            Boolean hasLine = false;

            while ((strLine = userCompare.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempName = st1.nextToken();
                    tempPass = st1.nextToken();

                    if (tempName.equals(username) && tempPass.equals(password)) {
                        System.out.println("User Login Successful");

                        try {
                            File gettingMessage = new File("user messages.txt");
                            BufferedReader umessage = new BufferedReader(new FileReader(gettingMessage));

                            String strLine1, sender1, receiver1, message1;
                            Boolean hasLine1 = false;

                            while ((strLine1 = umessage.readLine()) != null) {
                                StringTokenizer st11 = new StringTokenizer(strLine1, ",");
                                while (st11.hasMoreTokens()) {
                                    sender1 = st11.nextToken();
                                    // System.out.println("sender--"+sender1);
                                    receiver1 = st11.nextToken();
                                    // System.out.println("receiver--"+receiver1);
                                    message1 = st11.nextToken();

                                    if (username.equals(receiver1)) {
                                        System.out.println(sender1 + " sent you a message ");
                                        System.out.println("message-> " + message1);
                                    }

                                }
                            }
                            System.out.println("press any key to continue");
                            scan.nextLine();

                        } catch (Exception e) {
                            e.printStackTrace();

                        }

                        // ************************************************

                        return 1;
                    }

                }
            }

            userCompare.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return 0;

    }

    public static int adminLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter Username");
        String username = scan.nextLine();
        System.out.println("Enter Password");
        String password = scan.nextLine();
        adminUserName = username;
        adminPassword = password;

        try {
            File insert = new File("admin.txt");
            BufferedReader adminCompare = new BufferedReader(new FileReader(insert));

            String strLine, tempName, tempPass;
            Boolean hasLine = false;

            while ((strLine = adminCompare.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempName = st1.nextToken();
                    tempPass = st1.nextToken();

                    if (tempName.equals(username) && tempPass.equals(password)) {
                        System.out.println("Admin Login Successful");
                        return 1;
                    }

                }
            }

            adminCompare.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return 0;
    }

    static String abc = null;

    public static int OwnerLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Enter Username");
        String username = scan.nextLine();
        System.out.println("Enter Password");
        String password = scan.nextLine();
        ownerUserName = username;
        ownerPassword = password;

        try {
            File insert = new File("owner.txt");
            BufferedReader ownerCompare = new BufferedReader(new FileReader(insert));

            String strLine, tempName, tempPass;
            Boolean hasLine = false;

            while ((strLine = ownerCompare.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempName = st1.nextToken();
                    tempPass = st1.nextToken();

                    if (tempName.equals(username) && tempPass.equals(password)) {
                        abc = username;
                        System.out.println("Owner Login Successful");
                        return 1;
                    }

                }
            }

            ownerCompare.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return 0;

    }

    public static String ownerName() {
        return abc;
    }

    public static String retunuser() {
        return storeUsername;
    }
    
    public static void sendUserMessage(String tempUserName) 
  {
    Scanner userMessageScanner = new Scanner(System.in);
    System.out.println("please enter name of user you want to send message");
    String directedUser = userMessageScanner.nextLine();
    System.out.println("please enter message");
    String userMessage = userMessageScanner.nextLine();

    try (FileWriter fw = new FileWriter("user messages.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
      out.println(tempUserName + "," + directedUser + "," + userMessage);
      out.close();
    } catch (IOException e) {
    }

    System.out.println("message sent to user");
    System.out.println("press any key to go to User main menu");
    Scanner sc2 = new Scanner(System.in);
    sc2.nextLine();
  }

  public static void sendMessageToAdmin(String tempUserName) {

    Scanner adminMessageScanner = new Scanner(System.in);
    System.out.println("please enter message");
    String adminMessage = adminMessageScanner.nextLine();

    try (FileWriter fw = new FileWriter("admin messages.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw)) {
      out.println(tempUserName + "," + adminMessage);
      out.close();
    } 
    catch (IOException e) 
    {
    }
    System.out.println("message sent to admin");
    System.out.println("press any key to go to user main menu");
    Scanner sc2 = new Scanner(System.in);
    sc2.nextLine();

  }


}
