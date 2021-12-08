package com.zalocoders.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.zalocoders.jetpackcompose.ui.MainViewModel
import com.zalocoders.jetpackcompose.ui.theme.JetPackcomposeTheme

class MainActivity : ComponentActivity() {
	
	private val mainViewModel:MainViewModel by viewModels()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			JetPackcomposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					ScreenContent2(mainViewModel = mainViewModel)
					Divider()
					ExpandableCard("zalo","This is a test body where zalo is tallinf")
				}
			}
		}
	}
}


@Composable
fun ScreenContent2(
		mainViewModel: MainViewModel
){
	val name:String by mainViewModel.name.observeAsState("")
	
	TextField(
			value = name,
			onValueChange = {mainViewModel.onNameChanged(it)},
			label = { Text(text = "Name")}
	)
	
}

@Composable
fun ExpandableCard(title:String,body:String){
	var isExpanded by remember{ mutableStateOf(false)}
	
	Card {
		Column {
			Text(text = title)
			if(isExpanded){
				Text(text = body)
				IconButton(onClick = {isExpanded = false}) {
					Icon(Icons.Default.AccountBox, contentDescription = "Collapse")
				}
			}else{
				IconButton(onClick = {isExpanded = true}) {
					Icon(Icons.Default.Person, contentDescription = "Expand")
					Text(text = body)
				}
			}
		}
		
	}
	
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	
	JetPackcomposeTheme {
		JetPackcomposeTheme {
		
		}
	}
}