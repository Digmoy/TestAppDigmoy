package com.example.testappdigmoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testappdigmoy.databinding.ActivityMainBinding
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(),ItemAdapter.DeleteItem {

    private var modelList : ArrayList<String> = ArrayList()
    private lateinit var adapter : ItemAdapter

    private var input : String  = ""

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.edInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(arg0: Editable) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int) {

            }

            override fun onTextChanged(
                s: CharSequence, start: Int, before: Int,
                count: Int
            ) {
                if(s.toString() == "")
                {

                }
                else
                {
                    val lastChar = s.toString().substring(s.length - 1)
                    if (lastChar == " ") {

                        input = binding.edInput.text.toString().trim()
                        Log.d("input",""+input)
                        binding.recItem.visibility = View.VISIBLE
                        modelList.add(input)
                        println(modelList)
                        adapter = ItemAdapter(this@MainActivity,modelList,this@MainActivity)
                        binding.recItem.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.edInput.setText("")

                    }
                    else if (lastChar == ",")
                    {
                        input = binding.edInput.text.toString().trim().replace(",","")
                        Log.d("input",""+input)
                        binding.recItem.visibility = View.VISIBLE
                        modelList.add(input)
                        println(modelList)
                        adapter = ItemAdapter(this@MainActivity,modelList,this@MainActivity)
                        binding.recItem.adapter = adapter
                        adapter.notifyDataSetChanged()
                        binding.edInput.setText("")
                    }
                }

            }
        })


    }

    override fun delete(position: Int) {
        modelList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}