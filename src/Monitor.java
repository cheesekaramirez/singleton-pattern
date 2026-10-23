import java.util.Scanner;

public class Monitor {
    public static Scanner scn = new Scanner(System.in);
    public static final QueueSys sys = QueueSys.getInstance();
    static Helpdesk[] desks= {new Helpdesk(1), new Helpdesk(2), new Helpdesk(3)};
    static Helpdesk currDesk;
    public static void main(String[] args) {
        while(true) {
        System.out.println("Welcome to PAG-IBIG Queueing System!");
        System.out.print("Choose your helpdesk(1,2,3): ");
        int deskNum =  scn.nextInt();
        if(deskNum <=0 || deskNum > 3){
            System.out.println("Invalid desk number");
            continue;
        }
        currDesk = desks[deskNum-1];
        System.out.println("[1] Issue a Ticket");
        System.out.println("[2] Serve Next Ticket");
        System.out.println("[3] Reset Queue Number");
        System.out.println("[4] Exit");
        System.out.print("Select a number:");
        int choice=scn.nextInt();
        switch (choice) {
            case 1:
                sys.enqueue();
                break;
            case 2:
                currDesk.nextPerson();
                break;
            case 3:
                System.out.print("Type a new number to reset to: ");
                int newNum = scn.nextInt();
                if (newNum < 1) {
                    System.out.println("New number must be greater than 0.");
                    break;
                }
                currDesk.reset(newNum);
                break;
            case 4:
                scn.close();
                System.exit(0);
                break;
            default:
                System.out.println("Please choose a valid number.");
        }
    }
    }
}