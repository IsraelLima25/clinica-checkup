package br.com.israel.clinicacheckup.cadastrarMedico

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.Plantao
import br.com.israel.clinicacheckup.cadastrarEspecialidade.Especialidade
import br.com.israel.clinicacheckup.marcarConsulta.Consulta
import org.hibernate.annotations.Type
import org.springframework.util.Assert
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.constraints.*

@Entity
class Medico(
    @Id
    @NotBlank
    @Size(max = 4)
    val crm: String,
    @NotBlank
    val nome: String,
    @Past
    @NotNull
    val dataNascimento: LocalDate
) {
    @NotNull
    @Type(type = "org.hibernate.type.UUIDCharType")
    val id: UUID = UUID.randomUUID()

    @NotNull
    @PastOrPresent
    val dataAdmissao: LocalDate = LocalDate.now()

    @OneToOne
    @NotNull
    var especialidade: Especialidade? = null
        private set(value) {
            field = value
        }

    @OneToMany(mappedBy = "medico", cascade = [CascadeType.MERGE])
    var plantoes: MutableList<Plantao> = mutableListOf()
        private set(value) {
            field = value
        }

    @OneToMany(mappedBy = "medico", cascade = [CascadeType.MERGE])
    var consultas: MutableSet<Consulta> = mutableSetOf()
        private set(value) {
            field = value
        }

    fun adicionarEspecialidade(especialidade: Especialidade) {
        Assert.notNull(especialidade, "Um médico não deve ter uma especialidade inválida")
        this.especialidade = especialidade
    }

    fun adicionarPlantao(plantao: Plantao) {
        Assert.notNull(plantao, "Um médico não deve ter um plantão inválido")
        this.plantoes.add(plantao)
    }

    fun adicionarConsulta(consulta: Consulta) {
        Assert.notNull(consulta, "Um médico não deve ter uma consulta inválida")
        this.consultas.add(consulta)
    }
}


