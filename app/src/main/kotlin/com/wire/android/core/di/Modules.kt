package com.wire.android.core.di

import android.content.Context
import android.view.accessibility.AccessibilityManager
import com.wire.android.core.accessibility.Accessibility
import com.wire.android.core.accessibility.AccessibilityConfig
import com.wire.android.core.accessibility.InputFocusViewModel
import com.wire.android.core.async.DefaultDispatcherProvider
import com.wire.android.core.async.DispatcherProvider
import com.wire.android.core.compatibility.Compatibility
import com.wire.android.core.config.LocaleConfig
import com.wire.android.core.events.EventsHandler
import com.wire.android.core.io.FileSystem
import com.wire.android.core.ui.dialog.DialogBuilder
import com.wire.android.core.ui.dialog.MaterialDialogBuilderProvider
import com.wire.android.core.ui.navigation.FragmentStackHandler
import com.wire.android.core.ui.navigation.Navigator
import com.wire.android.core.ui.navigation.UriNavigationHandler
import com.wire.android.core.ui.recyclerview.ViewHolderInflater
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    single { EventsHandler() }
    //TODO: this should be separate per user
    factory { androidContext().getSharedPreferences("com.wire.android.userprefs", Context.MODE_PRIVATE) }
}

val accessibilityModule = module {
    factory { androidContext().getSystemService(Context.ACCESSIBILITY_SERVICE) as AccessibilityManager }
    factory { Accessibility(get()) }
    factory { AccessibilityConfig(get()) }
    viewModel { InputFocusViewModel(get()) }
}

val compatibilityModule = module {
    factory { Compatibility() }
}

val appConfigModule = module {
    factory { LocaleConfig(androidContext()) }
}


val asyncModule = module {
    single<DispatcherProvider> { DefaultDispatcherProvider() }
}

val uiModule = module {
    factory { MaterialDialogBuilderProvider() }
    factory { DialogBuilder(get()) }

    single { Navigator(get(), get(), get(), get(), get()) }
    single { FragmentStackHandler() }
    single { UriNavigationHandler() }

    factory { ViewHolderInflater() }
}

val ioModule = module {
    single { FileSystem(androidContext()) }
}
