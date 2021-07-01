package br.com.israel.clinicacheckup.marcarConsulta

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.Plantao
import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.cadastrarPaciente.Paciente
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

class ConsultaRequest(rgPaciente: String, idPlantao: Long, plano: Plano) {
    @NotBlank
    val rgPaciente: String = rgPaciente

    @NotNull
    @Positive
    val idPlantao: Long = idPlantao

    @NotNull
    val plano: Plano = plano

    fun toModel(medico: Medico, paciente: Paciente, plantao: Plantao): Consulta {
        return Consulta(medico = medico, paciente = paciente, plantao = plantao, plano = plano)
    }
}
