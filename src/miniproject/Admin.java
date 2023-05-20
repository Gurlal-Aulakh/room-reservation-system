
package miniproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Admin {

    private String sender, receiver, message;

    public static int getMessage() {

        try {
            File gettingMessage = new File("admin messages.txt");
            BufferedReader umessage = new BufferedReader(new FileReader(gettingMessage));

            String strLine1, sender1, receiver1, message1;
            Boolean hasLine1 = false;

            while ((strLine1 = umessage.readLine()) != null) {
                StringTokenizer st11 = new StringTokenizer(strLine1, ",");
                while (st11.hasMoreTokens()) {
                    sender1 = st11.nextToken();
                    message1 = st11.nextToken();
                    System.out.println("Sender's Name- " + sender1);
                    System.out.println("message-> " + message1);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go to admin main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();
        return 1;

    }

    public static int blockUser() {

        try {
            File insert1234 = new File("user.txt");
            BufferedReader br1234 = new BufferedReader(new FileReader(insert1234));
            String line = "a";
            String[] lineArr;
            String strLine, tempusername = " ", temppassword;

            Boolean hasLine = false;

            int i = 1;
            while ((strLine = br1234.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempusername = st1.nextToken();
                    temppassword = st1.nextToken();

                    System.out.println("Username - " + tempusername);

                }

            }

            br1234.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("please enter the username you want to block");
        Scanner sc21 = new Scanner(System.in);
        String name = sc21.nextLine();

        ArrayList<String> tempArray12 = new ArrayList<>();
        try {

            File insert = new File("user.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            String strLine, tempusername = " ", temppassword;
          
            while ((strLine = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempusername = st1.nextToken();
                    temppassword = st1.nextToken();

                    if (tempusername.equals(name)) {
                    } else {

                        tempArray12.add(strLine);
                    }

                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr1 = new PrintWriter("user.txt");
            for (String str : tempArray12) {
                pr1.println(str);
            }

            System.out.println("User is Blocked");

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("press any key to go to admin main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();
        return 1;

    }

    public static int blockOwner() {

        try {
            File insert1234 = new File("owner.txt");
            BufferedReader br1234 = new BufferedReader(new FileReader(insert1234));
            String line = "a";
            String[] lineArr;
            String strLine, tempusername = " ", temppassword;

            Boolean hasLine = false;

            int i = 1;
            while ((strLine = br1234.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempusername = st1.nextToken();
                    temppassword = st1.nextToken();

                    System.out.println("Owner's name - " + tempusername);

                }

            }

            br1234.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("please enter the owner's name you want to block");
        Scanner sc21 = new Scanner(System.in);
        String name = sc21.nextLine();

        ArrayList<String> tempArray12 = new ArrayList<>();
        try {

            File insert = new File("owner.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            String strLine, tempusername = " ", temppassword;
            // for booked seats

            //// for booked seats

            while ((strLine = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempusername = st1.nextToken();
                    temppassword = st1.nextToken();

                    if (tempusername.equals(name)) {
                    } else {

                        tempArray12.add(strLine);
                    }

                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr1 = new PrintWriter("owner.txt");
            for (String str : tempArray12) {
                pr1.println(str);
            }

            System.out.println("owner is Blocked");

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("press any key to go to admin main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();
        return 1;

    }

    public static int bookedSeats() {
        try {
            File insert1234 = new File("bookedseats.txt");
            BufferedReader br1234 = new BufferedReader(new FileReader(insert1234));
            String line = "a";
            String[] lineArr;
            String strLine, tempownername, tempusername = " ", tempseatno, tempava, temprice = " ", temproomtype,
                    tempmonth;
            String tempdate, temptime;
            Boolean hasLine = false;

            while ((strLine = br1234.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    temproomtype = st1.nextToken();
                    tempownername = st1.nextToken();
                    tempusername = st1.nextToken();
                    tempseatno = st1.nextToken();
                    tempava = st1.nextToken();
                    temprice = st1.nextToken();
                    tempmonth = st1.nextToken();
                    tempdate = st1.nextToken();
                    temptime = st1.nextToken();

                    System.out.println(tempownername + "'s " + temproomtype + "  ||   booked by " + tempusername
                            + " ||  seat number is " + tempseatno + "  || Price is  $" + temprice + "  ||  date is "
                            + tempmonth + "/" +
                            tempdate + "  ||  Time is  " + temptime);

                }

            }
            br1234.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go admin main menu");
        Scanner sc2345 = new Scanner(System.in);
        sc2345.nextLine();
        return 1;
    }

    public static int resoldSeats() {
        try {
            File insert1234 = new File("resell.txt");
            BufferedReader br1234 = new BufferedReader(new FileReader(insert1234));
            String line = "a";
            String[] lineArr;
            String strLine, tempownername, tempusername = " ", tempseatno, tempava, temprice = " ", temproomtype,
                    tempmonth;
            String tempdate, temptime;
            Boolean hasLine = false;

            while ((strLine = br1234.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    temproomtype = st1.nextToken();
                    tempownername = st1.nextToken();
                    tempusername = st1.nextToken();
                    tempseatno = st1.nextToken();
                    tempava = st1.nextToken();
                    temprice = st1.nextToken();
                    tempmonth = st1.nextToken();
                    tempdate = st1.nextToken();
                    temptime = st1.nextToken();

                    // System.out.println(tempownername+"'s " +temproomtype+" seat number is--
                    // "+tempseatno+", Price is -- $"+temprice+" date is-- " +tempmonth+"/"+
                    // tempdate+" Time is-- "+temptime);

                    System.out.println(tempownername + "'s " + temproomtype + "  ||   booked by " + tempusername
                            + "  ||  seat number is " + tempseatno + "  || Discounted Price is  $" + temprice
                            + "  ||  date is " + tempmonth + "/" +
                            tempdate + "  ||  Time is  " + temptime);

                }

            }
            br1234.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go admin main menu");
        Scanner sc2345 = new Scanner(System.in);
        sc2345.nextLine();
        return 1;
    }

}
