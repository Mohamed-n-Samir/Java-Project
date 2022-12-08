package UsersClasses;


public class Teacher {
    private static int id;
    private static String name;
    private static String subject1;
    private static String subject2;
    private static String subject3;
    private static String email;
    

    public Teacher(int id, String name, String subject1,String subject2,String subject3, String email){
        this.id = id;
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.email = email;
    }
    
    public static int getID(){
        return id;
    }
    
    public static String getName(){
        return name;
    }
    
    public static String getSubject1(){
        return subject1;
    }
    
    public static String getSubject2(){
        return subject2;
    }
    
    public static String getSubject3(){
        return subject3;
    }
    
    public static String getEmail(){
        return email;
    }
    
}
