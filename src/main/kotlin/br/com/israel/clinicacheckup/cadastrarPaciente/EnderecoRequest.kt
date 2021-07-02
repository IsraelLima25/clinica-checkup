package br.com.israel.clinicacheckup.cadastrarPaciente

import javax.validation.constraints.NotBlank

class EnderecoRequest(
    @field:NotBlank val logradouro: String,
    @field:NotBlank val bairro: String,
    val numero: String = "S/N",
    @field:NotBlank val cidade: String,
    @field:NotBlank val estado: String,
    @field:NotBlank val pais: String
) {

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
