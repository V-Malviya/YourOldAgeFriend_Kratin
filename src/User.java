import java.util.ArrayList;
import java.util.Scanner;

//import java.time.LocalDate;
//import java.time.Period;
public class User {
    String name;
    int age;
    String dob;
    String gender;
    String address;
    long mobileNumber;
    String emailId;
    ArrayList<Activity> activityList;
    ArrayList<Medicine> medication;
    public User()
    {
        activityList=new ArrayList<Activity>();
        medication=new ArrayList<Medicine>();
    }
    public static User addUser() {
        Scanner sc=new Scanner(System.in);
        User u=new User();
        System.out.println("Please enter your full name :");
        u.name=sc.nextLine();
        System.out.println("Please enter your age :");
        u.age=Integer.parseInt(sc.nextLine());
        System.out.println("Please enter your date of birth(DD-MM-YYYY) :");
        u.dob=sc.nextLine();
        System.out.println("Please enter your gender(Male/Female) :");
        u.gender=sc.nextLine();
        System.out.println("Please enter your address :");
        u.address=sc.nextLine();
        System.out.println("Please enter your mobile number :");
        u.mobileNumber=Long.parseLong(sc.nextLine());
        System.out.println("Please enter your email Id :");
        u.emailId=sc.nextLine();
        return u;
    }
    public static User setUser(ArrayList<User> users)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Here is the list of all user available.\nPlease select user by providing corresponding number : ");
        int ind=0;
        for(int i=0;i<users.size();i++)
        {
            System.out.println((i+1)+" : "+(users.get(i).name));
        }
        ind=Integer.parseInt(sc.nextLine());
        return users.get(ind-1);
    }
    public void displayMedication(User u)
    {
        System.out.println("___________________________________________________________________________________");
        if(u.medication.size()==0)
        {
            System.out.println("There is no medication available for "+u.name);
        }
        else {
            for (int i = 0; i < u.medication.size(); i++) {
                System.out.println("___________________________________________________________________________________");
                Medicine m = u.medication.get(i);
                System.out.println(m.medicationName + "<=====>" + m.dosage + "<=====>" + m.purpose + "<=====>" + m.route);
                System.out.println("Timings Are as follows");
                for (String s : m.timings) {
                    System.out.println(s);
                }
                System.out.println("___________________________________________________________________________________");
            }
        }
        System.out.println("___________________________________________________________________________________");

    }
}
