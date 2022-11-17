package com.mateuszgrabarski.habittracker.business.data.models.user

import com.mateuszgrabarski.habittracker.business.data.types.Id

class UserFactory {

    fun new() = User(
        id = Id.randomUUID()
    )
}
