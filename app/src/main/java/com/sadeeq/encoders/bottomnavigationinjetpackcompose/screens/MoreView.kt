package com.sadeeq.encoders.bottomnavigationinjetpackcompose.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.BadgeViewModel
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.R
import com.sadeeq.encoders.bottomnavigationinjetpackcompose.ui.theme.BottomNavigationInJetpackComposeTheme


@Composable
fun MoreScreen(badgeViewModel: BadgeViewModel) {
    val context = LocalContext.current
    badgeViewModel.updateBadge("More",99)
    Card(
        colors = CardDefaults.cardColors(
            colorResource(id = R.color.white)
        ),
        border = BorderStroke(1.dp, color = Color.Blue),
        modifier = Modifier
            .padding(top = 10.dp, start = 10.dp, end = 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        )
    ) {
        Row(modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Sadeeq", Toast.LENGTH_SHORT)
                    .show()
            }) {
            Image(
                contentScale = ContentScale.FillBounds,
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "My Picture",
                modifier = Modifier
                    .size(dimensionResource(id = com.intuit.sdp.R.dimen._80sdp))
                    .clip(CircleShape)
                    .border(2.dp, MaterialTheme.colorScheme.primary, RectangleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Swat",
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Pakistan",
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleSmall,
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    BottomNavigationInJetpackComposeTheme {

    }
}