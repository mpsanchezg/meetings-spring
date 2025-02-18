package cl.sangut.projects.meetings.models

import java.time.ZonedDateTime

data class Meeting(
    val id: Long,
    val subject: String,
    val date: ZonedDateTime
)
