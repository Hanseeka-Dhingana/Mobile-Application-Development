package com.example.sharedpeferences



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SharedPeferencesTheme {

                var showGreeting by remember { mutableStateOf(false) }

                if (showGreeting) {
                    Greeting()
                } else {
                    MainScreen(
                        onSaveClick = {
                            showGreeting = true
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(onSaveClick: () -> Unit) {

    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    var name by remember { mutableStateOf("Hanseeka") }
    var email by remember { mutableStateOf("abc@gmail.com") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Save data to SharedPreferences
                sharedPreferences.edit {
                    putString("name", name)
                        .putString("email", email)
                }

                // Move to GreetingActivity
                onSaveClick()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}
