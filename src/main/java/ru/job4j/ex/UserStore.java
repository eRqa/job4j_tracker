package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                rsl = user;
                break;
            }
        }
        if (rsl == null) {
            throw new UserNotFoundException("User not found");
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean rsl = true;
        if (!user.isValid() || user.getUsername().length() < 3) {
            rsl = false;
            throw new UserInvalidException("User is not valid");
        }
        return rsl;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException userInvalidException) {
            userInvalidException.printStackTrace();
        } catch (UserNotFoundException userNotFoundException) {
            userNotFoundException.printStackTrace();
        }
    }
}