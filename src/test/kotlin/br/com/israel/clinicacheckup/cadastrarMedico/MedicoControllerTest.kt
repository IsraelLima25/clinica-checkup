package br.com.israel.clinicacheckup.cadastrarMedico

import MedicoRequest
import br.com.israel.clinicacheckup.cadastrarEspecialidade.Especialidade
import br.com.israel.clinicacheckup.cadastrarEspecialidade.EspecialidadeRepository
import br.com.israel.clinicacheckup.cadastrarEspecialidade.TipoEspecialidade
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.Assert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Month
import java.util.*
import javax.transaction.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("teste")
class MedicoControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val mapper: ObjectMapper
) {

    @MockBean
    lateinit var especialidadeRepositoryMock: EspecialidadeRepository

    @MockBean
    lateinit var medicoRepositoryMock: MedicoRepository

    var medicoRequest1: MedicoRequest? = null
    var especialidade: Especialidade? = null

    @BeforeEach
    fun init() {
        medicoRequest1 = MedicoRequest(
            "1518", "Dr. Mateus",
            LocalDate.of(1985, Month.APRIL.value, 10), TipoEspecialidade.DENTISTA
        )
        especialidade = Especialidade(TipoEspecialidade.DENTISTA, BigDecimal("400.00"))

    }

    @Test
    fun `deve cadastrar medico com sucesso`() {
        `when`(especialidadeRepositoryMock.findBytipoEspecialidade(TipoEspecialidade.DENTISTA))
            .thenReturn(Optional.ofNullable(especialidade))
        `when`(medicoRepositoryMock.save(medicoRequest1!!.toModel())).thenReturn(medicoRequest1?.toModel())
        mockMvc.perform(
            post("/medicos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper(medicoRequest1!!))
        ).andExpect(status().isCreated)
    }

    private fun mapper(obj: Any) = mapper.writeValueAsString(obj)
}
