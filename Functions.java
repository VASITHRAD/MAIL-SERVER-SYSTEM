import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Functions {
    static ArrayList<String> mailIDlist = new ArrayList<>();
    static ArrayList<Email> allMail = new ArrayList<>();
        public static void readFileContent() throws IOException{
            File file = new File("Mail.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedReader rd;
            try {
                rd = new BufferedReader(new FileReader(file));
                String line = "";
                int count = 0;
                Email exitingMail = new Email();
                while((line = rd.readLine())!=null){
                    if(count==4){
                        allMail.add(exitingMail);
                        count = 0;
                    }
                    if(line.contains("senderMailID")){
                        String[] senderMail = line.split("= ");
                        exitingMail.setSenderMailID(senderMail[1]);
                    }
                    if(line.contains("receiverMaiID")){
                        String[] receiverMail = line.split("= ");
                        exitingMail.setReceiverMaiID(receiverMail[1]);
                    }
                    if(line.contains("subject")){
                        String[] sub = line.split("= ");
                        exitingMail.setSubject(sub[1]);
                    }
                    if(line.contains("content")){
                        String[] content = line.split("= ");
                        exitingMail.setContent(content[1]);
                    }
                    count++;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    
        public static void writetoFile(Email mail) throws IOException{
            FileWriter write = new FileWriter("Mail.txt",true);
            BufferedWriter wr = new BufferedWriter(write);
            wr.write(mail.toString());
            allMail.add(mail);
            wr.newLine();
            wr.close();
        }
    
        public static void readMailId() throws IOException{
            File mailIDfile = new File("MailIDList.txt");
            if(!mailIDfile.exists()){
                mailIDfile.createNewFile();
            }
            BufferedReader rd = new BufferedReader(new FileReader("MailIDList.txt"));
            String line = "";
            while((line = rd.readLine())!=null){
                mailIDlist.add(line);
            }
        }

        public static void writeMailID(String mailID) throws IOException{
            FileWriter wr = new FileWriter("MailIDList.txt",true);
            BufferedWriter writer = new BufferedWriter(wr);
            writer.write(mailID);
            mailIDlist.add(mailID);
            writer.newLine();
            writer.close();
        }

        public static boolean checkMail(String mailID){
            System.out.println("Entered mail : "+mailID);
            if(!mailID.contains("@gmail.com") && !mailID.contains("@yahoo.in")){
                System.out.println("Enter a valid mail");
                return false;
            }
            if(mailIDlist.contains(mailID)){
                System.out.println(mailIDlist);
                System.out.println("Mail Already occupied. Give a unique name");
                return false;
            }
            return true;
        }

        public static boolean check(String mailID){
            if(mailIDlist.contains(mailID)){
                return true;
            }
            return false;
        }

        public static boolean strengthOfPass(String password){
            boolean num = false, specialCharacter = false, lowerChar = false, upperChar = false, len = false;
            String specialChar = "%\\/)(*&^$#!)-+><;:'[]{}|=_@";
            if(password.length()>=5){
                len = true;
            }
            for(int i = 0; i<password.length(); i++){
                if(Character.isDigit(password.charAt(i))){
                    num = true;
                }
                else if(Character.isUpperCase(password.charAt(i))){
                    upperChar = true;
                }
                else if(Character.isLowerCase(password.charAt(i))){
                    lowerChar = true;
                }
                else if(specialChar.contains(String.valueOf(password.charAt(i)))){
                    specialCharacter = true;
                }
            }
            if(num==true && specialCharacter==true && len==true && upperChar==true && lowerChar==true){
                return true;
            }
            return false;
        }
        
        public static void listMailID(){
            if(mailIDlist.size()==0){
                System.out.println("There is no users till. Please do create one.");
                return;
            }
            for(String mail : mailIDlist){
                System.out.println(mail);
            }
        }

        public static void receivedMail(String Mail){
            boolean found = false;
            for(Email m : allMail){
                if(m.getReceiverMaiID().equals(Mail)){
                    found = true;
                    System.out.println(m.toString());
                    System.out.println("---------------------------------------------------------------------");
                }
            }
            if(found==false){
                System.out.println("This user haven't received any mail yet!!!");
                return;
            }
        }

        public static void senderMail(String Mail){
            boolean found = false;
            for(Email m : allMail){
                if(m.getSenderMailID().equals(Mail)){
                    found = true;
                    System.out.println(m.toString());
                    System.out.println("---------------------------------------------------------------------");
                }
            }
            if(found==false){
                System.out.println("This user haven't sent any mail yet!!!");
                return;
            }
        }
}
