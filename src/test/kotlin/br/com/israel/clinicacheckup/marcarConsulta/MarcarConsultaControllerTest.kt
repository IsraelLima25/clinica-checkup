package br.com.israel.clinicacheckup.marcarConsulta

import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class MarcarConsultaControllerTest {

    @Test
    fun `consulta deve ser marcada quando houver vagas na agenda do medico`(){
        // TODO
    }

}