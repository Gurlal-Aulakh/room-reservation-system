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
import static miniproject.Login_Info.newPassword;
import static miniproject.Login_Info.newUserName;

public class BussinessOwner {
    static String roomTypeForCancel = " ";
    static String BSUser;
    static int l;
    static String user123;
    static int locationType;
     static int roomSide;

    static public void getLocationInfo(int a, String BSUser) {
        Scanner scan4 = new Scanner(System.in);
        System.out.println("What is the side of the room");
        int side = scan4.nextInt();
        l = side;
        String f;
        f = "hdj";
        System.out.println("What is the Regular Price of the seat");
        double price = scan4.nextDouble();
        String roomType;
        if (a == 1) {
            roomType = "cinema";
        } else if (a == 2) {
            roomType = "restaurant";
        } else if (a == 3) {
            roomType = "airplane";
        } else {
            roomType = "conferance room";
        }
         roomSide=side;
        // createLocation(a,side,price);
        
//        Room room1 = new Room(roomType, side, price, BSUser);
//        room1.createLocation(roomType, side, price);
//        room1.setPrice(side, price);
           createLocation(roomType, side, price);
           setPrice(side, price);
    }
        public double seatPrice[][] = new double[roomSide][roomSide];
    public static void setPrice(int side, double price) {
        double seatPrice[][] = new double[side][side];
    }

    public static void createLocation(String name, int side, double price) {
        int[][] roomArr = new int[side][side];
        System.out.println(name + " created Succesfully");
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                roomArr[i][j] = 1;
            }
        }
        double seatPrice[][] = new double[side][side];
        if (side % 2 == 1) {
            for (int i = 0; i < side; i++) {
                for (int j = 0; j < side; j++) {
                    if (i == 0) {
                        seatPrice[i][j] = 2 * price;
                    } else if (i == (side - 1)) {
                        seatPrice[i][j] = 0.75 * price;
                    } else if (j == side / 2 && i != 0 && i != side) {
                        seatPrice[i][j] = 1.25 * price;
                    } else {
                        seatPrice[i][j] = price;
                    }
                }
            }
        }
        if (side % 2 == 0) {
            for (int i = 0; i < side; i++) {
                for (int j = 0; j < side; j++) {
                    if (i == 0) {
                        seatPrice[i][j] = 2 * price;
                    } else if (i == (side - 1)) {
                        seatPrice[i][j] = 0.75 * price;
                    } else if (j == side / 2 && j == (side - 1) / 2 && i != 0 && i != side) {
                        seatPrice[i][j] = 1.25 * price;
                    } else {
                        seatPrice[i][j] = price;
                    }
                }
            }
        }
        String filepath = name + ".txt";
        try (FileWriter fw = new FileWriter(filepath, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            int count = 1;
            for (int i = 0; i < side; i++) {
                for (int j = 0; j < side; j++) {
                    String seatAvailability;
                    if (roomArr[i][j] == 1) {
                        seatAvailability = "Available";
                    } else {
                        seatAvailability = "Not Available";
                    }
                    out.println(BSUser + "," + count + "," + seatAvailability + "," + seatPrice[i][j]);
                    count++;
                }
            }

        } catch (IOException e) {

        }

    }
 
    public static void userSeatBooking(int roomType, String user1234) {
        user123 = user1234;
        if (roomType == 1) {
            locationType = roomType;
            try {
                File insert = new File("cinema.txt");
                BufferedReader availableOwnerCinemaseats = new BufferedReader(new FileReader(insert));

                String strLine, ownerName, seatNumber, availiablity, price;
                String prevName = "jjljbhvjbjvhnjvhgbhbvgfhbvhghnvhgfhg";
                Boolean hasLine = false;

                while ((strLine = availableOwnerCinemaseats.readLine()) != null) {
                    StringTokenizer st1 = new StringTokenizer(strLine, ",");
                    while (st1.hasMoreTokens()) {
                        ownerName = st1.nextToken();
                        seatNumber = st1.nextToken();
                        availiablity = st1.nextToken();
                        price = st1.nextToken();

                        if (!(ownerName.equals(prevName)) && availiablity.equals("Available")) {
                            System.out.println("---------------------------------------\n");
                            System.out.println(ownerName + "'s Cinema\n");
                            System.out.println("---------------------------------------\n");
                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");

                        } else if ((ownerName.equals(prevName)) && availiablity.equals("Available")) {

                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");
                        }

                        prevName = ownerName;

                    }
                }

                availableOwnerCinemaseats.close();
            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        if (roomType == 2) {
            locationType = roomType;

        }

        if (roomType == 3) {
            locationType = roomType;
            try {
                File insert = new File("restaurant.txt");
                BufferedReader availableOwnerRestaurantseats = new BufferedReader(new FileReader(insert));

                String strLine, ownerName, seatNumber, availiablity, price;
                String prevName = "jjljbhvjbjvhnjvhgbhbvgfhbvhghnvhgfhg";
                Boolean hasLine = false;

                while ((strLine = availableOwnerRestaurantseats.readLine()) != null) {
                    StringTokenizer st1 = new StringTokenizer(strLine, ",");
                    while (st1.hasMoreTokens()) {
                        ownerName = st1.nextToken();
                        seatNumber = st1.nextToken();
                        availiablity = st1.nextToken();
                        price = st1.nextToken();

                        if (!(ownerName.equals(prevName)) && availiablity.equals("Available")) {
                            System.out.println("---------------------------------------\n");
                            System.out.println(ownerName + "'s Restaurant\n");
                            System.out.println("---------------------------------------\n");
                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");

                        } else if ((ownerName.equals(prevName)) && availiablity.equals("Available")) {

                            System.out
                                    .println("seat No." + seatNumber + " is " + availiablity + "      $" + price + "\n");
                        }

                        prevName = ownerName;

                    }
                }

                availableOwnerRestaurantseats.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        if (roomType == 4) {
            locationType = roomType;

        }

        if (roomType == 5) {
            locationType = roomType;
            try {
                File insert = new File("airplane.txt");
                BufferedReader availableOwnerAirplaneseats = new BufferedReader(new FileReader(insert));

                String strLine, ownerName, seatNumber, availiablity, price;
                String prevName = "jjljbhvjbjvhnjvhgbhbvgfhbvhghnvhgfhg";
                Boolean hasLine = false;

                while ((strLine = availableOwnerAirplaneseats.readLine()) != null) {
                    StringTokenizer st1 = new StringTokenizer(strLine, ",");
                    while (st1.hasMoreTokens()) {
                        ownerName = st1.nextToken();
                        seatNumber = st1.nextToken();
                        availiablity = st1.nextToken();
                        price = st1.nextToken();

                        if (!(ownerName.equals(prevName)) && availiablity.equals("Available")) {
                            System.out.println("---------------------------------------\n");
                            System.out.println(ownerName + "'s Airplane\n");
                            System.out.println("---------------------------------------\n");
                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");

                        } else if ((ownerName.equals(prevName)) && availiablity.equals("Available")) {

                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");
                        }

                        prevName = ownerName;

                    }
                }

                availableOwnerAirplaneseats.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

        if (roomType == 6) {
            locationType = roomType;
        }

        if (roomType == 7) {
            locationType = roomType;
            try {
                File insert = new File("conferance room.txt");
                BufferedReader availableOwnerConferenceRoomseats = new BufferedReader(new FileReader(insert));

                String strLine, ownerName, seatNumber, availiablity, price;
                String prevName = "jjljbhvjbjvhnjvhgbhbvgfhbvhghnvhgfhg";
                Boolean hasLine = false;

                while ((strLine = availableOwnerConferenceRoomseats.readLine()) != null) {
                    StringTokenizer st1 = new StringTokenizer(strLine, ",");
                    while (st1.hasMoreTokens()) {
                        ownerName = st1.nextToken();
                        seatNumber = st1.nextToken();
                        availiablity = st1.nextToken();
                        price = st1.nextToken();

                        if (!(ownerName.equals(prevName)) && availiablity.equals("Available")) {
                            System.out.println("---------------------------------------\n");
                            System.out.println(ownerName + "'s conferance room\n");
                            System.out.println("---------------------------------------\n");
                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");

                        } else if ((ownerName.equals(prevName)) && availiablity.equals("Available")) {

                            System.out.println(
                                    "seat No. " + seatNumber + " is " + availiablity + "      $" + price + "\n");
                        }

                        prevName = ownerName;

                    }
                }

                availableOwnerConferenceRoomseats.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        if (roomType == 8) {
            locationType = roomType;
        }
        if (roomType == 9) {
            System.out.println("Cancel Room");

        }
        if (roomType == 10) {

        }
        System.out.println("Enter the Room Owner's name");
        Scanner scanSeatOwner = new Scanner(System.in);
        String cinemaName = scanSeatOwner.nextLine();
        System.out.println("Enter the Seat Number");
        String seatSelected = scanSeatOwner.nextLine();
        // System.out.println(cinemaName + " " + seatSelected);
        System.out.println("Enter month's name");
        String month = scanSeatOwner.nextLine();
        System.out.println("Enter date");
        String date = scanSeatOwner.nextLine();
        System.out.println("Enter the start timings in 24 hours format");

        String starttime = scanSeatOwner.nextLine();
        int abcd = checkBookedSeats(cinemaName, seatSelected, month, date, starttime);

        // ***** System.out.println(abcd);
        if (abcd == 1) {
            System.out.println("User had already booked at this timeslot");
            System.out.println("Enter different time");
            String temptime = scanSeatOwner.nextLine();
            starttime = temptime;
        }
        editSeat(cinemaName, seatSelected, month, date, starttime);

        System.out.println("press any key to go to user main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();
    }

    public static void editSeat(String cinemaName, String seatSelected, String month, String date, String starttime) {
        ArrayList<String> tempArray = new ArrayList<>();
        String roomFilePath = "";

        try {
            if (locationType == 1) {
                roomFilePath = "cinema";
            } else if (locationType == 3) {
                roomFilePath = "restaurant";
            } else if (locationType == 5) {
                roomFilePath = "airplane";
            } else if (locationType == 7) {
                roomFilePath = "conferance room";
            }
            File insert = new File(roomFilePath + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            // for booked seats
            File insert1 = new File("bookedseats.txt");
            BufferedReader br1 = new BufferedReader(new FileReader(insert1));
            // for booked seats
            String strLine, tempname, tempseatno, tempava, tempprice;
            Boolean hasLine = false;

            while ((strLine = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {
                    tempname = st1.nextToken();
                    tempseatno = st1.nextToken();
                    tempava = st1.nextToken();
                    tempprice = st1.nextToken();

                    if (tempname.equals(cinemaName) && tempseatno.equals(seatSelected)) {
                        hasLine = true;

                        // ***** System.out.println(seatSelected);
                        tempArray.add(tempname + "," + tempseatno + "," + "Not Available" + "," + tempprice);
                        // writing a different file
                        try {
                            // PrintWriter pr1=new PrintWriter("bookedseats.txt");
                            FileWriter fw12 = new FileWriter("bookedseats.txt", true);
                            BufferedWriter bw12 = new BufferedWriter(fw12);
                            PrintWriter out1 = new PrintWriter(bw12);

                            out1.println(roomFilePath + "," + tempname + "," + user123 + "," + tempseatno + ","
                                    + "Not Available" + "," + tempprice + "," + month + "," + date + "," + starttime);

                            out1.flush();
                            out1.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else {

                        tempArray.add(strLine);
                    }

                }
            }
            System.out.println("Seat booked succesfully");

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr = new PrintWriter(roomFilePath + ".txt");
            for (String str : tempArray) {
                pr.println(str);
            }

            pr.flush();
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int bussinessOwnerDisplay(String user) {
        System.out.println("type 1 for creating cinema");
        System.out.println("type 2 for creating restaurant");
        System.out.println("type 3 for creating airplane");
        System.out.println("type 4 for creating conference room");
        System.out.println("type 5 for Logout");
        BSUser = user;
        Scanner scan = new Scanner(System.in);
        int locationResponse = scan.nextInt();
        if (locationResponse == 5) {
            return 1;
        } else {
            getLocationInfo(locationResponse, BSUser);
            System.out.println("press any key to go to Owner's main menu");
            Scanner sc2 = new Scanner(System.in);
            sc2.nextLine();
            return 0;
        }

    }

    public static int checkBookedSeats(String cinemaName1, String seatSelected1, String month1, String date1,
            String starttime1) {
        try {

            String line = "a";
            // String[] lineArr;
            // for booked seats
            File insert2 = new File("bookedseats.txt");
            BufferedReader br2 = new BufferedReader(new FileReader(insert2));
            // for booked seats
            String strLine1, temproomType, tempusername1, tempownername1, tempseatno1, tempava1, tempprice1, tempmonth1,
                    tempdate1, tempstarttime1;
            Boolean hasLine = false;
            while ((strLine1 = br2.readLine()) != null) {

                StringTokenizer st1 = new StringTokenizer(strLine1, ",");
                while (st1.hasMoreTokens()) {
                    temproomType = st1.nextToken();
                    tempownername1 = st1.nextToken();
                    tempusername1 = st1.nextToken();
                    tempseatno1 = st1.nextToken();
                    tempava1 = st1.nextToken();
                    tempprice1 = st1.nextToken();
                    tempmonth1 = st1.nextToken();
                    tempdate1 = st1.nextToken();
                    tempstarttime1 = st1.nextToken();
                    // System.out.println(tempusername1);
                    // System.out.println(tempmonth1);
                    // System.out.println(tempdate1);
                    // System.out.println(tempstarttime1);

                    if (tempusername1.equals(user123) && tempmonth1.equals(month1) && tempdate1.equals(date1)
                            && tempstarttime1.equals(starttime1)) {

                        return 1;
                    }

                }
            }

            return 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void cancelSeat(String tempUser) {

        ArrayList<String> tempArray = new ArrayList<>();

        try {
            File insert = new File("bookedseats.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            String strLine, tempownername, tempusername, tempseatno, tempava, temprice, temproomtype, tempmonth;
            String tempdate, temptime;
            Boolean hasLine = false;

            int i = 1;
            while ((strLine = br.readLine()) != null) {
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

                    if (tempusername.equals(tempUser)) {
                        hasLine = true;

                        // tempArray.add(i++ +","+tempownername+","+tempusername
                        // +","+ tempseatno+","+tempava +","+temprice+"," +tempmonth
                        // +","+tempdate+","+temptime);
                        // writing a different file
                        System.out.println(tempownername + "'s " + temproomtype + "  seat number is-- " + tempseatno
                                + ", Price is -- $" + temprice + "  date is-- " + tempmonth + "/" +
                                tempdate + "  Time is--  " + temptime);

                    }

                }
            }
            if (hasLine == true) {
                System.out.println("Enter the type of room you want to cancel");
                Scanner canscanner = new Scanner(System.in);
                String roomtype = canscanner.nextLine();
                System.out.println("Enter the name of room owner");
                String ownertype = canscanner.nextLine();
                System.out.println("Enter the seat you want to cancel");
                String seatno = canscanner.nextLine();

                System.out.println("Selected seat is cancelled");
                // System.out.println(roomtype+","+ownertype+","+seatno);
                updateByUserAction(seatno, roomtype, tempUser, ownertype);
                br.close();
            } else {
                System.out.println("No Seats booked");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go to user main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();

    }

    public static void updateByUserAction(String seatNumber, String roomType, String userName, String OwnerName) {
        ArrayList<String> tempArray121 = new ArrayList<>();
        try {

            File insert = new File("bookedseats.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            // for booked seats

            //// for booked seats
            String strLine, tempownername, tempusername, tempseatno, tempava, temprice, temproomtype, tempmonth;
            String tempdate, temptime;

            while ((strLine = br.readLine()) != null) {
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

                    if (temproomtype.equals(roomType) && tempownername.equals(OwnerName)
                            && tempusername.equals(userName) && tempseatno.equals(seatNumber)) {

                        // writing a different file
                        // try
                        // {
                        //// PrintWriter pr1=new PrintWriter("bookedseats.txt");
                        // FileWriter fw12 = new FileWriter("bookedseats.txt", true);
                        // BufferedWriter bw12 = new BufferedWriter(fw12);
                        // PrintWriter out1 = new PrintWriter(bw12);
                        //
                        // out1.println(roomFilePath+","+tempname + "," +user123+"," + tempseatno + ","
                        // + "Not Available" +","+tempprice+ "," + month + ","+ date+ ","+ starttime);
                        //
                        //
                        // out1.flush();
                        // out1.close();
                        // }
                        // catch(Exception e)
                        // {
                        // e.printStackTrace();
                        // }

                    } else {

                        tempArray121.add(strLine);
                    }

                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr1 = new PrintWriter("bookedseats.txt");
            for (String str : tempArray121) {
                pr1.println(str);
            }

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // ****************************************************

        ArrayList<String> tempArray1211 = new ArrayList<>();
        try {

            File insert = new File(roomType + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            // for booked seats

            //// for booked seats
            String strLine, tempownername, tempseatno, tempava, temprice;

            while ((strLine = br.readLine()) != null) {
                StringTokenizer st1 = new StringTokenizer(strLine, ",");
                while (st1.hasMoreTokens()) {

                    tempownername = st1.nextToken();

                    tempseatno = st1.nextToken();
                    tempava = st1.nextToken();
                    temprice = st1.nextToken();

                    if (tempownername.equals(OwnerName) && tempseatno.equals(seatNumber)) {
                        tempArray1211.add(tempownername + "," + tempseatno + "," + "Available," + temprice);

                        // writing a different file
                        // try
                        // {
                        //// PrintWriter pr1=new PrintWriter("bookedseats.txt");
                        // FileWriter fw12 = new FileWriter("bookedseats.txt", true);
                        // BufferedWriter bw12 = new BufferedWriter(fw12);
                        // PrintWriter out1 = new PrintWriter(bw12);
                        //

                        // out1.println(roomFilePath+","+tempname + "," +user123+"," + tempseatno + ","
                        // + "Not Available" +","+tempprice+ "," + month + ","+ date+ ","+ starttime);
                        //
                        //
                        // out1.flush();
                        // out1.close();
                        // }
                        // catch(Exception e)
                        // {
                        // e.printStackTrace();
                        // }

                    } else {

                        tempArray1211.add(strLine);
                    }

                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr1 = new PrintWriter(roomType + ".txt");
            for (String str : tempArray1211) {
                pr1.println(str);
            }

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resell(String tempUser) {
        // ArrayList<String> tempArray = new ArrayList<> ();

        try {
            File insertResell = new File("bookedseats.txt");
            BufferedReader br = new BufferedReader(new FileReader(insertResell));
            String line = "a";
            String[] lineArr;
            String strLine, tempownername, tempusername, tempseatno, tempava, temprice, temproomtype, tempmonth;
            String tempdate, temptime;
            Boolean hasLine = false;

            while ((strLine = br.readLine()) != null) {
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

                    if (tempusername.equals(tempUser)) {
                        hasLine = true;

                        // tempArray.add(i++ +","+tempownername+","+tempusername
                        // +","+ tempseatno+","+tempava +","+temprice+"," +tempmonth
                        // +","+tempdate+","+temptime);
                        // writing a different file
                        System.out.println(tempownername + "'s " + temproomtype + "  seat number is-- " + tempseatno
                                + ", Price is -- $" + temprice + "  date is-- " + tempmonth + "/" +
                                tempdate + "  Time is--  " + temptime);

                    }

                }
            }
            if (hasLine == true) {
                System.out.println("Enter the type of room you want to resell");
                Scanner canscanner = new Scanner(System.in);
                String roomtype = canscanner.nextLine();
                System.out.println("Enter the name of room owner");
                String ownertype = canscanner.nextLine();
                System.out.println("Enter the seat you want to resell");
                String seatno = canscanner.nextLine();
                System.out.println("Enter the discounted price of the seat you want to resell");
                String discountedPrice = canscanner.nextLine();
                System.out.println("Seat added to Reseller list");
                // s
                // System.out.println(roomtype+","+ownertype+","+seatno);
                updateByUserResell(seatno, roomtype, tempUser, ownertype, discountedPrice);
                br.close();
            } else {
                System.out.println("No seats Booked");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go to user main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();

    }

    public static void updateByUserResell(String seatNumber, String roomType, String userName, String OwnerName,
            String discountedPrice) {
        ArrayList<String> tempArray121 = new ArrayList<>();
        try {

            File insert = new File("bookedseats.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            // for booked seats

            //// for booked seats
            String strLine, tempownername, tempusername, tempseatno, tempava, temprice, temproomtype, tempmonth;
            String tempdate, temptime;

            while ((strLine = br.readLine()) != null) {
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

                    if (temproomtype.equals(roomType) && tempownername.equals(OwnerName)
                            && tempusername.equals(userName) && tempseatno.equals(seatNumber)) {
                        try {
                            FileWriter fw123 = new FileWriter("resell.txt", true);
                            BufferedWriter bw123 = new BufferedWriter(fw123);
                            PrintWriter out12 = new PrintWriter(bw123);

                            out12.println(temproomtype + "," + tempownername + "," + tempusername + "," + tempseatno
                                    + "," + "Available" + "," + discountedPrice + "," + tempmonth + "," + tempdate + ","
                                    + temptime);

                            out12.flush();
                            out12.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {

                        tempArray121.add(strLine);
                    }

                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        try {
            PrintWriter pr1 = new PrintWriter("bookedseats.txt");
            for (String str : tempArray121) {
                pr1.println(str);
            }

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void buyResoldSeats(String roomType, String userName) {
        try {
            File insert1234 = new File("resell.txt");
            BufferedReader br1234 = new BufferedReader(new FileReader(insert1234));
            String line = "a";
            String[] lineArr;
            String strLine, tempownername, tempusername = " ", tempseatno, tempava, temprice = " ", temproomtype,
                    tempmonth;
            String tempdate, temptime;
            Boolean hasLine = false;

            int i = 1;
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

                    if (roomType.equals(temproomtype) && !(tempusername.equals(userName))) {
                        hasLine = true;

                        System.out.println(tempownername + "'s " + temproomtype + "  seat number is-- " + tempseatno
                                + ", Discounted Price is -- $" + temprice + "  date is-- " + tempmonth + "/" +
                                tempdate + "  Time is--  " + temptime);

                    }

                }
            }

            if (hasLine == true) {
                System.out.println("Enter the type of room you want to buy");
                Scanner canscanner = new Scanner(System.in);
                String roomtype = canscanner.nextLine();
                System.out.println("Enter the name of room owner");
                String ownertype = canscanner.nextLine();
                System.out.println("Enter the seat you want to buy");
                String seatno = canscanner.nextLine();

                System.out.println(roomtype + "," + ownertype + "," + seatno);
                updateResoldSeats(seatno, roomtype, tempusername, ownertype, temprice);
                br1234.close();
            } else {
                System.out.println("No resellers currently available");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        System.out.println("press any key to go to user main menu");
        Scanner sc2 = new Scanner(System.in);
        sc2.nextLine();
    }

    public static void updateResoldSeats(String seatNumber, String roomType, String userName, String OwnerName,
            String discountedPrice) {
        ArrayList<String> tempArray12 = new ArrayList<>();
        try {

            File insert = new File("resell.txt");
            BufferedReader br = new BufferedReader(new FileReader(insert));
            String line = "a";
            String[] lineArr;
            // for booked seats

            //// for booked seats
            String strLine, tempownername, tempusername, tempseatno, tempava, temprice, temproomtype, tempmonth;
            String tempdate, temptime;

            while ((strLine = br.readLine()) != null) {
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

                    if (temproomtype.equals(roomType) && tempownername.equals(OwnerName)
                            && tempusername.equals(userName) && tempseatno.equals(seatNumber)) {
                        try {
                            FileWriter fw123 = new FileWriter("bookedseats.txt", true);
                            BufferedWriter bw123 = new BufferedWriter(fw123);
                            PrintWriter out12 = new PrintWriter(bw123);

                            out12.println(temproomtype + "," + tempownername + "," + tempusername + "," + tempseatno
                                    + "," + "Not Available" + "," + discountedPrice + "," + tempmonth + "," + tempdate
                                    + "," + temptime);

                            out12.flush();
                            out12.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

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
            PrintWriter pr1 = new PrintWriter("resell.txt");
            for (String str : tempArray12) {
                pr1.println(str);
            }

            pr1.flush();
            pr1.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
