package br.com.israel.clinicacheckup.cadastrarEspecialidade

import br.com.israel.clinicacheckup.validators.UniqueValue
import java.math.BigDecimal
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class EspecialidadeRequest(@NotNull tipoEspecialidade: TipoEspecialidade, @NotNull @Positive valor: BigDecimal) {

    @UniqueValue(domainClass = Especialidade::class, fieldName = "tipoEspecialidade")
    @NotNull
    val tipoEspecialidade: TipoEspecialidade = tipoEspecialidade

    @NotNull
    @Positive
    val valor: BigDecimal = valor

    fun toModel(): Especialidade {
        return Especialidade(tipoEspecialidade = tipoEspecialidade, valor = valor)
    }
}
