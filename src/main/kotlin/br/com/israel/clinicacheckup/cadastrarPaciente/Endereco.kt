package br.com.israel.clinicacheckup.cadastrarPaciente

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class Endereco(
    @NotBlank logradouro: String,
    @NotBlank bairro: String,
    numero: String = "S/N",
    @NotBlank cidade: String,
    @NotBlank estado: String,
    @NotBlank pais: String
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotBlank
    val logradouro: String = logradouro

    @NotBlank
    val bairro: String = bairro

    val numero: String = numero

    @NotBlank
    val cidade: String = cidade

    @NotBlank
    val estado: String = estado

    @NotBlank
    val pais: String = pais

}