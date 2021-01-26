package spring.security.api.config;

import javax.servlet.http.HttpServletResponse;

public class AppConfig {

    public static final int SUCCESS_CODE = HttpServletResponse.SC_OK;
    public static final int CREATED_CODE = HttpServletResponse.SC_CREATED;
    public static final int BAD_REQUEST_CODE = HttpServletResponse.SC_BAD_REQUEST;
    public static final int NOT_FOUND_CODE = HttpServletResponse.SC_NOT_FOUND;
    public static final int FORBIDDEN_CODE = HttpServletResponse.SC_FORBIDDEN;
    public static final int UNAUTHORIZED_CODE = HttpServletResponse.SC_UNAUTHORIZED;
    public static final int INTERNAL_SERVER_ERROR_CODE = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

    public static final String SUCCESS_MSG = "SUCCESS";
    public static final String CREATED_MSG = "RECORD CREATED";
    public static final String FAILED_MSG = "FAILED";
    public static final String NOT_FOUND_MSG = "NOT FOUND";
    public static final String FORBIDDEN_MSG = "FORBIDDEN";
    public static final String UNAUTHORIZED_MSG = "UNAUTHORIZED";
    public static final String LOGIN_FAILED_MSG = "LOGIN FAILED.BAD CREDENTIALS";
    public static final String EMAIL_ALREADY_EXISTS_MSG = "Record with provided email already exists";
    public static final String USERNAME_ALREADY_EXISTS_MSG = "Record with provided username already exists";
    public static final String RECORD_CREATED_WITH_ID_MSG = "Record created successfully. Record ID: ";
    public static final String RECORD_UPDATED_WITH_ID_MSG = "Record updated successfully. Record ID: ";
    public static final String RECORD_DELETED_WITH_ID_MSG = "Record Deleted successfully. Record ID: ";
    public static final String NULL_PASSWORD_MSG = "Password is required";
    public static final String MIN_LENGTH_PASSWORD_MSG = "Atleast a minimum of " + AppConfig.MIN_PASSWORD_LENGTH + " charecters are required for the password";
    public static final String BAD_REQUEST_MSG = "BAD REQUEST";
    public static final String INTERNAL_SERVER_ERROR_MSG = "INTERNAL SERVER ERROR";

    public static final String SECRET_KEY = "spring.app@secure123!";
    public static final long EXPIRATION_TIME = 90000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String REGISTER_URL = "/api/user/register";
    public static final String LOGIN_URL = "/api/user/login";

    public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final int MIN_PASSWORD_LENGTH = 4;

    public static final String APP_EMAIL_ADDRESS = "no-reply@gmail.com";
    public static final String PASSWORD_RESET_CODE_EMAIL_SENT_MSG = "Password Reset code successfully sent to: ";
    public static final String INVALID_RESET_CODE_MSG = "Invalid/expired reset code";
}
