@file:OptIn(ExperimentalMaterialApi::class)

package com.mateuszgrabarski.habittracker.resources.ui.components.spinner

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.mateuszgrabarski.habittracker.resources.R
import com.mateuszgrabarski.habittracker.resources.ui.components.abstraction.ItemToSelect
import com.mateuszgrabarski.habittracker.resources.ui.theme.BorderColor

@Composable
fun SelectableSpinner(
    title: Int,
    notSelectedOption: ItemToSelect,
    options: List<ItemToSelect>,
    selectedOption: ItemToSelect,
    onValueChange: (ItemToSelect) -> Unit
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
            value = stringResource(id = selectedOption.stringId),
            onValueChange = {},
            label = {
                Text(text = stringResource(id = title))
            },
            trailingIcon = {
                if (expanded) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_up),
                        contentDescription = "",
                        tint = MaterialTheme.colors.BorderColor
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_down),
                        contentDescription = "",
                        tint = MaterialTheme.colors.BorderColor
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
            (listOf(notSelectedOption) + options)
                .forEach {
                    DropdownMenuItem(
                        onClick = {
                            onValueChange(it)
                            expanded = false
                        }
                    ) {
                        val selectedText = stringResource(id = it.stringId)
                        if (selectedText == "-") {
                            Text(text = selectedText, color = MaterialTheme.colors.BorderColor)
                        } else {
                            Text(text = selectedText)
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

    data class SomeItems(override val stringId: Int) : ItemToSelect

    SelectableSpinner(
        title = R.string.test_text,
        notSelectedOption = SomeItems(stringId = R.string.test_text),
        options = listOf(SomeItems(stringId = R.string.test_text)),
        selectedOption = SomeItems(stringId = R.string.test_text),
        onValueChange = {}
    )
}
