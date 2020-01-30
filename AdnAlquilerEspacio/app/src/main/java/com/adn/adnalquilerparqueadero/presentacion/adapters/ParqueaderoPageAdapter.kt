package com.adn.adnalquilerparqueadero.presentacion.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.AutoFragment
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.MotoListFragment
import com.adn.adnalquilerparqueadero.presentacion.fragmentos.ResumenFragment

const val MY_PARQUEADERO_RESUMEN_INDEX = 0
const val MOTO_PAGE_INDEX = 1
const val AUTO_PAGE_INDEX = 2



class ParqueaderoPageAdapter(fragment: Fragment) :FragmentStateAdapter(fragment)
   {


       private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
           MY_PARQUEADERO_RESUMEN_INDEX to { ResumenFragment() },
           MOTO_PAGE_INDEX to { MotoListFragment() },
           AUTO_PAGE_INDEX to { AutoFragment() }
       )

       override fun getItemCount(): Int {
            return tabFragmentsCreators.size
       }


       //Buscar implementacion invoke
       override fun createFragment(position: Int): Fragment {
           return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
       }

   }