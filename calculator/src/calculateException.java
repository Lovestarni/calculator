class zeroException extends Exception {
    private String message;

    public zeroException() {
        this.message = "The Denominator can't be zero.";
    }

    public String getMessage() {
        return message;
    }
}

class pointException extends Exception {
    private String message;

    public pointException() {
        this.message = "Too manny radix point";
    }

    public String getMessage() {
        return message;
    }
}