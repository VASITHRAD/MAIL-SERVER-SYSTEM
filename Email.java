public class Email {
    private String senderMailID;
    private String receiverMaiID;
    private String subject;
    private String content;

    public String getSenderMailID() {
        return senderMailID;
    }
    public void setSenderMailID(String senderMailID) {
        this.senderMailID = senderMailID;
    }
    public String getReceiverMaiID() {
        return receiverMaiID;
    }
    public void setReceiverMaiID(String receiverMaiID) {
        this.receiverMaiID = receiverMaiID;
    }
    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public String toString() {
        return "senderMailID= " + senderMailID + "\nreceiverMaiID= " + receiverMaiID + "\nsubject= " + subject
                + "\ncontent= " + content +"\n";
    }
    
}
