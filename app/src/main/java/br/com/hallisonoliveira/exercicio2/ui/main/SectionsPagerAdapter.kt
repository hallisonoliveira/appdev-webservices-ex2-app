package br.com.hallisonoliveira.exercicio2.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import br.com.hallisonoliveira.exercicio2.R
import br.com.hallisonoliveira.exercicio2.ui.main.mimic.MimicFragment
import br.com.hallisonoliveira.exercicio2.ui.main.number.NumberFragment

private val TAB_TITLES = arrayOf(
    R.string.numbers,
    R.string.mimic
)

class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            NUMBER -> NumberFragment.newInstance()
            else -> MimicFragment.newInstance()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }

    companion object {
        const val NUMBER = 0
        const val MIMIC = 1
    }
}