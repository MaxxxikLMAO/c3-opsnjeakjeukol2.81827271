package cz.educanet.mavenz;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class UserManager { // řeší logickou část registrace

    private List<User> userList = new ArrayList<User>();

    public boolean existByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


    public void userInfoStorage(User tempUser) { // Zde se uklada info o vsech userech
        userList.add(tempUser);

    }

    public User getUserByUsernameNPass(String username, String password) {

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUsername().equals(username) && (userList.get(i).getPassword().equals(password))) {
                return userList.get(i);
            }
        }
        return null;
    }
}


