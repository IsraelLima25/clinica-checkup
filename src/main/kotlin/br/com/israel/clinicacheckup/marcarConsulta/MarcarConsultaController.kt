package br.com.israel.clinicacheckup.marcarConsulta

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.PlantaoRepository
import br.com.israel.clinicacheckup.cadastrarMedico.MedicoRepository
import br.com.israel.clinicacheckup.cadastrarPaciente.PacienteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/consultas")
class MarcarConsultaController(
    @Autowired
    val medicoRepository: MedicoRepository,
    @Autowired
    val pacienteRepository: PacienteRepository,
    @Autowired
    val plantaoRepository: PlantaoRepository
) {

    @PostMapping("/marcar/{crmMedico}")
    fun marcarConsulta(
        @Valid @RequestBody request: ConsultaRequest,
        @PathVariable crmMedico: String
    ): ResponseEntity<Void> {

        val possivelMedico = medicoRepository.findById(crmMedico)
        val possivelPaciente = pacienteRepository.findByRg(request.rgPaciente)
        val possivelPlantao = plantaoRepository.findById(request.idPlantao)
        if (!possivelPaciente.isPresent || !possivelMedico.isPresent) {
            return ResponseEntity.notFound().build()
        }
        val medico = possivelMedico.get()
        val paciente = possivelPaciente.get()
        val plantao = possivelPlantao.get()
        val consulta = request.toModel(medico = medico, paciente = paciente, plantao = plantao)
        medico.adicionarConsulta(consulta)
        medicoRepository.save(medico)
        return ResponseEntity.ok().build()
    }

}