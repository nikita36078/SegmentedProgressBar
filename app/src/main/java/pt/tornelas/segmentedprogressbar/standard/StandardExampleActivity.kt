package pt.tornelas.segmentedprogressbar.standard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.tornelas.segmentedprogressbar.SegmentedProgressBarListener
import pt.tornelas.segmentedprogressbar.dataSource
import pt.tornelas.segmentedprogressbar.databinding.ActivityStandardExampleBinding
import pt.tornelas.segmentedprogressbar.pager.PagerAdapter

class StandardExampleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStandardExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStandardExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = dataSource()

        with(binding) {
            pagerLayout.viewPager.adapter = PagerAdapter(supportFragmentManager, items)
            spb.viewPager = pagerLayout.viewPager

            spb.segmentCount = items.size
            spb.listener = object : SegmentedProgressBarListener {
                override fun onPage(oldPageIndex: Int, newPageIndex: Int) {
                    // New page started animating
                }

                override fun onFinished() {
                    finish()
                }
            }
            spb.start()

            pagerLayout.btnNext.setOnClickListener { spb.next() }
            pagerLayout.btnPrevious.setOnClickListener { spb.previous() }
        }
    }
}
