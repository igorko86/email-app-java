package emailappjava;

import java.util.Scanner;

public class Email {
    private String name;
    private String lastName;
    private String password;
    private final int DEFAULT_PASSWORD_LENGTH = 10;
    private final String COMPANY_SUFFIX = "company.com";
    private String email;
    private String department;
    private int mailBoxCapacity = 500;
    private String alternateEmail;

    public Email(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.password = generateRandomPassword(DEFAULT_PASSWORD_LENGTH);
        this.department = this.setDepartment();
        this.email = createEmail();
    }

    public String setDepartment() {
        System.out.print("Departments: \n" + "Enter: \n" + "For selling - 1\n" + "For development - 2\n"
                + "For accounting - 3\n" + "For other - 0\n" + "ENTER: " );

        int ans;
        try(Scanner scn = new Scanner(System.in);) {
            ans = scn.nextInt();
        } catch (Exception ex) {
            ex.printStackTrace();
            ans = 0;
        }
        System.out.println("Department Code: " + ans);
        return switch (ans) {
            case 3 -> "sales";
            case 2 -> "dev";
            case 1 -> "acc";
            default -> "";
        };
    }

    public void setMailBoxCapacity(int mailBoxCapacity) {
        this.mailBoxCapacity = mailBoxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    private String createEmail() {
        String name = this.name.toLowerCase();
        String lastName = this.lastName.toLowerCase();
        char firstL = name.charAt(0);
        return firstL + "_" + lastName + "@" + this.department + "." + COMPANY_SUFFIX;
    }

    public String generateRandomPassword(int length) {
        String setCharacters = "ABCDEFGHIKLMNOPQRSTUWXYZabsdefghiklmnopqrstuwxyz1234567890";
        try {
            if (length < 2) throw new ArithmeticException();
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
            length = DEFAULT_PASSWORD_LENGTH;
        }
        String pass = "";
        for (int i = 0; i < length; i++) {
            int n = (int) Math.floor(Math.random() * setCharacters.length());
            char l = setCharacters.charAt(n);
            pass += l;
        }
        return pass;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Email{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", DEFAULT_PASSWORD_LENGTH=" + DEFAULT_PASSWORD_LENGTH +
                ", COMPANY_SUFFIX='" + COMPANY_SUFFIX + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", mailBoxCapacity=" + mailBoxCapacity +
                ", alternateEmail='" + alternateEmail + '\'' +
                '}';
    }
}
