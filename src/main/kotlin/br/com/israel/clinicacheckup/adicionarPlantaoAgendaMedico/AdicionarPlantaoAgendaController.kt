package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.cadastrarMedico.MedicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/plantoes")
class AdicionarPlantaoAgendaController(
    @Autowired
    val medicoRepository: MedicoRepository
) {

    @PostMapping
    fun adicionarPlantao(@Valid @RequestBody request: PlantaoRequest): ResponseEntity<Void> {
        val possivelMedico: Optional<Medico> = medicoRepository.findById(request.crmMedico)
        if (!possivelMedico.isPresent) {
            return ResponseEntity.notFound().build()
        }
        val medico: Medico = possivelMedico.get()
        val novoPlantao: Plantao = request.toModel(possivelMedico.get())
        medico.adicionarPlantao(novoPlantao)
        medicoRepository.save(medico)
        return ResponseEntity.ok().build()
    }
}