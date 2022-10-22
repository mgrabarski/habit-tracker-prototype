@file:OptIn(ExperimentalMaterialApi::class)

package com.mateuszgrabarski.habittracker.resources.ui.components.spinner

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.theme.Grey600

@Composable
fun SelectableSpinner(
    title: String,
    notSelectedOption: String,
    options: List<String>,
    selectedOption: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = {
            expanded = !expanded
        }
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            label = {
                Text(text = title)
            },
            trailingIcon = {
                if (expanded) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_up),
                        contentDescription = "",
                        tint = Grey600
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "",
                        tint = Grey600
                    )
                }
            }
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                expanded = false
            }
        ) {
            (listOf(notSelectedOption) + options).forEach { selectionOption ->
                DropdownMenuItem(
                    onClick = {
                        onValueChange(selectionOption)
                        expanded = false
                    }
                ) {
                    if (selectionOption == "-") {
                        Text(text = selectionOption, color = Grey600)
                    } else {
                        Text(text = selectionOption)
                    }
                }
            }
        }
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showSystemUi = true)
@Composable
private fun SelectableSpinnerPreview() {
    SelectableSpinner(
        title = "some title",
        notSelectedOption = "-",
        options = listOf("option1", "option2"),
        selectedOption = "-",
        onValueChange = {}
    )
}
