import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username; //A
    String password;  //A
    String email;   //A

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function (User user, List<User> allUsers) {
        if (user==null || user.getPassword()==null || user.getEmail()==null){ //B
            throw new RuntimeException("Mandatory information missing!");  //C
        }

        if (user.getUsername()==null){  //D
            user.setUsername(user.getEmail());  //E
        }

        int same = 1;   //F
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) {   //G
            same = 0;   //H
            for (int i=0;i<allUsers.size();i++) {  //I
                User existingUser = allUsers.get(i);
                if (existingUser.getEmail() == user.getEmail()) {  //J
                    same += 1;  //K
                }
                if (existingUser.getUsername() == user.getUsername()) {   //L
                    same += 1;  //M
                }
            }
        }

        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";  //O
        String password = user.getPassword();   //O
        String passwordLower = password.toLowerCase();   //O

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length()<8) {  //P
            return false;  //Q
        }
        else {  //R
            if (!passwordLower.contains(" ")) {  //S
                for (int i = 0; i < specialCharacters.length(); i++) {  //T
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) {  //U
                        return same == 0;  //V
                    }
                }
            }
        }
        return false;  //Y
    }

}
