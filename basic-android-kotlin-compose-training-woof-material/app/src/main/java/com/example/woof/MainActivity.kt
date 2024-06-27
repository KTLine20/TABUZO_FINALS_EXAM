

package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.woof.data.spots
import com.example.woof.data.bspot
import com.example.woof.ui.theme.WoofTheme
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.system.exitProcess


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    mainpage()

                }
            }
        }
    }
}

    @Composable
    fun mainpage() {

        //si result variable is nakaset na value para sa button para magkaaction
        var result by remember { mutableStateOf(0) }

        //lalagyanan ng name input
        var UserInput by remember { mutableStateOf("") }

        // si trigger variable para magnext page nakaset siya sa one
        var trigger by remember { mutableStateOf(1) }


        if (trigger == 1) {
            //PICTURE NG BLUE HEADER
            val image = painterResource(id = R.drawable.bicol_intro)
            Column {
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth(),
                    //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
                    contentScale = ContentScale.Fit
                )
                //inputbox
                InputField(
                    UserInput,
                    onValueChange = { UserInput = it },
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth()
                )
                //code para sa button
                //pagkapindot ng button magchchange ng value si result from 0 to 1
                Button(onClick = { result = 1 })
                {
                    Text(
                        stringResource(R.string.OK)
                    )


                }
            }
        }//
        Column {
            //and dahil true yung magiging result ng condition dahil sa action ng button tatawagin niya yung nextpage function then izezero si trigger which will not run the mainpage again
            if (result == 1) {

                Header()
                //GREETING TEXT NG SECOND PAGE
                Text(
                    text = "WELCOME TO BICOL!" + " " + UserInput,
                    fontSize = 25.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        //PAGITAN NG HEADER TSAKA TEST
                        .padding(15.dp)
                        //PARA GUMITNA YUNG TITLE
                        .padding(horizontal = 50.dp)

                )

                Content()
                trigger = 0
                Button(onClick = { result = 2 })
                {
                    Text(
                        stringResource(R.string.LETSGO)
                    )
                }

            }
        }

        Column {
            //and dahil true yung magiging result ng condition dahil sa action ng button tatawagin niya yung nextpage function then izezero si trigger which will not run the mainpage again
            if (result == 2) {
                bicolApp()
            }
        }
    }


    @Composable
    fun Header() {
        //  var trigger by remember { mutableStateOf(0) }
        val image = painterResource(id = R.drawable.header)
        var UserInput by remember { mutableStateOf("") }
        Column {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(),
                //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
                contentScale = ContentScale.FillWidth
            )

        }
    }

@Composable
    fun Content() {


        val image1 = painterResource(id = R.drawable.mayon)
        Image(
            painter = image1,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 20.dp)
                .fillMaxWidth(),

            //PARA MAG STRETCH HANGGANG DULO YUNG HEADER
            contentScale = ContentScale.FillWidth
        )

        Text(
            text = "If you're looking for an adventurous getaway, Bicol is the place to be! With many fascinating places to explore, a trip to any Bicol tourist spotpromises to be an exhilarating adventure that will leave you spellbound.\n" +
                    "\n" +
                    "Be captivated by majestic volcanoes and unspoiled beaches brimming with diverse marine life. Swim with friendly butanding or uncover the mysteries of mountains, caves, and cliffs.\n" +
                    "\n",
            fontSize = 15.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                //PAGITAN NG HEADER TSAKA TEST
                .padding(15.dp)
                //PARA GUMITNA YUNG TITLE
                .padding(horizontal = 20.dp)
        )
    }

@Composable
    fun InputField(
        UsertInput: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier
    ) {
        TextField(
            value = UsertInput,
            onValueChange = onValueChange,
            modifier = modifier,

            singleLine = true,
            label = { Text(text = "ENTER NAME :") }
        )
    }

@Composable
    fun bicolApp() {
        Scaffold(
            topBar = {
                Header()
                end()
            }
        )
        { it ->

            LazyColumn(contentPadding = it) {
                items(bspot) {
                    Item(
                        area = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }

            }
        }

}

@Composable
fun end(){
    var result by remember { mutableStateOf(0) }

    Button(onClick = { result = 3 })
    {
        Text(
            stringResource(R.string.mainpage)

        )
    }
    Column {
        if (result == 3) {
            exitProcess(status = 1)

        }
    }
}
//para sa pinakanilalaman ng 3rd page
    @Composable
    fun Item(
        area: spots,
        modifier: Modifier = Modifier
    ) {
    var expanded by remember { mutableStateOf(false) }
        Card(
            modifier = modifier
        ) {
            Column(
                modifier = Modifier
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMedium
                        )
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(dimensionResource(R.dimen.padding_small))
                ) {
                    Icon(area.imageResourceId)
                    Information(area.name,area.loc)
                    Spacer(Modifier.weight(1f))
                    ItemButton(
                        expanded = expanded,
                        onClick = { expanded = !expanded },
                    )
                }
                if (expanded) {
                    Info(
                        area.hobbies, modifier = Modifier.padding(
                            start = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_small),
                            bottom = dimensionResource(R.dimen.padding_medium),
                            end = dimensionResource(R.dimen.padding_medium)
                        )
                    )
                }
            }

        }
    }

//for expandmore/less button
    @Composable
    private fun ItemButton(
        expanded: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        IconButton(
            onClick = onClick,
            modifier = modifier
        ) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = stringResource(R.string.expand_button_content_description),
                tint = MaterialTheme.colorScheme.secondary
            )
        }
}

// for the image icon on 3rd page
    @Composable
    fun Icon(

        @DrawableRes spotIcon: Int,
        modifier: Modifier = Modifier
    ) {
        Image(
            modifier = modifier
                .size(dimensionResource(R.dimen.image_size))
                .padding(dimensionResource(R.dimen.padding_small))
                .clip(MaterialTheme.shapes.extraLarge),
            contentScale = ContentScale.Fit,
            painter = painterResource(spotIcon),


            contentDescription = null
        )
    }

// inside the more/less button
    @Composable
    fun Information(
        @StringRes areaName: Int,
       @StringRes arealoc: Int,
        modifier: Modifier = Modifier
    ) {
        Column(modifier = modifier) {
            Text(
                text = stringResource(areaName),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
            )
            Text(
                text = stringResource(arealoc),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }


// for the name and location of the spots in list
    @Composable
    fun Info(
        @StringRes spotInfo: Int,
        modifier: Modifier = Modifier
    ) {
        Column(
            modifier = modifier
        ) {
            Text(
                text = stringResource(R.string.about),
                style = MaterialTheme.typography.labelSmall
            )
            Text(
                text = stringResource(spotInfo),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    @Preview
    @Composable
    fun WoofDarkThemePreview() {
        WoofTheme(darkTheme = true) {
            mainpage()

        }
    }

//Change 1