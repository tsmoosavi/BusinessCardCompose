package com.example.businesscardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardcompose.ui.theme.BusinessCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun ExpertiseInformation(modifier: Modifier = Modifier) {
    val androidPicture = painterResource(R.drawable.android_logo)
    Column(modifier = modifier,verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = androidPicture, contentDescription = "android logo", modifier = Modifier.size(100.dp))
        Text(text = "Alex Hardi", fontSize = 34.sp,color = Color.White, modifier = Modifier.padding( bottom = 8.dp))
        Text(text = "Android Developer Extraordinaire", fontSize = 12.sp, color = Color(0xFF3DDC84), fontWeight = FontWeight.Bold)
    }
}
@Composable
fun PersonalInfoRow(icon:ImageVector,info:String){
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)) {
            Spacer(modifier = Modifier.width(60.dp))
            Icon(imageVector = icon, contentDescription = "icon", tint = Color(0xFF3DDC84))
            Spacer(modifier = Modifier.width(20.dp))
            Text(text = info, color = Color.White)
        }
}

@Composable
fun PersonalInfoPart(modifier: Modifier = Modifier){
    Column(modifier = modifier.fillMaxSize(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.Start) {
        Divider(color = Color(0xFF526E7B))
         PersonalInfoRow(icon = Icons.Filled.Call, info = "+11 (123) 444 555 666")
        Divider(color = Color(0xFF526E7B))
        PersonalInfoRow(icon = Icons.Filled.Share, info = "@AndroidDev")
        Divider(color = Color(0xFF526E7B))
        PersonalInfoRow(icon = Icons.Filled.Email, info = "alex.hardi@gamil.com")
    }
}


@Composable
fun BusinessCard(){
        Surface(color = Color(0xFF073042), modifier = Modifier.fillMaxSize()) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
                ExpertiseInformation(Modifier.weight(2f))
                PersonalInfoPart(Modifier.weight(1f))
            }
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardComposeTheme {
        BusinessCard()
    }
}