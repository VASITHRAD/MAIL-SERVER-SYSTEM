import java.io.IOException;
import java.util.Scanner;
class main{
    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            Functions.readFileContent();
            Functions.readMailId();
            System.out.println("WELCOME TO THE MAIL SERVER");
            System.out.println("Please select the option below : ");
            System.out.println("1. Create mail\n2. Send mail\n3. List all available mail\n4. List the mail received by particular mail\n5. List the mail sent by particular mail\n6. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Please enter mail id to create new mail like ('abc@gmail.com' or 'xyz@yahoo.in'):");
                    String mail = sc.next();
                    boolean exist = Functions.checkMail(mail);
                    System.out.println(exist);
                    while(exist==false){
                        System.out.println("Please enter an unique mail,this is already occupied or invalid ");
                        mail = sc.next();
                        exist = Functions.checkMail(mail);
                    }
                    
                    System.out.println("You have chose your mail id as follow : "+mail);
                    System.out.println("Enter a strong password :\n It must contain the following \n1. A Uppercase character\n2. A lowercase Character\n3. A special character\n4. A number\5. Length of password should be minimum 5.");
                    String password = sc.next();
                    boolean strongPass = Functions.strengthOfPass(password);
                    while(strongPass==false){
                        System.out.println("Please give a strong password ");
                        password = sc.next();
                        strongPass = Functions.strengthOfPass(password);
                    }

                    System.out.println("The mail id "+mail+" is created with the password you entered");
                    Functions.writeMailID(mail);
                    break;
                
                case 2:
                    System.out.println("Please enter the below details to send mail ");
                    System.out.println("Enter the sender mail id :");
                    String sender = sc.next();

                    boolean senderMail = Functions.check(sender);
                    while(senderMail==false){
                        System.out.println("Sender mail is invalid or does not exist. Please enter a valid mail");
                        sender = sc.next();
                        senderMail = Functions.check(sender);
                    }

                    System.out.println("Enter the receiver mail id : ");
                    String receiver = sc.next();
                    boolean receiverMail = Functions.check(receiver);
                    while (receiverMail==false) {
                        System.out.println("Receiver mail is invalid or does not exist. Please enter a valid mail");
                        receiver = sc.next();
                        receiverMail = Functions.check(receiver);
                    }

                    System.out.println("Enter the subject of the body : ");
                    String subject = sc.next();
                    System.out.println("Enter the content of the mail :");
                    String content = sc.next();

                    Email email = new Email();
                    email.setSenderMailID(sender);
                    email.setReceiverMaiID(receiver);
                    email.setSubject(subject);
                    email.setContent(content);

                    Functions.writetoFile(email);
                    System.out.println("Mail sent successfully");
                    break;

                case 3:
                    Functions.listMailID();
                    break;
                
                case 4:
                    System.out.println("Enter the mail ID to view all the mail received by them.");
                    String getRecieverMail = sc.next();
                    Functions.receivedMail(getRecieverMail);
                    break;
                case 5:
                    System.out.println("Enter the mail ID to view all the mail sent by them.");
                    String getSenderMail = sc.next();
                    Functions.senderMail(getSenderMail);
                    break;
                case 6:
                    System.out.println("BYE BYE!!!!");
                    System.exit(1);
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        }
    }
}