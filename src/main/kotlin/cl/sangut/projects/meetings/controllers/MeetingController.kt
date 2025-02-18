package cl.sangut.projects.meetings.controllers

import cl.sangut.projects.meetings.models.MeetingPresentationModel
import cl.sangut.projects.meetings.models.MeetingsConstants
import cl.sangut.projects.meetings.models.toPresentationModel
import cl.sangut.projects.meetings.service.MeetingService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/meetings")
class MeetingController {
    @Autowired
    lateinit var meetingService: MeetingService

    @GetMapping
    fun getAllMeetings(model: Model): String {
        model.addAttribute(
            "meetings",
            meetingService.getAllMeetings().map { it.toPresentationModel() }
        )
        return "meetings"
    }
}