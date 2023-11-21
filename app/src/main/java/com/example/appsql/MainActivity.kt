package com.example.appsql

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appsql.db.DBHandler
import com.example.appsql.ui.theme.AppSQLTheme
import com.example.appsql.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSQLTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "GFG",
                                        modifier = Modifier.fillMaxWidth(),
                                        textAlign = TextAlign.Center,
                                        color = Color.White
                                    )
                                },
                                navigationIcon = {
                                    // Icon for the navigation menu
                                    IconButton(
                                        onClick = {
                                            // Handle navigation icon click
                                            Toast.makeText(
                                                this@MainActivity,
                                                "Navigation Icon Clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }
                                },
                                actions = {
                                    // Add your menu items here
                                    // For example:
                                    IconButton(
                                        onClick = {
                                            // Handle menu item click
                                            Toast.makeText(
                                                this@MainActivity,
                                                "Menu Item Clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }
                                    IconButton(
                                        onClick = {
                                            // Handle menu item click
                                            Toast.makeText(
                                                this@MainActivity,
                                                "Another Item Clicked",
                                                Toast.LENGTH_SHORT
                                            ).show()
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Person,
                                            contentDescription = null,
                                            tint = Color.White
                                        )
                                    }
                                }
                            )
                        },
                        content = {
                            // Content of your scaffold remains unchanged
                            addDataToDatabase(LocalContext.current)
                        }
                    )
                }
            }
        }
    }


    // on below line we are creating battery status function.
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun addDataToDatabase(
        context: Context
    ) {

        val activity = context as Activity
        // on below line creating a variable for battery status
        val Name = remember {
            mutableStateOf(TextFieldValue())
        }
        val Endereco = remember {
            mutableStateOf(TextFieldValue())
        }
        val bairro = remember {
            mutableStateOf(TextFieldValue())
        }
        val cep = remember {
            mutableStateOf(TextFieldValue())
        }
        val cidade = remember {
            mutableStateOf(TextFieldValue())
        }
        val estado = remember {
            mutableStateOf(TextFieldValue())
        }
        val telefone = remember {
            mutableStateOf(TextFieldValue())
        }
        val celular = remember {
            mutableStateOf(TextFieldValue())
        }


        // on below line we are creating a column,
        Column(
            // on below line we are adding a modifier to it,
            modifier = Modifier
                .fillMaxSize()
                // on below line we are adding a padding.
                .padding(all = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {

                var dbHandler: DBHandler = DBHandler(context)

                // on below line we are adding a text for heading.
                Text(
                    // on below line we are specifying text
                    text = "SQlite Database in Android",
                    // on below line we are specifying text color, font size and font weight
                    color = PurpleGrey40, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )

                // on below line adding a spacer.
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = Name.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { Name.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "Nome") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line we are adding spacer
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = Endereco.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { Endereco.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "Endereco") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line we are adding spacer
                Spacer(modifier = Modifier.height(20.dp))


                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = bairro.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { bairro.value = it },
                    // on below line we are adding place holder as text
                    placeholder = { Text(text = "bairro") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line we are adding spacer
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = cep.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { cep.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "cep") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line adding a spacer.
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = cidade.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { cidade.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "cidade") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line adding a spacer.
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = estado.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { estado.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "estado") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line adding a spacer.
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = telefone.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { telefone.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "telefone") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line adding a spacer.
                Spacer(modifier = Modifier.height(20.dp))

                // on below line we are creating a text field.
                TextField(
                    // on below line we are specifying value for our email text field.
                    value = celular.value,
                    // on below line we are adding on value change for text field.
                    onValueChange = { celular.value = it },
                    // on below line we are adding place holder as text as "Enter your email"
                    placeholder = { Text(text = "celular") },
                    // on below line we are adding modifier to it
                    // and adding padding to it and filling max width
                    modifier = Modifier
                        .fillMaxWidth(),
                    // on below line we are adding text style
                    // specifying color and font size to it.
                    textStyle = TextStyle(color = Color.Black, fontSize = 15.sp),
                    // on below line we are adding single line to it.
                    singleLine = true,
                )
                // on below line we are adding spacer
                Spacer(modifier = Modifier.height(15.dp))

                // on below line creating a button to check battery charging status
                Button(onClick = {
                    dbHandler.addNewCourse(
                        Name.value.text,
                        Endereco.value.text,
                        bairro.value.text,
                        cep.value.text,
                        cidade.value.text,
                        estado.value.text,
                        telefone.value.text,
                        celular.value.text

                    )
                    Toast.makeText(
                        context,
                        "Cadastro adicionado ao banco de dados",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }) {
                    // on below line adding a text for our button.
                    Text(text = "Adicionar cadastro ao banco de dados", color = Color.White)
                }

                // on below line we are adding spacer
                Spacer(modifier = Modifier.height(15.dp))

                // on below line creating a button to open view course activity
                Button(onClick = {
                    val i = Intent(context, ViewCourses::class.java)
                    context.startActivity(i)
                }) {
                    // on below line adding a text for our button.
                    Text(text = "Ler cadastro no banco de dados", color = Color.White)
                }
            }
        }
    }
}