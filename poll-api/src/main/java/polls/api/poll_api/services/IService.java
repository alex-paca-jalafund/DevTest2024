package polls.api.poll_api.services;

import polls.api.poll_api.dto.PollDto;

import java.util.List;

public interface IService<T>{
    public List<T> getAll();
}
