# Simple Quiz App

A simple Android application built with Kotlin and XML that displays multiple-choice general knowledge questions, tracks user selections, and calculates the final score on a completion screen.

## 📌 Project Overview
The Simple Quiz App combines key Android UI components, dynamic user input handling, conditional scoring logic, and screen state navigation. Users answer a set of multiple-choice questions one by one, view their progress, and receive their total score upon completion with an option to restart the quiz.

## ✨ Features
- **Multiple-Choice Questions:** Interactive UI presenting general knowledge questions with four options each.
- **Progress Tracking:** Displays current question count and total questions (e.g., "Question 1 of 5").
- **Dynamic Score Calculation:** Evaluates selected answers and dynamically calculates the final score.
- **Interactive Score Screen:** Hides the quiz interface and displays final results upon submission.
- **Restart Quiz Functionality:** Allows users to reset the state and retake the quiz anytime.

## 🛠️ Tools & Technologies Used
- **IDE:** Android Studio
- **Language:** Kotlin
- **UI Design:** XML (LinearLayout, TextView, RadioGroup, RadioButton, Material Buttons)
- **Architecture:** Single Activity with View Visibility Management

## 📁 Repository Structure
```text
SimpleQuizApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/simplequizeapp/
│   │       │   └── MainActivity.kt
│   │       ├── res/
│   │       │   └── layout/
│   │       │       └── activity_main.xml
│   │       └── AndroidManifest.xml
│   └── build.gradle
└── README.md
