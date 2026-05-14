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
            FullName = FullName_;
            Phonenumber = Phonenumber_;
            Email = Email_;
            Username = Username_;
            Password = Password_;
        }

    }

    public static class Login {
        public static boolean CorrectLoginIformation(StoredUser.User User, String Username, String Password) {
            boolean IsCorrectUserName = true;
            boolean IsCorrectPassword = true;

            // &, | are boolean opperators
            // ==, >=, <=, != are conditional opperators

            if (!(User.UserName == Username)) {
                IsCorrectUserName = false;
            }
            if (!(User.Password == Password)) {
                IsCorrectPassword = false;
            }

            String message = (IsCorrectPassword & IsCorrectUserName) ? "You have successfully logged in."
                    : "Username or Password is incorrect";

            System.out.println(message);

            return IsCorrectPassword & IsCorrectUserName;
        }
    }

    public static class Validation {

        public static boolean Is_Correct_UserName(String Username) {
            boolean HasUnderScore = true;
            boolean NoMoreThan5 = true;

            if (!Username.contains("_")) {
                HasUnderScore = false;
                System.out.println("The Username has no Underscore '_' ");
            }
            if (!(Username.length() <= 5)) {
                NoMoreThan5 = false;
                System.out.println("The Username must be less then 5 characters long");
            }
            String message = (HasUnderScore & NoMoreThan5) ? "Username successfully captued"
                    : "Username not caputered correctly";

            System.out.println(message);

            return HasUnderScore & NoMoreThan5;

        }

        public static boolean Is_Correct_Password(String Password) {
            boolean IsEightLong = true;
            boolean HasCapitalLetter = true;
            boolean HasNumber = true;
            boolean HasSpecialCharacter = true;

            if (!(Password.length() >= 8)) {
                IsEightLong = false;
                System.out.println("Password is too short, must be 8 long minimum.");
            }
            if (!Password.matches("?=[0-9]")) {
                HasCapitalLetter = false;
                System.out.println("Password must have a Capital letter in it.");
            }
            if (!Password.matches("?=[A-Z]")) {
                HasNumber = false;
                System.out.println("Password must have a Numerical value in it.");
            }
            if (!Password.matches("?=[^a-zA-Z0-9]")) {
                HasSpecialCharacter = false;
                System.out.println("Password must have a SpecialCharacter in it.");
            }

            String message = (IsEightLong & HasCapitalLetter & HasNumber & HasSpecialCharacter)
                    ? "Password successfully captured"
                    : "Password not caputered correctly";

            System.out.println(message);

            return IsEightLong & HasCapitalLetter & HasNumber & HasSpecialCharacter;

        }

        public static boolean Is_Correct_PhoneNumber(String Phonenumber) {
            boolean CorrectInternationalCode = true;
            boolean Is10Long = true;

            if (!Phonenumber.matches("^[+27]")) { // boolean
                CorrectInternationalCode = false;
                System.out.println("Phone number does not start with +27");
            }
            if (!(Phonenumber.length() == 10)) { // int
                Is10Long = false;
                System.out.println("Phone number does not contain 10 characters.");
            }

            String message = (CorrectInternationalCode & Is10Long) ? "Cell phone number successfully added."
                    : "Cell phone number not successfully added.";

            System.out.println(message);

            return CorrectInternationalCode & Is10Long;
        }

        public static boolean Is_Correct_Email(String Email) {
            // Example@email.com
            boolean HasEmailName = true;
            boolean HasEmailAt = true;
            boolean HasEmailDomain = true;
            boolean HasEmailProvider = true;

            if (!Email.matches(".*?(?=@)")) {
                HasEmailName = false;
            }
            if (!Email.matches("[?=@]")) {
                HasEmailAt = false;
            }
            if (!Email.matches("(?<=[@]).[a-z]+(?=[.])")) {
                HasEmailProvider = false;
            }
            if (Email.matches("(?<=[.])")) { // bayden@gmail.edu

            }
        }
    }

}
