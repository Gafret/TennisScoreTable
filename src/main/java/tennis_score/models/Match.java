package tennis_score.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "matches")
public class Match {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "match_id")
    private long matchId;

    @ManyToOne
    @JoinColumn(name = "player1_id", nullable = false)
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id", nullable = false)
    private Player player2;

    @ManyToOne
    @JoinColumn(name = "winner_id", nullable = true)
    private Player winner;
}