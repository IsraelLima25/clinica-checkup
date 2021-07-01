package br.com.israel.clinicacheckup.validators

import org.springframework.util.Assert
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class UniqueValueValidator(
    @PersistenceContext
    val manager: EntityManager

) : ConstraintValidator<UniqueValue, String> {

    var domainAttribute: String = ""
    var klass: KClass<out Any>? = null

    override fun initialize(params: UniqueValue?) {
        this.domainAttribute = params?.fieldName ?: ""
        this.klass = params?.domainClass ?: klass
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        val query: Query = manager
            .createQuery("select 1 from " + klass?.simpleName + " where " + domainAttribute + "=:value")
        query.setParameter("value", value)
        val list = query.resultList
        Assert.state(list.size <= 1, "Foi encontrado mais de um " + klass?.simpleName + " com o mesmo valor");
        return list.isEmpty()
    }
}
