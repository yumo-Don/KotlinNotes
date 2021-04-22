package com.lollipop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.lollipop.fragment.NumFragment
import com.lollipop.kotlinnotes.databinding.ActivityFragmentTestBinding

/**
 * fragment测试页面
 * fragment的页面回退
 * fragment的状态保存
 */
class FragmentTestActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityFragmentTestBinding
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityFragmentTestBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        testBackStack()
    }

    /**
     * 把fragment加入到回退栈中，点击返回按钮时，会回到上一个fragment
     */
    private fun testBackStack(){
        viewBinding.tvAddFragemnt.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(viewBinding.fragmentContainer.id,NumFragment.newInstance(count.toString()),count.toString())
            transaction.addToBackStack(null)
            transaction.commit()
            count++
        }
    }
}