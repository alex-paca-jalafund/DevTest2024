package polls.api.poll_api.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import polls.api.poll_api.dto.PollDto;
import polls.api.poll_api.dto.Request.CreatePollRequest;
import polls.api.poll_api.dto.Request.VoteDto;
import polls.api.poll_api.dto.Response.VoteResponse;
import polls.api.poll_api.services.Concrete.PollService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/polls")
public class PollController {
    PollService pollService;

    @GetMapping
    public List<PollDto> getAllPolls(){
        return pollService.getAll();
    }

    @PostMapping
    public ResponseEntity<PollDto> createPoll(@RequestBody CreatePollRequest pollRequest){
        PollDto poll = pollService.create(pollRequest);
        return new ResponseEntity<>(poll,HttpStatus.CREATED);
    }

     @PostMapping("{id}/votes")
    public ResponseEntity<VoteResponse> votePoll(@PathVariable Long id, @RequestBody VoteDto vote){
        VoteResponse createdVote = pollService.pollVote(id, vote);
        return new ResponseEntity<>( createdVote, HttpStatus.CREATED);
     }

}
