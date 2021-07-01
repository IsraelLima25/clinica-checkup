package br.com.israel.clinicacheckup.cadastrarEspecialidade

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/especialidades")
class CadastrarEspecialidadeController(
    @Autowired
    val especialidadeRepository: EspecialidadeRepository
) {

    @PostMapping
    @Transactional
    fun cadastrarEspecialidade(
        @Valid @RequestBody request: EspecialidadeRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Void> {
        val novaEspecialidade = request.toModel()
        val especialidadeSalva = especialidadeRepository.save(novaEspecialidade)
        return ResponseEntity.created(
            uri.path("/especialidades/{id}")
                .buildAndExpand(especialidadeSalva.id).toUri()
        )
            .build()
    }
}