package com.example.quiz_app_starter

import QuestionScreen
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz_app_starter.ui.theme.QuizappstarterTheme

class MainActivity : ComponentActivity() {  //kann als Activity verwendet werden, weil es von Parent erbt
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  //creation of onCreate from the parent
        enableEdgeToEdge()
        setContent {
            QuizappstarterTheme {   //Komponente { with a lot of parameters, a lot of Lambda expressions }
               Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentColor = MaterialTheme.colorScheme.background
                    //TopBar und BottomBar
                    /*topBar = {

                    },
                    bottomBar = {

                    }*/
                ) { innerPadding ->
                   {
                   }
                   /*MainMenuScreen(
                        bestScore = 12,
                        modifier = Modifier.padding(innerPadding)
                    )*/
                   //New Component / Composable from QuestionScreen.kt
                   QuestionScreen(
                       modifier = Modifier.padding(innerPadding)
                   )
               }
            }
        }
    }
}

@Composable //Als Teile der UI definiert, dann sind diese annotiert und deklariert als UI-Teil
fun MainMenuScreen(
    bestScore: Int = 0,
    modifier: Modifier
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.own_icon),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Our awesome Quiz-App",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(10.dp))

        //This color also in Theme.kt or Color.kt created
        val rainbowColors = listOf(Cyan, Color.Magenta, Color(0xFFFFA500), Green)
        Text(
            text = buildAnnotatedString {
                append("Test your\n")
                withStyle(
                    SpanStyle(
                        brush = Brush.linearGradient(
                            colors = rainbowColors
                        )
                    )
                ) {
                    append("KNOWLEDGE!")
                }
            },
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(16.dp)
                )
                //.background(colorResource(id = R.color.teal_200).copy(0.4f))
                .background(MaterialTheme.colorScheme.tertiary)
                .padding(16.dp)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Best of all time",
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.7f)
                )
                Text(text = bestScore.toString(), fontSize = 64.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                Log.i("MainActivity", "Play-Button clicked")
            },
            modifier = Modifier.fillMaxWidth(0.6f),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Play!", style = MaterialTheme.typography.labelLarge)
        }
    }
}

@Preview(showBackground = true, name = "MainMenuPreview")
@Composable
fun MainMenuScreenPreview() {
    QuizappstarterTheme {
        MainMenuScreen(bestScore = 12, modifier = Modifier)
    }
}