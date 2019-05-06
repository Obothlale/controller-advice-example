package co.za.obothlale.advice;

import co.za.obothlale.exception.NoWorldMentionedToGreetException;
import co.za.obothlale.model.ErrorMessage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NoWorldMentionedToGreetException.class})
    @ResponseBody
    public ErrorMessage handleNoWorldMentionedToGreetException(NoWorldMentionedToGreetException exception) {
        return new ErrorMessage(exception.getMessage(),"500");
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseBody
    public ErrorMessage handleNullPointExceptions(NullPointerException exception) {
        return new ErrorMessage(exception.getMessage(),"500");
    }
}
