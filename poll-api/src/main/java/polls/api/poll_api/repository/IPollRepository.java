package polls.api.poll_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import polls.api.poll_api.entity.Poll;

public interface IPollRepository extends JpaRepository<Poll,Long> {
}
