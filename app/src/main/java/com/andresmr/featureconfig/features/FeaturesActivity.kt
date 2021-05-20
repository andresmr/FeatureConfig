package com.andresmr.featureconfig.features

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import com.andresmr.featureconfig.ui.theme.FeatureConfigTheme

class MainActivity : ComponentActivity() {

    val viewModel by viewModels<FeaturesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatureConfigTheme {
                Surface(color = Color.White) {
                    FeaturesScreen(
                        title = viewModel.title,
                        features = viewModel.featureItems,
                        viewModel::onItemSelected
                    )
                }
            }
        }
    }
}