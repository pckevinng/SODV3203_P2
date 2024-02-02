package com.example.lemonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonapp.ui.theme.LemonAppTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var currentStep by remember { mutableStateOf(1) }
    var clickCount by remember { mutableStateOf(0) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_tree),
                        contentDescription = "Tap the lemon tree to select a lemon",
                        modifier = Modifier
                            .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(4.dp))
                            .wrapContentSize()
                            .clickable {
                                currentStep = 2
                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Tap the lemon tree to select a lemon",
                        fontSize = 18.sp)
                }
            }
            2 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_squeeze),
                        contentDescription = "Keep tapping the lemon to squeeze it",
                        modifier = Modifier
                            .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(4.dp))
                            .wrapContentSize()
                            .clickable {
                                clickCount++
                                if(clickCount == (2..4).random())
                                {
                                    currentStep = 3
                                    clickCount = 0
                                }

                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Keep tapping the lemon to squeeze it",
                        fontSize = 18.sp)
                }
            }
            3 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_drink),
                        contentDescription = "Tap the lemonade to drink it",
                        modifier = Modifier
                            .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(4.dp))
                            .wrapContentSize()
                            .clickable {
                                currentStep = 4
                            }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    Text(text = "Tap the lemonade to drink it",
                        fontSize = 18.sp)
                }
            }
            4 -> {
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ){
                    Image(
                        painter = painterResource(R.drawable.lemon_restart),
                        contentDescription = "Tap the empty glass to start again",
                        modifier = Modifier
                            .border(2.dp, Color(105, 205, 216), shape = RoundedCornerShape(4.dp))
                            .wrapContentSize()
                            .clickable {
                                currentStep = 1
                            }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Tap the empty glass to start again",
                        fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonAppPreview() {
    LemonAppTheme {
        LemonApp()
    }
}