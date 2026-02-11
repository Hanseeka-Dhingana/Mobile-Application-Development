package com.example.registration_screen_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.registration_screen_jetpackcompose.ui.theme.Registration_screen_jetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Registration_screen_jetpackcomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    RegistrationScreen(Modifier.padding(padding))
                }
            }
        }
    }
}

@Composable
fun RegistrationScreen(modifier: Modifier = Modifier) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf<String?>(null) }
    var emailError by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf<String?>(null) }
    var confirmPasswordError by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Register", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(16.dp))

        InputField("Name", name, nameError) {
            name = it; nameError = null
        }

        InputField("Email", email, emailError) {
            email = it; emailError = null
        }

        InputField("Password", password, passwordError, isPassword = true) {
            password = it; passwordError = null
        }

        InputField("Confirm Password", confirmPassword, confirmPasswordError, isPassword = true) {
            confirmPassword = it; confirmPasswordError = null
        }

        Spacer(Modifier.height(16.dp))

        Button(onClick = {
            nameError = if (name.isBlank()) "Name required" else null
            emailError = if (email.isBlank()) "Email required" else null
            passwordError = when {
                password.isBlank() -> "Password required"
                password.length < 6 -> "At least 6 characters"
                else -> null
            }
            confirmPasswordError = if (confirmPassword != password) "Passwords don't match" else null

            val hasError = listOf(nameError, emailError, passwordError, confirmPasswordError).any { it != null }

            if (!hasError) {
                // Registration success (Toast/snackbar logic can go here)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Register")
        }
    }
}

@Composable
fun InputField(
    label: String,
    value: String,
    error: String?,
    isPassword: Boolean = false,
    onValueChange: (String) -> Unit
) {
    Column(Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            isError = error != null,
            singleLine = true,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier.fillMaxWidth()
        )
        error?.let {
            Text(text = it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationPreview() {
    Registration_screen_jetpackcomposeTheme {
        RegistrationScreen()
    }
}
