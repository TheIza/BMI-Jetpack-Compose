package org.insbaixcamp.bmijetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.bmijetpackcompose.ui.theme.BMIJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BMIJetPackComposeTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    BMIScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun BMIScreen(modifier: Modifier = Modifier) {

    var name: String by remember { mutableStateOf("Iza") }
    var pes: Int by remember { mutableStateOf(40) }
    var alcada: Float by remember { mutableStateOf(180f) }
    var bmi: Float by remember { mutableStateOf(0f) }
    var alcadaMetres: Float by remember { mutableStateOf(0f) }

    val background = Color(0xFF061018)
    val panel = Color(0xFF0B1B25)
    val neonBlue = Color(0xFF73E8FF)
    val textWhite = Color(0xFFE8FAFF)
    val textGrey = Color(0xFF8BA9B5)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {

        Text(
            text = "BMI Calculadora",
            color = neonBlue,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Calcula el teu índex de massa corporal",
            color = textGrey,
            fontSize = 14.sp
        )

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = neonBlue,
                    shape = RoundedCornerShape(14.dp)
                ),
            value = name,
            onValueChange = { name = it },
            label = {
                Text("Name")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = panel,
                unfocusedContainerColor = panel,
                focusedTextColor = textWhite,
                unfocusedTextColor = textWhite,
                focusedLabelColor = neonBlue,
                unfocusedLabelColor = textGrey,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = neonBlue
            ),
            shape = RoundedCornerShape(14.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = panel,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFF164052),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(18.dp)
        ) {

            Text(
                text = "PES",
                color = textGrey,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "$pes kg",
                color = neonBlue,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Button(
                    onClick = {
                        pes -= 1
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF102B38),
                        contentColor = neonBlue

                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "-",
                        fontSize = 22.sp
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        pes += 1
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = neonBlue,
                        contentColor = background
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "+",
                        fontSize = 22.sp
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = panel,
                    shape = RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color(0xFF164052),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(18.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "ALÇADA",
                    color = textGrey,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "${alcada.toInt()} cm",
                    color = neonBlue,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Slider(
                value = alcada,
                onValueChange = { alcada = it },
                valueRange = 100f..250f,
                colors = SliderDefaults.colors(
                    thumbColor = neonBlue,
                    activeTrackColor = neonBlue,
                    inactiveTrackColor = Color(0xFF164052)
                )
            )
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            onClick = {
                alcadaMetres = alcada / 100
                bmi = pes.toFloat() / (alcadaMetres * alcadaMetres)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = neonBlue,
                contentColor = background
            ),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text(
                text = "CALCULAR BMI",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Text(
            text = "Hola $name",
            color = textWhite,
            fontSize = 16.sp
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = panel,
                    shape = RoundedCornerShape(18.dp)
                )
                .border(
                    width = 1.dp,
                    color = neonBlue,
                    shape = RoundedCornerShape(18.dp)
                )
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "EL TEU BMI",
                color = textGrey,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "%.2f".format(bmi),
                color = neonBlue,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    BMIJetPackComposeTheme {
        BMIScreen()
    }
}