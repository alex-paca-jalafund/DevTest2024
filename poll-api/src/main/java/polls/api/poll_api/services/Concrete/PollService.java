package polls.api.poll_api.services.Concrete;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import polls.api.poll_api.dto.PollDto;
import polls.api.poll_api.dto.Request.CreatePollRequest;
import polls.api.poll_api.dto.Request.VoteDto;
import polls.api.poll_api.dto.Response.VoteResponse;
import polls.api.poll_api.entity.Poll;
import polls.api.poll_api.exception.NotFoundException;
import polls.api.poll_api.mapper.PollMapper;
import polls.api.poll_api.repository.IPollRepository;
import polls.api.poll_api.services.IService;

import java.util.List;

@Service
@AllArgsConstructor
public class PollService implements IService<PollDto> {
    IPollRepository pollRepository;

    @Override
    public List<PollDto> getAll() {
        return pollRepository.findAll().stream().map((poll) -> PollMapper.pollToPollDto(poll)).toList();
    }

    public PollDto create(CreatePollRequest pollRequest){
        Poll poll = pollRepository.save(PollMapper.pollRequestToPoll(pollRequest));
        return PollMapper.pollToPollDto(poll);
    }

    public PollDto getByID(Long id){
        return PollMapper.pollToPollDto(
                pollRepository.findById(id)
                        .orElseThrow(() -> new NotFoundException("Poll with this id not found"))
        );
    }

    public VoteResponse pollVote(Long pollId,VoteDto vote){
        return new VoteResponse(
                vote.getId(),
                pollId,
                vote.getId(),
                vote.getEmail()
        );
    }
}
