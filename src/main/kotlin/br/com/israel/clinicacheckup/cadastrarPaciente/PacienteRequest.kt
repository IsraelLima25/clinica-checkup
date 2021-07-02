package br.com.israel.clinicacheckup.cadastrarPaciente

import br.com.israel.clinicacheckup.validators.UniqueValue
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.*

class PacienteRequest(
    @field:NotBlank @field:UniqueValue(domainClass = Paciente::class, fieldName = "rg")
    val rg: String,
    @field:NotBlank val nome: String,
    @field:NotNull @field:Past val dataNascimento: LocalDate,
    @field:Valid @field:NotNull val endereco: EnderecoRequest
) {

    fun toModel(): Paciente {
        return Paciente(rg = rg, nome = nome, dataNascimento = dataNascimento, endereco = endereco.toModel())
    }
}
