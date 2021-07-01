package br.com.israel.clinicacheckup.cadastrarPaciente

import org.hibernate.annotations.Type
import java.time.LocalDate
import java.util.*
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.PastOrPresent

@Entity
class Paciente(
    @NotBlank rg: String,
    @NotBlank nome: String,
    @NotNull @Past dataNascimento: LocalDate,
    @Valid @NotNull endereco: Endereco
) {

    @Id
    @Type(type = "org.hibernate.type.UUIDCharType")
    val id: UUID = UUID.randomUUID()

    @NotBlank
    val nome: String = nome

    @NotNull
    @Past
    val dataNascimento: LocalDate = dataNascimento

    @NotBlank
    val rg: String = rg

    @NotNull
    @Valid
    @OneToOne(cascade = [CascadeType.MERGE])
    val endereco: Endereco = endereco

    @NotNull
    @PastOrPresent
    val dataCadastro: LocalDate = LocalDate.now()
}