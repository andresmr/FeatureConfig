package com.andresmr.featureconfig.features

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.andresmr.featureconfig.data.FeaturesRepository
import com.andresmr.featureconfig.model.FeatureItem

class FeaturesViewModel : ViewModel() {

    private val repository = FeaturesRepository()
    val title = "Let's Rock"

    var featureItems by mutableStateOf(listOf<FeatureItem>())
        private set

    init {
        featureItems = featureItems + repository.provideFeatures()
    }

    fun onItemSelected(item: FeatureItem) {

    }
}
