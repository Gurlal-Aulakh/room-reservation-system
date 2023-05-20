package miniproject;

import java.util.*;
//import miniproject.*;

public class MiniProject {

    public static void main(String[] args) {
        Boolean adminLoginFlag = false;
        Scanner scan = new Scanner(System.in);
        showInitialDisplay();

    }

    static private Boolean adminLoginFlag = false;
    static private Boolean userLoginFlag = false;
    static private Boolean ownerLoginFlag = false;
    static private int adminloginStatus = 66;
    static private int userloginStatus = 66;
    static private int ownerloginStatus = 66;
    static private int userResponse = 66;
    static private int OwnerResponse = 66;
    static private String tempUserName;

    static void showInitialDisplay() {
        int response = Display.initialDisplay();
        initialResponse(response);
    }

    static void initialResponse(int a) {
        if (a == 1) {
            if (userLoginFlag == false) {
                userResponse = Display.loginSignup();
            }
            // userResponse=Display.loginSignup();
            if (userResponse == 1) {
                if (userLoginFlag == false) {
                    userloginStatus = Login_Info.UserLogin();
                }
                // int userloginStatus=Login_Info.UserLogin();
                if (userloginStatus == 1) {
                    // System.out.println("User Login Successful");
                    String user123 = Login_Info.retunuser();
                    tempUserName = user123;
                    // System.out.println(user123);
                    int roomType1 = Display.userDisplay();
                    if (roomType1 == 9) {
                        BussinessOwner.cancelSeat(tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);

                    } else if (roomType1 == 10) {
                        BussinessOwner.resell(tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 11) {
                        Login_Info.sendUserMessage(tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 12) {
                        Login_Info.sendMessageToAdmin(tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 13) {
                        userLoginFlag = false;
                        userloginStatus = 66;
                        showInitialDisplay();

                    } else if (roomType1 == 2) {
                        BussinessOwner.buyResoldSeats("cinema", tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 4) {
                        BussinessOwner.buyResoldSeats("restaurant", tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 6) {
                        BussinessOwner.buyResoldSeats("airplane", tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else if (roomType1 == 8) {
                        BussinessOwner.buyResoldSeats("conferance room", tempUserName);
                        userLoginFlag = true;
                        initialResponse(1);
                    } else {
                        BussinessOwner.userSeatBooking(roomType1, user123);
                        userLoginFlag = true;
                        initialResponse(1);
                    }
                }
                if (userloginStatus == 0) {
                    System.out.println("Login Unsuccessful, please try again");
                    initialResponse(1);

                }
            }

            if (userResponse == 2) {
                int userSignupStatus = Login_Info.userSignup();
                if (userSignupStatus == 1) {
                    initialResponse(1);
                }

                if (userSignupStatus == 0) {
                    initialResponse(1);
                }
            }

            if (userResponse == 3) {
                userLoginFlag = false;
                userloginStatus = 66;
                showInitialDisplay();
            }

        } else if (a == 2) {

            if (ownerLoginFlag == false) {
                OwnerResponse = Display.loginSignup();
            }

            if (OwnerResponse == 1) {
                if (ownerLoginFlag == false) {
                    ownerloginStatus = Login_Info.OwnerLogin();
                }

                if (ownerloginStatus == 1) {
                    String owner = Login_Info.ownerName();
                    int out = BussinessOwner.bussinessOwnerDisplay(owner);
                    if (out == 0) {
                        ownerLoginFlag = true;
                        initialResponse(2);
                    } else if (out == 1)
                        ownerLoginFlag = false;
                    ownerloginStatus = 66;
                    showInitialDisplay();
                }

                if (ownerloginStatus == 0) {
                    System.out.println("Login Unsuccessful, please try again");
                    initialResponse(2);

                }

            }

            if (OwnerResponse == 2) {
                int ownerSignupStatus = Login_Info.ownerSignup();
                if (ownerSignupStatus == 1) {
                    initialResponse(2);
                }

                if (ownerSignupStatus == 0) {
                    initialResponse(2);
                }
            }

            if (OwnerResponse == 3) {
                ownerLoginFlag = false;
                ownerloginStatus = 66;
                showInitialDisplay();
            }

        }

        else if (a == 3) {
            // int adminloginStatus=66;
            if (adminLoginFlag == false) {
                adminloginStatus = Login_Info.adminLogin();
            }
            // int adminloginStatus=Login_Info.adminLogin();
            if (adminloginStatus == 1) {
                // System.out.println("Admin Login Successful");
                int adminResponse = Display.adminDisplay();
                if (adminResponse == 1) {
                    int r = Admin.getMessage();
                    if (r == 1) {
                        adminLoginFlag = true;
                        initialResponse(3);
                    }
                }
                if (adminResponse == 2) {
                    int r = Admin.blockUser();
                    if (r == 1) {
                        adminLoginFlag = true;
                        initialResponse(3);
                    }
                }
                if (adminResponse == 3) {
                    int r = Admin.blockOwner();
                    if (r == 1) {
                        adminLoginFlag = true;
                        initialResponse(3);
                    }
                }
                if (adminResponse == 4) {
                    int r = Admin.bookedSeats();
                    if (r == 1) {
                        adminLoginFlag = true;
                        initialResponse(3);
                    }
                }
                if (adminResponse == 5) {
                    int r = Admin.resoldSeats();
                    if (r == 1) {
                        adminLoginFlag = true;
                        initialResponse(3);

                    }
                }
                if (adminResponse == 6) {

                    adminLoginFlag = false;
                    adminloginStatus = 66;
                    showInitialDisplay();

                }
                if (adminloginStatus == 0) {
                    System.out.println("Login Unsuccessful, please try again");
                    initialResponse(3);

                }

            }
        } else if (a == 4) {
            System.exit(0);
        }
    }
}