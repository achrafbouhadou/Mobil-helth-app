package `in`.insideandroid.logintemplate

import `in`.insideandroid.logintemplate.databinding.ActivityMainBinding
import `in`.insideandroid.logintemplate.databinding.FragmentAddBinding
import `in`.insideandroid.logintemplate.viewModel.MainViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_add.*


class AddFragment : Fragment(R.layout.fragment_add) {

    private var _binding:FragmentAddBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddBinding.inflate(inflater,container,false)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}