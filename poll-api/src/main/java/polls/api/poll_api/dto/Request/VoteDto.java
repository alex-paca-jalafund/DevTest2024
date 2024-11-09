package polls.api.poll_api.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDto {
    Long id;
    String email;
}
