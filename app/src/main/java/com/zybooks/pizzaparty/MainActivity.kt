package com.zybooks.pizzaparty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zybooks.pizzaparty.ui.theme.PizzaPartyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaPartyTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PizzaPartyScreen()
                }
            }
        }
    }
}

@Composable
fun PizzaPartyScreen(modifier: Modifier = Modifier) {
    var totalPizzas by remember {mutableIntStateOf(0)}

    Column (
        modifier = modifier.padding(10.dp)
    ) {
        Text (
            text = stringResource(R.string.app_name),
            fontSize = 30.sp,
            modifier = modifier.padding(bottom = 16.dp)
        )
        NumberField (
            labelText = stringResource(R.string.number_of_people),
            modifier = modifier.padding(bottom = 16.dp).fillMaxWidth()
        )
        RadioGroup (
            labelText = stringResource(R.string.how_hungry),
            radioOptions = listOf(
                stringResource(R.string.option_light),
                stringResource(R.string.option_medium),
                stringResource(R.string.option_ravenous)
            ),
            selectedValue = stringResource(R.string.option_medium),
            modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Text (
            text = stringResource(R.string.total_pizzas, totalPizzas),
            fontSize = 22.sp,
            modifier = modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Button(
            onClick = {

            },
            modifier = modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.calculate))
        }
    }
}

@Composable
fun NumberField(
    labelText: String,
    modifier: Modifier = Modifier
) {

}

@Composable
fun RadioGroup(
    labelText: String,
    radioOptions: List<String>,
    selectedValue: String,
    modifier: Modifier = Modifier
) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PizzaPartyTheme {
        PizzaPartyScreen()
    }
}