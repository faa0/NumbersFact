package com.fara.numbersfact.di.component.main

import com.fara.feature_home.di.component.homeComponent

val appComponent = mutableListOf(
    homeComponent
).flatten()