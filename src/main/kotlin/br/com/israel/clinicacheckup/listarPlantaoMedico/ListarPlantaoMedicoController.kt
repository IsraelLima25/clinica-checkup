package br.com.israel.clinicacheckup.listarPlantaoMedico

import br.com.israel.clinicacheckup.cadastrarMedico.MedicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/plantoes")
class ListarPlantaoMedicoController(
    @Autowired
    val medicoRepository: MedicoRepository
) {

    @GetMapping("/{crm}")
    fun listarPlantao(@PathVariable crm: String): ResponseEntity<List<PlantaoResponse>> {
        val possivelMedico = medicoRepository.findById(crm)
        if (!possivelMedico.isPresent) {
            return ResponseEntity.notFound().build()
        }
        val medico = possivelMedico.get()
        return ResponseEntity.ok().body(
            medico.plantoes.map { plantao ->
                PlantaoResponse(plantao.data, HoraResponse(plantao.hora.inicio, plantao.hora.fim))
            }.toList()
        )
    }
}