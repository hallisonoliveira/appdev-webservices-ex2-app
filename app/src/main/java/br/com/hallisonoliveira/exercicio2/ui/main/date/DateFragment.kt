package br.com.hallisonoliveira.exercicio2.ui.main.date

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.hallisonoliveira.exercicio2.R
import br.com.hallisonoliveira.exercicio2.util.DateUtils
import kotlinx.android.synthetic.main.fragment_date.*
import org.threeten.bp.LocalDate

class DateFragment : Fragment() {

    private lateinit var viewModel: DateViewModel

    private var startDate: LocalDate? = null
    private var endDate: LocalDate? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DateViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_date, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Registro de um observador que será acionado quando os dados forem recebidos
        viewModel.dateLiveData.observe(viewLifecycleOwner, Observer { date ->
            differenceInDaysValue.text = context!!.getString(R.string.difference_in_days, date.differenceInDays)
            differenceInWeeksValue.text = context!!.getString(R.string.difference_in_weeks, date.differenceInWeeks)
            differenceInMonthsValue.text = context!!.getString(R.string.difference_in_months, date.differenceInMonths)
        })

        startDateButton.setOnClickListener {
            val localDate = LocalDate.now()
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    setStartDate(LocalDate.of(year, month + 1, dayOfMonth))
                }, localDate.year, localDate.monthValue - 1, localDate.dayOfMonth
            ).show()
        }

        endDateButton.setOnClickListener {
            val localDate = LocalDate.now()
            DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                    setEndDate(LocalDate.of(year, month + 1, dayOfMonth))
                }, localDate.year, localDate.monthValue - 1, localDate.dayOfMonth
            ).show()
        }

        // Acão para o clique do botão
        sendButton.setOnClickListener {
            try {
                if (startDate != null && endDate != null) {
                    viewModel.getDateDifferences(
                        DateUtils().toDateTime(startDate!!),
                        DateUtils().toDateTime(endDate!!)
                    )
                }
            } catch (e: Exception) { // Tratamento de erro
                Log.e(DateFragment::class.java.simpleName, e.toString())
                Toast.makeText(context, R.string.request_error, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setStartDate(date: LocalDate) {
        startDateLabel.text = getString(R.string.start_date, DateUtils().formatDateToShow(date))
        startDate = date
    }

    private fun setEndDate(date: LocalDate) {
        endDateLabel.text = getString(R.string.end_date, DateUtils().formatDateToShow(date))
        endDate = date
    }

    companion object {
        @JvmStatic
        fun newInstance(): DateFragment {
            return DateFragment()
        }
    }
}