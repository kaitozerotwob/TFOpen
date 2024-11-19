package org.hign.platform.u20221a322.shared.domain.model.valueobjects;

import java.util.UUID;

/**
 * @summary
 * <p>
 *     Shared domain model value object for National Provider Identifier.
 *     Constraints:
 *     <ul>
 *         <li>Cannot be null</li>
 *         <li>Must be UUID v4 format</li>
 *     </ul>
 * </p>
 * @author Alex Avila Asto
 */
public record NationalProviderIdentifier(String nationalProviderIdentifier) {

    public NationalProviderIdentifier {
        if (nationalProviderIdentifier == null || nationalProviderIdentifier.isBlank()) {
            throw new IllegalArgumentException("National Provider Identifier cannot be null");
        }

        // Validate UUID v4 format
        try {
            UUID.fromString(nationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("National Provider Identifier must be uuid v4 format");
        }
    }
}
