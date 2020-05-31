package com.alexparpas.sample.process.utils

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit

/**
 * Switch fragment asynchronously.
 * The fragment transaction commit does not happen immediately;
 * it will be scheduled as work on the main thread to be done the next time that thread is ready.
 */
fun FragmentManager.switchFragment(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    clearBackstack: Boolean = true,
    addToBackstack: Boolean = false,
    shouldPopBackStack: Boolean = false
) {
    if (shouldSwitchFragment(this, clearBackstack, fragment)) {
        commit {
            if (shouldPopBackStack) popBackStack()


            replace(containerViewId, fragment, fragment::class.java.canonicalName)

            if (clearBackstack) clearBackStack()
            if (addToBackstack) addToBackStack(fragment::class.java.name)

            setPrimaryNavigationFragment(fragment)
        }
    }
}

private fun FragmentManager.clearBackStack() {
    (1..backStackEntryCount).forEach { _ ->
        try {
            popBackStack()
        } catch (e: IllegalStateException) {
            // There's no way of avoiding this if saveInstanceState has already been called
        }
    }
}

private fun shouldSwitchFragment(fragmentManager: FragmentManager, rootView: Boolean, fragment: Fragment): Boolean {
    val currentFrag = fragmentManager.primaryNavigationFragment
    return currentFrag == null || !rootView || currentFrag::class != fragment::class
}