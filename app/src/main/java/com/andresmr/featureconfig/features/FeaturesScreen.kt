package com.andresmr.featureconfig.features

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andresmr.featureconfig.data.FeaturesRepository
import com.andresmr.featureconfig.model.FeatureItem

@Composable
fun FeaturesScreen(
    title: String,
    features: List<FeatureItem>,
    onItemSelected: (FeatureItem) -> Unit
) {
    Column(modifier = Modifier.fillMaxHeight()) {

        Text(
            title,
            modifier = Modifier.padding(12.dp),
            style = MaterialTheme.typography.h5,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Bold
        )

        LazyColumn(modifier = Modifier.apply {
            padding(12.dp)
            weight(1f)
            fillMaxWidth()
        }) {
            items(items = features) { feature ->
                FeatureRow(
                    featureItem = feature,
                    onItemSelected = { onItemSelected(it) },
                    Modifier.fillParentMaxWidth()
                )
            }
        }
    }
}

@Composable
fun FeatureRow(
    featureItem: FeatureItem,
    onItemSelected: (FeatureItem) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier
            .clickable { onItemSelected(featureItem) }
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = featureItem.title)
        Checkbox(
            checked = featureItem.active,
            onCheckedChange = { onItemSelected(featureItem) })
    }
}

@Preview(showBackground = true, name = "Main Screen Preview")
@Composable
fun PreviewFeaturesScreen() {
    FeaturesScreen(
        "Title",
        FeaturesRepository().provideFeatures()
    ) {}
}

@Preview(showBackground = true, name = "Row Preview")
@Composable
fun PreviewFeatureRow() {
    val featureItem = FeatureItem(
        "Feature 1",
        "Description",
        false
    )
    FeatureRow(
        featureItem = featureItem,
        onItemSelected = {},
        modifier = Modifier.fillMaxWidth()
    )
}
