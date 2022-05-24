package br.com.cafecomdeploy.aplicacao.handler;

import br.com.cafecomdeploy.aplicacao.exceptions.CamposMensagem;
import br.com.cafecomdeploy.aplicacao.exceptions.Erro;
import br.com.cafecomdeploy.aplicacao.exceptions.ErroValidacao;
import br.com.cafecomdeploy.aplicacao.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@ControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<Erro> objectNotFound(ObjectNotFoundException e,
                                               HttpServletRequest request) {

        Erro err = new Erro(  LocalDate.now(),
                HttpStatus.NOT_FOUND.value(),
                e.getClass().getName(),
                e.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> validation(MethodArgumentNotValidException e,
                                           HttpServletRequest request) {

        ErroValidacao err = new ErroValidacao(LocalDate.now(),
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                e.getClass().getName(),
                e.getMessage(),
                request.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
}
