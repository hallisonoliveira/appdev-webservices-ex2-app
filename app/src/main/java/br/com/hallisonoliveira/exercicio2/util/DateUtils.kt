package br.com.hallisonoliveira.exercicio2.util

import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.*

class DateUtils {

    fun locale() = Locale("pt", "BR")

    fun formatDateToShow(localDate: LocalDate) : String {
        return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(locale()))
    }

    fun toDateTime(date: LocalDate): String {
        val dateTime = date.atStartOfDay()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")
        return formatter.format(dateTime)
    }
}