package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
              LemonadeApp()
                }
            }
        }
    }


@Preview
@Composable
fun LemonadeApp() {
    LemonadeAppActions(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeAppActions(
    modifier: Modifier = Modifier
) {
    var clickResult by remember {
        mutableStateOf(0)
    }

    var actionText by remember {
        mutableStateOf(R.string.Lemon_tree)
    }

    val resourceImage = when (clickResult) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    val resourceString = when (clickResult) {
        0 -> R.string.Lemon_tree
        1 -> R.string.Lemon
        2 -> R.string.Glass_of_lemonade
        3 -> R.string.Empty_glass
        else -> R.string.Lemon_tree
    }

    if(clickResult >= 4) clickResult =0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFC3FBD8)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(300.dp))

        Image(
            painter = painterResource(resourceImage),
            contentDescription = clickResult.toString(),
            modifier = Modifier
                .clickable { clickResult++ }
                .border(3.dp, Color.Black)
                .background(Color(0xFFFED6BC))
        )

        Spacer(modifier = Modifier.height(80.dp))

        Text(
            textAlign = TextAlign.Center,
            text = stringResource(resourceString),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

