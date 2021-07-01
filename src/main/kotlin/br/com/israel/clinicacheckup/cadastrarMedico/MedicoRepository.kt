package br.com.israel.clinicacheckup.cadastrarMedico

import org.springframework.data.jpa.repository.JpaRepository

interface MedicoRepository : JpaRepository<Medico, String> {
}