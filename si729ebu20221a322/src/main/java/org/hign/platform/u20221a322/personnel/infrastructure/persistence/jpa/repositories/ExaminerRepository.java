package org.hign.platform.u20221a322.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.u20221a322.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.u20221a322.shared.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {

    /**
     * <p>
     *     Check if an examiner exists by the national provider identifier
     * </p>
     * @return true if the examiner exists, false otherwise
     * @author Alex Avila Asto (u20221a322)
     */
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);

    /**
     * <p>
     *     Query an examiner by the national provider identifier
     * </p>
     * @return an optional examiner if it exists, empty otherwise
     */
    Optional<Examiner> findByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}
