import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        
        String[] usernames = {"marcos", "admin", "juan"};
        String[] password = {"1234","1234", "1234"};

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el username");
        String user = scanner.next();

        System.out.println("Ingrese el password");
        String pass = scanner.next();

        boolean isAuthenticated = false;

        for(int i = 0; i < usernames.length; i++){
            isAuthenticated = (usernames[i].equals(user) && password[i].equals(pass)) ? true: isAuthenticated;
        }

        String message = isAuthenticated ? "Bienvenido usuario " + user : "User o contraseña son incorrectas,  requiere authenticacion ";

        System.out.println("Message:  " + message);
    }
}
