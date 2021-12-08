package com.zalocoders.jetpackcompose.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
 
 private val _name = MutableLiveData("")
 val name:LiveData<String> = _name
 
 fun onNameChanged(newName:String){
  _name.value = newName
 }
 
 
}