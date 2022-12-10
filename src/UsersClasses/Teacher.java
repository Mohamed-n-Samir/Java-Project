package UsersClasses;


public class Teacher {
    private static int id;
    private static String name;
    private static String subject1;
    private static String subject2;
    private static String subject3;
    private static String email;
    private static String password;
    

    public Teacher(int id, String name, String subject1,String subject2,String subject3, String email, String password){
        this.id = id;
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.email = email;
        this.password = password;
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
        
    public static String getPassword(){
        return password;
    }

    public static void setPassword(String password1){
        password = password1;
    }
    
    public static void setName(String name1){
        name = name1;
    }
    
    public static void setEmail(String email1){
        email = email1;
    }
    
    public static void setSub1(String subject11){
        subject1 = subject11;
    }
    
    public static void setSub2(String subject21){
        subject2 = subject21;
    }
    
    public static void setSub3(String subject31){
        subject3 = subject31;
    }
}
