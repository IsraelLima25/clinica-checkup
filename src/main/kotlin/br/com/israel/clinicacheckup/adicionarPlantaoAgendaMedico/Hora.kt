package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity
class Hora(@NotNull val inicio: LocalTime, @NotNull val fim: LocalTime) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
