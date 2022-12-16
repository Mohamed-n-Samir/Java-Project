package UsersClasses;

public class User {

    static int id;
    static String userName;
    static String password;
    static String email;
    static String name;

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        User.userName = userName;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        User.name = name;
    }

    public static int getID() {
        return id;
    }
    
    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email1) {
        email = email1;
    }
    
    public static void setID(int id){
        User.id = id;
    }
}
