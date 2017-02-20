package org.tutorial.web.controllers.advices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.tutorial.web.auth.LoggedUserHelper.isRoleAdmin;

/**
 * Created by taras on 18.02.17.
 */

@ControllerAdvice
public class ExceptionsController
{
    private static final Logger logger = LoggerFactory.getLogger(ExceptionsController.class);

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public String handleIllegalArgumentException(Model model, IllegalArgumentException ex)
    {
        logger.error("IllegalArgumentException: " + ex.getMessage());

        model.addAttribute("error", ex.getMessage());

        if (isRoleAdmin()) {
            model.addAttribute("stack", displayStackTrace(ex));
        }

        return "errors/50x";
    }

    public static String displayStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        String stackTrace = sw.toString();
        return stackTrace.replace(System.getProperty("line.separator"), "<br/>\n");
    }
}
