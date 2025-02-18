package cl.sangut.projects.meetings.models

import java.time.format.DateTimeFormatter

data class MeetingPresentationModel(
    val id: Long,
    val subject: String,
    val date: String
)

fun Meeting.toPresentationModel() = MeetingPresentationModel(
    id = this.id,
    subject = this.subject,
    date = this.date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z"))
)