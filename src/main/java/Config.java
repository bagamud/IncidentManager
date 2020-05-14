import java.io.*;

public class Config {
    private File conf = new File("cfg/config.txt");
    private String url;
    private String username;
    private String password;

    public Config() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(conf));
        while (reader.ready()) {
            String[] line = reader.readLine().split("=");
            switch (line[0]) {
                case "url":
                    url = line[1];
                    break;
                case "username":
                    username = line[1];
                    break;
                case "password":
                    password = line[1];
                    break;
                default:
                    break;
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
