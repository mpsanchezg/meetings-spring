package cl.sangut.projects.meetings.service

import cl.sangut.projects.meetings.models.Meeting
import cl.sangut.projects.meetings.models.MeetingsConstants
import org.springframework.stereotype.Service

@Service
class MeetingService {
    fun getAllMeetings(): List<Meeting> {
        return MeetingsConstants.meetings
    }
}