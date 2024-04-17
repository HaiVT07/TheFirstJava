package org.example.util;

public class Constant {
    public class ErrorType {
        public static final String SUCCESS = "SUCCESS";
        public static final String FALSE = "FALSE";
        public static final String LOGIN_USER_NOT_FOUND = "LOGIN_USER_NOT_FOUND";
        public static final String LOGIN_FAIL = "LOGIN_FAIL";
        public static final String INVALID_TOKEN = "INVALID_TOKEN";
        public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
        public static final String USER_DEACTIVATED = "USER_DEACTIVATED";
    }
    public static class Message {
        public static final String SUCCESS = "success";
        public static final String LOGIN_FAIL = "Email or password is not correct !";
        public static final String USER_NOT_FOUND = "not found user.";
        public static final String LOGIN_USER_NOT_FOUND = "Your account does not exist, please contact administrator.";
        public static final String USER_DEACTIVE = "user is Deactive. Please contact with admin.";
    }
    public class Code {
        public static final int SUCCESS = 200;
        public static final int NOT_FOUND = 400;
        public static final int BAD_REQUEST = 400;
        public static final int INTERNAL_SERVER_ERROR = 400;
        public static final int FALSE = 1;
    }

}
