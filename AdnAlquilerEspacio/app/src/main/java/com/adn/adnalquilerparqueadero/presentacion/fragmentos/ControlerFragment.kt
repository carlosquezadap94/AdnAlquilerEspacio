package com.adn.adnalquilerparqueadero.presentacion.fragmentos


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adn.adnalquilerparqueadero.R
import com.adn.adnalquilerparqueadero.databinding.FragmentControlerBinding
import com.adn.adnalquilerparqueadero.presentacion.adapters.ParqueaderoPageAdapter
import com.google.android.material.tabs.TabLayoutMediator

const val VEHICULO_PAGE_INDEX = 0

class ControlerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentControlerBinding.inflate(inflater, container, false)

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
            VEHICULO_PAGE_INDEX -> R.drawable.ic_account_balance_black_24dp
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            VEHICULO_PAGE_INDEX -> "ALquiler"
            else -> null
        }
    }

}
