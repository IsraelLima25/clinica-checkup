package br.com.israel.clinicacheckup.cadastrarMedico

import br.com.israel.clinicacheckup.cadastrarEspecialidade.Especialidade
import br.com.israel.clinicacheckup.cadastrarEspecialidade.EspecialidadeRepository
import br.com.israel.clinicacheckup.cadastrarEspecialidade.TipoEspecialidade
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureDataJpa
@ActiveProfiles("teste")
class MedicoControllerIntegrationTest(
    @Autowired val mock: MockMvc, @Autowired val medicoRepository: MedicoRepository,
    @Autowired val especialidadeRepository: EspecialidadeRepository,
    @Autowired val mapper: ObjectMapper
) {

    var especialidade: Especialidade? = null
    var medico: Medico? = null

    @Transactional
    @Test
    fun `crm do medico não deve ser repetido`() {
        especialidade = Especialidade(TipoEspecialidade.CARDIOLOGISTA, BigDecimal("400.0"))
        Assert.assertTrue(true)
        val especialidadeSalva = especialidadeRepository.save(especialidade!!)
        medico = Medico("1518", "Mateus", LocalDate.of(1985, Month.APRIL.value, 10))
        medico?.adicionarEspecialidade(especialidadeSalva!!)
        medicoRepository.save(medico!!)
        mock.perform(
            post("/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper(medico!!))
        ).andExpect(status().isBadRequest)
    }

    private fun mapper(obj: Any) = mapper.writeValueAsString(obj)
}