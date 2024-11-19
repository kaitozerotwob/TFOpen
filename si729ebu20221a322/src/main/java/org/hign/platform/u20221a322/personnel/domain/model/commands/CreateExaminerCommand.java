package org.hign.platform.u20221a322.personnel.domain.model.commands;

import java.util.UUID;

/**
 * <p>
 *     Command to create an examiner
 *     <br>
 *     Constraints:
 *     <ul>
 *         <li>First name must not be null or empty</li>
 *         <li>Last name must not be null or empty</li>
 *         <li>National provider identifier must not be null or empty</li>
 *         <li>National provider identifier must be a valid uuid v4</li>
 *     </ul>
 * </p>
 * @param firstName
 * @param lastName
 * @param nationalProviderIdentifier
 * @author Alex Avila Asto (u20221a322)
 */
public record CreateExaminerCommand(
        String firstName,
        String lastName,
        String nationalProviderIdentifier
) {

    public CreateExaminerCommand {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("National provider identifier must not be null or empty");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name must not be null or empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name must not be null or empty");
        }
        try {
            UUID.fromString(nationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("National provider identifier must be uuid v4 format");
        }
    }
}
