import br.com.israel.clinicacheckup.cadastrarEspecialidade.TipoEspecialidade
import br.com.israel.clinicacheckup.cadastrarMedico.Medico
import br.com.israel.clinicacheckup.validators.UniqueValue
import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Past
import javax.validation.constraints.Size

class MedicoRequest(
    @NotBlank @Size(max = 4) crm: String,
    @NotBlank nome: String,
    @NotNull @Past dataNascimento: LocalDate,
    tipoEspecialidade: TipoEspecialidade
) {
    @UniqueValue(domainClass = Medico::class, fieldName = "crm")
    @NotBlank
    @Size(max = 4)
    val crm: String = crm

    @NotBlank
    val nome: String = nome

    @NotNull
    @Past
    val dataNascimento: LocalDate = dataNascimento

    @NotNull
    val tipoEspecialidade: TipoEspecialidade = tipoEspecialidade

    fun toModel(): Medico {
        return Medico(crm = crm, nome = nome, dataNascimento = dataNascimento)
    }

}
