package br.com.israel.clinicacheckup.exception

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ResourceExceptionHandler(
    @Autowired
    val messageSource: MessageSource
) {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun handlerArgumentNotValid(exception: MethodArgumentNotValidException): List<CampoInvalido> {
        val fieldErrors: List<FieldError> = exception.bindingResult.fieldErrors
        return extrairErros(fieldErrors)
    }

    fun handlerApiErrorException(apiErroException: ApiErroException): ResponseEntity<CampoInvalido> {
        val campoInvalido = CampoInvalido(apiErroException.campo, apiErroException.causa)
        return ResponseEntity.status(apiErroException.httpStatus).body(campoInvalido)
    }

    private fun extrairErros(fieldErrors: List<FieldError>): List<CampoInvalido> {
        return fieldErrors.map { error ->
            CampoInvalido(error.field, messageSource.getMessage(error, LocaleContextHolder.getLocale()))
        }.toList()
    }
}