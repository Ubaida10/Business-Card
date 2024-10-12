package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface (
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ){
                BusinessCard()
            }
        }
    }
}


@Composable
fun BusinessCard() {
    BusinessCardVisual(stringResource(R.string.name),
        stringResource(R.string.occupation),
        stringResource(R.string.contact), stringResource(R.string.email),
        stringResource(R.string.share)
    )
}


@Composable
private fun BusinessCardVisual(
    name: String,
    description: String,
    cell: String,
    email: String,
    share: String
) {
    val androidImage = painterResource(R.drawable.app_15642977)
    val cellImage = painterResource(R.drawable.phone)
    val emailImage = painterResource(R.drawable.email)
    val shareImage = painterResource(R.drawable.share)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image
        Image(
            painter = androidImage,
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .padding(bottom = 16.dp)
        )

        // Name
        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        // Description
        Text(
            text = description,
            color = Color.Gray,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        // Contact Information as a Row of Columns
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 180.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Icons in a single column
                Image(painter = cellImage, contentDescription = null, modifier = Modifier.height(25.dp))
                Image(painter = emailImage, contentDescription = null, modifier = Modifier.height(25.dp))
                Image(painter = shareImage, contentDescription = null, modifier = Modifier.height(25.dp))
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(start = 16.dp)
            ) {
                // Text corresponding to each icon
                Text(text = cell, fontSize = 18.sp, color = Color.Black)
                Text(text = email, fontSize = 18.sp, color = Color.Black)
                Text(text = share, fontSize = 18.sp, color = Color.Black)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardVisual("Abu Ubaida", "A Computer Science Student", "+923265327377", "au889482@gamil.com", "Abu Ubaida")
    }
}