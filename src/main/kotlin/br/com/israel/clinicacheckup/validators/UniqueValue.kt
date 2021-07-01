package br.com.israel.clinicacheckup.validators

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Constraint(validatedBy = [UniqueValueValidator::class])
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class UniqueValue(
    val message: String = "{br.com.israel.clinicacheckup.uniqueValue}",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = [],
    val fieldName: String,
    val domainClass: KClass<out Any>
)


