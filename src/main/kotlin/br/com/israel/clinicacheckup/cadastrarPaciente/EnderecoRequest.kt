package br.com.israel.clinicacheckup.cadastrarPaciente

import javax.validation.constraints.NotBlank

class EnderecoRequest(
    @NotBlank logradouro: String,
    @NotBlank bairro: String,
    numero: String = "S/N",
    @NotBlank cidade: String,
    @NotBlank estado: String,
    @NotBlank pais: String
) {

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


    fun toModel(): Endereco {
        return Endereco(
            logradouro = logradouro,
            bairro = bairro,
            cidade = cidade,
            numero = numero,
            estado = estado,
            pais = pais
        )
    }
}
