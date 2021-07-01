package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.validator

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [HoraPlantaoValidator::class])
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class HoraPlantao(
    val message: String = "{br.com.israel.clinicacheckup.horaplantao}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)
