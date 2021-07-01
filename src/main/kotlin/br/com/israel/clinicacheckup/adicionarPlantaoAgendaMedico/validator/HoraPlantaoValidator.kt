package br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.validator

import br.com.israel.clinicacheckup.adicionarPlantaoAgendaMedico.HoraRequest
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class HoraPlantaoValidator : ConstraintValidator<HoraPlantao, HoraRequest> {

    override fun isValid(value: HoraRequest?, context: ConstraintValidatorContext?): Boolean {
        val resultadoComparacao: Boolean = value?.let {
            (value.inicio.compareTo(value.fim)) < 0 && (value.fim.compareTo(value.inicio)) > 0
        } == true
        return resultadoComparacao
    }
}
