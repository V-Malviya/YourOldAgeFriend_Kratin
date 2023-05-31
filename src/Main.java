import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static User nobody=new User();
    static ArrayList<User> users=new ArrayList<>();
    static User currentUser=nobody;
    public static void main(String[] args) {
        boolean flag=true;
        Scanner sc=new Scanner(System.in);
        nobody.name="(Opps! no User Found please add new user first)";
        while(flag)
        {
            System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");
            System.out.println("Hello "+currentUser.name+". We hope you are doing well!\nSelect any options");
            System.out.println("1. Add new user.");
            System.out.println("2. Set user.");
            System.out.println("3. Add medicine for "+currentUser.name+".");
            System.out.println("4. Remove medicine for "+currentUser.name+".");
            System.out.println("5. Display today's Medication for "+currentUser.name+".");
            System.out.println("6. Set reminder for an activity.");
//            System.out.println("7. Mark medication for current user as");
            System.out.println("7. Display ToDo (Activity).");
            System.out.println("8. Exit.");
            System.out.println("*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*");

            int choice=Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                {
                    users.add(User.addUser());
                    break;
                }
                case 2:
                {
                    currentUser=User.setUser(users);
                    break;
                }
                case 3:
                {
                    currentUser.medication.add(Medicine.addMedicine());
                    break;
                }
                case 4: {
                    Medicine.removeMedicine(currentUser);
                    break;
                }
                case 5:
                {
                    currentUser.displayMedication(currentUser);
                    break;
                }
                case 6:
                {
                    Activity.setRemainder(currentUser);
                    break;
                }
                case 7:
                {
                    Activity.displayToDo(currentUser);
                    break;
                }
                case 8: {
                    System.out.println("we are happy to serve you and wish you to have best possible health.");
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Invalid input! please try again");
                }
            }
        }
    }
}
