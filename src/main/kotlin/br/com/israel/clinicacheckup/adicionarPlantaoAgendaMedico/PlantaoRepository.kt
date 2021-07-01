package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import org.springframework.data.jpa.repository.JpaRepository

interface PlantaoRepository : JpaRepository<Plantao, Long> {
}