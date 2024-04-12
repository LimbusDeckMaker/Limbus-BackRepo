package com.example.limbusDeckMaker.repository.specification;

import com.example.limbusDeckMaker.domain.Identity;
import org.springframework.data.jpa.domain.Specification;

public class IdentitySpecification {

    public static Specification<Identity> hasSinnerId(Long sinnerId) {
        return (root, query, cb) -> {
            if (sinnerId == null) return null;
            return cb.equal(root.get("sinner").get("id"), sinnerId);
        };
    }

    public static Specification<Identity> hasSeason(Integer season) {
        return (root, query, cb) -> {
            if (season == null) return null;
            return cb.equal(root.get("season"), season);
        };
    }

    public static Specification<Identity> hasGrade(Integer grade) {
        return (root, query, cb) -> {
            if (grade == null)
                return null;
            return cb.equal(root.get("grade"), grade);
        };
    }

    public static Specification<Identity> hasAffiliation(String affiliation) {
        return (root, query, cb) -> {
            if (affiliation == null)
                return null;
            return cb.equal(root.get("affiliation"), affiliation);
        };
    }
}
