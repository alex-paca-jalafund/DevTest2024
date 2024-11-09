package polls.api.poll_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import polls.api.poll_api.entity.Option;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PollDto {
    private Long id;
    private String pollName;
    private List<Option> optionList;
}
