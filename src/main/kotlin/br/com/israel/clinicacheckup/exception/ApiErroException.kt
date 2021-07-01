package br.com.israel.clinicacheckup.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

class ApiErroException(
    val httpStatus: HttpStatus,
    val campo: String,
    val causa: String
) : RuntimeException() {

}
