package polls.api.poll_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @NotEmpty
    private String pollName;

    @Column
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_id")
    private List<Option> optionList;
}
