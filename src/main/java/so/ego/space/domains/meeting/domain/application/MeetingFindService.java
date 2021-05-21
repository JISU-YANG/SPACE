package so.ego.space.domains.meeting.domain.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import so.ego.space.domains.meeting.domain.application.dto.MeetingFindResponse;
import so.ego.space.domains.meeting.domain.domain.Meeting;
import so.ego.space.domains.meeting.domain.domain.MeetingRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingFindService {

    private final MeetingRepository meetingRepository;

    //회의 리스트
    public List<MeetingFindResponse> findAllMeetings(){
        List<MeetingFindResponse> meetingFindResponseList = new LinkedList<>();
        List<Meeting> meetingList = meetingRepository.findAll();

        for(Meeting meeting :meetingList ){
            meetingFindResponseList.add(MeetingFindResponse.builder().name(meeting.getName()).check(meeting.getCheck()).goal(meeting.getGoal()).end_time(meeting.getEnd_time()).start_time(meeting.getStart_time()).build());
        }
        return meetingFindResponseList;
    }

    //회의 상세보기
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
