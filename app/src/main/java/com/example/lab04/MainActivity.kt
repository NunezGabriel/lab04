package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White // Fondo limpio
                ) {
                    AgeInputScreen()
                }
            }
        }
    }
}

@Composable
fun AgeInputScreen() {
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ingresa tu edad",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3EBB76), // Verde personalizado
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Edad", color = Color(0xFF3EBB76)) },
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFF3EBB76),
                unfocusedBorderColor = Color(0xFF3EBB76),
                cursorColor = Color(0xFF3EBB76)
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AgeInputPreview() {
    Lab04Theme {
        AgeInputScreen()
    }
}
