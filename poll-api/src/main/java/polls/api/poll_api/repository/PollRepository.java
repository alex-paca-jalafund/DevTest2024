package polls.api.poll_api.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import polls.api.poll_api.entity.Poll;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class PollRepository {
    HashMap<Long, Poll> pollList = new HashMap<>();

    public List<Poll> getAll(){
        return new ArrayList<Poll>(pollList.values());
    }

    public Poll create(Poll poll){
       Poll created = pollList.put(poll.getId(),poll);
       return created;
    }

    public Poll postVote(Poll poll){
        Poll updated = pollList.get(poll.getId());
        updated.setPollName(poll.getPollName());
        updated.setOptionList(poll.getOptionList());
        return updated;
    }
}
