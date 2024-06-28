package com.o5appstudio.retrofitconcepts

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.o5appstudio.retrofitconcepts.api.ApiResponse
import com.o5appstudio.retrofitconcepts.databinding.ActivityMainBinding
import com.o5appstudio.retrofitconcepts.models.StoreData
import com.o5appstudio.retrofitconcepts.viewmodel.StoreViewModel
import com.o5appstudio.retrofitconcepts.viewmodel.StoreViewModel2
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var storeViewModel: StoreViewModel
    private lateinit var storeViewModel2: StoreViewModel2
    lateinit var binding : ActivityMainBinding
    var prog  = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        storeViewModel = ViewModelProvider.create(this)[StoreViewModel::class.java]
        storeViewModel2 = ViewModelProvider.create(this)[StoreViewModel2::class.java]

//        storeViewModel.productsList.observe(this) {
//
//            if(it.isEmpty()){
//                binding.text.text = "Loading"
//            } else {
//                binding.text.text = "Data Loaded"
//                Log.d("TAG", (it[1].rating.rate).toString())
//            }
//
//
//
//
//        }

        CoroutineScope(Dispatchers.IO).launch {
//            val result = storeViewModel2.fetchData()
//            result.collect{
//                Log.d("TAG",it.toString())
//            }



            storeViewModel2.productsList.collect{


                when(it){
                    is ApiResponse.Failure -> {
                        Log.d("TAG",it.errorMsg.toString())
                    }
                    is ApiResponse.Loading -> {
                        prog = true
                        Log.d("TAG","Loading and progress ${prog}")
                    }
                    is ApiResponse.Success -> {
                        prog = false
                        Log.d("TAG","Loaded and progress ${prog}")

                        Log.d("TAG",it.data.toString())
                    }
                }
            }




//
        }








    }
}