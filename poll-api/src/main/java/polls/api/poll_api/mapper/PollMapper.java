package polls.api.poll_api.mapper;

import polls.api.poll_api.dto.PollDto;
import polls.api.poll_api.dto.Request.CreateOptionRequest;
import polls.api.poll_api.dto.Request.CreatePollRequest;
import polls.api.poll_api.entity.Option;
import polls.api.poll_api.entity.Poll;

import java.util.List;

public class PollMapper {
    public static Poll pollDtoToPoll(PollDto pollDto){
        return new Poll(
                pollDto.getId(),
                pollDto.getPollName(),
                pollDto.getOptionList()
        );
    }

    public static PollDto pollToPollDto(Poll poll){
        return new PollDto(
                poll.getId(),
                poll.getPollName(),
                poll.getOptionList()
        );
    }

    public static CreateOptionRequest OptionToOptionRequest(Option option){
        return  new CreateOptionRequest(
                option.getOptionName()
        );
    }

    public  static Option CreateOptionToOption(CreateOptionRequest create){
        Long id = 1L;
        int votes = 10;
        return new Option(
                id,
                create.getOptionName(),
                votes
        );
    }

    public static CreatePollRequest pollCreateRequest(Poll poll){
        List<CreateOptionRequest> optionRequests = poll.getOptionList().stream().map((option -> PollMapper.OptionToOptionRequest(option))).toList();
        return new CreatePollRequest(
                poll.getPollName(),
                optionRequests
        );
    }

    public static Poll pollRequestToPoll(CreatePollRequest createPoll){
        List<Option> options = createPoll.getOptionList().stream().map((option -> PollMapper.CreateOptionToOption(option))).toList();
        Long id = Long.valueOf(1);
        return new Poll(
                id,
                createPoll.getName(),
                options
                );
    }
}
