package polls.api.poll_api.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VoteResponse {
    Long id;
    Long pollid;
    Long optionId;
    String email;
}
