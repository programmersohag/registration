package com.blog.registration.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    private String id;
    private ErrorCodes code;

    public UserNotFoundException(Object id, ErrorCodes codes) {
        super(String.format(codes.getMessage(), id));
        this.id = (String) id;
        this.code = codes;
    }

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }
}
