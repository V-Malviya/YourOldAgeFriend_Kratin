import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Medicine implements Timings{
    String medicationName;
    String purpose;
    String dosage;
    String route;
    ArrayList<String> timings;
    public Medicine()
    {
        timings=new ArrayList<>();
    }
    public static Medicine addMedicine()
    {
        Scanner sc=new Scanner(System.in);
        Medicine m=new Medicine();
        System.out.println("Enter medicine name ");
        m.medicationName=sc.nextLine();
        System.out.println("Enter medicine purpose ");
        m.purpose=sc.nextLine();
        System.out.println("Enter medicine dosage(x tablets /X mg) ");
        m.dosage=sc.nextLine();
        System.out.println("Enter medicine route ");
        m.route=sc.nextLine();
        System.out.println("Please provide the timing \n");
        for(int i=0;i<4;i++)
        {
            System.out.println("Do you required to take this medicine at "+frequency.get(i));
            System.out.println("Enter yes or no like (y/n)");
            String input=sc.nextLine();
            if(input.equalsIgnoreCase("Y"))
            {
                m.timings.add(frequency.get(i));
            } else if (input.equalsIgnoreCase("N")) {

            }
            else
            {
                System.out.println("Invalid input! please provide input as (y/n)");
                i--;
            }
        }
//        sc.nextLine();
        return m;
    }
    public static void removeMedicine(User u)
    {
        Scanner sc=new Scanner(System.in);
        boolean choice=true;
        do {
            if (u.medication.size() == 0) {
                System.out.println("No medicine available to remove");
                return;
            }
            System.out.println("Given is the list medicine for " + u.name);
            System.out.println("Enter medicine number whom you want to remove ");
            for(int i=0;i<u.medication.size();i++)
            {
                System.out.println((i+1)+" name "+(u.medication.get(i).medicationName));
            }
            int ind=Integer.parseInt(sc.nextLine());
            if(ind>=1 && ind <=u.medication.size())
            {
                u.medication.remove(ind-1);
            }
            else
            {
                System.out.println("invalid input");
            }
            System.out.println("Do you want to remove again (true/false) ");
            choice=sc.nextBoolean();
            sc.nextLine();
        }while(choice);
    }
}
