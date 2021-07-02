package br.com.israel.clinicacheckup.marcarConsulta

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.Plantao
import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.cadastrarPaciente.Paciente
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class ConsultaRequest(
    @field:NotBlank val rgPaciente: String,
    @field:NotNull @field:Positive val idPlantao: Long,
    @field:NotNull val plano: Plano
) {
    fun toModel(medico: Medico, paciente: Paciente, plantao: Plantao): Consulta {
        return Consulta(medico = medico, paciente = paciente, plantao = plantao, plano = plano)
    }
}
