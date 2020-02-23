package definition;

public class Person {
    private String fName;
    private String lName;
    private String[] no;
    private String email;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(ANSI_BLUE+"-------- * -------- * -------- * --------\n"+ANSI_RESET);
        sb.append(ANSI_PURPLE+"First Name: "+ANSI_RESET).append(fName).append('\n');
        sb.append(ANSI_PURPLE+"Last Name: "+ANSI_RESET).append(lName).append('\n');
        sb.append(ANSI_PURPLE+"Contact No: "+ANSI_RESET);
        for (int i = 0; i < no.length; i++) {
            sb.append((no[0] != null && i == 0 ? no[0] : "") + (no[1] != null && i == 1 ? ", " + no[1] : "") +
                    (no[2] != null && i == 2 ? ", " + no[i] : ""));
        }
        sb.append(ANSI_PURPLE+"\nEmail: "+ANSI_RESET).append((email != null ? email : "")).append('\n');
        sb.append(ANSI_BLUE+"-------- * -------- * -------- * --------\n"+ANSI_RESET);
        return sb.toString();
    }

    public Person(String fName, String lName, String[] no, String email) {
        this.fName = fName;
        this.lName = lName;
        this.no = no;
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String[] getNo() {
        return no;
    }

    public void setNo(String[] no) {
        this.no = no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
