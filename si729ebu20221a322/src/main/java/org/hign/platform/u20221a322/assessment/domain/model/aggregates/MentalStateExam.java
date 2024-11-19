package org.hign.platform.u20221a322.assessment.domain.model.aggregates;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.hign.platform.u20221a322.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.u20221a322.assessment.domain.model.valueobjects.MentalStateExamInformation;
import org.hign.platform.u20221a322.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u20221a322.shared.domain.model.valueobjects.NationalProviderIdentifier;

@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @Column(nullable = false)
    @Getter
    private Long patientId;

    @Embedded
    @Column(nullable = false)
    @Getter
    private NationalProviderIdentifier examinerNationalProviderIdentifier;

    @Embedded
    @Column(nullable = false)
    @Getter
    private MentalStateExamInformation information;

    public MentalStateExam() {

    }

    /**
     * <p>
     *     Create a new mental state exam.
     *     This constructor is used by the command handler to create a new mental state exam.
     *     The examiner's national provider identifier is used to identify the examiner who conducted the exam.
     *     A exam can be conducted by a single examiner.
     *     The exam date, orientation score, registration score, attention and calculation score, recall score, and language score
     * </p>
     * @author Alex Avila Asto (u20221a322)
     */
    public MentalStateExam(CreateMentalStateExamCommand command) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new NationalProviderIdentifier(command.examinerNationalProviderIdentifier());
        this.information = new MentalStateExamInformation(
                command.examDate(),
                command.orientationScore(),
                command.registrationScore(),
                command.attentionAndCalculationScore(),
                command.recallScore(),
                command.languageScore()
        );
    }

}
