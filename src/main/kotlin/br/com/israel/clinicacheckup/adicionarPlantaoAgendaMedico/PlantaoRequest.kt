package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.*

class PlantaoRequest(
    @field:NotBlank @field:Size(max = 4) val crmMedico: String,
    @field:NotNull @field:FutureOrPresent val data: LocalDate,
    @field:Valid val hora: HoraRequest,
    @field:NotNull @field:Positive val quantidadePacientesPermitidos: Int
) {

    fun toModel(medico: Medico): Plantao {
        return Plantao(
            medico = medico,
            data = data,
            hora = hora.toModel(),
            quantidadePacientesPermitidos = quantidadePacientesPermitidos
        )
    }
}
