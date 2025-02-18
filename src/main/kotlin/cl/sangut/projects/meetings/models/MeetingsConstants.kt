package cl.sangut.projects.meetings.models

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object MeetingsConstants {
    val meetings = listOf(
        Meeting(1, "Subject", ZonedDateTime.now().plusDays(1)),
        Meeting(2, "Subject", ZonedDateTime.now().plusDays(2)),
    )
}
