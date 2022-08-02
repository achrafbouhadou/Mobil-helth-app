package `in`.insideandroid.logintemplate

import `in`.insideandroid.logintemplate.databinding.ActivityLoginBinding
import `in`.insideandroid.logintemplate.databinding.ActivityMainBinding
import `in`.insideandroid.logintemplate.viewModel.MainViewModel
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.view.menu.MenuView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var toggle: ActionBarDrawerToggle
    private val addFragment = AddFragment()
    private val passionFragment = PassionFragment()
    private var section:String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.readFromDataStore.observe(this) { myName ->
            section = myName
        }
        val drawerLayout: DrawerLayout = binding.drawerlayout
        val navView: NavigationView = binding.navMenu
        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        replaceFragment(addFragment)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        var addNavBar = binding.navMenu.menu.findItem(R.id.it_add)
        mainViewModel.readFromDataStore.observe(this) { myName ->
            addNavBar.isVisible = myName.toBoolean()
        }

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.it_list->replaceFragment(passionFragment)
                R.id.it_add->replaceFragment(addFragment)
                R.id.it_logout->changeActivity()
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment!=null){
           val transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.fragment_content,fragment)
            transition.commit()
        }
    }
    private fun changeActivity() {

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}