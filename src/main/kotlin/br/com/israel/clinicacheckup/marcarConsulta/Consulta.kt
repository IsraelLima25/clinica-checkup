package br.com.israel.clinicacheckup.marcarConsulta

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.Plantao
import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.cadastrarPaciente.Paciente
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
class Consulta(
    @NotNull medico: Medico,
    @NotNull paciente: Paciente,
    @NotNull plantao: Plantao,
    @NotNull plano: Plano
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    @Enumerated(EnumType.STRING)
    val status: StatusConsulta = StatusConsulta.AGUARDANDO_ATENDIMENTO

    @NotNull
    @ManyToOne
    val medico: Medico = medico

    @NotNull
    @ManyToOne
    val paciente: Paciente = paciente

    @NotNull
    @ManyToOne
    val plantao: Plantao = plantao

    @NotNull
    @Enumerated(EnumType.STRING)
    val plano: Plano = plano
}