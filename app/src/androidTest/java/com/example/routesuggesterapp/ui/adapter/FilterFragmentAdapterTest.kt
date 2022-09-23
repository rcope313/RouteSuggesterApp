package com.example.routesuggesterapp.ui.adapter

import android.view.View
import android.widget.EditText
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.routesuggesterapp.R
import com.example.routesuggesterapp.ui.elements.FilterFragment
import com.example.routesuggesterapp.ui.elements.MainActivity
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilterFragmentAdapterTest {

    @Before
    fun setUp() {
       val scenario = launchFragmentInContainer<FilterFragment>()
    }

    fun typeTextInChildViewWithId(id: Int, textToBeTyped: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                TODO()
            }

            override fun getDescription(): String {
                TODO()
            }

            override fun perform(uiController: UiController, view: View) {
                TODO()
            }
        }
    }
}
