package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.validator.HoraPlantao
import java.time.LocalTime
import javax.validation.constraints.NotNull

@HoraPlantao
class HoraRequest(inicio: LocalTime, fim: LocalTime) {
    @NotNull
    val inicio: LocalTime = inicio

    @NotNull
    val fim: LocalTime = fim

    fun toModel(): Hora {
        return Hora(inicio, fim)
    }
}
