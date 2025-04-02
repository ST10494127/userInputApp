package vcmsa.ci.userinputapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import vcmsa.ci.userinputapp.ui.theme.UserInputAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun
            onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputTime = findViewById<EditText>(R.id.inputTime)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val tvMealSuggestion = findViewById<TextView>(R.id.tvMealSuggestion)
        val btnReset= findViewById<Button>(R.id.btnReset)


        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()

            var mealsuggestion = "Invalid input! Please enter a valid time of day"

            //meal suggestion for the user
            if (timeOfDay == "morning"){
                mealsuggestion = "english breakfast:flapjacks"
            } else if (timeOfDay == "mid-morning"){
                mealsuggestion = "snack:pear+orange"
            }else if (timeOfDay == "afternoon"){
                mealsuggestion = "lunch:toasted sandwich + potato chips"
            }else if (timeOfDay == "mid-afternoon"){
                mealsuggestion = "light meal: protein shake or packet of chips"
            }else if (timeOfDay =="dinner"){
                mealsuggestion = "Main Course: pasta or steak and rice"
            }else if (timeOfDay == "after dinner"){
                mealsuggestion = "Dessert: Ice Cream or jelly and custard"
            }

            tvMealSuggestion.text = mealsuggestion
        }

        btnReset.setOnClickListener {
            inputTime.text.clear()
            tvMealSuggestion.text = "Meal suggestion will appear here"
        }
    }
}


