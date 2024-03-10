package pro.sky.coursework2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionStorageIsFullException extends RuntimeException {
    public QuestionStorageIsFullException() {
    }

    public QuestionStorageIsFullException(String message) {
        super(message);
    }

    public QuestionStorageIsFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionStorageIsFullException(Throwable cause) {
        super(cause);
    }

    public QuestionStorageIsFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
