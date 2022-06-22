package com.debduttapanda.powermechanism

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PageBViewModel: ViewModel() {
    val uiScope = mutableStateOf<UIScope?>(null)
    private val counter = mutableStateOf(0)
    fun onButtonClick() {
        if((++counter.value)%2==1){
            uiScope.scope {
                it.toaster?.toast(it.toaster.stringResource(R.string.click_again))
            }
        }
        else{
            uiScope.scope {
                it.navHostController?.popBackStack()
            }
        }
    }
}