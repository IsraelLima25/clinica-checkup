package br.com.israel.clinicacheckup.cadastrarMedico

import MedicoRequest
import br.com.israel.clinicacheckup.cadastrarEspecialidade.EspecialidadeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/medicos")
class CadastrarMedicoController(
    val medicoRepository: MedicoRepository,
    val especialidadeRepository: EspecialidadeRepository
) {

    @PostMapping
    fun cadastrarMedico(
        @Valid @RequestBody request: MedicoRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Void> {
        val possivelEspecialidade = especialidadeRepository.findBytipoEspecialidade(request.tipoEspecialidade)
        if (!possivelEspecialidade.isPresent) {
            return ResponseEntity.notFound().build()
        }
        val novoMedico = request.toModel()
        novoMedico.adicionarEspecialidade(possivelEspecialidade.get())
        medicoRepository.save(novoMedico)
        return ResponseEntity.created(uri.path("/medicos/{crm}")
            .buildAndExpand(novoMedico.crm).toUri()).build()
    }
}