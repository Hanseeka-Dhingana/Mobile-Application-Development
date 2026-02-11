package com.example.navigationcode



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavigationCodeTheme {
                // Setting up Navigation
                val navController = rememberNavController()  // Initialize NavController

                // NavHost defines the navigation graph for the app
                NavHost(navController = navController, startDestination = "screen1") {
                    composable("screen1") { Screen1(navController) }
                    composable("screen2/{userData}") { backStackEntry ->
                        // Get the passed data from the route arguments
                        val userData = backStackEntry.arguments?.getString("userData") ?: "No Data"
                        Screen2(navController, userData)
                    }
                }
            }
        }
    }
}



@Composable
fun Screen1(navController: NavController) {
    var text by remember { mutableStateOf("") }

    // Box to center the content
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter your name") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    // Pass data to the next screen through the route
                    navController.navigate("screen2/$text")
                }
            ) {
                Text("Go to Screen 2")
            }
        }
    }
}

@Composable
fun Screen2(navController: NavController, userData: String) {
    // Use Box to center the button
    Box(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Hello, $userData!")

            Spacer(modifier = Modifier.height(16.dp))

            // Simple Back Button
            Button(onClick = {
                // Navigate back to Screen 1
                navController.popBackStack()
            }) {
                Text("Go Back to Screen 1")
            }
        }
    }

}


