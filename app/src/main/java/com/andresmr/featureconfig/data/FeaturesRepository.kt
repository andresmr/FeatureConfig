package com.andresmr.featureconfig.data

import com.andresmr.featureconfig.model.FeatureItem

class FeaturesRepository {

    fun provideFeatures() = listOf(
        FeatureItem(
            title = "Feature 1",
            description = "Feature 1 description",
            false
        ),
        FeatureItem(
            title = "Feature 2",
            description = "Feature 2 description",
            false
        ),
        FeatureItem(
            title = "Feature 3",
            description = "Feature 3 description",
            false
        ),
        FeatureItem(
            title = "Feature 4",
            description = "Feature 4 description",
            false
        )
    )
}