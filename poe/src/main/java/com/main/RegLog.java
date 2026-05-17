package com.main;

// Registration and Login class
public class RegLog {

    public static class Registration {
        String FullName;
        String Phonenumber;
        String Email;
        String Username;
        String Password;

        Registration(String FullName_, String Phonenumber_, String Email_, String Username_, String Password_) {
<<<<<<< Updated upstream
            if (Validation.Is_Correct_UserName(Username_)) {
                Username = Username_;
            }
            if (Validation.Is_Correct_PhoneNumber(Phonenumber_)) {
                Phonenumber = Phonenumber_;
            }
            if (Validation.Is_Correct_Email(Email_)) {
                Email = Email_;
            }
            if (Validation.Is_Correct_Password(Password_)) {
                Password = Password_;
            }
            FullName = FullName_;

        }
=======
>>>>>>> Stashed changes

            if (!Validation.Is_Correct_UserName(Username_))
                throw new IllegalArgumentException("Invalid username");

            if (!Validation.Is_Correct_PhoneNumber(Phonenumber_))
                throw new IllegalArgumentException("Invalid phone number");

            if (!Validation.Is_Correct_Email(Email_))
                throw new IllegalArgumentException("Invalid email");

            if (!Validation.Is_Correct_Password(Password_))
                throw new IllegalArgumentException("Invalid password");

            this.FullName = FullName_;
            this.Username = Username_;
            this.Phonenumber = Phonenumber_;
            this.Email = Email_;
            this.Password = Password_;
        }
    }

    public static class Login {
        public static boolean CorrectLoginIformation(StoredUser.User user, String username, String password) {

            boolean isCorrectUserName = user.UserName.equals(username);
            boolean isCorrectPassword = user.Password.equals(password);

            if (isCorrectUserName && isCorrectPassword) {
                System.out.println("You have successfully logged in.");
                return true;
            } else {
                System.out.println("Username or Password is incorrect");
                return false;
            }
        }
    }

    public static class Validation {

        public static boolean Is_Correct_UserName(String username) {
            boolean hasUnderscore = username.contains("_");
            boolean validLength = username.length() <= 5;

            if (!hasUnderscore) {
                System.out.println("Username must contain an underscore '_'");
            }
            if (!validLength) {
                System.out.println("Username must be 5 characters or less");
            }

            boolean valid = hasUnderscore && validLength;

            System.out.println(valid ? "Username successfully captured" : "Username not captured correctly");

            return valid;
        }

        public static boolean Is_Correct_Password(String password) {
            String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{8,}$";

            boolean valid = password.matches(regex);

            if (!valid) {
                System.out.println(
                        "Password must be at least 8 characters and include a capital letter, number, and special character.");
            } else {
                System.out.println("Password successfully captured");
            }

            return valid;
        }

        public static boolean Is_Correct_PhoneNumber(String number) {
            boolean valid = number.matches("^\\+27\\d{9}$");

            if (!valid) {
                System.out.println("Phone number must start with +27 and contain 9 digits after it.");
            } else {
                System.out.println("Cell phone number successfully added.");
            }

            return valid;
        }

        public static boolean Is_Correct_Email(String email) {
            boolean valid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"); // https://regex101.com/

            if (!valid) {
                System.out.println("Email not valid.");
            } else {
                System.out.println("Email successfully added");
            }
<<<<<<< Updated upstream
            if (!Email.matches("[?=@]")) {
                HasEmailAt = false;
            }
            if (!Email.matches("(?<=[@]).[a-z]+(?=[.])")) {
                HasEmailProvider = false;
            }
            if (!Email.matches("(?<=[.])")) { // bayden@gmail.edu
                HasEmailDomain = false;
            }

            if (HasEmailName & HasEmailAt & HasEmailProvider & HasEmailDomain) {
                System.out.println("Email successfully added");
            }

            return HasEmailName & HasEmailAt & HasEmailProvider & HasEmailDomain;
=======

            return valid;
>>>>>>> Stashed changes
        }
    }
}