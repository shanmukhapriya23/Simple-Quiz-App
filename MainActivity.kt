package com.example.simplequizeapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctIndex: Int
)

class MainActivity : AppCompatActivity() {

    private lateinit var quizContainer: LinearLayout
    private lateinit var scoreContainer: LinearLayout
    private lateinit var tvQuestionProgress: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var radioGroupOptions: RadioGroup
    private lateinit var rbOption1: RadioButton
    private lateinit var rbOption2: RadioButton
    private lateinit var rbOption3: RadioButton
    private lateinit var rbOption4: RadioButton
    private lateinit var btnSubmit: Button
    private lateinit var tvFinalScore: TextView
    private lateinit var btnRestart: Button

    private val questionList = listOf(
        Question(
            "What is the capital of France?",
            listOf("Berlin", "Madrid", "Paris", "Rome"),
            2
        ),
        Question(
            "Which planet is known as the Red Planet?",
            listOf("Earth", "Mars", "Jupiter", "Venus"),
            1
        ),
        Question(
            "Who wrote 'Hamlet'?",
            listOf("Charles Dickens", "William Shakespeare", "Mark Twain", "Leo Tolstoy"),
            1
        ),
        Question(
            "What is the chemical symbol for water?",
            listOf("O2", "H2O", "CO2", "NaCl"),
            1
        ),
        Question(
            "Which is the largest ocean on Earth?",
            listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"),
            3
        )
    )

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        quizContainer = findViewById(R.id.quizContainer)
        scoreContainer = findViewById(R.id.scoreContainer)
        tvQuestionProgress = findViewById(R.id.tvQuestionProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        radioGroupOptions = findViewById(R.id.radioGroupOptions)
        rbOption1 = findViewById(R.id.rbOption1)
        rbOption2 = findViewById(R.id.rbOption2)
        rbOption3 = findViewById(R.id.rbOption3)
        rbOption4 = findViewById(R.id.rbOption4)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvFinalScore = findViewById(R.id.tvFinalScore)
        btnRestart = findViewById(R.id.btnRestart)

        loadQuestion()

        btnSubmit.setOnClickListener {
            val selectedOptionId = radioGroupOptions.checkedRadioButtonId
            if (selectedOptionId == -1) {
                Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedRadioButton = findViewById<RadioButton>(selectedOptionId)
            val selectedIndex = radioGroupOptions.indexOfChild(selectedRadioButton)

            if (selectedIndex == questionList[currentQuestionIndex].correctIndex) {
                score++
            }

            currentQuestionIndex++
            if (currentQuestionIndex < questionList.size) {
                loadQuestion()
            } else {
                showScoreScreen()
            }
        }

        btnRestart.setOnClickListener {
            currentQuestionIndex = 0
            score = 0
            scoreContainer.visibility = View.GONE
            quizContainer.visibility = View.VISIBLE
            loadQuestion()
        }
    }

    private fun loadQuestion() {
        radioGroupOptions.clearCheck()
        val currentQuestion = questionList[currentQuestionIndex]

        tvQuestionProgress.text = "Question ${currentQuestionIndex + 1} of ${questionList.size}"
        tvQuestion.text = currentQuestion.questionText
        rbOption1.text = currentQuestion.options[0]
        rbOption2.text = currentQuestion.options[1]
        rbOption3.text = currentQuestion.options[2]
        rbOption4.text = currentQuestion.options[3]

        if (currentQuestionIndex == questionList.size - 1) {
            btnSubmit.text = "Submit Quiz"
        } else {
            btnSubmit.text = "Next"
        }
    }

    private fun showScoreScreen() {
        quizContainer.visibility = View.GONE
        scoreContainer.visibility = View.VISIBLE
        tvFinalScore.text = "Your Score: $score / ${questionList.size}"
    }
}