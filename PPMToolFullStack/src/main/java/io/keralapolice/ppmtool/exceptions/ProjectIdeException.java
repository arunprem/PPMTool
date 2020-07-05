package io.keralapolice.ppmtool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdeException extends  RuntimeException{

    public ProjectIdeException(String message) {
        super(message);
    }
}
