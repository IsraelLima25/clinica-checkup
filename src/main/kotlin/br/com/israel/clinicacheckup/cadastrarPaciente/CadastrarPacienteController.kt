package br.com.israel.clinicacheckup.cadastrarPaciente

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/pacientes")
class CadastrarPacienteController(
    @Autowired
    val pacienteRepository: PacienteRepository
) {

    @PostMapping
    fun cadastrarPaciente(
        @Valid @RequestBody request: PacienteRequest,
        uri: UriComponentsBuilder
    ): ResponseEntity<Void> {
        val novoPaciente = request.toModel()
        val pacienteSalvo = pacienteRepository.save(novoPaciente)
        return ResponseEntity.created(
            uri.path("/pacientes/{id}")
                .buildAndExpand(pacienteSalvo.id).toUri()
        )
            .build()
    }
}