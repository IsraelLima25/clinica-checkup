package br.com.israel.clinicacheckup.cadastrarEspecialidade

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*

@Service
interface EspecialidadeRepository : JpaRepository<Especialidade, Long> {

    fun findBytipoEspecialidade(tipoEspecialidade: TipoEspecialidade): Optional<Especialidade>
}