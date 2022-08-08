package `in`.insideandroid.logintemplate

import `in`.insideandroid.logintemplate.databinding.FragmentPassionBinding
import `in`.insideandroid.logintemplate.databinding.FragmentProfileBinding
import `in`.insideandroid.logintemplate.viewModel.MainViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider


class ProfileFragment : Fragment(R.layout.fragment_profile) {
    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!
    private lateinit var mainViewModel: MainViewModel



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mainViewModel.readFromDataStore.observe(viewLifecycleOwner) { myName ->
            binding.topLayoutProfil.tvDelete.isVisible = myName.toBoolean()
            binding.buttonModifier.isVisible = myName.toBoolean()
        }
        binding.topLayoutProfil.ivPassionFragment.setOnClickListener(){

            replaceFragment(PassionFragment())
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