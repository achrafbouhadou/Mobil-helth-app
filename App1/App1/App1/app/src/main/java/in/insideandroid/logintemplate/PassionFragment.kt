package `in`.insideandroid.logintemplate

import `in`.insideandroid.logintemplate.databinding.FragmentAddBinding
import `in`.insideandroid.logintemplate.databinding.FragmentPassionBinding
import `in`.insideandroid.logintemplate.viewModel.MainViewModel
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_passion.*
import kotlinx.android.synthetic.main.top_bare_layout.*


class PassionFragment : Fragment(R.layout.fragment_passion) {

    private var _binding: FragmentPassionBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel
    private val profileFragment = ProfileFragment()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPassionBinding.inflate(inflater,container,false)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
       binding.passionProfile.setOnClickListener(){
           replaceFragment(profileFragment)
       }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    private fun  replaceFragment(fragment: Fragment){
        val transition = fragmentManager?.beginTransaction()
        transition?.replace(R.id.fragment_content,fragment)
        transition?.commit()
    }

}