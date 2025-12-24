/**
 * This class represents a Challenge to solve a Multiplication (a * b).
 */

package microservice.book.multiplication.challenge;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor

public class Challenge{

    private int factorA;
    private int factorB;
}