package cl.sangut.projects.meetings.controllers

import cl.sangut.projects.meetings.models.Meeting
import cl.sangut.projects.meetings.service.MeetingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/meetings")
class MeetingRestController(
    private val meetingService: MeetingService
) {
    @GetMapping
    fun getAllMeetings(): List<Meeting> {
        return meetingService.getAllMeetings()
    }

}