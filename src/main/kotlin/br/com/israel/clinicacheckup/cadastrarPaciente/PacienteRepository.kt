package br.com.israel.clinicacheckup.cadastrarPaciente

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PacienteRepository : JpaRepository<Paciente, UUID> {

    fun findByRg(rg: String): Optional<Paciente>

}
