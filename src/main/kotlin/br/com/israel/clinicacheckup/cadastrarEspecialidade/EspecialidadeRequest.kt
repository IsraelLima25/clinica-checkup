package br.com.israel.clinicacheckup.cadastrarEspecialidade

import java.math.BigDecimal
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class EspecialidadeRequest(
    @field:NotNull
    val tipoEspecialidade: TipoEspecialidade,
    @field:NotNull @field:Positive val valor: BigDecimal
) {

    fun toModel(): Especialidade {
        return Especialidade(tipoEspecialidade = tipoEspecialidade, valor = valor)
    }
}
