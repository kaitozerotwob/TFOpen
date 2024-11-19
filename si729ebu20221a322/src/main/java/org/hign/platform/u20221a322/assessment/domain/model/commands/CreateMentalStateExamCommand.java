package org.hign.platform.u20221a322.assessment.domain.model.commands;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.UUID;

public record CreateMentalStateExamCommand(
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        @NotBlank int orientationScore,
        @NotBlank int registrationScore,
        @NotBlank int attentionAndCalculationScore,
        @NotBlank int recallScore,
        @NotBlank int languageScore
) {
    /**
     * <p>
     * This constructor validates the patient ID, examiner national provider identifier, exam date, orientation score,
     * registration score, attention and calculation score, recall score, and language score.
     * <br>
     * Constraints:
     * <ul>
     *     <li>The patient ID cannot be null</li>
     *     <li>The examiner national provider identifier must be a valid UUID</li>
     *     <li>The exam date cannot be greater than the current date</li>
     *     <li>The orientation score must be an integer between 0 and 10</li>
     *     <li>The registration score must be an integer between 0 and 3</li>
     *     <li>The attention and calculation score must be an integer between 0 and 5</li>
     *     <li>The recall score must be an integer between 0 and 3</li>
     *     <li>The language score must be an integer between 0 and 9</li>
     *  </ul>
     *
     * @param patientId
     * @param examinerNationalProviderIdentifier
     * @param examDate
     * @param orientationScore
     * @param registrationScore
     * @param attentionAndCalculationScore
     * @param recallScore
     * @param languageScore
     * @author Alex Avila Asto (u20221a322)
     */
    public CreateMentalStateExamCommand {
        if (patientId == null || patientId <= 0) {
            throw new IllegalArgumentException("The patient ID cannot be null");
        }
        try {
            UUID.fromString(examinerNationalProviderIdentifier);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("The examiner national provider identifier is invalid");
        }

        if (examDate.after(new Date())) {
            throw new IllegalArgumentException("The exam date cannot be greater than the current date");
        }
        if (orientationScore < 0 || orientationScore > 10) {
            throw new IllegalArgumentException("The orientation score must be an integer between 0 and 10");
        }
        if (registrationScore < 0 || registrationScore > 3) {
            throw new IllegalArgumentException("The registration score must be an integer between 0 and 3");
        }
        if (attentionAndCalculationScore < 0 || attentionAndCalculationScore > 5) {
            throw new IllegalArgumentException("The attention and calculation score must be an integer between 0 and 5");
        }
        if (recallScore < 0 || recallScore > 3) {
            throw new IllegalArgumentException("The recall score must be an integer between 0 and 3");
        }
        if (languageScore < 0 || languageScore > 9) {
            throw new IllegalArgumentException("The language score must be an integer between 0 and 9");
        }
    }
}
