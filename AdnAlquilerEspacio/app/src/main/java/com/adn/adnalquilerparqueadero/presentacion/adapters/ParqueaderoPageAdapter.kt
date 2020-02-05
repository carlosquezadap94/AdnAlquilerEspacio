package com.adn.adnalquilerparqueadero.presentacion.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.AlquilerListFragment

const val VEHICULO_PAGE_INDEX = 0

class ParqueaderoPageAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        VEHICULO_PAGE_INDEX to { AlquilerListFragment() }
    )

    override fun getItemCount(): Int {
        return tabFragmentsCreators.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}