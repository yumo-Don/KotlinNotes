package com.lollipop.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lollipop.kotlinnotes.R
import com.lollipop.kotlinnotes.databinding.FragmentNumBinding

private const val ARG_PARAM1 = "param1"


class NumFragment : Fragment() {

    private var _viewBinding: FragmentNumBinding? = null
    private val viewBinding get() = _viewBinding!!

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentNumBinding.inflate(layoutInflater,container,false)
        viewBinding.tvContent.text = param1
        return viewBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String) =
            NumFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }
}