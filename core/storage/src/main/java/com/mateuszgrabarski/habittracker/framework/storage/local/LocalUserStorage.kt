package com.mateuszgrabarski.habittracker.framework.storage.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.mateuszgrabarski.habittracker.business.data.models.user.User
import com.mateuszgrabarski.habittracker.business.data.types.Id
import com.mateuszgrabarski.habittracker.business.services.storage.UserStorage
import com.mateuszgrabarski.habittracker.framework.storage.userStorage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class LocalUserStorage(
    private val context: Context
) : UserStorage {

    private val userIdKey = stringPreferencesKey(name = "user_id")

    override suspend fun setActiveUser(user: User) {
        context.userStorage.edit {
            it[userIdKey] = user.id.toString()
        }
    }

    override fun readActiveUserId(): Flow<Id?> = context.userStorage.data.map { preferences ->
        preferences[userIdKey]?.let {
            Id.fromString(it)
        }
    }
}
