package org.hign.platform.u20221a322.personnel.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.hign.platform.u20221a322.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.u20221a322.personnel.domain.model.valueobjects.ExaminerInformation;
import org.hign.platform.u20221a322.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import org.hign.platform.u20221a322.shared.domain.model.valueobjects.NationalProviderIdentifier;

@Entity
public class Examiner extends AuditableAbstractAggregateRoot<Examiner> {

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "firstName", column = @Column(name = "first_name", nullable = false)),
        @AttributeOverride(name = "lastName", column = @Column(name = "last_name", nullable = false))
    })
    @Getter
    private ExaminerInformation information;

    @Embedded
    @Column(unique = true, nullable = false)
    @Getter
    private NationalProviderIdentifier nationalProviderIdentifier;

    public Examiner() {

    }

    public Examiner(CreateExaminerCommand command) {
        this.information = new ExaminerInformation(command.firstName(), command.lastName());
        this.nationalProviderIdentifier = new NationalProviderIdentifier(command.nationalProviderIdentifier());
    }
}
