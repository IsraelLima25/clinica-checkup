package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico

import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import java.time.LocalDate
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.FutureOrPresent
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Plantao(
    @NotNull medico: Medico,
    @NotNull @FutureOrPresent val data: LocalDate,
    @NotNull hora: Hora,
    @NotNull @Positive val quantidadePacientesPermitidos: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    // TODO implementar scheduller para no dia seguinte fechar o plantão
    @Enumerated(EnumType.STRING)
    val statusPlantao: StatusPlantao = StatusPlantao.ABERTO

    @NotNull
    @Valid
    @OneToOne(cascade = [CascadeType.MERGE])
    val hora: Hora = hora

    @ManyToOne
    val medico: Medico = medico
}
