package br.com.hallisonoliveira.exercicio2.ui.main.mimic

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
import kotlinx.android.synthetic.main.fragment_mimic.*

class MimicFragment : Fragment() {

    private lateinit var viewModel: MimicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MimicViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mimic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Registro de um observador que será acionado quando os dados forem recebidos
        viewModel.mimicTextLiveData.observe(viewLifecycleOwner, Observer { mimicText ->
            resultTextView.text = mimicText.mimicText
        })

        // Acão para o clique do botão
        sendButton.setOnClickListener {
            try {
                viewModel.getMimicText(textToConvertEditText.text.toString().trim())
            } catch (e: Exception) { // Tratamento de erro
                Log.e(MimicFragment::class.java.simpleName, e.toString())
                Toast.makeText(context, R.string.request_error, Toast.LENGTH_LONG).show()
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(): MimicFragment {
            return MimicFragment()
        }
    }
}