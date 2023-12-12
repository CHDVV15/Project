import java.util.ArrayList;
import java.util.Scanner;
class Contact {
    private String phone;
    private String name;

    public Contact(){
        setName();
        setPhone();
    }

    public Contact(String name,String phone) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }
    public String getName() {
        return name;
    }

    public void setPhone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone: ");
        String p= sc.nextLine();
        this.phone = p;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String n= sc.nextLine();
        this.name = n;
    }
}
class Message {
    String text;
    String person;
    Message(){}

    public Message(String text, String person) {
        this.text = text;
        this.person = person;
    }
    public String getText() {
        return text;
    }
    public String getPerson() {
        return person;
    }
    public void setText(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text: ");
        String p= sc.nextLine();
        this.text = text;
    }

    public void setRecipient(int recipient) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Person: ");
        String p= sc.nextLine();
        this.person = person;
    }
}
public class Contact_Message_Manager {
    static void menu1(){
        System.out.println("1.Manage Contact\n2.Messages\n3.Quit");
    }
    static void menu2(){
        System.out.println("1.Show all contacts\n2.Add a new contact\n3.Search for a contact\n4.Delete a contact\n5.Go back to previous menu");
    }
    static void menu3(){
        System.out.println("1.See the list of all messages\n2.Send a new message\n3.Go back to previous menu");
    }
    static void menu4(){
        System.out.println("1.Search by name\n2.Search by number");
    }
    static void menu5(){
        System.out.println("1.Remove by name\n2.Remove by number");
    }
    static void showcontact(ArrayList<Contact> contacts){
        for (Contact c : contacts){
            System.out.println(c.getName()+" "+c.getPhone());
        }
    }
    static void searchbyname(ArrayList<Contact> contacts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name:");
        String key = sc.nextLine();
        int flag=0;
        for (Contact c : contacts){
            if(key.equals(c.getName())) {
                System.out.println("Found");
                System.out.println(c.getName() + "  " + c.getPhone());
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.println("Not Found");
        }
    }
    static void searchbynumber(ArrayList<Contact> contacts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number:");
        String key = sc.nextLine();
        int flag=0;
        for (Contact c : contacts){
            if(key.equals(c.getPhone())) {
                System.out.println("Found");
                System.out.println(c.getName() + "  " + c.getPhone());
                flag=1;
                break;
            }
        }
        if (flag==0){
            System.out.println("Not Found");
        }
    }
    static void removebyname(ArrayList<Contact> contacts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name:");
        String key = sc.nextLine();
        for (Contact c : contacts){
            if(key.equals(c.getName())){
                contacts.remove(c);
            }
        }
    }
    static void removebynumber(ArrayList<Contact> contacts){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number:");
        String key = sc.nextLine();
        for (Contact c : contacts){
            if(key.equals(c.getPhone())){
                contacts.remove(c);
            }
        }
    }
    static void showmessage(ArrayList<Message> messages){
        for (Message m : messages){
            System.out.println(m.getText()+" "+m.getPerson());
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome Dinesh.");

        ArrayList<Contact> contacts= new ArrayList<Contact>();
        Contact c1=new Contact("Dad","9440166315");
        Contact c2=new Contact("Mom","9491756315");
        contacts.add(c1);
        contacts.add(c2);

        ArrayList<Message> messages = new ArrayList<Message>();
        Message m1=new Message("Good Morning","Dad");
        Message m2=new Message("Good Night","Mom");
        messages.add(m1);
        messages.add(m2);

        do {
            menu1();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an option: ");
            int ch = sc.nextInt();
            if (ch == 1) {
                menu2();
                System.out.print("Enter an option:");
                int ch1 = sc.nextInt();
                if (ch1 == 1) {
                    showcontact(contacts);
                } else if (ch1 == 2) {
                    Contact c = new Contact();
                    contacts.add(c);
                } else if (ch1 == 3) {
                    menu4();
                    System.out.println("Enter an option: ");
                    int a = sc.nextInt();
                    if (a == 1) {
                        searchbyname(contacts);
                    }
                    else if (a == 2) {
                        searchbynumber(contacts);
                    }
                    else{
                        System.out.println("Invalid Option");
                    }
                }
                else if (ch1 == 4){
                    menu5();
                    System.out.println("Enter an option: ");
                    int a = sc.nextInt();
                    if (a == 1) {
                        searchbyname(contacts);
                    }
                    else if (a == 2) {
                        searchbynumber(contacts);
                    }
                    else{
                        System.out.println("Invalid Option");
                    }
                }
            } else if (ch == 2) {
                menu3();
                System.out.println("Enter an option: ");
                int a= sc.nextInt();
                if (a==1){
                    showmessage(messages);
                }
                else if (a==2) {
                    Message m = new Message();
                    messages.add(m);
                }
                else {}
            } else if ((ch ==3)) {
                System.exit(0);
            }
            else{
                System.out.println("Invalid Option");
            }
        }while(true);
    }
}
