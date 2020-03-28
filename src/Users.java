import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Users {
    private String userLogin;
    private String userPassword;
    private String userName;
    private String userGroup;
    private String userEmail;

    public Users() throws IOException {
        //TODO: Сделать нормальное шифрование и хэширование пароля
        BufferedReader reader = new BufferedReader((new InputStreamReader(System.in)));
        System.out.print("Enter login: ");
        userLogin = reader.readLine();
        System.out.print("Enter password: ");
        userPassword = String.valueOf(reader.readLine().hashCode());
        System.out.print("Enter name: ");
        userName = reader.readLine();
        System.out.print("Choose group (admins or users): ");
        userGroup = reader.readLine();
        System.out.print("Enter e-mail: ");
        userEmail = reader.readLine();
    }
}
