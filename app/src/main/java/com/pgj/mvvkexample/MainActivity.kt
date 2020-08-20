package com.pgj.mvvkexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pgj.mvvkexample.model.App
import com.pgj.mvvkexample.model.AppList
import com.pgj.mvvkexample.mvvk.MySharePreference
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        save_data.setOnClickListener {
            MySharePreference.putString(this,"username",et_input.text.toString())
        }

        check_data.setOnClickListener {
            data_show.text=MySharePreference.getString(this,"username")
        }

        save_object.setOnClickListener {
            val apps= mutableListOf<App>()
            for(i in 0..5){
                val app=App(i,"app$i")
                apps.add(app)
            }
            val appList=AppList(apps)
            MySharePreference.putObject(this,"apps",appList)
            Toast.makeText(this,"对象已保存",Toast.LENGTH_LONG).show()
        }

        read_object.setOnClickListener {
            val appList=MySharePreference.getObject(this,"apps",AppList::class.java)
            val stringBuilder=StringBuilder()
            appList!!.apps!!.forEach {
                stringBuilder.append("id = ${it.id}.name=${it.name}\n")
            }
            Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show()
        }
    }
}