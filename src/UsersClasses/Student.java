package UsersClasses;

public class Student extends User{


    private static String phoneNumber;
    private static int age;
    private static String subject1;
    private static String subject2;
    private static String subject3;

    public Student(int ID, String name, String email, String phoneNumber, int age, String subject1, String subject2, String subject3,String password) {
        super.id = ID;
        super.name = name;
        this.age = age;
        super.email = email;
        this.phoneNumber = phoneNumber;
        super.password = password;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
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
