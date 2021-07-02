package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.validator.HoraPlantao
import java.time.LocalTime
import javax.validation.constraints.NotNull

@HoraPlantao
class HoraRequest(@field:NotNull val inicio: LocalTime, @field:NotNull val fim: LocalTime) {
    fun toModel(): Hora {
        return Hora(inicio, fim)
    }
}
