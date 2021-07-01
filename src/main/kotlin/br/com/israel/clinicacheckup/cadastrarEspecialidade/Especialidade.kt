package br.com.israel.clinicacheckup.cadastrarEspecialidade

import java.math.BigDecimal
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Especialidade(
    @NotNull tipoEspecialidade: TipoEspecialidade,
    @NotNull @Positive valor: BigDecimal
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @NotNull
    @Enumerated(EnumType.STRING)
    val tipoEspecialidade: TipoEspecialidade = tipoEspecialidade

    @NotNull
    @Positive
    val valor: BigDecimal = valor
}