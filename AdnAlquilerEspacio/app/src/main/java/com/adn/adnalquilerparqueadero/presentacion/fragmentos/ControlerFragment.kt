package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentControlerBinding
import com.adn.adnalquilerparqueadero.presentacion.adapters.ParqueaderoPageAdapter
import com.google.android.material.tabs.TabLayoutMediator

/**
 * A simple [Fragment] subclass.
 */

const val MY_PARQUEADERO_RESUMEN_INDEX = 0
const val MOTO_PAGE_INDEX = 1
const val AUTO_PAGE_INDEX = 2

class ControlerFragment : Fragment()
{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        val binding = FragmentControlerBinding.inflate(inflater,container,false)

        val viewPager = binding.viewPager
        viewPager.adapter = ParqueaderoPageAdapter(this)

        val tabLayout = binding.tabLayout
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()








        return binding.root
    }



    private fun getTabIcon(position: Int): Int {
        return when (position) {
            MY_PARQUEADERO_RESUMEN_INDEX -> R.drawable.resumen_tab_selection
            MOTO_PAGE_INDEX -> R.drawable.moto_tab_seleted
            AUTO_PAGE_INDEX -> R.drawable.car_tab_selection
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            MY_PARQUEADERO_RESUMEN_INDEX -> getString(R.string.resumen)
            MOTO_PAGE_INDEX -> getString(R.string.motocicletas)
            AUTO_PAGE_INDEX-> getString(R.string.automoviles)
            else -> null
        }
    }

}
