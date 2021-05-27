package so.ego.space.domains.meeting.domain.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import so.ego.space.domains.meeting.domain.application.MeetingUpdateService;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateGoalRequest;
import so.ego.space.domains.meeting.domain.application.dto.MeetingUpdateStatusRequest;

@RequiredArgsConstructor
@RestController
public class MeetingUpdateController {

    private final MeetingUpdateService meetingUpdateService;

    //회의 내용 변경
    @PutMapping("/meeting")
    public void updateMeetingGoal(@RequestBody MeetingUpdateGoalRequest meetingUpdateGoalRequest){
        meetingUpdateService.updateMeetingGoal(meetingUpdateGoalRequest);
    }

    //회의 상태 변경
    @PutMapping("/meeting/state")
    public void updateMeetingStatus(@RequestBody MeetingUpdateStatusRequest meetingUpdateStatusRequest){
        meetingUpdateService.updateMeetingStatus(meetingUpdateStatusRequest);
    }

}
