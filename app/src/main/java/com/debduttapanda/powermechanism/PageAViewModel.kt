package com.debduttapanda.powermechanism

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PageAViewModel: ViewModel() {
    val negativeText = mutableStateOf("Negative")
    val uiScope = mutableStateOf<UIScope?>(null)
    private val counter = mutableStateOf(0)
    fun onButtonClick() {
        val r = (++counter.value)%2
        when(r){
            1->{
                uiScope.scope {
                    it.toaster?.toast(it.toaster.stringResource(R.string.click_again))
                }
            }
            0->{
                uiScope.scope {
                    it.navHostController?.navigate("page_b")
                }

            }
        }
    }
}