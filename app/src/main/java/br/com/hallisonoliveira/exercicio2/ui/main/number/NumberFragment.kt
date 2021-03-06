package br.com.hallisonoliveira.exercicio2.ui.main.number

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
import kotlinx.android.synthetic.main.fragment_mimic.sendButton
import kotlinx.android.synthetic.main.fragment_mimic.textToConvertEditText
import kotlinx.android.synthetic.main.fragment_number.*

class NumberFragment : Fragment() {

    private lateinit var viewModel: NumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NumberViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_number, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Registro de um observador que será acionado quando os dados forem recebidos
        viewModel.numbersLiveData.observe(viewLifecycleOwner, Observer { numbers ->
            increasingListValue.text = numbers.increasingOrder.toString()
            decreasingListValue.text = numbers.decreasingOrder.toString()
            pairListValue.text = numbers.pairList.toString()
        })

        // Acão para o clique do botão
        sendButton.setOnClickListener {
            try {
                viewModel.getClassifiedNumbers(textToConvertEditText.text.toString().trim())
            } catch (e: Exception) { // Tratamento de erro
                Log.e(NumberFragment::class.java.simpleName, e.toString())
                Toast.makeText(
                    context,
                    getString(R.string.request_error),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): NumberFragment {
            return NumberFragment()
        }
    }
}