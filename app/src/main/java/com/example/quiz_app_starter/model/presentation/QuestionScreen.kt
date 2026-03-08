import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz_app_starter.model.Question
import com.example.quiz_app_starter.model.getDummyQuestions
import com.example.quiz_app_starter.ui.theme.QuizappstarterTheme

@Composable
fun QuestionScreen(
    modifier: Modifier
) {
    val questions: List<Question> = getDummyQuestions()
    var currentQuestionIndex = 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //All elements or functions called
        ProgressIndicator()
        Spacer(modifier = Modifier.height(32.dp))
        Question()
        Spacer(modifier = Modifier.height(32.dp))
        Answers(questions, currentQuestionIndex)
    }
}

//Elemente: ProgressIndicator, Card, LazyColumn, ScaffoldBottomBar
@Composable
fun ProgressIndicator() {
    LinearProgressIndicator(
        progress = {
            0.50f
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(16.dp),
        color = MaterialTheme.colorScheme.secondary,
        strokeCap = StrokeCap.Round,
        trackColor = Color.LightGray
    )
}

@Composable
fun Question() {
    Text(
        text = "Dummy Frage",
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(6.dp))
            .background(Color.DarkGray)
            .padding(16.dp)
    )
}

//eigene Methode für Answers holen
fun getCurrentQuestionElement() {

}

@Composable
fun Answers(questions: List<Question>, index: Int) {
    val selectedOption = remember { mutableStateOf<String?>(null)}
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(questions[index].answers) { answer ->

            //ForEach für jedes Element aus der Liste
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color.DarkGray)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = answer,
                    color = Color.White
                )
                RadioButton(
                    selected = answer == selectedOption.value,
                    onClick = { selectedOption.value = answer },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = MaterialTheme.colorScheme.secondary,
                        unselectedColor = Color.White
                    )
                )
            }
        }
    }
}

//Preview Screen
@Preview(showBackground = true, name = "QuestionScreenPreview")
@Composable
fun QuestionScreenPreview() {
    QuizappstarterTheme {
        QuestionScreen(modifier = Modifier)
    }
}