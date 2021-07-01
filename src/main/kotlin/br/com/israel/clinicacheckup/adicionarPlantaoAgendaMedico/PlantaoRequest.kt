package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.*

class PlantaoRequest(crmMedico: String, data: LocalDate, hora: HoraRequest, quantidadePacientesPermitidos: Int) {

    @NotBlank
    @Size(max = 4)
    val crmMedico: String = crmMedico

    @NotNull
    @FutureOrPresent
    val data: LocalDate = data

    @Valid
    val hora: HoraRequest = hora

    @NotNull
    @Positive
    val quantidadePacientesPermitidos: Int = quantidadePacientesPermitidos

    fun toModel(medico: Medico): Plantao {
        return Plantao(
            medico = medico,
            data = data,
            hora = hora.toModel(),
            quantidadePacientesPermitidos = quantidadePacientesPermitidos
        )
    }


}
