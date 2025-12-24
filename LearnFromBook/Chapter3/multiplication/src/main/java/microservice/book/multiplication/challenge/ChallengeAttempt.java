/**
 * Identifies the attempt from a {@link User} to solve a challenge.
 */

package microservice.book.multiplication.challenge;

import lombok.*;
import microservice.book.multiplication.user.User;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class ChallengeAttempt {
    private Long id;
    private Long userId;
    private int factorA;
    private int factorB;
    private int resultAttempt;
    private boolean correct;
}
