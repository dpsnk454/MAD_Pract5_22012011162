package com.example.mad_pract5_22012011162.screen.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.testing.TestNavHostController
import com.example.mad_pract5_22012011162.R
import com.example.mad_pract5_22012011162.showMsg
import com.example.mad_pract5_22012011162.ui.theme.MAD_Pract5_22012011162Theme
import kotlinx.coroutines.selects.RegistrationFunction


@Composable
fun RegistrationScreen(
    context: Context? = null,
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    var name by remember { mutableStateOf("")}
    var phone by remember { mutableStateOf("") }
    var city by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var scrollState = rememberScrollState()
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp))
    {
        Image(
            painter = painterResource(id = R.drawable.guni_pink_logo),
            contentDescription = "Login",
            modifier = Modifier
                .fillMaxWidth()
                .height(110.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(15.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ){
            FormField(labelString = "Name", textState =name , onTextChange = {name = it} )
            FormField(labelString = "Phone Number", isNumber = true, textState =phone , onTextChange = {phone = it} )
            FormField(labelString = "City", textState =city , onTextChange = {city = it} )
            FormField(labelString = "Email", textState =email , onTextChange = {email = it} )
            FormField(labelString = "Password", isPassWordField = true, textState = password , onTextChange = {password = it} )
            FormField(labelString = "Confirm Password", isPassWordField = true, textState =confirmPassword , onTextChange = { confirmPassword = it} )

            Button(
                onClick = {
                    showMsg(context!!,"Login Successfully")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ){
                Text(text = "REGISTER", fontSize = 18.sp)
            }

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(text = "Do you have an account?",
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(bottom = 50.dp))
            Text(
                text = "LOGIN",
                fontSize = 16.sp,
                color = colorResource(id = R.color.purple_200),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 50.dp)
                    .clickable {
                        navController.navigate("login") // Navigate to login
                    }
            )
        }
    }

}
@Preview
@Composable
fun RegistrationPreview(){
    MAD_Pract5_22012011162Theme {
        val mockNavController = TestNavHostController(LocalContext.current)
        RegistrationScreen(navController = mockNavController)
    }
}