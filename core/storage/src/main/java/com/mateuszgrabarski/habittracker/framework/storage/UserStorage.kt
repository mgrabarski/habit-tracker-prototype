package com.mateuszgrabarski.habittracker.framework.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.mateuszgrabarski.habittracker.framework.storage.PreferencesNames.User

internal val Context.userStorage: DataStore<Preferences> by preferencesDataStore(name = User)
