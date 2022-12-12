package UsersClasses;

public class Student {

    private static int ID;
    private static String name;
    private static String email;
    private static String password;
    private static String phoneNumber;
    private static int age;
    private static String subject1;
    private static String subject2;
    private static String subject3;

    public Student(int ID, String name, String email, String phoneNumber, int age, String subject1, String subject2, String subject3,String password) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID1) {
        ID = ID1;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name1) {
        name = name1;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email1) {
        email = email1;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password1) {
        password = password1;
    }
    
    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber1) {
        phoneNumber = phoneNumber1;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age1) {
        age = age1;
    }

    public static String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject11) {
        subject1 = subject11;
    }

    public static String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject21) {
        subject2 = subject21;
    }

    public static String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject31) {
        subject3 = subject31;
    }

}
