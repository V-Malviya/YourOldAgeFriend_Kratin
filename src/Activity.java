import java.time.LocalTime;
import java.util.Scanner;
class Activity {
    String name;
    LocalTime startTime;
    LocalTime endTime;

    public Activity(String name, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    static void displayToDo(User u) {
        LocalTime currentTime = LocalTime.now();
        if(u.activityList.size()==0)
        {
            System.out.println("No activity added for "+u.name+". please add to view");
        }
        else
        {
            int count=0;
            for(int i=0;i<u.activityList.size();i++)
            {
                Activity temp=u.activityList.get(i);
                if (!currentTime.isBefore(temp.startTime) && !currentTime.isAfter(temp.endTime)) {
                    count++;
                    System.out.println("___________________________________________________________________________________");
                    System.out.println("Hello "+u.name+" Gentle reminder you have todo : "+temp.name);
                    System.out.println("___________________________________________________________________________________");
                }
            }
            if(count==0)
            {
                System.out.println("No activity scheduled at the current time.");
            }
        }
    }
    static void setRemainder(User u) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name for activity");
        String name=sc.nextLine();
        System.out.println("Enter the start time for activity (24 hour format ex 2:30 pm= 14.30)");
        double st=sc.nextDouble();
        System.out.println("Enter the end time for activity (24 hour format ex 3:30 pm= 15.30)");
        double et=sc.nextDouble();
        Activity tempActivity = new Activity(name, LocalTime.of((int)st, (int)((st-(int)(st))*100)), LocalTime.of((int)et, (int)((et-(int)(et))*100)));
        u.activityList.add(tempActivity);
    }
}
