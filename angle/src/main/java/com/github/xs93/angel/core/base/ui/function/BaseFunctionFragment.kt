package com.github.xs93.angel.core.base.ui.function

import android.content.Context
import android.os.Bundle
import android.view.View
import com.github.xs93.angel.core.base.ui.base.BaseFragment

/**
 * 基础可添加功能的fragment
 *
 * @author XuShuai
 * @version v1.0
 * @date 2021/11/17 11:14
 */
abstract class BaseFunctionFragment : BaseFragment() {

    private val functions: MutableList<BaseFragmentFunction> = FunctionsManager.createFragmentFunctions()

    override fun onAttach(context: Context) {
        addFunctions()
        super.onAttach(context)
        for (function in functions) {
            function.onAttached(parentFragmentManager, this, context)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for (function in functions) {
            function.onCreated(parentFragmentManager, this, savedInstanceState)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (function in functions) {
            function.onViewCreated(parentFragmentManager, this, view, savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
        for (function in functions) {
            function.onStarted(parentFragmentManager, this)
        }
    }

    override fun onResume() {
        super.onResume()
        for (function in functions) {
            function.onResumed(parentFragmentManager, this)
        }
    }

    override fun onPause() {
        super.onPause()
        for (function in functions) {
            function.onPaused(parentFragmentManager, this)
        }
    }

    override fun onStop() {
        super.onStop()
        for (function in functions) {
            function.onStopped(parentFragmentManager, this)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        for (function in functions) {
            function.onViewDestroyed(parentFragmentManager, this)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        for (function in functions) {
            function.onDestroyed(parentFragmentManager, this)
        }
    }

    override fun onDetach() {
        super.onDetach()
        for (function in functions) {
            function.onDetached(parentFragmentManager, this)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        for (function in functions) {
            function.onSaveInstanceStated(parentFragmentManager, this, outState)
        }
    }

    @Suppress("DEPRECATION")
    @Deprecated("Deprecated in Java")
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        for (function in functions) {
            function.setUserVisibleHinted(parentFragmentManager, this, isVisibleToUser)
        }
    }

    /**
     * 添加界面单独的功能
     */
    open fun addFunctions() {

    }

    fun addFunction(function: BaseFragmentFunction) {
        functions.add(function)
    }
}