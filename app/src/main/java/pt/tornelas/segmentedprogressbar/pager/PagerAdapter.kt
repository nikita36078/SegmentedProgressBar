package pt.tornelas.segmentedprogressbar.pager

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: FragmentActivity, private val items: List<Int>):
    FragmentStateAdapter(activity) {

    override fun createFragment(position: Int) = PageFragment.newInstance(items[position])

    override fun getItemCount() = items.size
}