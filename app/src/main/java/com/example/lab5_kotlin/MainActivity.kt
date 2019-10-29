package com.example.lab5_kotlin

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.DialogInterface
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.lab5_kotlin.R.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        val btn = findViewById(id.button) as Button
        btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View) {
                val dialog = AlertDialog.Builder(this@MainActivity)
                dialog.setTitle("请编辑功能")
                dialog.setMessage("请根据下方按钮选择要显示的物件")
                dialog.setNeutralButton("取消", object : DialogInterface.OnClickListener{
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        Toast.makeText(this@MainActivity, "dialog关闭", Toast.LENGTH_SHORT).show()
                    }
                })
                dialog.setNeutralButton("自定义Toast", object : DialogInterface.OnClickListener {
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        showToast()
                    }
                })
                dialog.setPositiveButton("显示list", object : DialogInterface.OnClickListener{
                    override fun onClick(dialogInterface: DialogInterface, i: Int) {
                        showListDialog()
                    }
                })
                dialog.show()
            }
        })
    }

    private fun showToast() {
        val toast = Toast(this@MainActivity)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.setDuration(Toast.LENGTH_SHORT)
        val inflater = getLayoutInflater()
        val layout = inflater.inflate(
                layout.custom_toast,
                findViewById(id.custom_toast_root) as ViewGroup
        )
        toast.setView(layout)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("message1", "message2", "message3", "message4", "message5")
        val dialog_List = AlertDialog.Builder(this@MainActivity)
        dialog_List.setTitle("使用LIST呈现")
        dialog_List.setItems(list, object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface, i: Int) {
                Toast.makeText(this@MainActivity, "你选得是" + list[i], Toast.LENGTH_SHORT).show()
            }
        })
        dialog_List.show()
    }
}



