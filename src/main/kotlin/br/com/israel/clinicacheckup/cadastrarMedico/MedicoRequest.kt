import br.com.israel.clinicacheckup.cadastrarEspecialidade.TipoEspecialidade
import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.validators.UniqueValue
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

data class MedicoRequest(
    @field:NotBlank @field:Size(max = 4) @field:UniqueValue(domainClass = Medico::class, fieldName = "crm")
    val crm: String,
    @field:NotBlank val nome: String,
    @field:NotNull @field:Past val dataNascimento: LocalDate,
    @field:NotNull val tipoEspecialidade: TipoEspecialidade
) {
    fun toModel(): Medico {
        return Medico(crm = crm, nome = nome, dataNascimento = dataNascimento)
    }
}
