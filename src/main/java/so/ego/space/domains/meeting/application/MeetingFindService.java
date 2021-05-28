package so.ego.space.domains.meeting.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.ego.space.domains.meeting.application.dto.MeetingFindResponse;
import so.ego.space.domains.meeting.domain.MeetingRepository;
import so.ego.space.domains.meeting.domain.Meeting;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingFindService {

    private final MeetingRepository meetingRepository;

    //회의 리스트
    @Transactional
    public List<MeetingFindResponse> findAllMeetings(Long projectId){
        List<MeetingFindResponse> meetingFindResponseList = new LinkedList<>();
        List<Meeting> meetingList = meetingRepository.findAllByProjectId(projectId).orElseThrow(() -> new IllegalArgumentException("Invalid projectId Index"));
        for(Meeting meeting :meetingList ){
            meetingFindResponseList.add(MeetingFindResponse.builder()
                    .name(meeting.getName())
                    .check(meeting.getCheck())
                    .goal(meeting.getGoal())
                    .end_time(meeting.getEnd_time())
                    .start_time(meeting.getStart_time())
                    .build());
        }
        return meetingFindResponseList;
    }

    //회의 상세보기
    @Transactional
    public MeetingFindResponse findOneMeeting(Long meetingId){
        Meeting meeting = meetingRepository.findById(meetingId).orElseThrow(() -> new IllegalArgumentException("Invalid Meeting Index"));
        return MeetingFindResponse.builder()
                .name(meeting.getName())
                .goal(meeting.getGoal())
                .check(meeting.getCheck())
                .start_time(meeting.getStart_time())
                .end_time(meeting.getEnd_time()).build();
    }

}
