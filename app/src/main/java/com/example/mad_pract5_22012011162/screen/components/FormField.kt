package com.example.mad_pract5_22012011162.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormField(
    labelString:String,
    textState: String,
    onTextChange:(String)->Unit,
    isNumber: Boolean=false,
    isPassWordField: Boolean=false,
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(text = labelString, fontSize = 18.sp)
        if (isNumber) {
            OutlinedTextField(
                value = textState,
                onValueChange = onTextChange,
                label = { Text(text = labelString) },
                placeholder = { Text(text = labelString) },
                modifier = Modifier.padding(start = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = VisualTransformation.None
            )

        } else {
            OutlinedTextField(

                label = { Text(text = labelString) },
                placeholder = { Text(text = labelString) },
                value = textState,
                onValueChange = {newValue->
                    if (newValue.all { it.isDigit() }){
                        onTextChange(newValue)
                    }
                },
                modifier = Modifier.padding(start = 16.dp),
                textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
                visualTransformation =
                if (isPassWordField)
                    PasswordVisualTransformation()
                else
                    VisualTransformation.None


            )
        }
    }
}