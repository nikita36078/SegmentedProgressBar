package pt.tornelas.segmentedprogressbar.pager

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import pt.tornelas.segmentedprogressbar.databinding.FragmentPageBinding

private const val PAGE_INDEX = "PAGE_INDEX"

class PageFragment : Fragment(), RequestListener<Drawable> {

    companion object {
        @JvmStatic
        fun newInstance(pageIndex: Int) =
            PageFragment().apply {
                arguments = Bundle().apply {
                    putInt(PAGE_INDEX, pageIndex)
                }
            }
    }

    private var pageIndex: Int = 0
    private var _binding: FragmentPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pageIndex = it.getInt(PAGE_INDEX)
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPageBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE
        val aleatoryIndex = (1..50).random()

        Glide.with(this)
            .load("https://picsum.photos/id/${pageIndex + aleatoryIndex}/400/600")
            .listener(this)
            .into(binding.image)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>,
        isFirstResource: Boolean
    ): Boolean {
        return true
    }

    override fun onResourceReady(
        resource: Drawable,
        model: Any,
        target: Target<Drawable>?,
        dataSource: DataSource,
        isFirstResource: Boolean
    ): Boolean {
        binding.progressBar.visibility = View.GONE
        return false
    }
}
