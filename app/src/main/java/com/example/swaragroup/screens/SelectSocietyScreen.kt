package com.example.swaragroup.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.compose.ui.window.PopupProperties
import androidx.core.content.pm.ShortcutInfoCompat.Surface
import androidx.core.graphics.toColorInt
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.swaragroup.R
import com.example.swaragroup.components.NormalHeadingText
import com.example.swaragroup.navigation.Screen
import com.example.swaragroup.ui.theme.PurpleMain

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSocietyScreen(
    navController: NavController
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(start = 15.dp,end =15.dp, bottom = 5.dp)
                    .fillMaxWidth(),
                onClick = {
                    navController.navigate(Screen.Home.route)
                },
                backgroundColor = PurpleMain,
            ) {
                Text(
                    text = "Continue",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF)
                    )
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        topBar = {
            IconButton(
                modifier = Modifier.padding(top = 15.dp, start = 7.dp),
                onClick = {
                    navController.navigateUp()
                }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back Arrow",
                    modifier = Modifier
                        .size(30.dp)
                        .defaultMinSize(30.dp),
                    tint = Color.Black
                )
            }
        }
    ) { paddingItem ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingItem)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(start = 15.dp, end = 15.dp)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                NormalHeadingText(value = "Select Society", textAlign = TextAlign.Start)
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Search and select your society listed \non swara app",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(600),
                        color = Color("#BEBEBE".toColorInt()),
                        textAlign = TextAlign.Start
                    )
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "Select Your Society",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFBEBEBE),

                        )
                )
                val society = listOf(
                    "Swara Skydeck",
                    "Samanvay",
                    "Sanidhya",
                    "The Orb",
                    "Sapphire",
                    "Sevakunj"
                )
                dropDownMenu(society,"Select Society")
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Select Building",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFBEBEBE),

                        )
                )
                val building = listOf(
                    "A",
                    "B",
                    "C",
                    "D",
                    "E",
                    "F",
                    "G"
                )
                dropDownMenu(building,"Select Building")
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Select Flat Number",
                    modifier = Modifier.fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 25.sp,
                        lineHeight = 22.sp,
                        fontFamily = FontFamily(Font(R.font.open_sans)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFFBEBEBE),

                        )
                )
                val flat_number = listOf(
                    "A-101",
                    "A-102",
                    "B-101",
                    "C-101",
                    "D-101",
                    "E-101",
                    "F-101",
                    "G-101"
                )
                dropDownMenu(flat_number,"Select Flat Number")
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDownMenu(
    select: List<String>,
    hint: String
) {

    var expanded by remember { mutableStateOf(false) }
    val suggestions = select
    var selectedText by remember { mutableStateOf("") }

    var textfieldSize by remember { mutableStateOf(Size.Zero)}

    val icon = if (expanded)
        Icons.Default.KeyboardArrowUp
    else
        Icons.Filled.ArrowDropDown
    
    Column{
            TextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned { coordinates ->
                        //This value is used to assign to the DropDown the same width
                        textfieldSize = coordinates.size.toSize()
                    },
                placeholder = {Text(
                    text = hint,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.lato)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFFBEBEBE),

                        )
                )},
                trailingIcon = {
                    Icon(icon,"contentDescription",
                        Modifier.clickable { expanded = !expanded })
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.lato)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF000000),
                )
            )
            val filteringOptions = suggestions.filter { it.contains(selectedText, ignoreCase = true) }
            if(filteringOptions.isNotEmpty()){
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier
                        .background(Color.White)
                        .requiredSizeIn(maxHeight = 330.dp)
                        .width(with(LocalDensity.current) { textfieldSize.width.toDp() }),
                    properties = PopupProperties(focusable = false),
                ) {
                    filteringOptions.forEach { label ->
                        DropdownMenuItem(
                            text = { Text(text = label)},
                            onClick = {
                                selectedText = label
                                expanded = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                    }
                }
            }
    }

}

@Preview
@Composable
fun SelectSocietyScreenPreview() {
    SelectSocietyScreen(navController = rememberNavController())
}