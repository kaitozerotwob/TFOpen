package org.hign.platform.u20221a322.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

/**
 * <p>
 *     Simple value object representing the examiner's information.
 *     Constraints:
 *     <ul>
 *         <li>First name must not be empty or blank</li>
 *         <li>Last name must not be empty or blank</li>
 *     </ul>
 * </p>
 * @param firstName
 * @param lastName
 * @author Alex Avila Asto (u20221a322)
 */
@Embeddable
public record ExaminerInformation(
        @NotEmpty @NotBlank String firstName,
        @NotEmpty @NotBlank String lastName
) {
}
