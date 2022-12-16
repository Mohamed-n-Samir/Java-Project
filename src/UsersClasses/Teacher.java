package UsersClasses;

public class Teacher extends User{



    private static String subject1;
    private static String subject2;
    private static String subject3;


    public Teacher(int id, String name, String subject1, String subject2, String subject3, String email, String password) {
        super.id = id;
        super.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        super.email = email;
        super.password = password;
    }



    public static String getSubject1() {
        return subject1;
    }

    public static String getSubject2() {
        return subject2;
    }

    public static String getSubject3() {
        return subject3;
    }

    

    public static void setSub1(String subject11) {
        subject1 = subject11;
    }

    public static void setSub2(String subject21) {
        subject2 = subject21;
    }

    public static void setSub3(String subject31) {
        subject3 = subject31;
    }

}
