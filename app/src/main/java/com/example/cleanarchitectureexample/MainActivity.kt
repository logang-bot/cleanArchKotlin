package com.example.cleanarchitectureexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleanarchitectureexample.data.remote.RetrofitClient
import com.example.cleanarchitectureexample.data.repository.ApiInterface
import com.example.cleanarchitectureexample.databinding.ActivityMainBinding
import com.example.cleanarchitectureexample.domain.model.User
import com.example.cleanarchitectureexample.presentation.adapters.UserAdapter
import com.example.cleanarchitectureexample.presentation.viewmodel.UserViewModel
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: UserAdapter

    // CLEAN ARCHITECTURE
    private var viewmodel = UserViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)
//        val userList = mutableListOf(User(3, "fddd", "fds", "fds", "fds", "fds"), User(3, "fd", "fds", "fds", "fds", "fds"))
//        adapter = UserAdapter(userList)
//        updateRecycler()
//        getUserList() -< old way


        // Using Clean Architecture
        fun aux() {
            val userList = viewmodel.usersList
            adapter = UserAdapter(userList)
            updateRecycler()
        }

        viewmodel.getUsersDataFromApi(::aux)

    }

    // CLEAN ARCHITECTURE






    // OLD METHOD
    fun getUserList(){
        var retrofit = RetrofitClient.getInstance()
        var apiInterface = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            try {
                val response = apiInterface.getAllUsers()
                if (response.isSuccessful) {
                    Log.d("Info", response.body()?.size.toString())
                    val userList = response.body()?.toMutableList() as MutableList
                    adapter = UserAdapter(userList)
                    updateRecycler()
                } else {
                    Toast.makeText(this@MainActivity, response.errorBody().toString(), Toast.LENGTH_LONG).show()
                }
            } catch (Ex: Exception) {
                Log.e("Error", Ex.localizedMessage as String)
            }
        }
    }
    fun updateRecycler() {
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }
}