package br.com.israel.clinicacheckup.cadastrarPaciente

import br.com.israel.clinicacheckup.validators.UniqueValue
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.*

class PacienteRequest(
    @NotBlank rg: String,
    @NotBlank nome: String,
    @NotNull @Past dataNascimento: LocalDate,
    @Valid @NotNull endereco: EnderecoRequest
) {
    @NotBlank
    val nome: String = nome

    @NotNull
    @Past
    val dataNascimento: LocalDate = dataNascimento

    @UniqueValue(domainClass = Paciente::class, fieldName = "rg")
    @NotBlank
    val rg: String = rg

    @NotNull
    @Valid
    val endereco: EnderecoRequest = endereco

    fun toModel(): Paciente {
        return Paciente(rg=rg,nome = nome,dataNascimento = dataNascimento,endereco = endereco.toModel())
    }
}
